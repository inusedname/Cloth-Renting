package dev.vstd.clothes_renting

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Configuration
import org.springframework.format.FormatterRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import java.time.LocalDate

@SpringBootApplication
class ClothesRentingApplication {

	@Configuration
	class WebMvcConfig: WebMvcConfigurer {
		override fun addFormatters(registry: FormatterRegistry) {
			super.addFormatters(registry)
			registry.addConverter(String::class.java, LocalDate::class.java) { source ->
				LocalDate.parse("$source-01")
			}
		}
	}
}

fun main(args: Array<String>) {
	runApplication<ClothesRentingApplication>(*args)
}
