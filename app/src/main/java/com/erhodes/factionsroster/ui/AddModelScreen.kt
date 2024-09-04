package com.erhodes.factionsroster.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.erhodes.factionsroster.data.Crew
import com.erhodes.factionsroster.data.CrewRepository
import com.erhodes.factionsroster.data.ModelClass
import com.erhodes.factionsroster.ui.theme.FactionsRosterTheme

@Composable
fun AddModelScreen(activeCrew: Crew, onClassSelected: (ModelClass) -> Unit, modifier: Modifier = Modifier) {
    
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        activeCrew.crewType.modelClasses.forEach {
            ModelClassItem(modelClass = it, onClassSelected)
        }
    }
}

@Composable
fun ModelClassItem(modelClass: ModelClass, onClick: (ModelClass) -> Unit, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onClick(modelClass) },
    ) {
        Row(
            verticalAlignment = Alignment.Bottom
        ) {
            Text(
                text = modelClass.name,
                style = MaterialTheme.typography.headlineMedium
            )
            Text(
                text = "(${modelClass.type})",
                textAlign = TextAlign.End
            )
        }

    }
}

@Preview
@Composable
fun AddModelScreenPreview() {
    FactionsRosterTheme {
        val activeCrew = CrewRepository.buildDefaults()

        AddModelScreen(activeCrew = activeCrew, {})
    }
}