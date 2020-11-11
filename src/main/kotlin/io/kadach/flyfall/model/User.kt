package io.kadach.flyfall.model

import javax.persistence.Column
import javax.persistence.Entity

@Entity(name = "users")
data class User(

        @Column(nullable = false, updatable = false, unique = true)
        val mobileId: String,

        @Column(nullable = false, updatable = false)
        val name: String

) : BaseModel()