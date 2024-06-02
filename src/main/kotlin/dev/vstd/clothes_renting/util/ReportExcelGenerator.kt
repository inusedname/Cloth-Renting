package dev.vstd.clothes_renting.util

import com.google.gson.Gson
import dev.vstd.clothes_renting.data.service.ReportService
import okhttp3.OkHttpClient
import okhttp3.Request
import org.apache.poi.ss.usermodel.*
import org.apache.poi.ss.util.CellRangeAddress
import org.apache.poi.xssf.usermodel.XSSFCellStyle
import org.apache.poi.xssf.usermodel.XSSFColor
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.apache.poi.xssf.usermodel.extensions.XSSFCellBorder
import java.awt.Color
import java.io.File
import java.io.FileOutputStream
import java.net.URLEncoder
import java.nio.file.Files
import java.nio.file.Paths
import java.nio.file.StandardCopyOption
import java.time.LocalDateTime


class ReportExcelGenerator {
    data class QuickChartPiePayload(
        val type: String = "pie",
        val data: QuickChartData,
        val options: ChartOption,
    ) {
        data class QuickChartData(
            val labels: List<String>,
            val datasets: List<QuickChartDataset>,
        )

        data class QuickChartDataset(
            val data: List<Number>,
        )

        data class ChartOption(val title: ChartTitle) {
            data class ChartTitle(val display: Boolean = true, val text: String)
        }

        companion object {
            fun getSales(records: List<ReportService.SellerSalesRating>, month: String): QuickChartPiePayload {
                val labels = records.map { it.name }
                val data = records.map { it.totalSales.toInt() }
                return QuickChartPiePayload(
                    data = QuickChartData(
                        labels = labels,
                        datasets = listOf(QuickChartDataset(data = data))
                    ),
                    options = ChartOption(ChartOption.ChartTitle(text = "Doanh thu theo nhà cung cấp: $month"))
                )
            }
            fun getConsuming(records: List<ReportService.SellerSalesRating>, dateString: String): QuickChartPiePayload {
                val labels = records.map { it.name }
                val data = records.map { it.totalOrders.toInt() }
                return QuickChartPiePayload(
                    data = QuickChartData(
                        labels = labels,
                        datasets = listOf(QuickChartDataset(data = data))
                    ),
                    options = ChartOption(ChartOption.ChartTitle(text = "Số đơn hàng đã bán theo nhà cung cấp: $dateString"))
                )
            }
        }
    }
    private fun generateChartImage(records: List<ReportService.SellerSalesRating>, dateString: String) {

        val gson = Gson()
        val salesPayload = gson.toJson(QuickChartPiePayload.getSales(records, dateString)).apply {
            URLEncoder.encode(this, "UTF-8")
        }
        val consumingPayload = gson.toJson(QuickChartPiePayload.getConsuming(records, dateString)).apply {
            URLEncoder.encode(this, "UTF-8")
        }
        val chartUrl = "https://quickchart.io/chart?c="

        val client = OkHttpClient()

        val salesRequest = Request.Builder()
            .url(chartUrl + salesPayload)
            .build()

        client.newCall(salesRequest).execute().use { response ->
            if (!response.isSuccessful) {
                println("Error: ${response.code} ${response.message}")
            } else {
                response.body?.byteStream()?.use { input ->
                    Files.copy(input, Paths.get("chart-sales.jpeg"), StandardCopyOption.REPLACE_EXISTING)
                }
            }
        }

        val consumingRequest = Request.Builder()
            .url(chartUrl + consumingPayload)
            .build()

        client.newCall(consumingRequest).execute().use { response ->
            if (!response.isSuccessful) {
                println("Error: ${response.code} ${response.message}")
            } else {
                response.body?.byteStream()?.use { input ->
                    Files.copy(input, Paths.get("chart-consuming.jpeg"), StandardCopyOption.REPLACE_EXISTING)
                } ?: println("No response body")
            }
        }
    }
    fun generate(top: Int, dateString: String, records: List<ReportService.SellerSalesRating>): String {
        val workbook = XSSFWorkbook()

        val timesNewRomanFont = {
            workbook.createFont().apply {
                fontName = "Times New Roman"
                bold = false
            }
        }

        // Create styles
        val titleStyle = workbook.createCellStyle().apply {
            alignment = HorizontalAlignment.CENTER
            setFont(timesNewRomanFont().apply {
                fontHeightInPoints = 16
                bold = true
            })
            verticalAlignment = VerticalAlignment.CENTER
        }

        val subtitleStyle = workbook.createCellStyle().apply {
            alignment = HorizontalAlignment.CENTER
            setFont(timesNewRomanFont().apply {
                fontHeightInPoints = 14
            })
            verticalAlignment = VerticalAlignment.CENTER
        }

        val headerStyle = workbook.createCellStyle().apply {
            fillForegroundColor = IndexedColors.CORNFLOWER_BLUE.getIndex()
            fillPattern = FillPatternType.SOLID_FOREGROUND
            setFont(timesNewRomanFont().apply {
                bold = true
                color = IndexedColors.WHITE.index
            })
            setBorderStyle(BorderStyle.HAIR)
            setBorderColor(XSSFCellBorder.BorderSide.VERTICAL, XSSFColor(Color.WHITE, workbook.stylesSource.indexedColors))
            setBorderColor(XSSFCellBorder.BorderSide.HORIZONTAL, XSSFColor(Color.WHITE, workbook.stylesSource.indexedColors))
            verticalAlignment = VerticalAlignment.CENTER
        }

        val bodyStyle = workbook.createCellStyle().apply {
            setFont(timesNewRomanFont())
            setBorderStyle(BorderStyle.HAIR)
            verticalAlignment = VerticalAlignment.CENTER
        }

        val sheet = workbook.createSheet("Sales Report")
        var countRows = 0

        countRows++

        // Report Title
        sheet.apply {
            val titleRow = createRow(countRows++)
            val titleCell = titleRow.createCell(0)
            titleCell.setCellValue("Báo cáo: Thống kê đối tác theo doanh thu")
            titleCell.cellStyle = titleStyle
            addMergedRegion(CellRangeAddress(1, 1, 0, 3))

            val dateRow = createRow(countRows++)
            val dateCell = dateRow.createCell(0)
            dateCell.setCellValue("Top $top đối tác có doanh thu cao nhất: $dateString")
            dateCell.cellStyle = subtitleStyle
            addMergedRegion(CellRangeAddress(2, 2, 0, 3))
        }

        countRows++

        // Main table
        sheet.apply {
            val headerRow = createRow(countRows++)
            headerRow.heightInPoints = 2 * sheet.defaultRowHeightInPoints // Set row height to twice the default
            val headers = listOf("Xếp hạng", "Tên nhà cung cấp", "Số đơn hàng đã bán", "Doanh thu")
            headers.forEachIndexed { index, header ->
                val headerCell = headerRow.createCell(index)
                headerCell.setCellValue(header)
                headerCell.cellStyle = headerStyle
            }

            records.forEachIndexed { index, record ->
                val row = createRow(countRows++)
                row.heightInPoints = 2 * sheet.defaultRowHeightInPoints // Set row height to twice the default
                val cells = listOf(index + 1, record.name, record.totalOrders, record.totalSales)
                cells.forEachIndexed { cellIndex, cellValue ->
                    val cell = row.createCell(cellIndex)
                    cell.setCellValue(cellValue.toString())
                    cell.cellStyle = bodyStyle
                }
            }
        }

        // Set column widths
        sheet.setColumnWidth(0, 256 * 16) // 256 characters wide
        sheet.setColumnWidth(1, 256 * 36)
        sheet.setColumnWidth(2, 256 * 24)
        sheet.setColumnWidth(3, 256 * 18)

        // charts
        generateChartImage(records, dateString)
        // Add chart images to the Excel file
        val salesChartPath = Paths.get("chart-sales.jpeg")
        val consumingChartPath = Paths.get("chart-consuming.jpeg")

        val salesChartBytes = Files.readAllBytes(salesChartPath)
        val consumingChartBytes = Files.readAllBytes(consumingChartPath)

        val salesChartId = workbook.addPicture(salesChartBytes, XSSFWorkbook.PICTURE_TYPE_JPEG)
        val consumingChartId = workbook.addPicture(consumingChartBytes, XSSFWorkbook.PICTURE_TYPE_JPEG)

        val drawing = sheet.createDrawingPatriarch()

        // Add sales chart
        val salesChartAnchor = workbook.creationHelper.createClientAnchor().apply {
            setCol1(0)
            setCol2(3)
            row1 = ++countRows
            row2 = row1 + 15  // adjust the height as needed
        }
        drawing.createPicture(salesChartAnchor, salesChartId)

        // Add consuming chart
        val consumingChartAnchor = workbook.creationHelper.createClientAnchor().apply {
            setCol1(3)
            setCol2(10)
            row1 = countRows++
            row2 = row1 + 15  // adjust the height as needed
        }
        drawing.createPicture(consumingChartAnchor, consumingChartId)


        // Create status row
        sheet.apply {
            countRows+=15
            val statusRow = createRow(countRows++)
            val statusCell = statusRow.createCell(0)
            val now = LocalDateTime.now()
            statusCell.setCellValue(String.format("Báo cáo tạo vào lúc %d:%d ngày %d/%d/%d", now.hour, now.minute, now.dayOfMonth, now.monthValue, now.year))
            val statusStyle = workbook.createCellStyle().apply {
                setFont(timesNewRomanFont().apply {
                    italic = true
                })
            }
            statusCell.cellStyle = statusStyle

            val signatureCell = statusRow.createCell(3)
            signatureCell.setCellValue("Ký tên")
            signatureCell.cellStyle = workbook.createCellStyle().apply {
                alignment = HorizontalAlignment.CENTER
                setFont(timesNewRomanFont().apply {
                    bold = true
                })
            }
        }

        val file = File.createTempFile("report", ".xlsx")
        FileOutputStream(file).use { outputStream -> workbook.write(outputStream) }
        workbook.close()
        file.deleteOnExit()
        return file.absolutePath
    }

    private fun XSSFCellStyle.setBorderStyle(style: BorderStyle) {
        borderBottom = style
        borderLeft = style
        borderRight = style
        borderTop = style
    }
}