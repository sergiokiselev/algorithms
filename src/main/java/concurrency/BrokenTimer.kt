import java.lang.RuntimeException
import java.util.*
import java.util.concurrent.TimeUnit

fun main() {
    val timer = Timer()
    timer.schedule(Worker(), 1)
    TimeUnit.SECONDS.sleep(1)
    timer.schedule(Worker(), 1)
    TimeUnit.SECONDS.sleep(3)
}

private class Worker : TimerTask() {
    override fun run() {
        throw RuntimeException()
    }
}