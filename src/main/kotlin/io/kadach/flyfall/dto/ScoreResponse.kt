package io.kadach.flyfall.dto

import io.kadach.flyfall.model.ScoreAggregation

class ScoreResponse(
        val mobileId: String,
        val name: String,
        val value: Long
) {

    constructor(aggregation: ScoreAggregation) : this(aggregation.mobileId, aggregation.name, aggregation.value)

}