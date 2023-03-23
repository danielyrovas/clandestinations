package org.yrovas.clandestinations

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import org.yrovas.clandestinations.data.Game
import org.yrovas.clandestinations.data.Identity
import org.yrovas.clandestinations.data.StaticData
import org.yrovas.clandestinations.data.randomIdentity
import org.yrovas.clandestinations.ui.theme.ClandestinationsTheme

class MainActivity : ComponentActivity() {
    private lateinit var navHost: NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ClandestinationsTheme {
                navHost = rememberNavController()

                val pref = getPreferences(Context.MODE_PRIVATE)

                SetupNavGraph(
                    navHost,
                    //StaticData.previewGame,
                    Game.loadOrRandom(pref)
                )

            }
        }
    }
}