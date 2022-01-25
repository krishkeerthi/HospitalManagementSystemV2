package com.krish.hms.ui

import com.krish.hms.helper.*
import com.krish.hms.model.*
import com.krish.hms.model.Modules
import java.time.LocalDate
import java.time.LocalTime


class UIHandler {

    fun readSSN() = enterField("SSN").toInt()

    fun readDoctorId() = enterField("Doctor Id")

    fun readPatientId() = enterField("Patient Id")

    fun readName() = enterField("name")

    fun readIssue() = enterField("issue")

    fun readYesOrNo() = isYes(enterField("yes or no for new case"))

    fun readCaseId() = enterField("case id")

    fun readAssessment() = enterField("Assessment message")

    fun readDoctor(ssn: Int): Doctor {
        val name = enterField("Name")
        val age = enterField("Age").toInt()
        val gender = getGender(enterField("1. Male 2. Female 3. Others").toInt().minus(1))
        val dob = enterField("Date of Birth(dd-mm-yyyy)").getDate() ?: LocalDate.now().
        also { println("Invalid Date entered, so Today's is assigned")}

        val address = enterField("Address")
        val contact = enterField("Contact Number")
        val bloodGroup = getBloodGroup(enterField("1. A+ 2. A- 3. B+ 4. B- 5. O+ 6. O- 7. AB+ 8. AB-").toInt().minus(1))
        val doctorId = generateId(IdHolder.DOCTOR)
        val department = getDepartment(enterField("1. Dermatology 2. ENT 3. Ophthalmology").toInt().minus(1))
        val experience = enterField("years of experience").toInt()

        val startTime = enterTime("start") ?: getDefaultTime().
        also { println("Invalid time entered, so default time(12:00pm) is assigned") }

        val endTime = enterTime("end") ?: getDefaultTime().
        also { println("Invalid time entered, so default time(12:00pm) is assigned") }

        return Doctor(name, age, gender, dob, address, contact, bloodGroup,
            ssn, doctorId, department, experience, startTime, endTime)
    }

    fun readPatient(ssn: Int): Patient {
        val name = enterField("Name")
        val age = enterField("Age").toInt()
        val gender = getGender(enterField("1. Male 2. Female 3. Others").toInt().minus(1))
        val dob = enterField("Date of Birth(dd-mm-yyyy)").getDate() ?: LocalDate.now().
        also { println("Invalid Date entered, so Today's is assigned")}

        val address = enterField("Address")
        val contact = enterField("Contact Number")
        val bloodGroup = getBloodGroup(enterField("1. A+ 2. A- 3. B+ 4. B- 5. O+ 6. O- 7. AB+ 8. AB-").toInt().minus(1))
        val patientId = generateId(IdHolder.PATIENT)

        return Patient(name, age, gender, dob, address, contact, bloodGroup,
            ssn, patientId , getToday(), getToday())
    }

    fun readInTime(): LocalTime{
        return enterTime("patient in") ?: getDefaultTime().
        also { println("Invalid time entered, so default time(12:00pm) is assigned") }
    }


    fun readMedicine(): Medicine{
        val name = enterField("Medicine Name")
        val type = getMedicineType(enterField("1. Tablet 2. Drops 3. Syrup 4. Inhaler 5. Cream").toInt().minus(1))
        val count = enterField("Count of usage").toInt()
        val days = enterField("No of days to continue").toInt()
        val morning = isYes(enterField("Yes or No for morning"))
        val afternoon = isYes(enterField("Yes or No for afternoon"))
        val night = isYes(enterField("Yes or No for evening"))

        return Medicine(generateId(IdHolder.MEDICINE), name, type, count, days, morning, afternoon, night)
    }

    fun readDoctorSelection() = enterField("1. All 2. By id 3. By department").toInt()

    fun readDepartmentSelection() = getDepartment(enterField("1. Dermatology 2. ENT 3. Ophthalmology").toInt().minus(1))

    fun readPatientSelection() = enterField("1. All 2. By id 3. By name").toInt()

    fun readModules(): Int{
        var i= 1
        for(module in Modules.values())
            println("${i++} . $module")
        return enterField("option").toInt()
    }

    fun thankYouMessage() {
        println("Thank you")
    }

    fun welcomeMessage() {
        println("Welcome to Hospital Management System")
    }


    // Need to write print methods
}