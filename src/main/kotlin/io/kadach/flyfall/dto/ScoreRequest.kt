package io.kadach.flyfall.dto

import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank

class ScoreRequest (
        @field:NotBlank var mobileId: String? = null,
        @field:NotBlank var name: String? = null,
        @field:Min(1) var value: Long? = null
)