package io.kadach.flyfall.model

import org.springframework.data.relational.core.mapping.Table

@Table("users")
data class User(
        val mobileId: String
) : BaseModel()