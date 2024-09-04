package com.erhodes.factionsroster.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.erhodes.factionsroster.data.CrewRepository
import com.erhodes.factionsroster.data.ModelClass
import com.erhodes.factionsroster.data.WeaponLoadout
import com.erhodes.factionsroster.ui.theme.FactionsRosterTheme

@Composable
fun SelectLoadoutScreen(modelClass: ModelClass, onLoadoutSelected: (WeaponLoadout) -> Unit, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        SpecialStatLine(stats = modelClass.special)
        Text(
            text = "Choose a weapon loadout",
            modifier = modifier.padding(vertical = 5.dp)
        )
        modelClass.loadouts.forEach { loadout ->
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .clickable { onLoadoutSelected(loadout) }
            ) {
                loadout.weapons.forEach {
                    Text(it.name)
                }
                Text(
                    modifier = modifier,
                    text = loadout.rating.toString()
                )
            }
        }
    }
}

@Preview
@Composable
fun SelectLoadoutScreenPreview() {
    FactionsRosterTheme {

        SelectLoadoutScreen(CrewRepository.buildDefaults().crewType.modelClasses[0], {})
    }
}