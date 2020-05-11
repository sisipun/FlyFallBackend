package io.kadach.flyfall.model

import org.springframework.data.relational.core.mapping.Table

@Table("scores")
data class Score(
        val userId: Long,
        val value: Long
): BaseModel() {


}