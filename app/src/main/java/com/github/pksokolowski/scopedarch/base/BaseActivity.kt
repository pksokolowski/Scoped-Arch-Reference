package com.github.pksokolowski.scopedarch.base

import android.os.Bundle
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.bluelinelabs.conductor.Conductor
import com.bluelinelabs.conductor.Controller
import com.bluelinelabs.conductor.ControllerChangeHandler
import com.bluelinelabs.conductor.Router
import com.github.pksokolowski.scopedarch.R
import com.github.pksokolowski.scopedarch.di.ScreenInjector
import com.github.pksokolowski.scopedarch.di.clearComponent
import com.github.pksokolowski.scopedarch.di.inject
import com.github.pksokolowski.scopedarch.ui.ScreenNavigator
import java.lang.NullPointerException
import java.util.*
import javax.inject.Inject


abstract class BaseActivity : AppCompatActivity() {
    var instanceId: String? = null
        private set

    private lateinit var router: Router

    @Inject
    lateinit var screenInjector: ScreenInjector

    @Inject
    lateinit var screenNavigator: ScreenNavigator

    protected abstract val layoutRes: Int

    protected abstract val initialScreen: Controller

    override fun onCreate(savedInstanceState: Bundle?) {
        // assign an instance id, either new or the saved one, for dagger scoping.
        if (savedInstanceState != null) {
            instanceId = savedInstanceState.getString(INSTANCE_ID_KEY, null)
        }
        if (instanceId == null) {
            instanceId = UUID.randomUUID().toString()
        }

        inject(this)
        setContentView(layoutRes)
        val containerView: ViewGroup = findViewById(R.id.screen_container)
            ?: throw NullPointerException("root of each screen layout must have id = screen_container")
        router = Conductor.attachRouter(this, containerView, savedInstanceState)
        screenNavigator.initWithRouter(router, initialScreen)
        monitorBackStack()
        super.onCreate(savedInstanceState)
    }

    private fun monitorBackStack() {
        router.addChangeListener(object : ControllerChangeHandler.ControllerChangeListener {
            override fun onChangeCompleted(
                to: Controller?,
                from: Controller?,
                isPush: Boolean,
                container: ViewGroup,
                handler: ControllerChangeHandler
            ) {
                super.onChangeCompleted(to, from, isPush, container, handler)
                if (!isPush && from != null) {
                    clearComponent(from)
                }
            }
        })
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(INSTANCE_ID_KEY, instanceId)
    }

    override fun onBackPressed() {
        if (!screenNavigator.pop()) {
            super.onBackPressed()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        screenNavigator.clear()
        if (isFinishing) {
            clearComponent(this)
        }
    }
}

private const val INSTANCE_ID_KEY = "instance_id"