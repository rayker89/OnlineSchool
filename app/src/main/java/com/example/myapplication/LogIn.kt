package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth

class LogIn : AppCompatActivity() {

    var user_email:EditText? = null
    var user_pass:EditText? = null
    var login_btn:Button? = null
    var firebaseAuth:FirebaseAuth? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)

        user_email = findViewById(R.id.user_login_email)
        user_pass = findViewById(R.id.user_login_password)
        login_btn = findViewById(R.id.login)
        firebaseAuth = FirebaseAuth.getInstance()

        login_btn?.setOnClickListener {
            LoginUser()
        }

    }

    private fun LoginUser() {

        var email = user_email?.text.toString().trim()
        var password = user_pass?.text.toString().trim()

        if(TextUtils.isEmpty(email) && TextUtils.isEmpty(password) ) {

            Toast.makeText(applicationContext, "This field, can not be empty!", Toast.LENGTH_SHORT).show()

        } else {

            firebaseAuth?.signInWithEmailAndPassword(email, password)?.addOnCompleteListener(object:OnCompleteListener<AuthResult>{
                override fun onComplete(auth: Task<AuthResult>) {
                    if(auth.isSuccessful) {
                        Toast.makeText(applicationContext, "You are logedin in successfully!", Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this@LogIn, Dashboard::class.java))

                    }else {
                        var error = auth.exception?.message
                        Toast.makeText(applicationContext, "Error " + error, Toast.LENGTH_SHORT).show()

                    }
                }

            })

        }

    }
}
