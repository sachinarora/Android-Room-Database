package com.sacvintechno.myapplication.ui.savereceipt

import androidx.annotation.IntegerRes
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "EmployeeRecord")
data class EmployeeRecord(

    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "email") val email: String,
    @ColumnInfo(name = "age") val age: Int
)