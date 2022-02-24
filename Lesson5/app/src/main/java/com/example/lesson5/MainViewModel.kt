package com.example.lesson5

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*

class MainViewModel: ViewModel() {
    private val repository:Repository
    private val _liveData:MutableLiveData<Posts> = MutableLiveData<Posts>()
    val liveData:LiveData<Posts>
    get()=_liveData
    init{
        repository=Repository()
    }
    fun getData(){
        val coroutinesScope = CoroutineScope(Dispatchers.Default+ SupervisorJob()+ CoroutineExceptionHandler{context,throwable->println(throwable.message)})
        coroutinesScope.launch {
            val posts = repository.getData()
            _liveData.postValue(posts)
        }
    }
}