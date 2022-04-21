package eem.controller

import org.apache.commons.io.IOUtils
import org.springframework.web.bind.annotation.*
import java.io.File
import java.util.*
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@RestController
@RequestMapping("/eem")
class IndexPageUploadController {
    val imgs = mutableMapOf<String, ByteArray>()

    @GetMapping("/api/img")
    fun get(@RequestParam imgId: String, res: HttpServletResponse){
        res.contentType = "image/jpeg;charset=UTF-8"
        var d = imgs[imgId]
        if(d == null){
            d = File("D:\\img\\1.png").readBytes()
        }
        res.outputStream.write(d)
        res.outputStream.flush()
    }

    @PostMapping("/api/SystemphotoEditDisplay")
    fun g():Map<String, String>{

         return mapOf("loginPhotosmall" to "https://zos.alipayobjects.com/rmsportal/jkjgkEfvpUPVyRjUImniVslZfWPnJuuZ.png",
         "loginPhotobig" to "https://zos.alipayobjects.com/rmsportal/jkjgkEfvpUPVyRjUImniVslZfWPnJuuZ.png",
         "hudongPhoto" to "https://zos.alipayobjects.com/rmsportal/jkjgkEfvpUPVyRjUImniVslZfWPnJuuZ.png")
    }
    @PostMapping("/api/SystemphotoEditApi")
    fun upload(request: HttpServletRequest):Map<String, Any>{
        val excel = request.getPart("file").inputStream!!
        val d = IOUtils.toByteArray(excel)
        val id = UUID.randomUUID().toString()
        imgs[id] = d
        val data = """
            {
                  "url":"/eem/img?imgId=$id"
            }
        """.trimIndent()
        return JsonUtil.fromJson(data, Map::class.java) as Map<String, Any>
    }
}

///api/SystemphotoEditApi
//
///api/SystemphotoEditDisplay
//String id = "AY0000000000";
//String loginPhotosmall = "";
//String loginPhotobig = "";
//String hudongPhoto = "";
//String accessToken = "";