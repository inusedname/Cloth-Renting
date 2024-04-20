package dev.vstd.clothes_renting.controller

import dev.vstd.clothes_renting.Constants
import dev.vstd.clothes_renting.controller.form.UpdateInventoryForm
import dev.vstd.clothes_renting.data.entity.UserEntity
import dev.vstd.clothes_renting.data.service.ClothService
import dev.vstd.clothes_renting.data.service.InventoryService
import jakarta.servlet.http.HttpServletRequest
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import java.util.logging.Logger

@Controller
@RequestMapping("/inventory")
class InventoryController(private val inventoryService: InventoryService, private val clothService: ClothService) {
    private val logger = Logger.getLogger(InventoryController::class.qualifiedName)

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
    fun updateInventory(model: Model): String {
        val products = clothService.getAllClothes()
        model[Constants.ATTR_PRODUCTS] = products
        return "update_inventory"
    }

    @PostMapping("/update", consumes = ["application/x-www-form-urlencoded"])
    fun postUpdateInventory(form: UpdateInventoryForm, request: HttpServletRequest): String {
        val user = request.session.getAttribute(Constants.ATTR_USER) as UserEntity
        if (form.type == Constants.BUY_IN) {
            inventoryService.buyIn(user = user, productId = form.productId, quantity = form.quantity, date = form.date)
        } else if (form.type == Constants.SELL_OUT) {
            inventoryService.sellOut(user = user, productId = form.productId, quantity = form.quantity, date = form.date)
        }
        return "redirect:/inventory"
    }
}