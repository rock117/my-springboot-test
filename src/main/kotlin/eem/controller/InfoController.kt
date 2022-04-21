package eem.controller

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/eem")
class InfoController {


    @PostMapping("/api/AdvertisingEditReadApi")
    fun getAvertiseInfo(@RequestBody req:Request): Any {
        return getAboutUsInfo(req)
    }
    @PostMapping("/api/AboutusEditReadApi")
    fun getAboutUsInfo(@RequestBody req:Request): Any {
        val d = """
            {
                "id": 95384,
                "title": "你看电影，我买单！",
                "publishMark": true,
                "orderid": 999,
                "readingamout": 79, 
                "thumbnail": null,
                "urlMark": false,
                "type":"3",
                "url": "",
                "jianjie":"abc",
                "richtextmark":false,
                "jianjie22": "<p style=\"text-indent: 2em; text-align: center;\"><img leipiplugins=\"image\" src=\"/eem/temp/08e8997c-0477-3eb2-9692-5817b14d03e0.jpg\" alt=\"电影.jpg\" style=\"width:800px;height:444px; border:0px solid gray;\" width=\"800\" height=\"444\"/></p><p style=\"text-indent: 2em;\"><br/></p><section data-role=\"outer\" label=\"Powered by 365editor\" style=\"font-family: 微软雅黑;\"><section class=\"KolEditor\" data-tools-id=\"49657\"><section style=\"margin:9px;display: flex;justify-content: center;align-items: center;\"><section style=\"width:100%;box-shadow: 0px 0px 7px 0px rgba(255, 218, 32, 0.71);padding:12px 25px;box-sizing: border-box;display: flex;flex-direction: column;justify-content: center;align-items: center;\"><section style=\"display: flex;flex-direction: row;justify-content: center;align-items: flex-end;\"><section style=\"width:29px;flex-shrink: 0;z-index: 1;margin-right:-12px;\" class=\"\"></section><section style=\"border-bottom:3px solid #fff4bc;box-sizing: border-box;padding:0 8px 0 18px;\"><p style=\"margin-top: 0px; margin-bottom: 0px; text-align: center; font-size: 15px; color: rgb(94, 62, 53); letter-spacing: 1.5px; line-height: 1.75em;\"><strong style=\"font-size: 16px;\"><span style=\"color: rgb(255, 0, 0); letter-spacing: 0px; font-size: 14px; font-family: 宋体;\"><strong style=\"color: rgb(94, 62, 53); letter-spacing: 1.5px;\"><span style=\"color: rgb(255, 0, 0); letter-spacing: 0px;\"><strong style=\"color: rgb(94, 62, 53); font-size: 15px; letter-spacing: 1.5px;\"><span style=\"letter-spacing: 0px; font-size: 20px;\">你看电影，我买</span></strong><strong style=\"color: rgb(94, 62, 53); font-size: 15px; letter-spacing: 1.5px;\"><span style=\"letter-spacing: 0px; font-size: 20px;\">单</span></strong></span></strong></span></strong></p></section></section><section style=\"width:100%;box-sizing: border-box;margin-top:18px;\"><p style=\"text-align: center; line-height: 1.75em;\"><span style=\"font-size: 15px; color: rgb(255, 192, 0);\"><strong><span style=\"letter-spacing: 0px; font-family: 宋体;\">「拾影」</span></strong><span style=\"letter-spacing: 0px; font-family: 宋体;\">栏目正式开通！</span></span></p><p style=\"text-align: center; line-height: 1.75em;\"><span style=\"font-size: 15px; color: rgb(255, 192, 0);\"><span style=\"letter-spacing: 0px; font-family: 宋体;\">电影火热征集中</span><span style=\"font-family: Calibri; letter-spacing: 0px;\">……</span><span style=\"font-family: 宋体; letter-spacing: 0px;\">&nbsp;</span></span></p><p style=\"text-align: center; line-height: 1.75em;\"><span style=\"font-family: 宋体; letter-spacing: 0px; font-size: 15px; color: rgb(255, 192, 0);\">期待已久的电影院终于开门啦！</span></p><p style=\"text-align: center; line-height: 1.75em;\"><span style=\"font-family: 宋体; letter-spacing: 0px; font-size: 15px; color: rgb(255, 192, 0);\">你最想在电影院看哪一部电影呢</span></p><p style=\"text-align: center; line-height: 1.75em;\"><span style=\"font-size: 15px; color: rgb(255, 192, 0);\"><span style=\"font-family: 宋体; letter-spacing: 0px; font-size: 14px;\">抓紧参加爱育幼童</span></span></p><p style=\"line-height: 1.75em; text-align: center;\"><span style=\"font-size: 15px; color: rgb(255, 192, 0);\"><strong><span style=\"font-family: 宋体; letter-spacing: 0px; font-size: 14px;\">“你看电影，我买单”</span></strong><span style=\"letter-spacing: 0px; font-size: 14px; font-family: 宋体;\">活动</span></span></p><p style=\"text-align: center; line-height: 1.75em;\"><span style=\"font-size: 15px; color: rgb(255, 192, 0);\"><span style=\"letter-spacing: 0px; font-family: 宋体;\">可</span><span style=\"color: rgb(255, 192, 0); font-size: 16px;\"><strong><span style=\"color: rgb(255, 0, 0); letter-spacing: 0px; font-family: 宋体;\">免费</span></strong></span><span style=\"font-family: 宋体; letter-spacing: 0px;\">看电影哦！&nbsp;</span></span></p><p style=\"line-height: normal;\"><br/></p><p style=\"line-height: normal;\"><br/></p><p style=\"text-align: center; line-height: 1.75em;\"><span style=\"color: rgb(255, 192, 0); font-size: 16px;\"><strong><span style=\"color: rgb(255, 192, 0); font-family: 宋体; letter-spacing: 0px;\">1、参与方式：</span></strong></span><span style=\"color: rgb(255, 192, 0);\"><strong><span style=\"font-family: 宋体; letter-spacing: 0px; font-size: 18px;\"></span></strong><strong><span style=\"font-family: 宋体; letter-spacing: 0px; font-size: 18px;\"></span></strong></span></p><p style=\"line-height: normal;\"><br/></p><p style=\"text-align: left; line-height: 1.75em;\"><span style=\"color: rgb(127, 127, 127);\"><span style=\"font-size: 14px;\"><span style=\"letter-spacing: 0px; font-family: 宋体;\">关注</span><span style=\"font-family: 宋体; letter-spacing: 0px;\">&nbsp;</span><strong><span style=\"font-family: 宋体; letter-spacing: 0px;\">“爱育幼童教育”</span></strong><span style=\"letter-spacing: 0px; font-family: 宋体;\">公众号，在周一</span><strong><span style=\"font-family: 宋体; letter-spacing: 0px;\">“拾影栏目”</span></strong><span style=\"letter-spacing: 0px; font-family: 宋体;\">任意文章下留言我们将会选出</span><strong><span style=\"letter-spacing: 0px; font-family: 宋体;\">优秀留言者</span></strong><strong><span style=\"font-family: 宋体; letter-spacing: 0px;\">3名</span></strong><span style=\"letter-spacing: 0px; font-family: 宋体;\">送</span><strong><span style=\"font-family: 宋体; letter-spacing: 0px;\">【50元电影票券】</span></strong></span><span style=\"font-size: 14px;\"><strong><span style=\"font-family: 宋体; letter-spacing: 0px;\"></span></strong></span></span><span style=\"font-size: 14px; color: rgb(255, 192, 0);\"><span style=\"font-family: 宋体; color: rgb(255, 0, 0); letter-spacing: 0px;\">&nbsp;</span><strong><span style=\"font-family: 宋体; color: rgb(255, 0, 0); letter-spacing: 0px;\">&nbsp;</span></strong></span></p><p style=\"text-align: center; line-height: 1.75em;\"><span style=\"color: rgb(255, 192, 0);\"><strong><span style=\"font-family: 宋体; letter-spacing: 0px;\"><br/></span></strong></span></p><p style=\"text-align: center; line-height: 1.75em;\"><span style=\"color: rgb(255, 192, 0); font-size: 16px;\"><strong><span style=\"color: rgb(255, 192, 0); font-family: 宋体; letter-spacing: 0px;\">2、留言内容：</span></strong></span><span style=\"color: rgb(255, 192, 0);\"><strong><span style=\"font-family: 宋体; letter-spacing: 0px; font-size: 18px;\"></span></strong><strong><span style=\"font-family: 宋体; letter-spacing: 0px; font-size: 18px;\"></span></strong></span></p><p style=\"line-height: normal;\"><br/></p><p style=\"text-align: left; line-height: 1.75em;\"><span style=\"letter-spacing: 0px; font-size: 14px; font-family: 宋体; color: rgb(127, 127, 127);\">推荐一部你认为最有教育意义的电影，并谈谈自己的感受，或这部电影带给你什么样的启发，道理等。</span></p><p style=\"line-height: normal;\"><br/></p><p style=\"text-align: center; line-height: 1.75em;\"><span style=\"color: rgb(255, 192, 0); font-size: 16px;\"><strong><span style=\"color: rgb(255, 192, 0); font-family: 宋体; letter-spacing: 0px;\">3、领取方式：</span></strong><span style=\"color: rgb(255, 192, 0); font-family: sans-serif; letter-spacing: 0px;\">&nbsp;</span></span></p><p style=\"line-height: normal;\"><br/></p><p style=\"text-align: left; line-height: 1.75em;\"><span style=\"font-size: 14px; color: rgb(127, 127, 127);\"><strong><span style=\"font-family: 宋体; letter-spacing: 0px;\">2020年8月24日12点</span></strong><span style=\"letter-spacing: 0px; font-family: 宋体;\">准时在</span><strong><span style=\"font-family: 宋体; letter-spacing: 0px;\">“拾影栏目”文末</span></strong><span style=\"letter-spacing: 0px; font-family: 宋体;\">公布</span><strong><span style=\"letter-spacing: 0px; font-family: 宋体;\">中奖名单</span></strong><span style=\"letter-spacing: 0px; font-family: 宋体;\">；中奖者于</span><strong><span style=\"font-family: 宋体; letter-spacing: 0px;\">8月27日之前</span></strong><span style=\"letter-spacing: 0px; font-family: 宋体;\">和我们联系，</span><strong><span style=\"font-family: 宋体; letter-spacing: 0px;\">逾期视为弃权哦！&nbsp;</span></strong></span></p><p style=\"line-height: normal;\"><br/></p><p style=\"text-align: center; line-height: 1.75em;\"><span style=\"color: rgb(255, 192, 0); font-size: 16px;\"><strong><span style=\"color: rgb(255, 192, 0); font-family: 宋体; letter-spacing: 0px;\">4、活动时间：</span></strong></span></p><p style=\"line-height: 25px; text-align: center;\"><br/></p><p style=\"text-align: left; line-height: 1.75em;\"><strong><span style=\"color: rgb(127, 127, 127);\"><span style=\"font-family: 宋体; letter-spacing: 0px; font-size: 14px;\">2020年</span><span style=\"font-family: Calibri; letter-spacing: 0px; font-size: 14px;\">7</span><span style=\"letter-spacing: 0px; font-size: 14px; font-family: 宋体;\">月</span><span style=\"font-family: Calibri; letter-spacing: 0px; font-size: 14px;\">27</span><span style=\"font-family: 宋体; letter-spacing: 0px; font-size: 14px;\">日—</span><span style=\"font-family: Calibri; letter-spacing: 0px; font-size: 14px;\">8</span><span style=\"letter-spacing: 0px; font-size: 14px; font-family: 宋体;\">月</span><span style=\"font-family: Calibri; letter-spacing: 0px; font-size: 14px;\">21</span><span style=\"letter-spacing: 0px; font-size: 14px; font-family: 宋体;\">日</span></span></strong></p><section class=\"KolEditor\" style=\"min-width: 259px; text-align: center;\" data-tools-id=\"48961\"><br/></section><p style=\"margin-top: 0px; margin-bottom: 0px; text-align: justify; font-size: 13px; letter-spacing: 1.5px; line-height: 1.75;\"><br/></p><p style=\"text-indent: 2em; text-align: center;\"><img leipiplugins=\"image\" src=\"/eem/temp/78dcc728-38e4-3a42-b030-65b38b5e3e10.png\" alt=\"二维码3.png\" style=\"width:400px;height:520px; border:0px solid gray;\" width=\"400\" height=\"520\"/></p><p style=\"margin-top: 0px; margin-bottom: 0px; text-align: justify; font-size: 13px; letter-spacing: 1.5px; line-height: 1.75;\"><br/></p></section></section></section></section><p><br/></p><p><br/></p><p><br/></p></section><p><br/></p>",
                "createDatetime": "2020-07-28 10:52",
                "endDatetime": "2020-07-28",
                "outtime": "未过期",
                "xqmc": null,
                "directUrl": "directUrl",
                "mediaUrl": "mediaUrl"
            }
         """.trimIndent()
        return JsonUtil.fromJson(d, Map::class.java)
    }
    @PostMapping("/api/ActivitiesEditReadApi")
    fun getActivtiveInfo(@RequestBody req:Request): Any {
//        val map = mutableMapOf<Any?, Any?>()
//        map.put("id", "1")
//        map.put("title", "有书 |蓝精灵全新力作，考验智力和耐力的精美游戏活动书来啦！！")
//
//        map.put("type", 1)// "contractid": "H202000100",
//        map.put("publishMark", true)
//        map.put("orderid", "1")
//        map.put("createDatetime", "2020-09-09")
//        map.put("endDatetime", "2021-09-09")
//        map.put("readingamout", 3)
//        map.put("mediaUrl", "http://abc.com")
//        map.put("thumbnail", "https://ty.ayyt.com/eem/temp/c3cef86f-29fa-3b63-8e84-fb14325d3c80.jpg")
//        map.put("url", "http://abc.com")
//        map.put("jianjie", """ <p></p><div class="media-wrap image-wrap"><img src="/eemoss/img?imgId=b02eaab3-df03-4bce-ae10-82f509536061"/></div><p></p> """)
//        return map


        val d = """
            {
                "id": 95406,
                "title": "测试校区",
                "publishMark": true,
                "orderid": 999,
                "readingamout": 28,
                "thumbnail": "https://ty.ayyt.com/images/3a45e626-341d-3e54-bd4a-646e8178a636.jpg",
                "urlMark": false,
                "url": "",
                "jianjie":"<p><img class=\"media-wrap image-wrap\" src=\"/eem/temp/efcbc0fb-5f30-30b1-aa64-15c1f7ee1db3.png\"/></p>",
                "createDatetime": "2020-07-28 16:12",
                "endDatetime": null,
                "outtime": "未过期",
                "richtextmark": false,
                "xqmc": null
            }
        """.trimIndent()
        return JsonUtil.fromJson(d, Map::class.java)
    }

        @PostMapping("/api/AboutusSearchingApi")
    fun getAboutusSearchingApi(@RequestBody req:Request): Map<String, Any> {
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

    @PostMapping("/api/AdvertisingSearchingApi")
    fun getAverSearchingApi(@RequestBody req:Request): Map<String, Any> {
        val currentPage:Int = req.currentPage!!
        val pageSize:Int  = req.pageSize!!
        val list = io.vavr.collection.List.range(0, 333).mapIndexed { index, e ->
            val map = mutableMapOf<Any?, Any?>()
            map.put("orderId", "1-$index")
            map.put("id", "$index")
            map.put("title", "有书 |蓝精灵全新力作，考验智力和耐力的精美游戏活动书来啦！！")

            map.put("type", 1)// "contractid": "H202000100",
            map.put("publishMark", true)
            map.put("orderid", "1-$index")
            map.put("createDatetime", "2020-09-09")
            map.put("readingamout", 3)
            map.put("mediaUrl", "http://abc.com")
            map.put("url", "http://abc.com")
            map
        }
        return mapOf("list" to getPagingdData(list, currentPage, pageSize), "resultcout" to list.size, "pageSize" to pageSize )
    }

    @PostMapping("/api/ActivitiesSearchingApi")
    fun getActivitiesSearchingApi(@RequestBody req:Request): Map<String, Any> {
        val currentPage:Int = req.currentPage!!
        val pageSize:Int  = req.pageSize!!
        val list = io.vavr.collection.List.range(0, 333).mapIndexed { index, e ->
            val map = mutableMapOf<Any?, Any?>()
            map.put("id", "1-$index")
            map.put("title", "有书 |蓝精灵全新力作，考验智力和耐力的精美游戏活动书来啦！！")
            map.put("outtime", if(index%2 == 0) "未过期" else "过期")
            map.put("type", 1)// "contractid": "H202000100",
            map.put("publishMark", true)
            map.put("orderid", "1-$index")
            map.put("createDatetime", "2020-09-09")
            map.put("readingamout", 3)
            map.put("mediaUrl", "http://abc.com")
            map.put("url", "http://abc.com")
            map
        }
        return mapOf("list" to getPagingdData(list, currentPage, pageSize), "resultcout" to list.size, "pageSize" to pageSize )
    }
}