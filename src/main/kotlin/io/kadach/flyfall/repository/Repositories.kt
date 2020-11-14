package io.kadach.flyfall.repository

import io.kadach.flyfall.model.BaseModel
import io.kadach.flyfall.model.Score
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface BaseRepository<T : BaseModel> : CrudRepository<T, Long>

interface ScoreRepository : BaseRepository<Score> {

    @Query("""
        SELECT new io.kadach.flyfall.model.Score(s.mobileId, MAX(s.name), MAX(s.value), MAX(s.creationDate))
        FROM scores AS s WHERE EXISTS (
            SELECT highScores.mobileId FROM scores AS highScores
            GROUP BY highScores.mobileId 
            HAVING highScores.mobileId = s.mobileId AND MAX(highScores.value) = s.value) 
        GROUP BY s.mobileId
        ORDER BY MAX(s.value) DESC
        """)
    fun findMax(pageable: Pageable): List<Score>

    fun findByMobileId(mobileId: String): List<Score>

}