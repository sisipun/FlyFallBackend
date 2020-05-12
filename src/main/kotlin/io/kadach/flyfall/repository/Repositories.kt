package io.kadach.flyfall.repository

import io.kadach.flyfall.model.BaseModel
import io.kadach.flyfall.model.Score
import io.kadach.flyfall.model.User
import org.springframework.data.repository.CrudRepository

interface BaseRepository<T : BaseModel> : CrudRepository<T, Long>

interface ScoreRepository : BaseRepository<Score>

interface UserRepository : BaseRepository<User> {

    fun findByMobileId(mobileId: String): User?

}