package com.erhodes.factionsroster.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.erhodes.factionsroster.CrewViewModel
import com.erhodes.factionsroster.R

enum class Screens(@StringRes val title: Int) {
    CrewDetails(title = R.string.crew_list),
    AddModel(title = R.string.add_model),
    SelectLoadout(title = R.string.select_loadout)
}

/**
 * Composable that displays the topBar and displays back button if back navigation is possible.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RosterAppBar(
    currentScreen: Screens,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = { Text(stringResource(currentScreen.title)) },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back_button)
                    )
                }
            }
        }
    )
}

@Composable
fun RosterApp(crewViewModel: CrewViewModel = viewModel(), navController: NavHostController = rememberNavController()) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = Screens.valueOf(
        backStackEntry?.destination?.route ?: Screens.CrewDetails.name
    )

    Scaffold(
        topBar = {
            RosterAppBar(
                currentScreen = currentScreen,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() }
            )
        },
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screens.CrewDetails.name,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            composable(route = Screens.CrewDetails.name) {
                val activeCrew = crewViewModel.activeCrewFlow.collectAsState()
                CrewDetailsScreen(activeCrew.value!!, {navController.navigate(Screens.AddModel.name)})
            }
            composable(route = Screens.AddModel.name) {
                val activeCrew = crewViewModel.activeCrewFlow.collectAsState()
                AddModelScreen(
                    activeCrew = activeCrew.value!!,
                    {
                        crewViewModel.selectedModelClass = it
                        navController.navigate(Screens.SelectLoadout.name)
                    }
                )
            }
            composable(route = Screens.SelectLoadout.name) {
                SelectLoadoutScreen(
                    modelClass = crewViewModel.selectedModelClass!!,
                    onLoadoutSelected = {
                        crewViewModel.addModel(it)
                        navController.navigate(Screens.CrewDetails.name)
                    })
            }
        }
    }
}