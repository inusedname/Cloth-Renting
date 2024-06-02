package dev.vstd.clothes_renting.controller

import dev.vstd.clothes_renting.Constants
import dev.vstd.clothes_renting.data.service.BuyInOrderService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime

@Controller
@RequestMapping("/order")
class BuyInOrderController(
    private val buyInOrderService: BuyInOrderService
) {
    @GetMapping("")
    fun inventoryHistory(model: Model): String {
        val histories = buyInOrderService.findAll().sortedByDescending { it.date }
        model[Constants.ATTR_RECORDS] = histories
        return "manage_buy_in_order"
    }

    @GetMapping("/filter")
    fun filterByNCC(
        @RequestParam tenNhaCungCap: String,
        @RequestParam from: LocalDate,
        @RequestParam to: LocalDate,
        model: Model
    ): String {
        val dateString =
            "T${from.monthValue}/${from.dayOfMonth}/${from.year} - T${to.monthValue}/${to.dayOfMonth}/${to.year}"
        val histories = buyInOrderService.findAll()
            .filter {
                it.sellerEntity.name.contains(tenNhaCungCap, ignoreCase = true) &&
                        it.date >= LocalDateTime.of(
                    from.withDayOfMonth(1),
                    LocalTime.MIN
                ) && it.date <= LocalDateTime.of(to.withDayOfMonth(to.lengthOfMonth()), LocalTime.MAX)
            }
        model[Constants.ATTR_RECORDS] = histories
        return "manage_buy_in_order"
    }
}