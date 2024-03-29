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

package com.tokopedia.mylibrary

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

/** A simple Activity displaying some text, written in Kotlin. */
class MyLibrarySampleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_library)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().replace(R.id.container,
                KotlinSampleWebViewFragment(),
                "a").commit()
        }
        Toast.makeText(this, getString(R.string.entering_library), Toast.LENGTH_LONG).show()
    }

}
