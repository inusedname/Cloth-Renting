package dev.vstd.clothes_renting.util

import dev.vstd.clothes_renting.data.service.ReportService
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import java.io.File
import java.io.FileOutputStream
import java.time.LocalDate


class ReportExcelGenerator {
    fun generate(top: Int, month: LocalDate, records: List<ReportService.SellerSalesRating>): String {
        val workbook = XSSFWorkbook()
        val sheet = workbook.createSheet("Sales Report")
        var countRows = 0

        ////////////////
        // Report Title
        sheet.apply {
            val titleRow = createRow(countRows++)
            val titleCell = titleRow.createCell(0)
            titleCell.setCellValue("Báo cáo: Thống kê đối tác theo doanh thu")
            val dateRow = createRow(countRows++)
            val dateCell = dateRow.createCell(0)
            dateCell.setCellValue("Top $top đối tác có doanh thu cao nhất tháng ${month.monthValue}")
        }

        /////////////////
        // Main table
        // A table to demon $records, it has 4 columns: Xếp hạng, Tên nhà cung cấp, Số đơn hàng đã bán, doanh thu
        sheet.apply {
            val headerRow = createRow(countRows++)
            val headers = listOf("Xếp hạng", "Tên nhà cung cấp", "Số đơn hàng đã bán", "Doanh thu")
            headers.forEachIndexed { index, header ->
                val headerCell = headerRow.createCell(index)
                headerCell.setCellValue(header)
            }

            records.forEachIndexed { index, record ->
                val row = createRow(countRows++)
                val cells = listOf(index + 1, record.name, record.totalOrders, record.totalSales)
                cells.forEachIndexed { cellIndex, cellValue ->
                    val cell = row.createCell(cellIndex)
                    cell.setCellValue(cellValue.toString())
                }
            }
        }

        val file = File.createTempFile("report", ".xlsx")
        FileOutputStream(file).use { outputStream -> workbook.write(outputStream) }
        workbook.close()
        file.deleteOnExit()
        return file.absolutePath
    }
}