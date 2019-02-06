package com.arieharyana.dev.blackpink

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.content.ContextCompat
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_login.*
import android.content.Intent

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val defaultEmail: String = "riantriyana@gmail.com"
        val defaultPassword: String = "12345"

        btn_login.setOnClickListener{
            val isEmailValid: Boolean = defaultEmail == ed_email.text.toString()
            val isPasswordValid: Boolean = defaultPassword == ed_passsword.text.toString()
            val isAuthValid = isEmailValid && isPasswordValid

            val message: String = if(isAuthValid) {
                "Success"
            } else {
                "Failed"
            }
            val snackbar = Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_SHORT)
            val sbView = snackbar.view

            val respColor = if(isAuthValid){
                R.color.green200
            }else{
                R.color.red800
            }

            sbView.setBackgroundColor(ContextCompat.getColor(this, respColor))
            val textView = sbView.findViewById<View>(android.support.design.R.id.snackbar_text) as TextView
            textView.setTextColor(ContextCompat.getColor(this, R.color.white))
            snackbar.show()

            if(isAuthValid) {
                val myIntent = Intent(baseContext, ListActivity::class.java)
                startActivity(myIntent)
            }

        }
    }
}
