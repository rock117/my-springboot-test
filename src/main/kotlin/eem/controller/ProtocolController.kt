package eem.controller

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/eem")
class ProtocolController {

//    /api/ProtocalAndPrivaceEditDisplaySingle单个的servlet
//    服务协议（登）loginProtocal、
//    隐私协议（登）loginPrivace、
//    服务协议（手机-家-弹窗）telphoneProtocalStu、
//    隐私协议（手机-家-弹窗）telphonePrivaceStu、
//    服务协议（手机-校区-弹窗）telphoneProtocalCampus
//    隐私协议（手机-校区-弹窗）telphonePrivaceCampus
//    使用须知（PC-校区-弹窗）modelPcCampus
    @GetMapping("/api/ProtocalAndPrivaceDisplay")
    fun get(): Map<String, String> {
       return mapOf("loginProtocal" to "aaa1", "loginPrivace" to "bbb")
    }
    @PostMapping("/api/ProtocalAndPrivaceEdit")
    fun save(): Map<String, Any> {
        return mapOf("result" to true)
    }
}