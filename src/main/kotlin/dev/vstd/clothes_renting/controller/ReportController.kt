package dev.vstd.clothes_renting.controller

import dev.vstd.clothes_renting.Constants
import dev.vstd.clothes_renting.data.service.ReportService
import dev.vstd.clothes_renting.util.ReportExcelGenerator
import org.springframework.core.io.FileSystemResource
import org.springframework.core.io.Resource
import org.springframework.format.annotation.DateTimeFormat
import org.springframework.http.HttpHeaders
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import java.time.LocalDate

@Controller
class ReportController(private val reportService: ReportService) {
    private val reportExcelGenerator = ReportExcelGenerator()

    @GetMapping("report-consuming")
    fun getConsuming(
        model: Model,
        @RequestParam limit: Int = 5,
        @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) date: LocalDate = LocalDate.now()
    ): String {
        val rating = reportService.getSellerConsumingRatings(limit, date)
        model[Constants.ATTR_SELLER_RATINGS] = rating
        return "dashboard_report_seller_consuming"
    }

    @GetMapping("report-sales")
    fun getSales(
        model: Model,
        @RequestParam limit: Int = 5,
        @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) date: LocalDate = LocalDate.now()
    ): String {
        val start = date.withDayOfMonth(1)
        val end = date.withDayOfMonth(date.lengthOfMonth())
        val ratings = reportService.getSellerSalesRatings(limit, start, end)
        model[Constants.ATTR_SELLER_RATINGS] = ratings
        return "dashboard_report_seller_sales"
    }

    @GetMapping("report-sales/excel")
    fun downloadExcel(
        @RequestParam(required = true) limit: Int,
        @RequestParam(required = true) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) date: LocalDate,
        model: Model
    ): ResponseEntity<Resource> {
        val start = date.withDayOfMonth(1)
        val end = date.withDayOfMonth(date.lengthOfMonth())
        val ratings = reportService.getSellerSalesRatings(limit, start, end)
        val outputDownloadPath = reportExcelGenerator.generate(limit, date, ratings)
        return ResponseEntity.ok()
            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=report.xlsx")
            .body(FileSystemResource(outputDownloadPath))
    }
}