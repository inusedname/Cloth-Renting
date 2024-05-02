package dev.vstd.clothes_renting.controller

import dev.vstd.clothes_renting.Constants
import dev.vstd.clothes_renting.data.service.ReportService
import org.springframework.format.annotation.DateTimeFormat
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import java.time.LocalDate

@Controller
class ReportController(private val reportService: ReportService) {

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
        val rating = reportService.getSellerSalesRatings(limit, start, end)
        model[Constants.ATTR_SELLER_RATINGS] = rating
        return "dashboard_report_seller_sales"
    }
}