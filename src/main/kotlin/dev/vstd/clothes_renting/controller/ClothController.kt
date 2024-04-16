package dev.vstd.clothes_renting.controller

import dev.vstd.clothes_renting.Constants
import dev.vstd.clothes_renting.data.entity.ClothEntity
import dev.vstd.clothes_renting.data.service.ClothService
import dev.vstd.clothes_renting.data.service.SellerService
import dev.vstd.clothes_renting.domain.Cloth
import org.springframework.http.MediaType
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
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

    @PostMapping("/new", consumes = [MediaType.APPLICATION_FORM_URLENCODED_VALUE])
    fun postNewCloth(body: Cloth): String {
        logger.log(java.util.logging.Level.INFO, body.toString())
        clothService.saveCloth(body)
        return "redirect:/cloth"
    }

    @PostMapping("/edit", consumes = [MediaType.APPLICATION_FORM_URLENCODED_VALUE])
    fun postEditCloth(body: Cloth): String {
        logger.log(java.util.logging.Level.INFO, body.toString())
        clothService.saveCloth(body)
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
        model[Constants.ATTR_SELLERS] = sellerService.getSellers()
        return "add_cloth"
    }

    @GetMapping("/edit")
    fun editCloth(@RequestParam id: String, model: Model): String {
        val record = clothService.findClothById(id.toLong())
        if (record != null) {
            model[Constants.ATTR_SELLERS] = sellerService.getSellers()
            model[Constants.ATTR_CLOTH_ITEM] = record
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
}