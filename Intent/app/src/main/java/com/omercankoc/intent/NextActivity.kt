package com.omercankoc.intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class NextActivity : AppCompatActivity() {

    // Definition
    var textViewNameSurname : TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_next)

        // Initialize
        textViewNameSurname = findViewById<View>(R.id.textViewNameSurname) as TextView

        /*
         * Key-Value tipinde tutulan ve baska Activity'den gelen verilerin alinması.
         */
        val intent = intent
        var name : String = intent.getStringExtra("name")
        var surname : String = intent.getStringExtra("surname")
        // Gelen verileri TextView'a gonder.
        textViewNameSurname!!.text = "Hello $name $surname"
    }
}
