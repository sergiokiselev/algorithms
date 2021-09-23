package concurrency

import com.fasterxml.jackson.databind.ObjectMapper
import feign.Feign
import feign.Logger
import feign.jackson.JacksonDecoder
import feign.jackson.JacksonEncoder
import feign.slf4j.Slf4jLogger
import org.springframework.cloud.netflix.feign.support.SpringMvcContract
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import java.io.IOException

import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements
import javax.swing.JFrame

import java.awt.Image

import java.awt.Graphics

import java.awt.Canvas
import java.awt.Toolkit


class ImageDownloader {

    fun downloadHtml(url: String): List<String> {
        val text = ClientBuilder()
            .build(url)
            .get()

        //println(text)

        var jsDoc: Document? = null


        jsDoc = Jsoup.connect(SITE_URL).get()
        // System.out.println(jsDoc);
        val img: Elements = jsDoc.select("img[src]")
        val imgSrc: String = img.attr("src")
        return img.map { it.attr("src") }
    }
}

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

fun main() {
}

private const val SITE_URL = "https://www.shutterstock.com/search"

class MyCanvas : Canvas() {
    override fun paint(g: Graphics) {
        val t: Toolkit = Toolkit.getDefaultToolkit()
        val imageSources = ImageDownloader().downloadHtml(SITE_URL)
        for (s in imageSources.take(100)) {
            val i: Image = t.getImage(s)
            g.drawImage(i, 120, 100, this)
        }
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val m = MyCanvas()
            val f = JFrame()
            f.add(m)
            f.setSize(400, 400)
            f.isVisible = true
        }
    }
}