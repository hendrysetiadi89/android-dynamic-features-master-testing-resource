package com.google.android.samples.dynamicfeatures.ondemand

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.android.samples.dynamicfeatures.ondemand.kotlin.R

/**
 * Created by hendry on 2019-08-13.
 */
class KotlinSampleFragment : Fragment() {
    var str: String? = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            str = getString(R.string.test_fragment)
        } catch (e:Exception) {
            str = "Resource not found exception"
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_test, container, false)
        view.findViewById<TextView>(R.id.textView).text = str
        return view
    }
}
