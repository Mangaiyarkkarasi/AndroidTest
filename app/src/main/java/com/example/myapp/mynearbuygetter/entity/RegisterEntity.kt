package com.example.myapp.mynearbuygetter.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey


@Entity(tableName = "registration")
data class RegisterEntity (
                            @PrimaryKey
                           @ColumnInfo(name="username")
                            var userName: String)

{
    /*@PrimaryKey(autoGenerate = true)
    var id: Int=0
*/
}