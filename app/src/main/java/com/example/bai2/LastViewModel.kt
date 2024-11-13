package com.example.bai2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LastViewModel : ViewModel() {
    private val _selectedFoods = MutableLiveData<MutableList<String>>().apply { value = mutableListOf() }
    val selectedFoods: LiveData<MutableList<String>> get() = _selectedFoods

    init {
        _selectedFoods.value = mutableListOf()
    }


    fun addFood(food: String) {
        _selectedFoods.value?.add(food)
    }


    fun removeFood(food: String) {
        _selectedFoods.value?.remove(food)
    }
    fun getSecondFood(): String? {
        return _selectedFoods.value?.getOrNull(0) // Trả về null nếu không có đối tượng thứ hai
    }
}