package io.kadach.flyfall

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories

@SpringBootApplication
@EnableJdbcRepositories
class FlyfallApplication

fun main(args: Array<String>) {
    runApplication<FlyfallApplication>(*args)
}
