package eem.controller

import org.apache.commons.io.IOUtils
import org.springframework.web.bind.annotation.*
import java.io.File
import java.util.*
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@RestController
@RequestMapping("/eem")
class UploadController {
    val imgs = mutableMapOf<String, ByteArray>()

    @GetMapping("/img")
    fun g(@RequestParam imgId: String, res: HttpServletResponse){
        res.contentType = "image/jpeg;charset=UTF-8"
        var d = imgs[imgId]
        if(d == null){
            d = File("D:\\img\\1.png").readBytes()
        }
        res.outputStream.write(d)
        res.outputStream.flush()
    }
    @PostMapping("/api/UploadimageServlet")
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