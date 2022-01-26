
package com.krish.hms.ui

import com.krish.hms.helper.getMeridian
import com.krish.hms.helper.getTime
import com.krish.hms.helper.toInt
import com.krish.hms.model.LogLevel
import com.krish.hms.model.Meridian
import java.time.LocalTime

class UIHandler {

    fun readData(field: String): String{
        println("Enter $field:")
        var input = readLine()
        while(input == null || input == "")
            input = readLine()
        return input
    }


    fun writeData(message: String, logLevel: LogLevel = LogLevel.INFO){
        when(logLevel){
            LogLevel.ERROR -> println(ANSI_RED + message + ANSI_RESET)
            LogLevel.WARNING -> println(ANSI_YELLOW + message + ANSI_RESET)
            LogLevel.INFO -> println(ANSI_WHITE + message + ANSI_RESET)
        }
    }

    fun readTime(field: String): LocalTime? {
        val hour = readData("$field hour").toInt()
        val minutes = readData("$field minutes").toInt()
        val meridian = getMeridian(readOptions(Meridian.values()))
        return getTime(hour, minutes, meridian)
    }

    fun <T> readOptions(options: Array<T>): Int{
        var i= 1
        for(option in options)
            println("${i++} . $option")
        return readData("option").toInt().minus(1)
    }

    companion object{
        const val ANSI_RESET = "\u001B[0m"
        const val ANSI_RED = "\u001B[31m"
        const val ANSI_YELLOW = "\u001B[33m"
        const val ANSI_WHITE = "\u001B[37m"
    }

}