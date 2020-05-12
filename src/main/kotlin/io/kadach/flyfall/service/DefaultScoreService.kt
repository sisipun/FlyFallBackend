package io.kadach.flyfall.service

import io.kadach.flyfall.dto.ScoreRequest
import io.kadach.flyfall.model.Score
import io.kadach.flyfall.model.User
import io.kadach.flyfall.repository.ScoreRepository
import io.kadach.flyfall.repository.UserRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class DefaultScoreService(
        private val repository: ScoreRepository,
        private val userRepository: UserRepository
): ScoreService {

    @Transactional
    override fun save(request: ScoreRequest): Score {
        val user = userRepository.findByMobileId(request.mobileId!!) ?: userRepository.save(User(request.mobileId!!, request.name!!))
        return repository.save(Score(user.id!!, request.value!!))
    }
}