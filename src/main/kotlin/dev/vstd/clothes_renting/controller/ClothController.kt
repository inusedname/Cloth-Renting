package dev.vstd.clothes_renting.controller

import dev.vstd.clothes_renting.Constants
import dev.vstd.clothes_renting.data.service.ClothService
import dev.vstd.clothes_renting.data.service.SellerService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
@RequestMapping("/cloth")
class ClothController(private val clothService: ClothService, private val sellerService: SellerService) {

    @GetMapping("")
    fun dashboard(model: Model): String {
        val records = clothService.getAllClothes()
        model[Constants.ATTR_RECORDS] = records
        return "dashboard_clothes"
    }

    @PostMapping("/new-cloth")
    fun postNewCloth(): String {
        TODO("Not yet implemented")
    }

    @GetMapping("/delete")
    fun deleteCloth(@RequestParam id: String): String {
        TODO("Not yet implemented")
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