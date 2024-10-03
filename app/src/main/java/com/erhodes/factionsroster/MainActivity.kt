package com.erhodes.factionsroster

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.room.Room
import com.erhodes.factionsroster.data.CrewType
import com.erhodes.factionsroster.data.ModelClass
import com.erhodes.factionsroster.data.Weapon
import com.erhodes.factionsroster.data.WeaponLoadout
import com.erhodes.factionsroster.database.AppDatabase
import com.erhodes.factionsroster.ui.RosterApp
import com.erhodes.factionsroster.ui.theme.FactionsRosterTheme

class MainActivity : ComponentActivity() {
    // todo replace this with injection
    companion object {
        lateinit var database: AppDatabase
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FactionsRosterTheme {
                RosterApp()
            }
        }
    }
}