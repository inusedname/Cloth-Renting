package dev.vstd.clothes_renting.controller

import dev.vstd.clothes_renting.Constants
import dev.vstd.clothes_renting.data.service.ReportService
import org.springframework.format.annotation.DateTimeFormat
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import java.time.LocalDate

@Controller
@RequestMapping("/report")
class ReportController(private val reportService: ReportService) {

    @GetMapping("")
    fun dashboard(
        model: Model,
        @RequestParam limit: Int = 5,
        @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) date: LocalDate = LocalDate.now()
    ): String {
        val rating = reportService.getSellerRatings(limit, date)
        model[Constants.ATTR_SELLER_RATINGS] = rating
        return "dashboard_report"
    }

    @GetMapping("/download")
    fun download(@RequestParam(required = true) type: String) {
        return when (type) {
            "xls" -> {
                // TODO
            }

            "pdf" -> {
                // TODO
            }

            else -> {
                // TODO
            }
        }
    }
}