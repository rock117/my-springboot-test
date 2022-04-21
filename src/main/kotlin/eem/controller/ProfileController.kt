package eem.controller

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/eem/api")
class ProfileController {
    @PostMapping("/BasicInfomationGet")
    fun BasicInfomationGet(@RequestBody req:Request): Map<String, Any> {
        val methodType = req.methodType

        return mapOf("scopeMark" to "1", "type" to "2", "validDateBegin" to "2020-01-01",
            "productName" to "productName hello world",
            "totalprice" to 1.2,
            "description" to "hello world",
            "expireYears" to 123,
            "telephone" to "15578002225"

        )
    }
}