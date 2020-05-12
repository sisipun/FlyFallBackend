package io.kadach.flyfall.model

import javax.persistence.Entity

@Entity(name = "scores")
data class Score(
        val userId: Long,
        val value: Long
): BaseModel()