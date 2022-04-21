package eem.controller


import JsonUtil
import org.apache.commons.io.IOUtils
import org.springframework.web.bind.annotation.*
import java.io.File
import java.util.concurrent.atomic.AtomicInteger
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import javax.servlet.http.Part


fun main(args: Array<String>) {
    val m = JsonUtil.fromJson(MenuData.data, Map::class.java)
    println(m)
}


@RestController
@RequestMapping("/eem")
class EemController {
    val seaSets =  mutableListOf<MutableMap<Any?, Any?>>()
    constructor(){
        this.seaSets.add(mutableMapOf("id" to "1", "openSeaSetName" to "公海-1", "openSeaSetValue" to "18"))
        this.seaSets.add(mutableMapOf("id" to "2", "openSeaSetName" to "公海-2", "openSeaSetValue" to "19"))
    }
    val curr = AtomicInteger(0)

    @PostMapping("/api/import-data")
    fun test(req: HttpServletRequest): Boolean {
        val part: Part = req.getPart("file")
        val input = part.inputStream!!
        val data = IOUtils.toByteArray(input)!!
        File("d:/j2ee/mmm.xlsx").writeBytes(data)
        return  true
    }


    @PostMapping("/api/StudentconstractPayForPcRedirect")
    fun StudentconstractPayForPcRedirect(): Map<String, Any>{
        return mapOf("redirecturl" to "https://baidu.com", "result" to true )
    }
    @PostMapping("/api/ChangeStudentKeshiRemain")
    fun ChangeStudentKeshiRemain(): Map<String, Any>{
        return mapOf("redirecturl" to "https://baidu.com", "result" to true )
    }







    @PostMapping("/getStudentContractList")
    fun getStudentContractList(@RequestBody req: Request): Map<String, *> {
        val datas = getContracts(355)
        val tabs = listOf<Map<String, String>>(
            mapOf("key" to "-1", "name" to "全部"),
            mapOf("key" to "00", "name" to "待支付"),

            mapOf("key" to "01", "name" to "已完成"),
            mapOf("key" to "02", "name" to "已取消"),
            mapOf("key" to "03", "name" to "支付中")
        )
        return mapOf("list" to getPagingdData(datas, req.currentPage!!, req.pageSize!!), "tabs" to tabs, "resultcout" to datas.size, "pageSize" to req.pageSize )
    }





    fun copy(v:Any): Any {
        val m = JsonUtil.toJson(v)
        return JsonUtil.fromJson(m, Any::class.java)
    }


    @PostMapping("/AddStudentContractListDelay")
    fun addStudentContractListDelay(@RequestBody req:DelayReq): Map<String, Int>{
        return mapOf("delaycout" to 100)
    }

    @PostMapping("/api/GetStudentFormalList")
    fun getStudentFormalList(@RequestBody req:Request): Map<String, Any> {

        val currentPage:Int = req.currentPage!!
        val pageSize:Int  = req.pageSize!!
        val list = io.vavr.collection.List.range(0, 333).mapIndexed { index, e ->
            val map = mutableMapOf<Any?, Any?>()
            map.put("stuid", "1234524242-$index")
            map.put("stuname", "宝宝姓名-$index")
            map.put("xsremain", 1234)
            map.put("stuage", "18-$index")// "contractid": "H202000100",
            map.put("stutelephone", "13798358621-$index")
            map
        }



        return mapOf("list" to getPagingdData(list, currentPage, pageSize), "resultcout" to list.size, "pageSize" to pageSize )
        // {“studentxmtel”：“”，“currentPage”：“1”}
    }

    @PostMapping("/OpenSeaSetChange")
    fun OpenSeaSetChange(@RequestBody req:Map<String, String>): Map<String, Any> {
        val id = req["id"]
        val v = req["setValue"]
        seaSets.filter { sea -> sea["id"] == id }.forEach { sea ->
            sea["openSeaSetValue"] = v
        }
        return mapOf("result" to true)
    }

    @GetMapping("/GetLeftmenuList")
    fun getMenus(resp:HttpServletResponse):Map<String, Any?>{
//        val data = MenuData.data
//       // val list = JsonUtil.fromJson(data, List::class.java) as List<Map<String, Any>>
//       // return list
//        resp.addHeader("Content-Type", "application/json")
//        resp.writer.write(data)
//        resp.writer.flush()
        val data = MenuData.data.replace("/eem/www/#", "/#")
        return JsonUtil.fromJson(data, Map::class.java) as Map<String, Any?>
    }

    @PostMapping("/OpenSeaSetFind")
    fun openSeaSetFind(): Map<String, Any> {
      //  name: data.openSeaSetName,
       // value: data.openSeaSetValue,
        return mapOf("openSeaSetName" to "111", "openSeaSetValue" to "222")
    }

    @PostMapping("/OpenSeaSetDisplay")
    fun getOpenSeaSetDisplay(@RequestBody req:Request): Map<String, Any> {

        val currentPage:Int = req.currentPage!!
        val pageSize:Int  = req.pageSize!!
        val list = seaSets.toList()
        return mapOf("list" to getPagingdData(list, currentPage, pageSize), "resultcout" to list.size, "pageSize" to pageSize )
        // {“studentxmtel”：“”，“currentPage”：“1”}
    }


}

fun <T> Int.repeat(t: T): List<T> {
    return ( 1 .. this).map { t }
}


data class DelayReq(val contractid: String, val endDate: String)
object Data{
    val d = """
        <p style="text-align: center;"><span style="font-size: 12px;"></span></p><p style="text-align: center; text-indent: 2em;"><img width="70%" height="100%" style="border: 0px solid gray; width: 70%; height: 100%;" alt="4.png" src="https://ty.ayyt.com/ayms/upload/868ea576e4dc40f586486bdbcac578de.jpg" leipiplugins="image"/></p><p style="text-align: center;"><span style="font-size: 12px;"><br/></span></p><p style="text-align: center;"><strong><span style="font-family: 宋体; font-size: 19px;">学员权益概要</span></strong></p><p style="line-height: normal;"><span style="font-family: 宋体;">学员了解并同意：</span></p><p style="line-height: normal;"><span style="font-family: 宋体;">一、厦门总部提供1</span><span style="font-family:;">〜</span><span style="font-family: 宋体;">6人精致</span><span style="font-family:;" ms=""></span><span style="font-family: 宋体;">小班制教学服务，每次扣抵2课时，每课时为45分钟。</span></p><p style="line-height: normal;"><span style="font-family: 宋体;">二、学员了解并同意，厦门总部所赠送予学员之课时，须缴清款项、购买之课时使用完毕且合同未到期时始有效，若有提前解除或终止合同，或有重大违约事由，撤销学员资格，不得申请将赠送课时折换成现金。</span></p><p style="line-height: normal;"><span style="font-family: 宋体;">三、学员了解并同意，使用教学服务时，最少需在课程服务开始前</span><span style="font-family:;">24</span><span style="font-family: 宋体;">小时通过系统进行课程预约，如课程当天因故无法出席，最迟须在五分钟前来电或通过系统取消课程。</span></p><p style="line-height: normal;"><span style="font-family: 宋体;">四、学员了解并同意，签订本合同后若欲申请解除或终止合同及退费者，应依下列规定办理：</span></p><p style="line-height: normal;"><span style="font-family: 宋体;">（一）本合同期间起始日起算至三十日，学员如对本公司所提供服务不愿再继续使用，申请退费时，应在前述期间内以书面方式通知本公司解除合同，本公司就使用部分按每一课时的价格乘以已上课时的标准扣除使用费用，退回剩余金额。</span></p><p style="line-height: normal;"><span style="font-family: 宋体;">（二）本合同期间起始日起算第三十一日起，学员不得通知解除合同或要求退费。学员了解并同意学员不得将会籍出售、转让给予他人使用，未经本公司同意私下出售、转让会造成丧失学员资格且不得请求退还未使用课程之费用。</span></p><p style="line-height: normal;"><span style="font-family: 宋体;">（三）学员同意本公司如合理怀疑学员违反本约定者，本公司有权暂时停止学员账户之使用，且若经确认违反本约定者，本公司有权解除或终止本合同。</span></p><p style="line-height: normal;"><strong><span style="font-family: 宋体;">学员对于本合同之全部条款已于合理期间内充分阅读了解，学员了解并同意一旦按下</span></strong><strong> </strong><strong><span style="font-family: 宋体;">「同意」之按键，即视为同意完全遵守本合同之所有约定。</span></strong></p><p style="text-align: center;">&nbsp;</p><p><span style="font-size: 12px;"></span></p><p><span style="font-size: 12px;">&nbsp;</span></p><p style="text-align: center;"><span style="font-size: 12px;"></span></p><p style="text-align: center; text-indent: 2em;"><img width="70%" height="100%" style="border: 0px solid gray; width: 70%; height: 100%;" alt="4.png" src="https://ty.ayyt.com/ayms/upload/868ea576e4dc40f586486bdbcac578de.jpg" leipiplugins="image"/></p><p style="text-indent: 2em;"><br/></p><p style="text-align: center;"><strong><span style="font-family: 宋体; font-size: 19px;">爱育幼童合同书</span></strong></p><p style="line-height: 29px;"><span style="font-family:;">&nbsp;</span></p><p style="line-height: normal;"><span style="font-family: 宋体;">宝贝姓名：</span><span style="text-decoration: underline;"><span style="font-family:;">&nbsp;&nbsp;&nbsp;</span><span style="color: rgb(64, 64, 64); font-family: 宋体;">正式学员</span></span><span style="text-decoration: none;"><span style="font-family:; text-decoration: none;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 性别：</span>男<span style="font-family:; text-decoration: none;"></span></span></p><p style="line-height: normal;"><span style="font-family: 宋体;">出生年月：</span><span style="text-decoration: underline;"><span style="font-family:;">&nbsp;&nbsp;&nbsp;&nbsp;2019-11-22&nbsp;&nbsp;&nbsp; </span></span></p><p style="line-height: normal;"><span style="font-family: 宋体;">家长姓名：</span><span style="text-decoration: underline;"><span style="font-family:;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></span><span style="font-family:;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></p><p style="line-height: normal;"><span style="font-family: 宋体;">电话：</span><span style="text-decoration: underline;"><span style="font-family:;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></span><span style="text-decoration: underline;"><span style="color: rgb(64, 64, 64);"><span style="font-family: 宋体;">15600000001</span></span></span><span style="text-decoration: underline;"><span style="font-family:;">&nbsp;&nbsp;&nbsp;</span></span></p><p style="line-height: normal;"><span style="font-family: 宋体;">备用电话：</span><span style="text-decoration: underline;"><span style="font-family:;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></span><span style="font-family:;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;QQ</span><span style="font-family: 宋体;">：</span><span style="text-decoration: underline;"><span style="font-family:;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></span><span style="font-family:;">&nbsp;&nbsp;</span></p><p style="line-height: normal;"><span style="font-family: 宋体;">所在幼儿园</span><span style="font-family:;">/</span><span style="font-family: 宋体;">学校：</span><span style="text-decoration: underline;"><span style="font-family:;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span></span><span style="font-family:;">&nbsp;&nbsp;&nbsp;&nbsp;</span></p><p style="line-height: normal;"><span style="font-family: 宋体;">学员编号（学员卡号）：</span><span style="text-decoration: underline;"><span style="font-family:;">&nbsp;&nbsp;&nbsp;</span></span><span style="text-decoration: underline;"><span style="color: rgb(64, 64, 64);"><span style="font-family: 宋体;">S201900003</span></span></span><span style="text-decoration: underline;"><span style="font-family:;">&nbsp;&nbsp;&nbsp;&nbsp;</span></span></p><p style="line-height: normal;"><span style="text-decoration: underline;"><span style="font-family:;"><br/></span></span></p><p style="line-height: normal;"><span style="font-family: 宋体;">立合同书人：</span></p><p style="line-height: normal;"><span style="font-family: 宋体;">爱育幼童厦门总部</span></p><p style="line-height: normal;"><span style="font-family: 宋体;">学员：正式学员</span></p><p style="line-height: normal;"><span style="font-family: 宋体;">兹就学员加入爱育幼童参加学习，并于合同期间内，依据本合同书所订的条款接受全脑右脑潜能的教学服务，双方同意就相关合同内容约定如下：</span></p><p style="line-height: normal;"><span style="font-family: 宋体;">—、服务内容</span></p><p style="line-height: normal;"><span style="font-family: 宋体;">1. 精致小班制：爱育课程针对0-12岁宝贝，采用3-8人小班制教学模式，即每班不超过8名宝贝，每课时时间为50分钟。</span></p><p style="line-height: normal;"><span style="font-family: 宋体;">&nbsp;</span></p><p style="line-height: normal;"><span style="font-family: 宋体;">2.本合同服务内容为: </span></p><p style="line-height: normal;"><span style="font-family: 宋体;">全脑佳第1阶段(100)学时；<br/></span></p><p style="line-height: normal;"><span style="font-family: 宋体;">共100学时。</span></p><p style="line-height: normal;"><span style="font-family: 宋体;">&nbsp;</span></p><p style="line-height: normal;"><span style="font-family: 宋体;">二、</span><span style="font-family:;">&nbsp;&nbsp;&nbsp;&nbsp; </span><span style="font-family: 宋体;">服务费用及付款方式</span></p><p style="line-height: normal;"><span style="font-family: 宋体;">本合同服务费用共计人民币（下同）<span style="color: rgb(64, 64, 64);">10000元</span>元整。学员于购买服务时，以汇款、在线刷卡或其他本公司同意方式将款项支付予本校区。</span></p><p style="line-height: normal;"><span style="font-family: 宋体;">三、合同期间</span></p><p style="line-height: normal;"><span style="font-family: 宋体;">合同期间即服务有效使用期间2019-11-23至2020-01-01。</span></p><p style="line-height: normal;"><span style="font-family: 宋体;">学员应于合同期间内使用完所有课时（包括赠送的课时），合同期间内未使用完毕的课时，于合同期间届满日自动失效。<span style="color: black;">课程将严格按照宝贝能力进行排课和升班，个别因特殊原因需申请延后，需提前申请。</span></span></p><p style="line-height: normal;"><span style="font-family: 宋体;">四、服务使用规则</span></p><p style="line-height: normal;"><span style="font-family: 宋体;">（一）学员可以按照学校排好的课程计划自主选课，确认参加对应课程者，按时间到对应教室上课即可。学员上课需现场签到，签到成功后，发送签到短信到家长，系统自动扣对应课程课时数。</span></p><p style="line-height: normal;"><span style="font-family: 宋体;">（二）为保证课堂的教学质量及宝贝的学习效果，家长应做到不迟到、不早退、不旷课。<span style="color: black;">本着相互尊重及培养宝贝良好习惯的原则，无特殊原因不建议请假；如有特殊原因（感冒、咳嗽、发烧、手足口等疾病，或家中有特殊事情无法上课）不能来上课，请提前一天致电前台或任班老师</span>。家长未提前请假而又不出席者，则视为缺课，中心将自动划扣该课课时。因特殊原因无法连续上课超过2周以上者，可到前台办理“延期申请”，时间为2周至2个月，期间学位将被临时取消。如遇国家法定节假日，课程将会相应的顺延或另行调整，所有的调整通知都会以书面或手机短信的形式正式通知到家长，请家长配合并且放心。</span></p><p style="line-height: normal;"><span style="font-family: 宋体;">（三）爱育所有课程为宝贝独立上课，不允许家长陪同。上课情景因涉及版权保护，严禁家长在室内外拍照及录像，课程中所涉及到的教材教具也不允许未经老师同意外带。</span></p><p style="line-height: normal;"><span style="font-family: 宋体;">（四）每班任课老师每月至少一次以电话或面谈的形式与宝贝家长进行学习的回馈及问题、建议的反馈。家长对于孩子的教育问题可以通过QQ、电话、面聊等方式及时请教我们的老师、校长，家长可以与老师保持高度顺畅的联系，以确保家校两方的无障碍沟通，共同打造我们的优秀宝贝。 </span></p><p style="line-height: normal;"><span style="font-family: 宋体;">&nbsp;</span></p><p style="line-height: normal;"><span style="font-family: 宋体;">五、</span><span style="font-family:;">&nbsp;&nbsp;&nbsp;&nbsp; </span><span style="font-family: 宋体;">遵守义务</span></p><p style="line-height: normal;"><span style="font-family: 宋体;">（一）家长要按要求配合老师的教学，如：科学合理地给孩子看电视电脑手机等电子设备，在家中养成孩子独立阅读学习的习惯，独立吃饭的习惯，按时睡觉的习惯，与孩子讲道理的习惯，让孩子参与家庭事务讨论的习惯，参与家务劳动的习惯，关心家庭成员的习惯等等。</span></p><p style="line-height: normal;"><span style="font-family: 宋体;">（二）家长要听取专家的建议，不给孩子吃零食，少看电视，少接触电脑，不打骂孩子。</span></p><p style="line-height: normal;"><span style="font-family: 宋体;">（三）家长要坚持亲自接送孩子上课，及时了解孩子的上课情况状况。</span></p><p style="line-height: normal;"><span style="font-family: 宋体;">（四）家长如果委托他人接送孩子，必须亲自打电话给老师或前台。</span></p><p style="line-height: normal;"><span style="font-family: 宋体;">（五）家长必须如实和老师说明孩子的身体状况，不得带病上课。</span></p><p style="line-height: normal;"><span style="font-family: 宋体;">（六）家长要认真学习学校提供的理论知识和科学育儿指导。</span></p><p style="line-height: normal;"><span style="font-family: 宋体;">（七）家长要了解右脑全脑潜能教育，认同右脑潜能理论，相信孩子的潜能是有待教育引导的。</span></p><p style="line-height: normal;"><span style="font-family: 宋体;">（八）家长要定期听本学校安排的专家讲座或沙龙会。</span></p><p style="line-height: normal;"><span style="font-family: 宋体;">（九）家长要学会坚持带孩子上完给孩子制定的课程计划，坚持的家长就能看到发生在孩子身上的奇迹。</span></p><p style="line-height: normal;"><span style="font-family: 宋体;">（十）家长要遵守学校的各项规则。</span></p><p style="line-height: normal;"><span style="font-family: 宋体;">六、关于办理延期、退费与转让</span></p><p style="line-height: normal;"><span style="font-family: 宋体;">（一）需办理延期的学员，应本人或家长到校亲自办理，同一课程延期手续只能办理一次，办理延期后未能到校上课的，课程自动作废。</span></p><p style="line-height: normal;"><span style="font-family: 宋体;">（二）本合同期间起始日起算至三十日，学员如对本公司所提供服务不愿再继续使用，申请退费时，应在前述期间内以书面方式通知本公司解除合同，本公司就使用部分按每一课时的价格乘以已上课时的标准扣除使用费用，退回剩余金额。</span></p><p style="line-height: normal;"><span style="font-family: 宋体;">（三）本合同期间起始日起算第三十一日起，学员不得通知解除合同或要求退费。</span></p><p style="line-height: normal;"><span style="font-family: 宋体;">（四）学员违反本合同规定时、本公司得解除或终止合同，已缴纳费用本公司不予退还。</span></p><p style="line-height: normal;"><span style="font-family: 宋体;">（五）需进行转让课程，应自行安排课程转让对象。学期过半不受理课程转让手续。</span></p><p style="line-height: normal;"><span style="font-family: 宋体;">七、其他</span></p><p style="line-height: normal;"><span style="font-family: 宋体;">（一）本合同取代双方就本合同所述事宜所达成的一切口头或书面约定，以及本公司通过一切媒介所发布的宣传资料、广告等。其他任何文件与本合同有不一致的，以本合同为准。</span></p><p style="line-height: normal;"><span style="font-family: 宋体;">（二）本合同签订后，如须修订，得经本公司同意后，由双方另以书面协议取代或修改本合同，任何口头非文字载明之承诺、条件，均视为无效约定。</span></p><p style="line-height: normal;"><span style="font-family: 宋体;">（三）双方同意本合同内容之全部或部分经法院判定无效时，并不影响合同其它条款之效力。</span></p><p style="line-height: normal;"><span style="font-family: 宋体;">（四）就本合同未尽事宜，双方同意依本公司内部或网站上有关之公告、说明、服务条款补充，并依中华人民共和国法律与其它相关法令解释并适用之。如果有争议，应提交至法院按其适用的仲裁规则。仲裁裁决对双方均具有约束力。</span></p><p style="line-height: normal;"><span style="font-family: 宋体;">（五）本合同经学员确认并同意后，将以电子文件方式留存于本公司系统中，以为双方合同签署及遵循之依据。</span></p><p style="line-height: normal;"><span style="font-family:;">&nbsp;</span></p><p style="line-height: normal;"><span style="font-family: 宋体;">学员签名:正式学员</span></p><p style="line-height: normal;"><span style="font-family: 宋体;">爱育幼童:厦门总部</span></p><p><span style="font-family:;">&nbsp;</span></p><p style="text-align: center;"><span style="font-size: 12px;"><br/></span></p><p style="text-align: justify;"><br/></p><p><span style="font-size: 12px;"></span></p><p><span style="font-size: 12px;">&nbsp;</span></p><p>&nbsp;</p><p><span style="font-size: 12px;">&nbsp;</span></p><p><span style="font-size: 12px;">&nbsp;</span></p><p><span style="font-size: 12px;">&nbsp;</span></p><p><span style="font-size: 12px;">&nbsp;</span></p><p><span style="font-size: 12px;">&nbsp;</span></p><p><span style="font-size: 12px;">&nbsp;</span></p><p><span style="font-size: 12px;">&nbsp;</span></p><p><span style="font-size: 12px;">&nbsp;</span></p><p style="text-align: center;">&nbsp;</p>
    """.trimIndent()


    val contractData = """
        {
            "zxsRemained": 100,
            "contractid": "H202000100",
            "createDate": "2020-03-06",
            "contracttype": "初报",
            "studentName": "正式学员",
            "telephone": "156000000011560000000115600000001",
            "contractName": "全脑佳系列100课时",
            "zxs": 100,
            "zxsCommon": 0,
            "zxsUsed": 0,
            "zxsCommonUsed": 0,
            "yingshou": 17200.0,
            "discount": 7200.0,
            "finalprice": 10000.0,
            "paytype": "",
            "status": "001",
            "statusName": "待支付",
            "orderTime": "",
            "dateBegin": "2019-11-23",
            "dateEnd": "2020-01-01",
            "delaymark":true,
            "delayday": 0,
            "owner": null,
            "orderId": null,
            "contentMain": "<p><span style=\"color: rgb(64, 64, 64); font-family: -apple-system, BlinkMacSystemFont, &quot;Fira Sans&quot;, &quot;Helvetica Neue&quot;, &quot;Apple Color Emoji&quot;, sans-serif;\">正式学员、男、2019-11-22、S201900003、15600000001、林小爱、H202000100、全脑佳系列100课时、2019-11-23至2020-01-01、厦门总部、10000元、100学时、全脑佳第1阶段(100)学时；<br/>、0学时、100学时、2020-03-06、全脑佳系列100课时、10000、100、、0学时、0元、无折扣</span></p>",
            "contentSub": "<p><span style=\"color: rgb(64, 64, 64); font-family: -apple-system, BlinkMacSystemFont, &quot;Fira Sans&quot;, &quot;Helvetica Neue&quot;, &quot;Apple Color Emoji&quot;, sans-serif;\">正式学员</span></p>"
        }
    """.trimIndent()

}



object MenuData {
    //val data:String = File("D:\\coding\\code\\open-source\\java\\eem-mock\\src\\main\\resources\\m.json").readText()
  //  val data:String = File("D:\\coding\\code\\open-source\\java\\eem-mock\\src\\main\\resources\\menu.json").readText()
    val data:String = IoUtil.readClassPath("menu.json")
}

fun getContracts(num:Int): List<MutableMap<Any?, Any?>> {
    val data = Data.contractData
    val list = io.vavr.collection.List.range(0, num).mapIndexed { index, e ->
        val map = JsonUtil.fromJson(data, Map::class.java).toMutableMap()
        map.put("contentMain", Data.d)
        map.put("contentSub", Data.d)
        map.put("contractid", "H202000100-$index")// "contractid": "H202000100",
        map
    }
    return list
}

fun getPagingdData(datas: List<MutableMap<Any?, Any?>>, currPage:Int, pageSize:Int ): List<MutableMap<Any?, Any?>>{
    val offset = (currPage - 1) * pageSize
    val end = Math.min(offset + pageSize, datas.size)
    return datas.subList(offset, end)
}








//http://localhost/eem/AddStudentContractListDelay
//{"contractid":"HT2020417000003","endDate":"2020-04-20 00:00:01"}
// 成功{“delaycout”：10}，失败{“delaycout”：-1}
// {“delaycout”：-2}，提示不能小于当前截止时间

//
//private String contractid;// 合同编号 放在卡片头部
//
//private String createDate;// 签约日期
//
//private String contracttype; // 合同类型(初报、续报)
//
//private String studentName;// 学员姓名
//
//private String telephone;// 家长手机
//
//private String contractName;// 课程包名称
//
//private Integer zxs = 0;// 专用总学时
//
//private Integer zxsCommon = 0;// 通用总学时
//
//private Integer zxsUsed = 0;// 已用专用学时
//
//private Integer zxsCommonUsed = 0;// 已用专用学时
//
//private Double yingshou = 0d;// 应收金额
//
//private Double discount = 0d;// 优惠金额
//
//private Double finalprice = 0d;// 实际金额
//
//private String paytype;// 支付方式
//
//private String statusName; // 支付状态
//
//private String orderTime;// 付款日期 放在卡片头部
//
//private String dateBegin;// 合同有效时间起
//
//private String dateEnd;// 合同有效时间止
//
//private Integer delayday;// 延长有效期天数
//
//private String owner; // 课程顾问
//
//private String orderId; // 流水号
//
//private String contentMain; // 主合同 按钮弹出显示，可以打印
//
//private String contentSub; // 补充协议 按钮弹出显示，可以打印