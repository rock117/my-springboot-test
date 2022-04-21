package eem.controller

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/eem/api")
class AboutusController {

    @PostMapping("/AboutusAddApi")
    fun getXufeiBoughtList(@RequestBody req:Request): Map<String, Any> {
        return mapOf("id" to "11111", "canSave" to true)
    }

    @PostMapping("/AdvertisingAddApi")
    fun a(@RequestBody req:Request): Map<String, Any> {
        return mapOf("id" to "11111", "canSave" to true)
    }
    @PostMapping("/ActivitiesAddApi")
    fun b(@RequestBody req:Request): Map<String, Any> {
        return mapOf("id" to "11111", "canSave" to true)
    }
}