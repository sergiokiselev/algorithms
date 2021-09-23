package concurrency

import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements
import java.awt.Canvas
import java.awt.Graphics
import java.awt.Image
import java.awt.Toolkit
import javax.swing.JFrame


class ImageDownloader {

    fun downloadHtml(url: String): List<String> {
        var jsDoc: Document? = null


        jsDoc = Jsoup.connect(SITE_URL).get()
        val img: Elements = jsDoc.select("img[src]")
        val imgSrc: String = img.attr("src")
        return img.map { it.attr("src") }
    }
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
}

fun main(args: Array<String>) {
    val m = MyCanvas()
    val f = JFrame()
    f.add(m)
    f.setSize(400, 400)
    f.isVisible = true
}
