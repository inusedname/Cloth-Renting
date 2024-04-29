package dev.vstd.clothes_renting.controller

import dev.vstd.clothes_renting.Constants
import dev.vstd.clothes_renting.data.service.BuyInOrderService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/order")
class BuyInOrderController(
    private val buyInOrderService: BuyInOrderService
) {
    @GetMapping("")
    fun inventoryHistory(model: Model): String {
        val histories = buyInOrderService.findAll()
        model[Constants.ATTR_RECORDS] = histories
        return "manage_buy_in_order"
    }
}