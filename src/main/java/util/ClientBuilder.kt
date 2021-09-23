package util

import com.fasterxml.jackson.databind.ObjectMapper
import feign.Feign
import feign.Logger
import feign.slf4j.Slf4jLogger
import org.springframework.cloud.netflix.feign.support.SpringMvcContract
import org.springframework.web.bind.annotation.GetMapping

class ClientBuilder {

    private val mapper = ObjectMapper()
    fun build(url: String) =
        Feign.builder()
            .contract(SpringMvcContract())
//            .encoder(JacksonEncoder(mapper))
//            .decoder(JacksonDecoder(mapper))
            .logLevel(Logger.Level.FULL)
            .logger(Slf4jLogger(this::class.java))
            .target(PixabayClient::class.java, url)
}

interface PixabayClient {

    @GetMapping("/girl")
    fun get(): String
}
