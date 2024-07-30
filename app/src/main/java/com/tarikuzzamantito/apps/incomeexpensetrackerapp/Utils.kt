package com.tarikuzzamantito.apps.incomeexpensetrackerapp

import java.text.SimpleDateFormat
import java.util.Locale

/**
 * Created by Tarikuzzaman Tito on 7/30/2024 4:49 PM
 */
object Utils {

    fun formatDateToHumanReadableFormat(dateInMills: Long) : String {
        val dateFormatter = SimpleDateFormat("dd/MM/YYYY", Locale.getDefault())
        return dateFormatter.format(dateInMills)
    }

    fun formatDecimalToValue(double: Double) : String {
        return String.format("%.2f", double)
    }
}