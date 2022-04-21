package eem.controller

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/eem")
class CampusController {
    @PostMapping("/api/CampusListForSelectingSmsApi")
    fun getList(@RequestBody req:Request): Map<String, Any> {
        val currentPage: Int = req.currentPage!!
        val pageSize: Int = req.pageSize!!
        val list = io.vavr.collection.List.range(0, 333).mapIndexed { index, e ->
            val map = mutableMapOf<Any?, Any?>()
            map.put("xqh", "$index")
            map.put("xqmc", "abc-$index")
            map
        }
        return mapOf(
            "list" to getPagingdData(list, currentPage, pageSize),
            "resultcout" to list.size,
            "pageSize" to pageSize
        )
        }
    }