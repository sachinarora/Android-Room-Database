package com.sacvintechno.roomimplementation

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.sacvintechno.myapplication.ui.savereceipt.EmployeeDao
import com.sacvintechno.myapplication.ui.savereceipt.EmployeeRecord

@Database(entities = arrayOf(EmployeeRecord::class), version = 1)
abstract class EmployeeDatabase: RoomDatabase() {
    abstract fun employeeDao(): EmployeeDao
    companion object {
        private var INSTANCE: EmployeeDatabase? = null
        fun getDatabase(context: Context): EmployeeDatabase? {
            if (INSTANCE == null) {
                synchronized(EmployeeDatabase::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.getApplicationContext(),
                        EmployeeDatabase::class.java, "employeeDatabase.db"
                    ).allowMainThreadQueries().build()
                }
            }
            return INSTANCE
        }
    }
}