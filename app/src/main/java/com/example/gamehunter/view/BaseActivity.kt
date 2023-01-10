package com.example.gamehunter.view

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.example.gamehunter.viewmodel.BaseViewModel

abstract class BaseActivity<T : ViewDataBinding, R : BaseViewModel>() : AppCompatActivity() {

    protected lateinit var viewDataBinding: T

    abstract val layoutId: Int
    abstract val viewModel: R

    override fun onCreate(savedInstanceState: Bundle?) {
        beforeSetContextView()

        super.onCreate(savedInstanceState)

        // 초기화된 layoutResId로 databinding 객체 생성
        viewDataBinding = DataBindingUtil.setContentView(this, layoutId)

        // live data를 사용하기 위해 해줘야함
        viewDataBinding.lifecycleOwner = this@BaseActivity

        initView()
        initViewModel()
        initListener()
        afterOnCreate()
    }

    protected open fun beforeSetContextView() {}
    protected open fun initView() {}
    protected open fun initViewModel() {}
    protected open fun initListener() {}
    protected open fun afterOnCreate() {}
}