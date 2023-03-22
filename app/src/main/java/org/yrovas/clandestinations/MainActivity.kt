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
                val disguiseID = pref.getInt("disguiseID", -1)
                var identity = randomIdentity()
                if (disguiseID != -1) {
                    identity = Identity(
                        pref.getString("name", "Name").toString(),
                        pref.getInt("agentID", 0),
                        disguiseID = disguiseID,
                        address = pref.getString("address", "Address").toString(),
                    )
                }
                SetupNavGraph(
                    navHost,
                    //Game(identity, disguiseID == -1)
                    StaticData.previewGame,
                )
            }
        }
    }

}