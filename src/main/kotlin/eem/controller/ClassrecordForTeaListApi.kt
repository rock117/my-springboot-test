package eem.controller

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/eem")
class ClassrecordForTeaListApi {
    @PostMapping("/api/ClassrecordForTeaList")
    fun getList(@RequestBody req:Request): Map<String, Any> {
        if(req.type != null) {
            return mapOf("url" to "http://www.baidu.com")
        }
        val currentPage:Int = req.currentPage!!
        val pageSize:Int  = req.pageSize!!
        val list = io.vavr.collection.List.range(0, 333).mapIndexed { index, e ->
            val map = mutableMapOf<Any?, Any?>()
            map.put("teacherZgh", "$index")
            map.put("teacherXm", "张老师$index")
            map.put("kch", "$index")

            map.put("kcmc", "课程$index")// "contractid": "H202000100",
            map.put("publishMark", if(index % 2 == 0) true else false)
            map.put("orderid", "1-$index")
            map.put("createDatetime", "2020-09-09")
            map.put("readingamout", 3)
            map.put("mediaUrl", "http://abc.com222")
            map.put("url", "http://www.baidu.com")
            map
        }
        val campusList = mapOf("1" to "广西", "2" to "广东")
        return mapOf("list" to getPagingdData(list, currentPage, pageSize),
            "campusMap" to campusList, "campusSearchRender" to true,
            "resultcout" to list.size, "pageSize" to pageSize )

    }

}