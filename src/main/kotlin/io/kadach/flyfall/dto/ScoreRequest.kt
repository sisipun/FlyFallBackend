package io.kadach.flyfall.dto

import javax.validation.constraints.NotNull

class ScoreRequest (
        @field:NotNull val mobileId: String,
        @field:NotNull val value: Long
)