package com.arieharyana.dev.blackpink

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.content.ContextCompat
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val defaultEmail: String = "hai@arie.com"
        val defaultPassword: String = "1234"

        btn_register.setOnClickListener{

            val message: String = "Success"

            val snackbar = Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_SHORT)
            val sbView = snackbar.view
            sbView.setBackgroundColor(ContextCompat.getColor(this, R.color.green800))
            val textView = sbView.findViewById<View>(android.support.design.R.id.snackbar_text) as TextView
            textView.setTextColor(ContextCompat.getColor(this, R.color.white))
            snackbar.show()

        }

        btn_signin.setOnClickListener {
            val myIntent = Intent(baseContext, LoginActivity::class.java)
            startActivity(myIntent)
        }
    }
}
