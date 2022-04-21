package eem.controller

import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile

@RestController
@RequestMapping("/eem")
class XufeiController {
    @PostMapping("/XfPurchaseHistoryDisplay")
    fun getXufeiBoughtList(@RequestBody req:Request): Map<String, Any> {

        val currentPage:Int = req.currentPage!!
        val pageSize:Int  = req.pageSize!!
        val list = io.vavr.collection.List.range(0, 333).mapIndexed { index, e ->
            val map = mutableMapOf<Any?, Any?>()
            map.put("orderId", "1-$index")
            map.put("xfPackage", "娃哈哈-$index")
            map.put("purchasingDate", "2020/01/01-$index")// "contractid": "H202000100",
            map.put("status", if(index %2 == 0) "已支付" else "未支付")
            map.put("telephone", "13798358621-$index")
            map.put("campus", "西大-$index")
            map.put("totalprice", 123.33)
            map
        }
        return mapOf("list" to getPagingdData(list, currentPage, pageSize), "resultcout" to list.size, "pageSize" to pageSize )
        // {“studentxmtel”：“”，“currentPage”：“1”}
    }

    @PostMapping("/XfPackageListServlet")
    fun getXufeiList(@RequestBody req:Request): Map<String, Any> {
       // 新建和编辑，deletemark=false，id为空为添加，不为空位编辑
        val currentPage:Int = req.currentPage!!
        val pageSize:Int  = req.pageSize!!
        val d = """
             [{
			"id": 53739,
			"name": "一年",
			"totalprice": 20001.0,
			"photourl": null,
			"description": null,
			"status": false,
			"createDate": "2020-06-21",
			"field": null,
            "serviceAgreement":"<p><span style='color:#d35400'>22</span></p>",
            "postageDetail":"<p><span style='color:#d35400'>22</span></p>"
		}, {
			"id": 53738,
			"name": "一年",
			"totalprice": 20001.0,
			"photourl": null,
			"description": null,
			"status": true,
			"createDate": "2020-06-21",
			"field": null,
 "serviceAgreement":"<p><span style='color:#d35400'>22</span></p>",
  "postageDetail":"<p><span style='color:#d35400'>22</span></p>"
		}, {
			"id": 53737,
			"name": "一年",
			"totalprice": 20001.0,
			"photourl": null,
			"description": null,
			"status": true,
			"createDate": "2020-06-21",
			"field": null,
            "serviceAgreement":"<p><span style='color:#d35400'>22</span></p>",
             "postageDetail":"<p><span style='color:#d35400'>22</span></p>"
		}
	]
        """.trimIndent()
      val list =  JsonUtil.fromJson(d, List::class.java)
        return mapOf("list" to list, "resultcout" to list.size, "pageSize" to pageSize )
        // {“studentxmtel”：“”，“currentPage”：“1”}
    }

    @PostMapping("/UploadimageServlet")
    fun upload(@RequestParam(value = "file",required = false)  file: MultipartFile): Map<String, Any> {
       // file.bytes
       // File("").writeBytes(file.bytes)
        return mapOf("field" to "111",  "url" to "http://thirdqq.qlogo.cn/g?b=oidb&k=IlibZianUOpDbv9HNBEJroSw&s=100&t=1556405884" )
    }

    @PostMapping("/XfPackageEditServlet")
    fun save():Map<String, Any>  {
        return mapOf("canSave" to true, "id" to "123")
    }

}