package com.example.myapp.mynearbuygetter.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.example.myapp.mynearbuygetter.entity.RegisterEntity

@Dao
interface RegisterDAO {
    @Query("SELECT *FROM registration")
    fun getALl(): List<RegisterEntity>


    @Insert
    fun insertAll(vararg registerEntity: RegisterEntity)

}