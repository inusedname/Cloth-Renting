package dev.vstd.clothes_renting

import dev.vstd.clothes_renting.data.entity.ClothEntity
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ClothesRentingApplication

fun main(args: Array<String>) {
	runApplication<ClothesRentingApplication>(*args)
}
