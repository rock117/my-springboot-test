
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import kotlin.reflect.KProperty0


object JsonUtil {
    /**
     * parse json to bean with date pattern
     *
     * @param json
     * @param clazz
     * @return
     */
    fun <T> fromJson(json: String,   clazz: Class<T>): T {
        val mapper: ObjectMapper = createDefaultObjectMapper()
        return  mapper.readValue(json, clazz)
    }
    private fun createDefaultObjectMapper(): ObjectMapper {
        val mapper = ObjectMapper()
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL)
        // mapper.registerModule(JavaslangModule())
        mapper.registerModule(Jdk8Module()).registerModule(JavaTimeModule())
        return mapper
    }

    fun toJson(bean: Any): String {
        val mapper = createDefaultObjectMapper()
        return mapper.writeValueAsString(bean)
    }
}