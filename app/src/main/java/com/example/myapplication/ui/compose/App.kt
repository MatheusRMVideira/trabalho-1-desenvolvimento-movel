package com.example.myapplication.ui.compose

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.R
import kotlinx.coroutines.launch

import com.example.myapplication.ui.theme.PokemonWikiTheme

@Composable
fun App(
    navController: NavHostController = rememberNavController()
) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val mainViewModel: MainViewModel = viewModel(factory = AppViewModelProvider.Factory)
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    val network_error = stringResource(id = R.string.network_error)
    val ok = stringResource(id = R.string.ok)

    Scaffold(
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        },
        topBar = {
            AppBar(
                canNavigateBack = backStackEntry?.destination?.route != "Initial",
                navigateUp = { navController.navigateUp() }
            )
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "Initial",
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            composable("Initial") {
                Init(
                    mainViewModel,
                    onSearchPokemonClicked = {
                        navController.navigate("PokemonDetails")
                    }
                )
            }
            composable("PokemonDetails") {
                DetailView(mainViewModel)
            }
        }
    }

    if (mainViewModel.showNetworkErrorSnackbar) {
        LaunchedEffect(mainViewModel.showNetworkErrorSnackbar) {
            scope.launch {
                val result = snackbarHostState.showSnackbar(
                    network_error,
                    actionLabel = ok,
                    duration = SnackbarDuration.Indefinite
                )
                when (result) {
                    SnackbarResult.Dismissed -> mainViewModel.dismissNetworkErrorSnackBar()
                    SnackbarResult.ActionPerformed -> mainViewModel.dismissNetworkErrorSnackBar()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppPreview() {
    PokemonWikiTheme {
        App()
    }
}