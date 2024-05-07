package dev.vstd.clothes_renting.controller

import dev.vstd.clothes_renting.Constants
import dev.vstd.clothes_renting.data.entity.ProductsOfOrderEntity
import dev.vstd.clothes_renting.data.entity.UserEntity
import dev.vstd.clothes_renting.data.service.BuyInOrderService
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
import java.time.LocalDateTime
import java.util.logging.Logger

@Controller
@RequestMapping("/inventory")
class InventoryController(
    private val inventoryService: InventoryService,
    private val clothService: ClothService,
    private val sellerService: SellerService,
    private val buyInOrderService: BuyInOrderService,
) {
    private val logger = Logger.getLogger(InventoryController::class.qualifiedName)

    @GetMapping("/request-product")
    fun getRequestMoreProduct(
        model: Model,
        @RequestParam(required = false) errorMessage: String?,
        @RequestParam(required = false) sellerId: Long?,
        request: HttpServletRequest
    ): String {
        model[Constants.ATTR_SELLERS] = sellerService.getSellers()
        if (errorMessage != null) {
            model[Constants.ATTR_ERROR_MSG] = errorMessage
        }
        if (sellerId != null) {
            if (request.session.getAttribute("sellerId") != sellerId) {
                resetCart(request)
            }
            request.session.setAttribute("sellerId", sellerId)
            val cart = request.session.getAttribute("cart") as MutableMap<Long, Int>
            val displayCart = cart.map {
                val cloth = clothService.findClothById(it.key)!!
                cloth.name to it.value
            }
            model["cart"] = displayCart
        }
        return "request_product"
    }

    private fun resetCart(request: HttpServletRequest) {
        request.session.setAttribute("cart", mutableMapOf<Long, Int>())
    }

    @GetMapping("/request-product-more")
    fun getRequestProductMore(
        model: Model,
        @RequestParam(required = false) editableClothId: Long?,
        request: HttpServletRequest
    ): String {
        val sellerId = request.session.getAttribute("sellerId") as Long
        if (editableClothId != null) {
            val clothEntity = clothService.findClothById(editableClothId)!!
            model[Constants.ATTR_CLOTH_ITEM] = clothEntity
            val cart = request.session.getAttribute("cart") as MutableMap<Long, Int>
            model["quantity"] = cart[editableClothId] ?: 0
        }
        val seller = sellerService.getSellerById(sellerId)!!
        val clothes = seller.clothes
        model["sellerName"] = seller.name
        model["products"] = clothes
        return "request_product_more"
    }

    @PostMapping("/request-product-more")
    fun postRequestProductMore(
        @RequestParam clothId: Long,
        @RequestParam quantity: Int,
        request: HttpServletRequest
    ): String {
        val cart = request.session.getAttribute("cart") as MutableMap<Long, Int>
        cart[clothId] = (cart[clothId] ?: 0) + quantity
        request.session.setAttribute("cart", cart)
        val sellerId = request.session.getAttribute("sellerId") as Long
        return "redirect:/inventory/request-product?sellerId=$sellerId"
    }

    @PostMapping("/request-product")
    fun postRequestMoreProduct(@RequestParam body: Map<String, String>, request: HttpServletRequest): String {
        val clothes = mutableListOf<ProductsOfOrderEntity>()
        val cart = request.session.getAttribute("cart") as MutableMap<Long, Int>
        for ((clothId, quantity) in cart) {
            val clothEntity = clothService.findClothById(clothId)!!
            if (quantity > 0) {
                clothes.add(
                    ProductsOfOrderEntity(
                        clothEntity = clothEntity,
                        quantity = quantity,
                        snapshotPrice = clothEntity.price
                    )
                )
            }
        }

        buyInOrderService.buyIn(
            user = request.session.getAttribute(Constants.ATTR_USER) as UserEntity,
            date = LocalDateTime.now(),
            clothes = clothes,
            sellerEntity = sellerService.getSellerById(body["sellerId"]!!.toLong())!!
        )
        return "redirect:/order"
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
}