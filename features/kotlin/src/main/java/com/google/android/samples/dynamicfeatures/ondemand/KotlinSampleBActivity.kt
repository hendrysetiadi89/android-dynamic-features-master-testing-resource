/*
 * Copyright 2018 Google LLC.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.android.samples.dynamicfeatures.ondemand

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.google.android.samples.dynamicfeatures.BaseSplitActivity
import com.google.android.samples.dynamicfeatures.ondemand.kotlin.R

/** A simple Activity displaying some text, written in Kotlin. */
class KotlinSampleBActivity : BaseSplitActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feature_kotlin)
        Toast.makeText(this, KotlinSampleBActivity::class.java.name, Toast.LENGTH_LONG).show()
        val button = findViewById<Button>(R.id.button)
        button.setText(getString(R.string.go_to_lib_module))
        button.setOnClickListener {
            val uri = Uri.parse("myscheme://myhost/mypath")
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = uri
            intent.setPackage(getPackageName())
            intent.addCategory(Intent.CATEGORY_DEFAULT)
            intent.addCategory(Intent.CATEGORY_BROWSABLE)
            startActivity(intent)
        }

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.frame_parent, KotlinSampleFragment())
                .commit()
        }

    }

    override fun onBackPressed() {
        super.onBackPressed()
        var str: String? = ""
        try {
            str = getString(R.string.test_fragment)
        } catch (e: Exception) {
            str = "Resource not found exception"
        }
        Toast.makeText(this, str, Toast.LENGTH_LONG).show()
    }

}
