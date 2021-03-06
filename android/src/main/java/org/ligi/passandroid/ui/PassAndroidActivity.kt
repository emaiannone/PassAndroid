package org.ligi.passandroid.ui

import androidx.appcompat.app.AppCompatActivity
import com.github.salomonbrys.kodein.instance
import org.greenrobot.eventbus.EventBus
import org.ligi.passandroid.App
import org.ligi.passandroid.Tracker
import org.ligi.passandroid.model.PassStore
import org.ligi.passandroid.model.Settings

open class PassAndroidActivity : AppCompatActivity() {

    val passStore: PassStore = App.kodein.instance()
    val settings: Settings = App.kodein.instance()
    val bus: EventBus = App.kodein.instance()
    val tracker: Tracker = App.kodein.instance()

    private var lastSetNightMode: Int? = null

    override fun onResume() {
        super.onResume()

        if (lastSetNightMode != null && lastSetNightMode != settings.getNightMode()) {
            recreate()
        }
        lastSetNightMode = settings.getNightMode()
    }

}