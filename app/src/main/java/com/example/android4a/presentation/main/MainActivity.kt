package com.example.android4a.presentation.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.android4a.R
import com.example.android4a.presentation.list.ListActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {


    private val mainViewModel : MainViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Reading status
        this.mainViewModel.loginLiveData.observe(this, {
            when (it) {
                is LoginSuccess -> {
                    Toast.makeText(this, "Account found", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, ListActivity::class.java)
                    startActivity(intent) //Opening new activity
                }
                LoginError -> {
                    MaterialAlertDialogBuilder(this).setTitle("Account Error").setMessage("Unknown account!").setPositiveButton("Ok"){ dialog,
                                                                                                                                       _ -> dialog.dismiss()}.show()
                }
            }
        })
        //Getting the values of email and password entered
        login_button.setOnClickListener{
            mainViewModel.onClickedLogin(login_edit.text.toString().trim(), password_edit.text.toString())
        }

        mainViewModel.createLiveData.observe(this, {
            when (it) {
                is CreateSuccess -> {
                    Toast.makeText(this, "Account successfully created", Toast.LENGTH_SHORT).show()
                }

                CreateError -> {
                    MaterialAlertDialogBuilder(this).setTitle("Email Error").setMessage("Email already used! Please try another one").setPositiveButton("Ok"){ dialog,
                                                                                                                                                               _ -> dialog.dismiss()}.show()
                }
            }
        })
        create_account_button.setOnClickListener{
            mainViewModel.onClickedCreate(login_edit.text.toString().trim(), password_edit.text.toString())
        }

    }
}