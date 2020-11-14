package io.kadach.flyfall.model

import java.util.*
import javax.persistence.Column
import javax.persistence.Entity

@Entity(name = "scores")
data class Score(

        @Column(nullable = false, updatable = false)
        val mobileId: String,

        @Column(nullable = false, updatable = false)
        val name: String,

        @Column(nullable = false, updatable = false)
        val value: Long,

        @Column(nullable = false, updatable = false)
        val creationDate: Date

): BaseModel()