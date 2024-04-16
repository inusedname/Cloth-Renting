package dev.vstd.clothes_renting.controller

import dev.vstd.clothes_renting.Constants
import dev.vstd.clothes_renting.data.service.InventoryService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
@RequestMapping("/inventory")
class InventoryController(private val inventoryService: InventoryService) {

    @GetMapping("/request-product")
    fun getRequestMoreProduct(): String {
        return "make_order_manager"
    }

    @GetMapping("")
    fun dashboard(model: Model, @RequestParam(required = false) search: String?): String {
        val items = if (search == null) {
            inventoryService.getAllInventoryItems()
        } else {
            inventoryService.filterByName(search)
        }
        model[Constants.ATTR_RECORDS] = items
        return "manage_inventory"
    }

    @GetMapping("/history")
    fun inventoryHistory(model: Model, @RequestParam(required = false) id: Long?): String {
        val histories = if (id == null) {
            inventoryService.getAllHistories()
        } else {
            inventoryService.filterByItemId(id)
        }
        model[Constants.ATTR_RECORDS] = histories
        return "history_inventory"
    }

    @GetMapping("/update")
    fun updateInventory(): String {
        return "update_inventory"
    }
}