
package com.krish.hms.model

import java.time.LocalDate

class Case(
    val caseId: String,
    val patientId: String,
    val firstVisit: LocalDate,
    var lastVisit: LocalDate,
) {

    constructor(fields: List<String>) :
            this(
                fields[0],
                fields[1],
                LocalDate.parse(fields[2]),
                LocalDate.parse(fields[3]))

    override fun toString(): String {
        return "$caseId|$patientId|$firstVisit|$lastVisit\n"
    }
}