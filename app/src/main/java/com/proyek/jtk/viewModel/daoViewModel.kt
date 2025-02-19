package com.proyek.jtk.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.proyek.jtk.data.AppDatabase
import com.proyek.jtk.model.Reward
import kotlinx.coroutines.withContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import com.proyek.jtk.R


class daoViewModel(application: Application) : AndroidViewModel(application) {
    private val dao = AppDatabase.getDatabase(application).dataDao()
    val rewardList: LiveData<List<Reward>> = dao.getAllReward()

    fun insertReward(
        image: String,
        title: String,
        requiredPoint: String
    ){
        viewModelScope.launch {
            val imageVal = image.toIntOrNull() ?: R.drawable.windowsnostalgia
            val requiredPointVal = requiredPoint.toIntOrNull() ?: 0
            dao.insert(
                Reward(
                    image = imageVal,
                    title = title,
                    requiredPoint = requiredPointVal
                )
            )
        }
    }

    fun updateReward(data: Reward) {
        viewModelScope.launch{
            dao.update(data)
        }
    }

    suspend fun deleteRewardById(id: Long): Reward?{
        return withContext(Dispatchers.IO){
            dao.deleteRewardById(id)
        }
    }

    suspend fun getRewardById(id: Long): Reward?{
        return withContext(Dispatchers.IO){
            dao.getRewardById(id)
        }
    }



}