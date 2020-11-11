package io.kadach.flyfall.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Entity(name = "scores")
data class Score(

        @ManyToOne
        @JoinColumn(name = "user_id", nullable = false, updatable = false)
        val user: User,

        @Column(nullable = false, updatable = false)
        val value: Long

): BaseModel()