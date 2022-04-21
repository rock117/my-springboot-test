package eem.controller

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/eem")
class StudentContractCashRecordController {

    @PostMapping("/api/StudentContractCashRecord")
    fun get(@RequestBody req:Request): Any {
        val index = 1
        val map = mutableMapOf<Any?, Any?>()
        map.put("id", "$index")
        map.put("contractid", "contractid-{$index}")

        map.put("contractname", "合同名1")// "contractid": "H202000100",
        map.put("studentxm", "张三")
        map.put("studentxh", "学号-$index")
        map.put("teacherxm", "提交人-$index")
        map.put("teacherzgh", "提交人工号-$index")
        map.put("status", "1")
        map.put("statusName", "statusName")

        map.put("finalprice", 1.2132)
        map.put("approversTelephone", "approversTelephone")
        map.put("approversName", "approversName")
        map.put("createdate", "createdate")

        map.put("reviewtime", "reviewtime")
        map.put("xqmc", "xqmc")
        return map
    }



    @PostMapping("/api/StudentContractCashRecordList")
    fun getList(@RequestBody req:Request): Map<String, Any> {
        val currentPage:Int = req.currentPage!!
        val pageSize:Int  = req.pageSize!!
        val list = io.vavr.collection.List.range(0, 333).mapIndexed { index, e ->
            val map = mutableMapOf<Any?, Any?>()
            map.put("id", "$index")
            map.put("contractid", "contractid-{$index}")

            map.put("contractname", "合同名1")// "contractid": "H202000100",
            map.put("studentxm", "张三")
            map.put("studentxh", "学号-$index")
            map.put("teacherxm", "提交人-$index")
            map.put("teacherzgh", "提交人工号-$index")
            map.put("status", "0")
            map.put("statusName", "statusName")

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