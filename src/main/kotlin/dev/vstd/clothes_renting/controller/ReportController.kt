package dev.vstd.clothes_renting.controller

import dev.vstd.clothes_renting.data.service.ReportService
import org.springframework.stereotype.Controller
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/report")
class ReportController(private val reportService: ReportService) {

    @GetMapping("")
    fun dashboard(): String {
        TODO()
    }

    @GetMapping("/download")
    fun downloadAsExcel(): String {
        TODO()
    }
}