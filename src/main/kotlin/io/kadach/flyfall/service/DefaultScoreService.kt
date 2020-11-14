package io.kadach.flyfall.service

import io.kadach.flyfall.dto.ScoreRequest
import io.kadach.flyfall.model.Score
import io.kadach.flyfall.repository.ScoreRepository
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
@Transactional(readOnly = true)
class DefaultScoreService(
        private val repository: ScoreRepository
) : ScoreService {

    @Transactional
    override fun save(request: ScoreRequest): Score =
            repository.save(Score(request.mobileId!!, request.name!!, request.value!!, Date()))

    override fun findAll(page: Int, size: Int): List<Score> = repository.findMax(PageRequest.of(page, size))

    override fun findByMobileId(mobileId: String): List<Score> = repository.findByMobileId(mobileId)
}