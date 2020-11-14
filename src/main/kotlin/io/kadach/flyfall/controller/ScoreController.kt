package io.kadach.flyfall.controller

import io.kadach.flyfall.dto.ScoreRequest
import io.kadach.flyfall.dto.ScoreResponse
import io.kadach.flyfall.service.ScoreService
import org.springframework.web.bind.annotation.*

@CrossOrigin
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
    fun findAll(@RequestParam page: Int, @RequestParam size: Int): List<ScoreResponse> =
            service.findAll(page, size).map { ScoreResponse(it) }

    @GetMapping("/{mobileId}")
    fun findByMobileId(@PathVariable mobileId: String) =
            service.findByMobileId(mobileId).map { ScoreResponse(it) }
}