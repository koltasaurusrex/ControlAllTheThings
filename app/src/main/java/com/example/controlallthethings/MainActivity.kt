package com.example.controlallthethings


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val context = this
        val db = DataBaseHandler(context)
        val user1 = db.readData(1)
        val user2 = db.readData(2)
        db.insertData(user1)
        db.insertData(user2)
        tempRoom.text = "" + user1.getTemp()
        speedRoom.text = "" + user1.getSpeed()
        tempNora.text = "" + user2.getTemp()
        speedNora.text = "" + user2.getSpeed()
        switch1.isChecked = user1.getState() == 1
        switch2.isChecked = user2.getState() == 1

//  ----------------BEDROOM-----------------------------

        switch1.setOnCheckedChangeListener { buttonView, isSwitched ->
            if (isSwitched) {
                user1.setState(1)
                db.updateUser(user1.getId(), user1.getState(), user1.getTemp(), user1.getSpeed())
            } else {
                user1.setState(0)
                db.updateUser(user1.getId(), user1.getState(), user1.getTemp(), user1.getSpeed())
            }
        }
        button2.setOnClickListener {
            if (editTextNumber6.text.isNotEmpty()) {
                user1.setTemp(Integer.parseInt(editTextNumber6.text.toString()))
                db.updateUser(user1.getId(), user1.getState(), user1.getTemp(), user1.getSpeed())
                tempRoom.text = "" + user1.getTemp()
            } else {
                Toast.makeText(context, "Please Enter Value", Toast.LENGTH_SHORT).show()
            }
        }
        button3.setOnClickListener {
            if (editTextNumber7.text.isNotEmpty()) {
                user1.setSpeed(Integer.parseInt(editTextNumber7.text.toString()))
                db.updateUser(user1.getId(), user1.getState(), user1.getTemp(), user1.getSpeed())
                speedRoom.text = "" + user1.getSpeed()
            } else {
                Toast.makeText(context, "Please Enter Value", Toast.LENGTH_SHORT).show()
            }
        }

//---------------Nora's ROOM ------------------------------

        switch2.setOnCheckedChangeListener { buttonView, isSwitched ->
            if (isSwitched) {
                user2.setState(1)
                db.updateUser(user2.getId(), user2.getState(), user2.getTemp(), user2.getSpeed())
            } else {
                user2.setState(0)
                db.updateUser(user2.getId(), user2.getState(), user2.getTemp(), user2.getSpeed())
            }
        }
        button4.setOnClickListener {
            if (editTextNumber5.text.isNotEmpty()) {
                user2.setSpeed(Integer.parseInt(editTextNumber5.text.toString()))
                db.updateUser(user2.getId(), user2.getState(), user2.getTemp(), user2.getSpeed())
                speedNora.text = "" + user2.getSpeed()
            } else {
                Toast.makeText(context, "Please Enter Value", Toast.LENGTH_SHORT).show()
            }
        }
        button5.setOnClickListener {
            if (editTextNumber2.text.isNotEmpty()) {
                user2.setTemp(Integer.parseInt(editTextNumber2.text.toString()))
                db.updateUser(user2.getId(), user2.getState(), user2.getTemp(), user2.getSpeed())
                tempNora.text = "" + user2.getTemp()
            } else {
                Toast.makeText(context, "Please Enter Value", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun setFields() {

    }
}