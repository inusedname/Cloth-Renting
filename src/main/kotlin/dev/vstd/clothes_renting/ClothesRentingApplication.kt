package dev.vstd.clothes_renting

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean
import org.springframework.context.annotation.Bean

@SpringBootApplication
class ClothesRentingApplication

fun main(args: Array<String>) {
	runApplication<ClothesRentingApplication>(*args)
}
