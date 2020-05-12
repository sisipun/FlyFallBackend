package io.kadach.flyfall

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EnableJpaRepositories
class FlyfallApplication

fun main(args: Array<String>) {
    runApplication<FlyfallApplication>(*args)
}
