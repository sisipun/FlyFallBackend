package io.kadach.flyfall.model

import org.springframework.data.annotation.Id

abstract class BaseModel(
        @field:Id
        open val id: Long? = null
) {
}