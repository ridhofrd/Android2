package com.proyek.jtk.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "reward")
data class Reward(
    @PrimaryKey(autoGenerate = true) val id: Long = 1111,
    val image: Int,
    val title: String,
    val requiredPoint: Int,
)