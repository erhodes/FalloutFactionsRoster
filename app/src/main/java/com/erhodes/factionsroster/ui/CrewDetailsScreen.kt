package com.erhodes.factionsroster.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.erhodes.factionsroster.data.Crew
import com.erhodes.factionsroster.data.CrewRepository
import com.erhodes.factionsroster.data.Model
import com.erhodes.factionsroster.ui.theme.FactionsRosterTheme

@Composable
fun CrewDetailsScreen(activeCrew: Crew, onAddClicked: () -> Unit, modifier: Modifier = Modifier) {
    
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        Text(
            text = activeCrew.crewName,
            style = MaterialTheme.typography.titleLarge
        )
        Text(
            text = activeCrew.crewFaction,
            style = MaterialTheme.typography.titleSmall
        )

        Text(
            text = "Reputation ${activeCrew.reputation}"
        )

        if (activeCrew.models.isEmpty()) {
            Text(
                text = "Your crew is empty!"
            )
        } else {
            activeCrew.models.forEach { model ->
                ModelItem(model = model)
            }
        }


        Button(
            onClick = onAddClicked
        ) {
            Text(text = "Add a model")
        }
    }
}

@Composable
fun ModelItem(
    model: Model,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .padding(vertical = 5.dp)
            .background(color = MaterialTheme.colorScheme.primaryContainer)
            .fillMaxWidth()
    ){
        Column {
            Text(text = model.name, fontSize = 26.sp)
            Text(text = model.modelClass.name)
        }
        model.special.forEach {
            Text(text = "$it")
        }
        Spacer(modifier = Modifier.width(10.dp))
        model.weapons.forEach { weapon ->
            Text(text = weapon.name)
        }
    }

}

@Preview
@Composable
fun CrewListPreview() {
    FactionsRosterTheme {
        val activeCrew = CrewRepository.buildDefaults()
        val modelClass = activeCrew.crewType.modelClasses[0]
        activeCrew.addModel(Model("Big Tom", modelClass, modelClass.loadouts[0]))

        activeCrew.addModel(Model("Doctor Boom", modelClass, modelClass.loadouts[0]))

        CrewDetailsScreen(activeCrew, onAddClicked = { })
    }
}