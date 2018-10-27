package com.github.marlonlom.motiondemo

import android.os.Bundle
import android.support.constraint.motion.MotionLayout
import android.support.v7.app.AppCompatActivity
import android.view.View

import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.ceil


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /* By attaching a TransitionListener object to the MotionLayout widget, you can closely monitor the progress of the animation. */
        motion_container.setTransitionListener(
            object : MotionLayout.TransitionListener {
                override fun onTransitionChange(
                    motionLayout: MotionLayout?,
                    startId: Int,
                    endId: Int,
                    progress: Float
                ) {
                    seekbar.progress = ceil(progress * 100).toInt()
                }

                override fun onTransitionCompleted(
                    motionLayout: MotionLayout,
                    currentId: Int
                ) {
                    if (currentId == R.id.ending_set) {
                        motion_container.transitionToStart()
                    }
                }
            }
        )
    }

    fun start(v: View) {
        /* To start the animation, all you need to do is call the transitionToEnd() method of the widget.*/
        motion_container.transitionToEnd()
    }
}
