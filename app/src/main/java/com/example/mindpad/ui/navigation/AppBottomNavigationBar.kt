package com.example.mindpad.ui.navigation

import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource

@Composable
fun AppBottomNavigationBar(
    modifier: Modifier = Modifier,
    bottomBarItemsList: List<BottomNavigationItem>,
    currentRoute: String?,
    onItemClick: (BottomNavigationItem) -> Unit,
    ) {
    NavigationBar {
        bottomBarItemsList.forEach {
            bottomBarItem ->
            NavigationBarItem(
                selected = currentRoute == bottomBarItem.route,
                onClick = {},
                icon = {
                    painterResource(bottomBarItem.icon)
                },
                label = {
                    Text(stringResource(bottomBarItem.label))
                }
            )

        }

    }


}