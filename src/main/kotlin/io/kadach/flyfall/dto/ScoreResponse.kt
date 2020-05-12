package io.kadach.flyfall.dto

import io.kadach.flyfall.model.ScoreAggregation

class ScoreResponse(
        val name: String,
        val value: Long
) {

    constructor(aggregation: ScoreAggregation) : this(aggregation.name, aggregation.value)

}