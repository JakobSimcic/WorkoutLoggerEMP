package com.example.workoutlogger

import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.workoutlogger.strani.Profile
import com.example.workoutlogger.strani.Stat
import com.example.workoutlogger.strani.Weight
import com.example.workoutlogger.strani.WorkoutL
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

@Composable
fun Logger(modifier: Modifier = Modifier, navController: NavController) {

    val navItemList = listOf(
        NavItem(R.drawable.clock),
        NavItem(R.drawable.dumbbell),
        NavItem(R.drawable.barchart),
        NavItem(R.drawable.user),
    )

    var selectedIndex by remember{
        mutableStateOf(0)
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            NavigationBar (
                containerColor = Color(0xFF28282B)
            ){
                navItemList.forEachIndexed{index, navItem ->
                    NavigationBarItem(
                        selected = selectedIndex == index,
                        onClick = {
                            selectedIndex = index
                        },
                        icon = {
                            Icon(
                                painter = painterResource(id = navItem.icon),
                                contentDescription = "icon",
                                modifier = Modifier.size(35.dp),
                                tint = if(selectedIndex == index) Color.White else Color(0xFF6A6A6E)
                            )
                        },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = Color.White,
                            unselectedIconColor = Color(0xFF6A6A6E),
                            indicatorColor = Color.Transparent
                        ),
                        interactionSource = remember { NoRippleInteractionSource() }
                    )
                }
            }
        }
        ) { innerPadding ->
        ContentScreen(modifier = Modifier.padding(innerPadding),selectedIndex = selectedIndex,navController = navController)
    }
    
}

@Composable
fun ContentScreen(modifier: Modifier = Modifier,selectedIndex : Int,navController: NavController) {
    when(selectedIndex){
        0-> WorkoutL(navController = navController)
        1-> Weight()
        2-> Stat()
        3-> Profile()
    }
}

class NoRippleInteractionSource : MutableInteractionSource {
    override val interactions: Flow<Interaction> = emptyFlow()
    override suspend fun emit(interaction: Interaction) {}
    override fun tryEmit(interaction: Interaction) = true
}