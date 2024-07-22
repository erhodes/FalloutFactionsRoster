package com.erhodes.factionsroster.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.erhodes.factionsroster.data.Crew

@Composable
fun AddModelScreen(activeCrew: Crew) {
    
    Column {
        activeCrew.crewType.modelClasses.forEach {
            Text(text = it.name)
        }
    }
}