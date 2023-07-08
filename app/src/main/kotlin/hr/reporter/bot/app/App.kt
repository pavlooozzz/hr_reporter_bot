package hr.reporter.bot.app

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class App

@SuppressWarnings("SpreadOperator")
fun main(args: Array<String>) {
    runApplication<App>(*args)
}
