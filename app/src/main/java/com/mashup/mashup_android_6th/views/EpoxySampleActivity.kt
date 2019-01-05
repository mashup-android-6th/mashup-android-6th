package com.mashup.mashup_android_6th.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.airbnb.epoxy.EpoxyController
import com.airbnb.epoxy.EpoxyRecyclerView
import com.mashup.mashup_android_6th.R
import kotlinx.android.synthetic.main.activity_epoxy_sample.*

class EpoxySampleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_epoxy_sample)

        ervName.withModels {
            
        }
    }

}

fun EpoxyRecyclerView.withModels(buildModelsCallback: EpoxyController.() -> Unit) {
    setControllerAndBuildModels(object : EpoxyController() {
        override fun buildModels() {
            buildModelsCallback()
        }
    })
}
