package hr.reporter.bot

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jdbc.repository.config.EnableJdbcAuditing

@SpringBootApplication
@EnableJdbcAuditing
class App

@SuppressWarnings("SpreadOperator")
fun main(args: Array<String>) {
    runApplication<App>(*args)
}
