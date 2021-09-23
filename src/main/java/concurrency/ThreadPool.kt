package concurrency

import java.util.Collections.synchronizedSet
import java.util.concurrent.CountDownLatch
import java.util.concurrent.Executors.newFixedThreadPool
import java.util.logging.Logger

class ExecutorServer(private val latch: CountDownLatch) {
    private val service = newFixedThreadPool(THREADS_COUNT)
    private val log by lazy { Logger.getLogger(ExecutorServer::class.java.name) }
    private val idsSet = mutableSetOf<Long>()
    private val idsSetSync = synchronizedSet(idsSet)

    fun execute(arg: String) {
        val task = Runnable {
            Thread.sleep(1000)
            log.info("Thread ID: ${Thread.currentThread().id}, Param: $arg")
            latch.countDown()
            idsSetSync.add(Thread.currentThread().id)
        }
        service.execute(task)
    }

    fun shutdown() {
        service.shutdown()
    }

    fun getThreadIds() =
        idsSetSync.toList()
}

fun main(args: Array<String>) {
    val latch = CountDownLatch(MESSAGES_NUMBER)
    val server = ExecutorServer(latch)
    for (i in 0 until MESSAGES_NUMBER) {
        server.execute(i.toString())
    }
    println("Finished submitting")
    latch.await()
    println("Finished calculations, shutting down")
    println(server.getThreadIds())
    server.shutdown()
}

private const val THREADS_COUNT = 8
private const val MESSAGES_NUMBER = 100