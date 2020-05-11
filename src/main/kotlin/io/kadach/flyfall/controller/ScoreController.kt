package io.kadach.flyfall.controller

import io.kadach.flyfall.dto.ScoreRequest
import io.kadach.flyfall.service.ScoreService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController("/score")
class ScoreController(
        private val service: ScoreService
) {
    @PostMapping
    fun save(request: ScoreRequest) {
        service.save(request)
    }
}