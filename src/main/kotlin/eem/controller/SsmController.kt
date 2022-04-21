package eem.controller

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/eem/api")
class SsmController {
    @PostMapping("/SmsTemplateList")
    fun getList(@RequestBody req:Request): Map<String, Any> {
        val currentPage:Int = req.currentPage!!
        val pageSize:Int  = req.pageSize!!
        val list = io.vavr.collection.List.range(0, 333).mapIndexed { index, e ->
            val map = mutableMapOf<Any?, Any?>()
            map.put("id", "$index")
            map.put("templateName", "书来啦！！")

            map.put("templateCode", 1)// "contractid": "H202000100",
            map.put("templateType", 1)
            map.put("templateStatus", "1")
            map.put("xqmc", "校区123")
            map.put("createDate", "2020-01-09")
            map.put("active", "1")
            map.put("url", "http://abc.com222")
            map
        }
        return mapOf("list" to getPagingdData(list, currentPage, pageSize), "resultcout" to list.size, "pageSize" to pageSize )

    }
    @PostMapping("/StudentListForGroupSendSms")
    fun StudentListForGroupSendSms(@RequestBody req:Request): Map<String, Any> {
        val currentPage:Int = req.currentPage!!
        val pageSize:Int  = req.pageSize!!
        val list = io.vavr.collection.List.range(0, 333).mapIndexed { index, e ->
            val map = mutableMapOf<Any?, Any?>()
            map.put("xh", "$index")
            map.put("xm", "xm-$index")
            map.put("xb", "xb")

            map.put("templateCode", 1)// "contractid": "H202000100",
            map.put("templateType", 1)
            map.put("templateStatus", "1")
            map.put("xqmc", "校区123")
            map.put("createDate", "2020-01-09")
            map.put("active", "1")
            map.put("url", "http://abc.com222")
            map
        }
        return mapOf("list" to getPagingdData(list, currentPage, pageSize), "resultcout" to list.size, "pageSize" to pageSize )

    }


    @PostMapping("/SmsTemplateListForSendGroupSmsStudent")
    fun SmsTemplateListForSendGroupSmsStudent(@RequestBody req:Request): Any {
        val currentPage:Int = req.currentPage!!
        val pageSize:Int  = req.pageSize!!
        val list = io.vavr.collection.List.range(0, 333).mapIndexed { index, e ->
            val map = mutableMapOf<Any?, Any?>()
            map.put("id", "$index")
            map.put("templateCode", "code-$index")
            map.put("templateName", "TemplateName-$index")

            map.put("templateContent", "TemplateContent-$index")// "contractid": "H202000100",

            map
        }
        return mapOf("list" to getPagingdData(list, currentPage, pageSize), "resultcout" to list.size, "pageSize" to pageSize )

    }

    @PostMapping("/StudentListForZongbuGroupSendSmsApi")
    fun StudentListForZongbuGroupSendSmsApi(@RequestBody req:Request): Any {
        val currentPage:Int = req.currentPage!!
        val pageSize:Int  = req.pageSize!!
        val list = io.vavr.collection.List.range(0, 333).mapIndexed { index, e ->
            val map = mutableMapOf<Any?, Any?>()
            map.put("id", "$index")
            map.put("templateCode", "code-$index")
            map.put("templateName", "TemplateName-$index")

            map.put("templateContent", "TemplateContent-$index")// "contractid": "H202000100",

            map
        }
        return mapOf("list" to getPagingdData(list, currentPage, pageSize), "resultcout" to list.size, "pageSize" to pageSize )

    }


    @PostMapping("/SmsTemplate")
    fun model(): Map<String, Any> {
        return mapOf(
            "id" to 123,
            "templateName" to "templateName123",
            "remark" to "remark1",
            "reason" to "reason 123",
            "active" to "1",
            "templateStatus" to "0"

        )
    }
    @PostMapping("/SmsSendAction")
    fun SmsSendAction(): Map<String, Any> {
        return mapOf(
            "result" to true,
            "templateName" to "templateName123",
            "remark" to "remark1",
            "active" to "1",
            "templateStatus" to "1"

        )
    }
}