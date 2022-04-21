package eem
import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication


@SpringBootApplication
class BootConfig

fun main(args: Array<String>) {
    val log = LoggerFactory.getLogger(BootConfig::class.java)
    val port = "8070"
    System.setProperty("server.port", port)
    log.info("Server started at $port")
    runApplication<BootConfig>(*args)

}
