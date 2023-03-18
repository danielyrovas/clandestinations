package org.yrovas.clandestinations

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import org.yrovas.clandestinations.ui.theme.ClandestinationsTheme

@Composable
fun MainGameScreen(navHostController: NavHostController) {
    Surface {
        Column(verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()) {
            Spacer(Modifier.height(500.dp))
            Text("Main Game Screen")
        }
    }
}

@Preview
@Composable
fun MainGameScreenPreview(navHostController: NavHostController = rememberNavController()) {
    ClandestinationsTheme {
        MainGameScreen(navHostController)
    }
}