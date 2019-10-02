package com.sacvintechno.roomimplementation

import android.os.Bundle
import android.text.TextUtils
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.sacvintechno.myapplication.ui.savereceipt.EmployeeRecord

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        var employeeDatabase= EmployeeDatabase.getDatabase(this)

        btn_save.setOnClickListener {
            if(TextUtils.isEmpty(edt_age.text)) {
                Toast.makeText(this, "Please enter age", Toast.LENGTH_LONG).show()
            }else{
            var employee = EmployeeRecord(name=edt_username.text.toString(),email=edt_email.text.toString(),age=Integer.parseInt(edt_age.text.toString()))
            employeeDatabase!!.employeeDao().insert(employee)
            Toast.makeText(this,"Data Saved",Toast.LENGTH_LONG).show()
            }
        }

        btn_refresh.setOnClickListener {
            var employee=employeeDatabase!!.employeeDao().getAllRows()

            var data = StringBuilder()
            for (i in 0..employee.size-1) {
                data.append("name="+employee.get(i).name+"\n")
                data.append("email="+employee.get(i).email+"\n")
                data.append("age="+employee.get(i).age+"\n\n\n")
            }
            tv_saved_data.text="Saved Data\n$data"
        }

    }


}
