package dev.vstd.clothes_renting.controller

import dev.vstd.clothes_renting.Constants
import dev.vstd.clothes_renting.controller.form.RequestMoreProductForm
import dev.vstd.clothes_renting.controller.form.UpdateInventoryForm
import dev.vstd.clothes_renting.data.entity.UserEntity
import dev.vstd.clothes_renting.data.service.ClothService
import dev.vstd.clothes_renting.data.service.InventoryService
import dev.vstd.clothes_renting.data.service.SellerService
import jakarta.servlet.http.HttpServletRequest
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.servlet.mvc.support.RedirectAttributes
import java.net.URLEncoder
import java.util.logging.Logger

@Controller
@RequestMapping("/inventory")
class InventoryController(
    private val inventoryService: InventoryService,
    private val clothService: ClothService,
    private val sellerService: SellerService
) {
    private val logger = Logger.getLogger(InventoryController::class.qualifiedName)

    @GetMapping("/request-product")
    fun getRequestMoreProduct(model: Model, @RequestParam(required = false) errorMessage: String?): String {
        model[Constants.ATTR_SELLERS] = sellerService.getSellers()
        model[Constants.ATTR_PRODUCTS] = clothService.getAllClothes()
        if (errorMessage != null) {
            model[Constants.ATTR_ERROR_MSG] = errorMessage
        }
        return "make_order_manager"
    }

    @PostMapping("/request-product")
    fun postRequestMoreProduct(body: RequestMoreProductForm, redirectAttributes: RedirectAttributes): String {
        logger.info("yooooooo")
        val encodedSubject = URLEncoder.encode("Đặt hàng", "UTF-8").replace("+", "%20")
        var bodyStr = "Chào bạn, tôi muốn đặt thêm:\n"

        // Construct mailto URI
        if (body.clothId1.isNotEmpty()) {
            val cloth = clothService.findClothById(body.clothId1.toLong())
            bodyStr += "${body.quantity1} sản phẩm ${cloth!!.name}\n"
        }
        if (body.clothId2.isNotEmpty()) {
            val cloth = clothService.findClothById(body.clothId2.toLong())
            bodyStr += "${body.quantity2} sản phẩm ${cloth!!.name}\n"
        }
        if (body.clothId3.isNotEmpty()) {
            val cloth = clothService.findClothById(body.clothId3.toLong())
            bodyStr += "${body.quantity3} sản phẩm ${cloth!!.name}\n"
        }

//        if (cloth?.seller?.id?.toInt() != body.sellerId) {
//            redirectAttributes[Constants.ATTR_ERROR_MSG] = "Lỗi: Người bán không chính xác. Gợi ý: ${cloth!!.seller!!.name}"
//            return "redirect:/inventory/request-product"
//        }
        // Encode subject and body
        val encodedBody = URLEncoder.encode(bodyStr, "UTF-8").replace("+", "%20")
        val cloth = clothService.findClothById(body.clothId1.toLong())
        val intent = "mailto:${cloth!!.seller!!.email}?subject=$encodedSubject&body=$encodedBody"

        return "redirect:$intent"
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
            inventoryService.sellOut(
                user = user,
                productId = form.productId,
                quantity = form.quantity,
                date = form.date
            )
        }
        return "redirect:/inventory"
    }
}