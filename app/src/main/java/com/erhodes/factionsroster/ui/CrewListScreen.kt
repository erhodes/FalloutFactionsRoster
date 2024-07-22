package com.erhodes.factionsroster.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.erhodes.factionsroster.CrewViewModel
import com.erhodes.factionsroster.data.CrewType
import com.erhodes.factionsroster.data.Model
import com.erhodes.factionsroster.data.ModelClass
import com.erhodes.factionsroster.data.Weapon
import com.erhodes.factionsroster.data.WeaponLoadout
import com.erhodes.factionsroster.ui.theme.FactionsRosterTheme

@Composable
fun CrewListScreen(crewViewModel: CrewViewModel, onAddClicked: () -> Unit, modifier: Modifier = Modifier) {
    val activeCrew by crewViewModel.activeCrew.collectAsState()
    
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = "its a start")
        Button(
            onClick = onAddClicked
        ) {
            Text(text = "Add a model")
        }
        activeCrew!!.models.forEach { model ->
            CrewListItem(model = model)
        }
    }
}

@Composable
fun CrewListItem(
    model: Model,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
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
    val launcher = Weapon("Missile Launcher")
    launcher.test = "6S"
    launcher.traits = "Area 3, Slow"
    launcher.criticalEffect = "Maim"

    val combatRifle = Weapon("Combat Rifle")
    combatRifle.test = "4P"
    combatRifle.traits = "Fast"
    combatRifle.criticalEffect = "Maim"

    val launcherLoadout = WeaponLoadout(listOf(launcher), 48)
    val rifleLoadout = WeaponLoadout(listOf(combatRifle), 27)

    val madeMan = ModelClass("Made Man", arrayListOf(4,6,4,4,5,4,2), arrayListOf(launcherLoadout))
    val scavver = ModelClass("Scavver", arrayListOf(3,4,4,4,5,3,2), arrayListOf(rifleLoadout))

    val operators = CrewType(name = "Operators", listOf(madeMan, scavver))

    val model = Model("Big Tom", madeMan, launcherLoadout)
    
    FactionsRosterTheme {
        CrewListItem(model = model)
    }
}