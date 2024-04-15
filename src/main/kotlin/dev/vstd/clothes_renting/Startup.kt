package dev.vstd.clothes_renting

import dev.vstd.clothes_renting.data.entity.UserEntity
import jakarta.servlet.http.HttpSessionEvent
import jakarta.servlet.http.HttpSessionListener

class Startup: HttpSessionListener {
    override fun sessionCreated(se: HttpSessionEvent?) {
        super.sessionCreated(se)
        val users = arrayOf(
            UserEntity(1, "admin", "admin", "admin", Role.ADMIN.id),
            UserEntity(2, "user", "user", "user", Role.USER.id),
        )
        se?.session?.apply {
            setAttribute("users", users)
            setAttribute(Constants.ATTR_USER, users[0])
        }
    }
}