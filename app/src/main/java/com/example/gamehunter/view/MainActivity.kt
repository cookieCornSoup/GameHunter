package com.example.gamehunter.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.gamehunter.R
import com.example.gamehunter.databinding.ActivityMainBinding
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    private var mBinding: ActivityMainBinding? = null

    private val binding get() = mBinding!!

    override fun onCreate(savedInstantState: Bundle?) {


        super.onCreate(savedInstantState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

        binding.recycleView.setHasFixedSize(true)
        binding.recycleView.layoutManager


        val database = FirebaseDatabase.getInstance()

        val databaseReference = database.getReference("User")



    }

    override fun onDestroy() {
        mBinding = null
        super.onDestroy()
    }
}