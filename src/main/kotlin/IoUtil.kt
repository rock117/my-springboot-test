import org.apache.commons.io.IOUtils

object IoUtil {
    fun readClassPath(path: String): String{
        val input = IoUtil::class.java.getResourceAsStream(path)
        val content = IOUtils.toString(input, "UTF-8")
        input.close()
        return content!!
    }
}