package com.example.gamehunter.view

import android.os.Bundle

import com.example.gamehunter.R
import com.example.gamehunter.databinding.ActivityMypageBinding

import com.example.gamehunter.viewmodel.MyPageViewModel

class MyPageActivity : BaseActivity<ActivityMypageBinding, MyPageViewModel>(){

    override val TAG : String = MyPageActivity::class.java.simpleName

    // 레이아웃 연결
    override val layoutId: Int = R.layout.activity_mypage

    // 의존성 주입
    override val viewModel: MyPageViewModel = MyPageViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



    }

    fun setupObserver(){
        viewModel.getData()
    }
}