package com.example.gamehunter.view

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.example.gamehunter.viewmodel.BaseViewModel

abstract class BaseActivity<T : ViewDataBinding, R : BaseViewModel>() : AppCompatActivity() {

    private lateinit var viewDataBinding: T // 데이터 바인딩
    abstract val TAG :String // 액티비티 태그
    abstract val layoutId: Int // 바인딩에 필요한 layout
    abstract val viewModel: R //뷰모델

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i(TAG,"onCreate")

        // 초기화된 layoutResId로 databinding 객체 생성
        viewDataBinding = DataBindingUtil.setContentView(this, layoutId)

        // live data를 사용하기 위해 해줘야함
        viewDataBinding.lifecycleOwner = this@BaseActivity

    }


    override fun onRestart() {
        super.onRestart()
        Log.i(TAG, "onRestart")
    }


    override fun onStart() {
        super.onStart()
        Log.i(TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i(TAG, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "onDestroy")
    }
}