package com.krish.hms.model

import com.krish.hms.helper.*

class Medicine(
    val medicineId: String,
    val medicineName: String,
    val medicineType: MedicineType,
    val count: Int,
    val days: Int,
    val morning: Boolean,
    val afternoon: Boolean,
    val night: Boolean,
){

    constructor(fields: List<String>) :
            this(
                fields[0],
                fields[1],
                getMedicineType(fields[2].toInt()),
                fields[3].toInt(),
                fields[4].toInt(),
                fields[5].toInt().getBoolean(),
                fields[6].toInt().getBoolean(),
                fields[7].toInt().getBoolean()
            )

    override fun toString(): String {
        return "$medicineId|$medicineName|${medicineType.ordinal}|$count|$days|" +
                "${morning.toInt}|${afternoon.toInt}|${night.toInt}\n"
    }
}