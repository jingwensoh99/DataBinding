package com.example.databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.databinding.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //Late initialize
    private lateinit var binding: ActivityMainBinding
    private var myName: MyName = MyName("Soh")
    private var contact: Contact = Contact("01123456789")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.btnSetName.setOnClickListener(){
            //it object(button) associated to an event
            addNickName(it)
        }

       binding.myName = myName
    }

   private fun addNickName(it: View?) {
       //apply = execute multiple setters
        binding.apply {
            myName?.name = editTextName.text.toString()
            invalidateAll()

        }
    }
}
