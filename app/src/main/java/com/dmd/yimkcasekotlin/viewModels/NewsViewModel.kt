package com.dmd.yimkcasekotlin.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dmd.yimkcasekotlin.api.Service
import com.dmd.yimkcasekotlin.models.News
import com.dmd.yimkcasekotlin.models.ServiceResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class NewsViewModel() : ViewModel(){
    private val dataApiService = Service()
    private val disposable = CompositeDisposable()

    val data = MutableLiveData<ArrayList<News>>()
    val dataError = MutableLiveData<Boolean>()
    val dataLoading = MutableLiveData<Boolean>()

    fun refreshData(){
        getDataFromApi()
    }

    private fun getDataFromApi(){
        dataLoading.value= true

        disposable.add(
            dataApiService.getData()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<ServiceResponse>(){
                    override fun onSuccess(t: ServiceResponse) {
                        data.value = t.news
                        dataError.value=false
                        dataLoading.value=false

                    }

                    override fun onError(e: Throwable) {
                        dataLoading.value=false
                        dataError.value=true
                        e.printStackTrace()

                    }

                })
        )
    }
}