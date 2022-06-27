package com.devpass.spaceapp.example.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devpass.spaceapp.example.domain.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.launch

class ExampleViewModel(private val getListUseCase: ExampleGetListUseCase = ExampleGetListUseCaseImpl(),
                       private val getNameUseCase : ExampleGetNameUseCase = ExampleGetNameUseCaseImpl(),
                       private val getEmailUseCase: ExampleGetEmailUseCase = ExampleGetEmailUseCaseImpl()
) : ViewModel() {

    /*Approach 1 - Referenciando como LiveData e inicializando como MutableLiveData*/
    val listLiveData : LiveData<List<String>> by lazy {
        MutableLiveData()
    }

    /*Approach 2 - Variável publica como LiveData e variável privada como MutableLiveData*/
    private val _userNameLiveData = MutableLiveData<String>()
    val userNameLiveData : LiveData<String> = _userNameLiveData

    /*Approach 3 - Referenciando e Inicializando como MutableLiveData*/
    val userEmailLiveData = MutableLiveData<String>()

    /*Approach 2 com StateFlow- Referenciando e Inicializando como MutableLiveData*/
    private val _userNameStateFlow = MutableStateFlow("")
    val userNameStateFlow : StateFlow<String> = _userNameStateFlow

    init {
        runGetList()
        runGetName()
        runGetEmail()
    }

    fun runGetList() {
        viewModelScope.launch {
            getListUseCase.getList().collect {
                (listLiveData as MutableLiveData).value = it
            }
        }
    }

    private fun runGetName() {
        getNameUseCase.getName().let {
            _userNameLiveData.value = it
            _userNameStateFlow.value = it
        }
    }

    private fun runGetEmail() {
        userEmailLiveData.value = getEmailUseCase.getEmail()
    }

    override fun onCleared() {
        super.onCleared()
    }
}