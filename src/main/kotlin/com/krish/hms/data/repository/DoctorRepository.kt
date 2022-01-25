package com.krish.hms.data.repository

import com.krish.hms.helper.generateId
import com.krish.hms.helper.getToday
import com.krish.hms.model.*
import java.time.LocalDate
import java.time.LocalTime
import java.util.*

class DoctorRepository {
    private val doctors = mutableMapOf<String, Doctor>()
    private val doctorsConsultations = mutableMapOf<String, MutableList<String>>() // <doctorId, ListOf<consultationId>> doctor's history of cases
    val doctorsPendingConsultations = mutableMapOf<String, Queue<String>>() // <doctorId, ListOf(consultationId)> doctor's current or pending consultations

    fun addDoctor(doctor: Doctor){

        doctors[doctor.doctorId] = doctor

        writeFile("Doctors", doctor.toString())
    }

    fun checkDoctorExistence(ssn: Int) : Boolean{
        return doctors.values.find { it.Ssn == ssn } != null
    }

    fun getDepartmentDoctors(department: Department): List<Doctor>{
        return doctors.values.filter { it.department == department }
    }

    fun getPendingConsultations(doctorId: String): Int{
        return doctorsPendingConsultations[doctorId]?.size ?: 0
    }

    fun manageConsultationsAndDoctors(doctorId: String, issue: String, caseId: String, department: Department, ssn: Int){
        //Create consultation
        val consultationId = generateId(IdHolder.CONSULTATION)
        consultations[consultationId] = Consultation(consultationId, caseId, doctorId, issue, department, getToday(), "")

        //Update case last visit date
        cases[caseId]!!.lastVisit = getToday()

        //Update patient last visit date
        val patientId = getPatientId(ssn)
        patients[patientId]!!.lastRegistered = getToday()

        addOrCreate(doctorsConsultations, doctorId, consultationId)
        addOrCreateQueue(doctorsPendingConsultations, doctorId, consultationId)
        addOrCreate(casesConsultations, caseId, consultationId)
    }
}