package com.erhodes.factionsroster.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.erhodes.factionsroster.ui.theme.FactionsRosterTheme

@Composable
fun SpecialStatLine(stats: ArrayList<Int>, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Row {
            arrayListOf("S","P","E","C","I","A","L").forEach {
                Text(
                    text = it
                )
            }
        }
        Row {
            stats.forEach {
                Text(
                    text = it.toString()
                )
            }
        }
    }
}

@Preview
@Composable
fun SpecialStatLinePreview() {
    FactionsRosterTheme {
        SpecialStatLine(arrayListOf(4,6,4,4,5,4,2))
    }
}