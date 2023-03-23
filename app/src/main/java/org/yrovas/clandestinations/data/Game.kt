package org.yrovas.clandestinations.data

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import org.yrovas.clandestinations.MainActivity

data class Game(
    var identity: Identity,
    var newGame: Boolean = false,
    var intel: Int = 0,
    var actions: MutableList<Action> = mutableListOf(),
    var tasks: MutableList<Task> = mutableListOf(),
    val pref: SharedPreferences? = null,
) {

    fun save() {
        newGame = false
        pref!!.edit {
            putInt("disguiseID", identity.disguiseID)
            putString("name", identity.name)
            putInt("agentID", identity.agentID)
            apply()
        }
    }

    fun new() {
        pref!!.edit {
            putInt("disguiseID", -1)
            apply()
        }
        val nG = loadOrRandom(this.pref!!)
        identity = nG.identity
        newGame = true
        intel = 0
        actions = StaticData.previewGame.actions
        tasks = StaticData.previewGame.tasks
    }

    companion object {
        fun loadOrRandom(pref: SharedPreferences): Game {
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
            return Game(
                identity = identity,
                newGame = disguiseID == -1,
                intel = 0,
                actions = StaticData.previewGame.actions,
                tasks = StaticData.previewGame.tasks,
                pref = pref
            )
        }
    }
}