package io.kadach.flyfall.model

import org.hibernate.annotations.Table
import javax.persistence.Entity

@Entity(name = "users")
data class User(
        val mobileId: String,
        val name: String
) : BaseModel()