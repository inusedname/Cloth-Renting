package dev.vstd.clothes_renting.controller

import dev.vstd.clothes_renting.Constants
import dev.vstd.clothes_renting.controller.form.RequestMoreProductForm
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
        @RequestParam(required = false) sellerId: Long?
    ): String {
        model[Constants.ATTR_SELLERS] = sellerService.getSellers()
        if (errorMessage != null) {
            model[Constants.ATTR_ERROR_MSG] = errorMessage
        }
        if (sellerId != null) {
            model[Constants.ATTR_PRODUCTS] = clothService.getAllClothes().filter { it.seller!!.id == sellerId }
        }
        return "request_product"
    }

    @PostMapping("/request-product")
    fun postRequestMoreProduct(body: RequestMoreProductForm, request: HttpServletRequest): String {
        val clothes = mutableListOf<ProductsOfOrderEntity>()

        // Construct mailto URI
        if (body.clothId1.isNotEmpty()) {
            val cloth = clothService.findClothById(body.clothId1.toLong())
            clothes += ProductsOfOrderEntity(
                clothEntity = cloth!!,
                quantity = body.quantity1,
                snapshotPrice = cloth.price
            )
        }
        if (body.clothId2.isNotEmpty()) {
            val cloth = clothService.findClothById(body.clothId2.toLong())
            clothes += ProductsOfOrderEntity(
                clothEntity = cloth!!,
                quantity = body.quantity2,
                snapshotPrice = cloth.price
            )
        }
        if (body.clothId3.isNotEmpty()) {
            val cloth = clothService.findClothById(body.clothId3.toLong())
            clothes += ProductsOfOrderEntity(
                clothEntity = cloth!!,
                quantity = body.quantity3,
                snapshotPrice = cloth.price
            )
        }

        buyInOrderService.buyIn(
            user = request.session.getAttribute(Constants.ATTR_USER) as UserEntity,
            date = LocalDateTime.now(),
            clothes = clothes,
            sellerEntity = sellerService.getSellerById(body.sellerId)!!
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