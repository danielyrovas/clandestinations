package org.yrovas.clandestinations

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import org.yrovas.clandestinations.data.Identity
import org.yrovas.clandestinations.data.randomIdentity
import org.yrovas.clandestinations.ui.theme.ClandestinationsTheme

class MainActivity : ComponentActivity() {
    lateinit var navHost: NavHostController
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
                        StaticData.disguises[disguiseID],
                        pref.getString("address", "Address").toString()
                    )
                }
                Log.d("MainActivity", "onCreate: ${identity.name}")
                Log.d("MainActivity", "onCreate: ${identity.address}")
                Log.d("MainActivity", "onCreate: ${identity.agentID}")
                Log.d("MainActivity", "onCreate: ${identity.disguise.role}")

                SetupNavGraph(navHost,
                    disguiseID == -1,
                    identity,
                )
            }
        }
    }

}