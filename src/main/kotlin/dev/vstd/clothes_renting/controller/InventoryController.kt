package dev.vstd.clothes_renting.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/inventory")
class InventoryController {

    @GetMapping("/request-product")
    fun getRequestMoreProduct(): String {
        TODO("Not yet implemented")
    }

    @PostMapping("/request-product")
    fun postRequestMoreProduct(): String {
        TODO("Not yet implemented")
    }

    @GetMapping("/dashboard")
    fun inventoryStatus(): String {
        TODO("Not yet implemented")
    }

    @GetMapping("/history")
    fun inventoryHistory(): String {
        TODO("Not yet implemented")
    }

    @GetMapping("/make-change")
    fun getChangeInventory(): String {
        TODO("Not yet implemented")
    }

    @PostMapping("/make-change")
    fun postChangeInventory(): String {
        TODO("Not yet implemented")
    }
}