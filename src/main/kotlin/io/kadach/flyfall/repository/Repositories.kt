package io.kadach.flyfall.repository

import io.kadach.flyfall.model.BaseModel
import io.kadach.flyfall.model.Score
import io.kadach.flyfall.model.ScoreAggregation
import io.kadach.flyfall.model.User
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface BaseRepository<T : BaseModel> : CrudRepository<T, Long>

interface ScoreRepository : BaseRepository<Score> {

    @Query("""SELECT new io.kadach.flyfall.model.ScoreAggregation(u.name, MAX(s.value))
            FROM scores AS s
            JOIN users AS u
            ON s.user.id=u.id
            GROUP BY u
            ORDER BY MAX(s.value) DESC""")
    fun findMax(pageable: Pageable): List<ScoreAggregation>

}

interface UserRepository : BaseRepository<User> {

    fun findByMobileId(mobileId: String): User?

}