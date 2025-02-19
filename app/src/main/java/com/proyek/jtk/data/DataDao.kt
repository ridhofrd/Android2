package com.proyek.jtk.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.proyek.jtk.model.Reward


@Dao
interface DataDao {

    @Insert
    suspend fun insert(data: Reward)

    @Update
    suspend fun update(data: Reward)

    @Query("SELECT * FROM reward")
    fun getAllReward(): LiveData<List<Reward>>

    @Query("SELECT * FROM reward WHERE id = :rewardId")
    suspend fun getRewardById(rewardId: Long): Reward?

    @Delete
    suspend fun delete(data: Reward)

    @Query("DELETE FROM reward WHERE id = :rewardId")
    suspend fun deleteRewardById(rewardId: Long): Reward?

}