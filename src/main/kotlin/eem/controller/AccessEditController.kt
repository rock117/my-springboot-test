package eem.controller

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/eem/api")
class AccessEditController {
    @PostMapping("/AssessEdit")
    fun get(@RequestBody req:Request): Map<String, Any> {
        val methodType = req.methodType

        return mapOf("scopeMark" to "1", "type" to "2", "validDateBegin" to "2020-01-01",
            "productName" to "productName hello world",
            "totalprice" to 1.2,
            "description" to "hello world",
            "expireYears" to 123

        )
    }

    @PostMapping("/AssessPurchaseHistoryList")
    fun getAssessPurchaseHistory(@RequestBody req:Request): Map<String, Any> {
        val currentPage:Int = req.currentPage!!
        val pageSize:Int  = req.pageSize!!
        val list = io.vavr.collection.List.range(0, 333).mapIndexed { index, e ->
            val map = mutableMapOf<Any?, Any?>()
            map.put("id", "$index")
            map.put("productName", "productName-{$index}")

            map.put("totalprice", 1.233)// "contractid": "H202000100",
            map.put("purchasingDate", "purchasingDate111")
            map.put("expireYears", 111)
            map.put("remaindays", 999)
            map.put("xqmc", "校区-$index")
            map.put("orderId", "流水123")
            map.put("statusName", "statusName111")

            map.put("finalprice", 1.2132)
            map.put("approversTelephone", "approversTelephone")
            map.put("approversName", "approversName")
            map.put("createdate", "createdate")

            map.put("reviewtime", "reviewtime")
            map.put("xqmc", "xqmc")
            map
        }
        return mapOf("list" to getPagingdData(list, currentPage, pageSize), "resultcout" to list.size, "pageSize" to pageSize )

    }


}