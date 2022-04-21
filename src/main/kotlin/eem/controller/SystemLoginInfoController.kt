package eem.controller

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/eem")
class SystemLoginInfoController {
    @GetMapping("/systemLoginInfo")
    fun getStudentContractList(): Map<String, *> {
        val data = """
            {
            	"currentLoginedRole": "1",
            	"currentLoginedRoleName": "教师",
            	"currentLoginedRolePhotoFileid": "3a9776e2-d8cf-38af-b346-1d216e928f8c",
            	"currentLoginedRoleUserName": "林小爱",
            	"currentLoginedUserName": null,
            	"currentCampusXqmc": "厦门总部",
            	"currentLoginedUserid": "admin",
            	"currentLoginedTelephone": "15600000001",
            	"currentWeixinOpenid": null,
            	"currentFranchiseeId": "HZS0000",
            	"currentFranchiseeTelephone": "15600000001",
            	"currentCampusXqh": "AY0000000000",
            	"currentCampusTelephone": "15600000001",
            	"currentLoginedStudentXh": null,
            	"currentLoginedTeacherZgh": "T201900000",
            	"currentTeacherPrivileges": ["jwgl", "jwgl_pk", "jwgl_sz", "jwgl_01", "jwgl_pc01", "jwgl_pc02", "jwgl_pc03", "jwgl_pc04", "qdgl", "qdgl_pc", "qdgl_pc01", "qdgl_pc02", "zhgl", "zhgl_pc", "zhgl_pc03", "zhgl_pc04", "xxgl", "xxgl_01", "xxgl_pc01", "xxgl_pc02", "xxgl_pc03", "kfgl", "kfgl_pc", "kfgl_pc01", "kfgl_pc02", "htgl", "htgl_01", "htgl_app", "htgl_pc", "htglApp_02", "htgl_004", "htglApp_01", "htglApp_03", "htgl_005", "htgl_pc01", "htgl_pc02", "htgl_pc03", "xtgl", "xtgl_rz", "xtgl_vx", "xtgl_yh", "xtgl_rz01", "xtgl_vx01", "xtgl_vx02", "xtgl_vx03", "xtgl_yh01", "xtgl_yh02", "hzgl", "hzgl_pc", "hzgl_pc01", "hzgl_pc02", "hzgl_pc03", "hzgl_pc04", "hzgl_pc05", "lbgl", "lbgl_pc", "lbgl_pc01", "lbgl_pc02", "lbgl_pc03", "dxgl", "dxgl_pc", "dxgl_pc01", "dxgl_pc02", "dxgl_pc03", "integralMall_pc01", "integralMall_pc02", "integralMall_pc03", "integralMall_pc04", "integralMall_pc05", "integralMall_pc06", "integralMall_pc07", "xygl", "xygl_01", "xygl_02", "xyglApp_02", "xyglApp_03", "xyglApp_04", "xyglApp_06", "xygl_pc02", "xyglApp_05", "xyglApp_07", "xyglApp_08", "rsgl", "rsgl_01", "rsgl_02", "rsgl_03", "rsgl_04", "rsgl_05", "rsgl_06", "rsgl_07", "rsgl_08", "rsgl_yg01", "rsgl_rssz01", "rsgl_rssz02", "rsgl_rssz03", "rsgl_rssz04", "rsgl_gz01", "rsgl_gz02", "rsgl_gz03", "rsgl_gz04", "rsgl_gzsz01", "rsgl_gzsz02", "rsgl_gzsz03", "rsgl_gzsz04", "rsgl_kqgl01", "rsgl_kqgl02", "rsgl_kqgl03", "rsgl_kqgl04", "rsgl_kqsz01", "rsgl_kqsz02", "rsgl_kqsz03", "rsgl_kqsz04", "rsgl_khgl01", "rsgl_khgl02", "rsgl_khsz01", "rsgl_khsz02", "htglApp_04", "hzgl_pc06", "integralMall_pc09", "xyglApp_10", "integralMall_pc08", "integralMall_pc", "integralMall"],
            	"adminCampus": true,
            	"adminFranchisee": true,
            	"adminHeadquarters": true
            }

        """.trimIndent()
       return JsonUtil.fromJson(data, Map::class.java) as Map<String, *>
    }
}