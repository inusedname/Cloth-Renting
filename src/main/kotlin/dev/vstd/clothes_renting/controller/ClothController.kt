package dev.vstd.clothes_renting.controller

import dev.vstd.clothes_renting.Constants
import dev.vstd.clothes_renting.controller.form.UpdateClothForm
import dev.vstd.clothes_renting.data.entity.SellerEntity
import dev.vstd.clothes_renting.data.service.ClothService
import dev.vstd.clothes_renting.data.service.SellerService
import jakarta.validation.Valid
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.*
import java.util.logging.Logger

@Controller
@RequestMapping("/cloth")
class ClothController(private val clothService: ClothService, private val sellerService: SellerService) {
    private val logger = Logger.getLogger(ClothController::class.java.name)

    @GetMapping("")
    fun dashboard(model: Model): String {
        val records = clothService.getAllClothes()
        model[Constants.ATTR_RECORDS] = records
        return "dashboard_clothes"
    }

    @PostMapping("/save")
    fun postNewCloth(
        @Valid @ModelAttribute("cloth") cloth: UpdateClothForm,
        bindingResult: BindingResult,
        model: Model
    ): String {
        if (bindingResult.hasErrors()) {
            logger.info("Error when saving cloth")
            // TODO: there should be some way to redirect + binding result, right?
            model[Constants.ATTR_SELLERS] = getListOfSellers(sellerService)
            return "add_cloth"
        }
        clothService.saveCloth(cloth)
        return "redirect:/cloth"
    }

    @GetMapping("/delete")
    fun deleteCloth(@RequestParam id: String): String {
        logger.log(java.util.logging.Level.INFO, "Deleting cloth with id: $id")
        clothService.deleteCloth(id.toLong())
        return "redirect:/cloth"
    }

    @GetMapping("/new")
    fun newCloth(model: Model): String {
        model[Constants.ATTR_SELLERS] = getListOfSellers(sellerService)
        model["cloth"] = UpdateClothForm()
        return "add_cloth"
    }

    @GetMapping("/edit")
    fun editCloth(@RequestParam id: String, model: Model): String {
        val record = clothService.findClothById(id.toLong())
        if (record != null) {
            model[Constants.ATTR_SELLERS] = getListOfSellers(sellerService)
            model["cloth"] = UpdateClothForm(
                id = record.id,
                name = record.name,
                previewImage = record.previewImage,
                price = record.price,
                description = record.description,
                sellerId = record.seller!!.id
            )
            return "add_cloth"
        } else {
            return "404"
        }
    }

    @GetMapping("/detail")
    fun detail(@RequestParam id: String, model: Model): String {
        val record = clothService.findClothById(id.toLong())
        if (record != null) {
            model[Constants.ATTR_CLOTH_ITEM] = record
            return "detail_cloth"
        } else {
            return "404"
        }
    }

    private fun getListOfSellers(sellerService: SellerService): List<SellerEntity> {
        val sellers = mutableListOf<SellerEntity>()
        sellers += SellerEntity(id = -1L, "Chọn sản phẩm", "", "", "", "")
        sellers += sellerService.getSellers()
        return sellers
    }
}