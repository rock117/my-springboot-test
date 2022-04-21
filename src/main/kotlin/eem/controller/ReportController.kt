package eem.controller

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/eem/api")
class ReportController {

    @PostMapping("/TeacherSales")
    fun getTeacherSales(@RequestBody req:Request): Map<String, Any> {
        val currentPage:Int = req.currentPage!!
        val pageSize:Int  = req.pageSize!!
        val list = io.vavr.collection.List.range(0, 333).mapIndexed { index, e ->
            val map = mutableMapOf<Any?, Any?>()
            map.put("id", "$index")
            map.put("title", "有书 |蓝精灵全新力作，考验智力和耐力的精美游戏活动书来啦！！")

            map.put("refundconstractPrice", 1.2)// "contractid": "H202000100",
            map.put("publishMark", if(index % 2 == 0) true else false)
            map.put("newConstractPrice", 3)
            map.put("createDatetime", "2020-09-09")
            map.put("rank", 3)
            map.put("mediaUrl", "http://abc.com222")
            map.put("url", "http://abc.com222")
            map
        }
        val campusList = mapOf("1" to "广西", "2" to "广东")
        return mapOf("list" to getPagingdData(list, currentPage, pageSize),
            "campusMap" to campusList, "campusSearchRender" to true,
            "resultcout" to list.size, "pageSize" to pageSize )

    }

    @PostMapping("/StudentMarketDetail")
    fun getStudentMarketDetail(@RequestBody req:Request): Map<String, Any> {
        val currentPage:Int = req.currentPage!!
        val pageSize:Int  = req.pageSize!!
        val list = io.vavr.collection.List.range(0, 333).mapIndexed { index, e ->
            val map = mutableMapOf<Any?, Any?>()
            map.put("id", "$index")
            map.put("title", "有书 |蓝精灵全新力作，考验智力和耐力的精美游戏活动书来啦！！")

            map.put("refundconstractPrice", 1.2)// "contractid": "H202000100",
            map.put("publishMark", if(index % 2 == 0) true else false)
            map.put("qianYue", 3)
            map.put("createDatetime", "2020-09-09")
            map.put("rank", 3)
            map.put("mediaUrl", "http://abc.com222")
            map.put("url", "http://abc.com222")
            map
        }
        return mapOf("list" to getPagingdData(list, currentPage, pageSize), "resultcout" to list.size, "pageSize" to pageSize )

    }

    @PostMapping("/StudentOriginDetail")
    fun StudentOriginDetail(@RequestBody req:Request): Map<String, Any> {
        val currentPage:Int = req.currentPage!!
        val pageSize:Int  = req.pageSize!!
        val list = io.vavr.collection.List.range(0, 333).mapIndexed { index, e ->
            val map = mutableMapOf<Any?, Any?>()
            map.put("id", "$index")
            map.put("title", "有书 |蓝精灵全新力作，考验智力和耐力的精美游戏活动书来啦！！")

            map.put("refundconstractPrice", 1.2)// "contractid": "H202000100",
            map.put("publishMark", if(index % 2 == 0) true else false)
            map.put("qianYue", 3)
            map.put("createDatetime", "2020-09-09")
            map.put("rank", 3)
            map.put("mediaUrl", "http://abc.com222")
            map.put("url", "http://abc.com222")
            map
        }
        val campusList = mapOf("1" to "广西", "2" to "广东")
        return mapOf("list" to getPagingdData(list, currentPage, pageSize),
            "campusMap" to campusList, "campusSearchRender" to true,
            "resultcout" to list.size, "pageSize" to pageSize )

    }
    @PostMapping("/SheduleCourse")
    fun SheduleCourse(@RequestBody req:Request): Map<String, Any> {
        val currentPage:Int = req.currentPage!!
        val pageSize:Int  = req.pageSize!!
        val list = io.vavr.collection.List.range(0, 333).mapIndexed { index, e ->
            val map = mutableMapOf<Any?, Any?>()
            map.put("id", "$index")
            map.put("title", "有书 |蓝精灵全新力作，考验智力和耐力的精美游戏活动书来啦！！")

            map.put("refundconstractPrice", 1.2)// "contractid": "H202000100",
            map.put("publishMark", if(index % 2 == 0) true else false)
            map.put("qianYue", 3)
            map.put("createDatetime", "2020-09-09")
            map.put("rank", 3)
            map.put("mediaUrl", "http://abc.com222")
            map.put("url", "http://abc.com222")
            map
        }
        val campusList = mapOf("1" to "广西", "2" to "广东")
        return mapOf("list" to getPagingdData(list, currentPage, pageSize),
            "campusMap" to campusList, "campusSearchRender" to true,
            "resultcout" to list.size, "pageSize" to pageSize )

    }

    @PostMapping("/StudentAddForYearDetail")
    fun StudentAddForYearDetail(@RequestBody req:Request): Map<String, Any> {
        val campusList = mapOf("1" to "广西", "2" to "广东")
        return mapOf("data" to mapOf(
            "year" to 2020,
            "total1" to "120", "qianYue1" to "55",
            "total2" to "333", "qianYue2" to "10",
            "total3" to "55", "qianYue3" to "1",
            "total4" to "88", "qianYue4" to "0",
            "total5" to "123", "qianYue5" to "111",
            "total6" to "123", "qianYue6" to "111",

            "total7" to "120", "qianYue7" to "55",
            "total8" to "333", "qianYue8" to "10",
            "total9" to "55", "qianYue9" to "1",
            "total10" to "88", "qianYue10" to "0",
            "total11" to "123", "qianYue11" to "111",
            "total12" to "123", "qianYue12" to "111",
            "campusMap" to campusList, "campusSearchRender" to true
        ))
    }

    @PostMapping("/StudentStatusClassifyDetail")
    fun StudentStatusClassifyDetail(@RequestBody req:Request): Map<String, Any?> {
        val campusList = mapOf("1" to "广西", "2" to "广东")
        return mapOf("data" to mapOf(
            "year" to 2020,
            "biyeshu" to null,
            "qianYueshu" to "55",
            "shitingshu" to "333",
            "noShiTingshu" to "10",

            "total3" to "55",
            "gongHaishu" to "1",
            "dongJieshu" to "88",

            "campusMap" to campusList, "campusSearchRender" to true
        ))
    }


    @PostMapping("/tttList")
    fun tttList(@RequestBody req:Request): Map<String, Any> {
        val currentPage:Int = req.currentPage!!
        val pageSize:Int  = req.pageSize!!
        val list = io.vavr.collection.List.range(0, 333).mapIndexed { index, e ->
            val map = mutableMapOf<Any?, Any?>()
            map.put("rowId", "$index")
            map.put("title", "有书 |蓝精灵全新力作，考验智力和耐力的精美游戏活动书来啦！！")

            map.put("refundconstractPrice", 1.2)// "contractid": "H202000100",
            map.put("publishMark", if(index % 2 == 0) true else false)
            map.put("qianYue", 3)
            map.put("createDatetime", "2020-09-09")
            map.put("rank", 3)
            map.put("mediaUrl", "http://abc.com222")
            map.put("url", "http://abc.com222")
            map
        }
        val columns = listOf(
            mapOf("id" to "title", "name" to "标题"),
            mapOf("id" to "rank", "name" to "分数")
        )
        val campusList = mapOf("1" to "广西", "2" to "广东")
        return mapOf("list" to getPagingdData(list, currentPage, pageSize),
            "campusMap" to campusList, "campusSearchRender" to true,
            "columns" to columns,
            "resultcout" to list.size, "pageSize" to pageSize )

    }

    @PostMapping("/StudentFollowUpDetail")
    fun StudentFollowUpDetail(@RequestBody req:Request): Map<String, Any> {
        val currentPage:Int = req.currentPage!!
        val pageSize:Int  = req.pageSize!!
        val list = io.vavr.collection.List.range(0, 333).mapIndexed { index, e ->
            val map = mutableMapOf<Any?, Any?>()
            map.put("id", "$index")
            map.put("title", "有书 |蓝精灵全新力作，考验智力和耐力的精美游戏活动书来啦！！")

            map.put("refundconstractPrice", 1.2)// "contractid": "H202000100",
            map.put("publishMark", if(index % 2 == 0) true else false)
            map.put("qianYue", 3)
            map.put("createDatetime", "2020-09-09")
            map.put("rank", 3)
            map.put("mediaUrl", "http://abc.com222")
            map.put("url", "http://abc.com222")
            map
        }
        val campusList = mapOf("1" to "广西", "2" to "广东")
        return mapOf("list" to getPagingdData(list, currentPage, pageSize),
            "campusMap" to campusList, "campusSearchRender" to true,
            "resultcout" to list.size, "pageSize" to pageSize )

    }
    @PostMapping("/TeacherSalaryYear")
    fun TeacherSalaryYear(@RequestBody req:Request): Map<String, Any> {
        val currentPage:Int = req.currentPage!!
        val pageSize:Int  = req.pageSize!!
        val list = io.vavr.collection.List.range(0, 333).mapIndexed { index, e ->
            val map = mutableMapOf<Any?, Any?>()
            map.put("id", "$index")
            map.put("title", "有书 |蓝精灵全新力作，考验智力和耐力的精美游戏活动书来啦！！")

            map.put("refundconstractPrice", 1.2)// "contractid": "H202000100",
            map.put("publishMark", if(index % 2 == 0) true else false)
            map.put("qianYue", 3)
            map.put("createDatetime", "2020-09-09")
            map.put("rank", 3)
            map.put("mediaUrl", "http://abc.com222")
            map.put("url", "http://abc.com222")
            map
        }
        val campusList = mapOf("1" to "广西", "2" to "广东")
        return mapOf("list" to getPagingdData(list, currentPage, pageSize),
            "campusMap" to campusList, "campusSearchRender" to true,
            "resultcout" to list.size, "pageSize" to pageSize )

    }
    @PostMapping("/CampusIncomeYear")
    fun CampusIncomeYear(@RequestBody req:Request): Map<String, Any> {
         return base(req)
    }
    fun base(@RequestBody req:Request): Map<String, Any> {
        val currentPage:Int = req.currentPage!!
        val pageSize:Int  = req.pageSize!!
        val list = io.vavr.collection.List.range(0, 333).mapIndexed { index, e ->
            val map = mutableMapOf<Any?, Any?>()
            map.put("id", "$index")
            map.put("title", "有书 |蓝精灵全新力作，考验智力和耐力的精美游戏活动书来啦！！")

            map.put("refundconstractPrice", 1.2)// "contractid": "H202000100",
            map.put("publishMark", if(index % 2 == 0) true else false)
            map.put("qianYue", 3)
            map.put("createDatetime", "2020-09-09")
            map.put("rank", 3)
            map.put("mediaUrl", "http://abc.com222")
            map.put("url", "http://abc.com222")
            map
        }
        val campusList = mapOf("1" to "广西", "2" to "广东")
        return mapOf("list" to getPagingdData(list, currentPage, pageSize),
            "campusMap" to campusList, "campusSearchRender" to true,
            "resultcout" to list.size, "pageSize" to pageSize )

    }


    @PostMapping("/StudentAuditionChangeDetail")
    fun StudentAuditionChangeModel(@RequestBody req:Request): Map<String, Any> {
        return base(req)
    }

    @PostMapping("/StudentCourseRemainDetail")
    fun StudentCourseRemainModel(@RequestBody req:Request): Map<String, Any> {
        return base(req)
    }

    @PostMapping("/CampusPayOrderYear")
    fun CampusPayOrderYear(@RequestBody req:Request): Map<String, Any> {
        return base(req)
    }
}