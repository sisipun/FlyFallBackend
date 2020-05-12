package io.kadach.flyfall.service

import io.kadach.flyfall.dto.ScoreRequest
import io.kadach.flyfall.model.Score
import io.kadach.flyfall.model.ScoreAggregation

interface ScoreService {

    fun save(request: ScoreRequest): Score

    fun list(page: Int, size: Int): List<ScoreAggregation>

}