package io.kadach.flyfall.service

import io.kadach.flyfall.dto.ScoreRequest
import io.kadach.flyfall.model.Score

interface ScoreService {

    fun save(request: ScoreRequest): Score

}