package com.example.android4a.presentation.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import com.example.android4a.R
import com.example.android4a.presentation.list.ListActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {


    val mainViewModel : MainViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainViewModel.loginLiveData.observe(this, Observer {
            when (it) {
                is LoginSuccess -> {
                    Toast.makeText(this, "Account found", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, ListActivity::class.java)
                    startActivity(intent)
                }
                LoginError -> {
                    MaterialAlertDialogBuilder(this).setTitle("Account Error").setMessage("Unknown account!").setPositiveButton("Ok"){ dialog,
                    which-> dialog.dismiss()}.show()
                }
            }
        })
        login_button.setOnClickListener{
            mainViewModel.onClickedLogin(login_edit.text.toString().trim(), password_edit.text.toString())
        }

        mainViewModel.createLiveData.observe(this, Observer {
            when (it) {
                is CreateSuccess -> {
                    Toast.makeText(this, "Account successfully created", Toast.LENGTH_SHORT).show()
                }

                CreateError -> {
                    MaterialAlertDialogBuilder(this).setTitle("Email Error").setMessage("Email already used! Please try another one").setPositiveButton("Ok"){ dialog,
                    which-> dialog.dismiss()}.show()
                }
            }
        })
        create_account_button.setOnClickListener{
            mainViewModel.onClickedCreate(login_edit.text.toString().trim(), password_edit.text.toString())
        }

    }
}