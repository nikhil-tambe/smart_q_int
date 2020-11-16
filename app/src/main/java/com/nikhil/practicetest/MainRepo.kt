package com.nikhil.practicetest

import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class MainRepo {

    var itemName : String = "Dosa"
    var timeRanges : String = "17:00-21:00,7:00-10:00,9:45-12:00"

    fun isItemAvailable( itemName: String, timeString: String) : Boolean {

        val timeSlots = timeRanges.split(",").map {
            val slot = it.split("-")

            val t1 = slot[0].split(":")
            val h1 = t1[0].toInt() * 3600
            val m1 = t1[1].toInt() * 60
            val start = h1 + m1;

            val t2 = slot[1].split(":")
            val h2 = t2[0].toInt() * 3600
            val m2 = t2[1].toInt() * 60
            val end = h2+m2

            (start)..(end)
        }

        val s = timeString.split(":")
        val currentTime = (s[0].toInt() * 3600) + (s[1].toInt() * 60)

        timeSlots.forEach {
            if(currentTime in it) return true
        }

        return false
    }

    fun isItemAvailable(itemName: String, timeInMillis: Long): Boolean {
        val cal = Calendar.getInstance()
        cal.timeInMillis = timeInMillis
        val hh = cal.get(Calendar.HOUR_OF_DAY).toString()
        val mm = cal.get(Calendar.MINUTE).toString()
        val time = "$hh:$mm"
        return isItemAvailable(itemName, time)
    }

    fun getUserList(): List<User> {
        return listOf(
            User(name = "A", age = 12, dob = "12-12-2020"),
            User(name = "B", age = 22, dob = "11-11-2020"),
            User(name = "C", age = 32, dob = "11-1-1992"),
            User(name = "D", age = 42, dob = "1-2-1991"),
        )
    }

}