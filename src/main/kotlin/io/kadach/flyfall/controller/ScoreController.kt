package io.kadach.flyfall.controller

import io.kadach.flyfall.dto.ScoreRequest
import io.kadach.flyfall.dto.ScoreResponse
import io.kadach.flyfall.service.ScoreService
import org.springframework.data.domain.PageRequest
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/scores")
class ScoreController(
        private val service: ScoreService
) {
    @PostMapping
    fun save(@RequestBody request: ScoreRequest) {
        service.save(request)
    }

    @GetMapping
    fun list(@RequestParam page: Int, @RequestParam size: Int): List<ScoreResponse> {
        return service.list(page, size).map { ScoreResponse(it) }
    }
}