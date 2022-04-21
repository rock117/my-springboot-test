package eem.controller

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/eem/api")
class JifenController {
    @PostMapping("/JifenOnAndOff")
    fun c3(@RequestBody req:Request): Map<String, Any> {
        return mapOf("jifenOnoff" to  "1", "commpleteUserOnOff" to "1",
        "qiandaoForJifenShangOnOff" to "1", "publishhudongbaOnOff" to "1",
        "reconmandtolistingOnOff" to "1", "reconmandtoRefundOnOff" to "1", "reconmandtofundOnOff" to "1")
    }
}