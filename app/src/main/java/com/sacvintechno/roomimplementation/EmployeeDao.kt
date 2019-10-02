package com.sacvintechno.myapplication.ui.savereceipt

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface EmployeeDao {

    @Insert
    fun insert(employeeRecord: EmployeeRecord)

    @Delete
    fun delete(employeeRecord: EmployeeRecord)

    @Query("SELECT * from EmployeeRecord")
    fun getAllRows(): List<EmployeeRecord>
}