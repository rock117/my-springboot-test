package eem.controller

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/eem/api")
class CouponController {

    @PostMapping("/StudentCoupon")
    fun get(@RequestBody req:Request): Map<String, Any> {
        return mapOf("scopeMark" to "1", "type" to "2", "validDateBegin" to "2020-01-01",
            "detail" to "hello world",
            "applicableCourseSet" to arrayOf("1", "2"),
            "applicableCoursePackageSet" to arrayOf("105113", "a"),
            "title" to "1234",
            "id" to 222,
            "usedNumber" to 2,
            "usedToMall" to true,
            "enable" to true,
            "thumbnailUrl" to "https://ty.ayyt.com/eem/image/common/logo.jpg",
            "conponpairSet" to arrayOf(1, 2)
        )
    }
    @PostMapping("/coupon/StudentCouponList")
    fun getList(@RequestBody req:Request): Map<String, Any> {
        val currentPage:Int = req.currentPage!!
        val pageSize:Int  = req.pageSize!!
        val list = io.vavr.collection.List.range(0, 333).mapIndexed { index, e ->
            val map = mutableMapOf<Any?, Any?>()
            map.put("id", "$index")
            map.put("title", "有书 |蓝精灵全新力作，考验智力和耐力的精美游戏活动书来啦！！")

            map.put("type", 1)// "contractid": "H202000100",
            map.put("publishMark", if(index % 2 == 0) true else false)
            map.put("orderid", "1-$index")
            map.put("createDatetime", "2020-09-09")
            map.put("readingamout", 3)
            map.put("mediaUrl", "http://abc.com222")
            map.put("url", "http://abc.com222")
            map
        }
        return mapOf("list" to getPagingdData(list, currentPage, pageSize), "resultcout" to list.size, "pageSize" to pageSize )

    }


    @PostMapping("/StudentCouponpairSearchingforCouponList")
    fun c(@RequestBody req:Request): Map<String, Any> {
        val currentPage:Int = 1// req.currentPage!!
        val pageSize:Int  = 11111111//req.pageSize!!
        val list = io.vavr.collection.List.range(0, 333).mapIndexed { index, e ->
            val map = mutableMapOf<Any?, Any?>()
            map.put("id", index)
            map.put("title", "同组优惠券${index}")

            map.put("type", 1)// "contractid": "H202000100",
            map.put("publishMark", if(index % 2 == 0) true else false)
            map.put("orderid", "1-$index")
            map.put("createDatetime", "2020-09-09")
            map.put("readingamout", 3)
            map.put("mediaUrl", "http://abc.com222")
            map.put("url", "http://abc.com222")
            map
        }
        return mapOf("list" to getPagingdData(list, currentPage, pageSize), "resultcout" to list.size, "pageSize" to pageSize )

    }

    @PostMapping("/StudentCourceParkageSearchingforCouponList")
    fun c2(@RequestBody req:Request): Map<String, Any> {
        val currentPage:Int = 1// req.currentPage!!
        val pageSize:Int  = 100000//req.pageSize!!
        val list = io.vavr.collection.List.range(0, 333).mapIndexed { index, e ->
            val map = mutableMapOf<Any?, Any?>()
            map.put("id", index.toString())
            map.put("kcbm", "课程包名称${index}")

            map.put("type", 1)// "contractid": "H202000100",
            map.put("publishMark", if(index % 2 == 0) true else false)
            map.put("orderid", "1-$index")
            map.put("createDatetime", "2020-09-09")
            map.put("readingamout", 3)
            map.put("mediaUrl", "http://abc.com222")
            map.put("url", "http://abc.com222")
            map
        }
        val d = """
            {"list":[{"id":"105113","kcbm":"test","zxs":0,"zxsCommon":3,"totalprice":30.0,"accessToken":null},{"id":"103021","kcbm":"2块","zxs":0,"zxsCommon":24,"totalprice":24.0,"accessToken":null},{"id":"123207","kcbm":"1块钱","zxs":0,"zxsCommon":1,"totalprice":1.0,"accessToken":null},{"id":"105205","kcbm":"1testdddddd","zxs":0,"zxsCommon":3,"totalprice":1.5,"accessToken":null},{"id":"103395","kcbm":"100块","zxs":0,"zxsCommon":24,"totalprice":2400.0,"accessToken":null}],"resultcout":"5"}
        """.trimIndent()
       // return mapOf("list" to getPagingdData(list, currentPage, pageSize), "resultcout" to list.size, "pageSize" to pageSize )
        return JsonUtil.fromJson(d, Map::class.java) as Map<String, Any>
    }
    @PostMapping("/StudentCourceSearchingforCouponList")
    fun c3(@RequestBody req:Request): Map<String, Any> {
        val currentPage:Int = 1//req.currentPage!!
        val pageSize:Int  = 100000//req.pageSize!!
        val list = io.vavr.collection.List.range(0, 333).mapIndexed { index, e ->
            val map = mutableMapOf<Any?, Any?>()
            map.put("kch", index.toString())
            map.put("kcmc", "有书${index}")

            map.put("courseType", "课程序列${index % 3}")// "contractid": "H202000100",
            map.put("courseBrand", "品牌${index % 2}")
            map.put("orderid", "1-$index")
            map.put("createDatetime", "2020-09-09")
            map.put("readingamout", 3)
            map.put("mediaUrl", "http://abc.com222")
            map.put("url", "http://abc.com222")
            map
        }
        return mapOf("list" to getPagingdData(list, currentPage, pageSize), "resultcout" to list.size, "pageSize" to pageSize )

    }
}