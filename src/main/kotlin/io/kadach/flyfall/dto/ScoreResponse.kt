package io.kadach.flyfall.dto

import io.kadach.flyfall.model.Score
import java.util.*

class ScoreResponse(
        val mobileId: String,
        val name: String,
        val value: Long,
        val creationDate: Date
) {

    constructor(aggregation: Score) : this(aggregation.mobileId, aggregation.name, aggregation.value,
            aggregation.creationDate)

}