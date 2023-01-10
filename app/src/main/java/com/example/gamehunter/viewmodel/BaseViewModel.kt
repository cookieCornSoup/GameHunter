package com.example.gamehunter.viewmodel

import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable

open class BaseViewModel : ViewModel(){

    private val compositeDisposable = CompositeDisposable()


    // Obsevable을 Observing 할때 사용
    fun addDisposable(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }

    // Observing을 그만둘때 메모리 누수 방지 위해 compositeDisposable 비우는 함수
    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }
}