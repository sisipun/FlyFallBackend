package io.kadach.flyfall.dto

import javax.validation.constraints.NotNull

class ScoreRequest (
        @field:NotNull var mobileId: String? = null,
        @field:NotNull var name: String? = null,
        @field:NotNull var value: Long? = null
)