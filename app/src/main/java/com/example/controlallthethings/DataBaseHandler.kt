package com.example.controlallthethings

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

const val DATABASE_NAME = "ThingsDB"
const val TABLE_NAME = "Things"
const val COL_STATE = "state"
const val COL_TEMP = "temp"
const val COL_SPEED = "speed"
const val COL_ID = "id"

class DataBaseHandler(var context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null,
    1) {
    override fun onCreate(db: SQLiteDatabase?) {
        val createTable = "CREATE TABLE " + TABLE_NAME + " (" +
                COL_ID + " INTEGER PRIMARY KEY," +
                COL_STATE + " INT," +
                COL_TEMP + " INT," +
                COL_SPEED + " INT)"

        db?.execSQL(createTable)
    }
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        if (db != null) {
            db.execSQL("drop table if exists " + TABLE_NAME)
        }
        else {
            onCreate(db)
        }
    }
    fun insertData(user: User) {
        val database = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COL_ID, user.getId())
        contentValues.put(COL_STATE, user.getState())
        contentValues.put(COL_TEMP, user.getTemp())
        contentValues.put(COL_SPEED, user.getSpeed())
        val result = database.insert(TABLE_NAME, null, contentValues)
        if (result == (0).toLong()) {
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show()
        }
        else {
            Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()
        }
    }

    fun updateUser(id: Int, state: Int, temp: Int, speed: Int ) {
        var db = this.writableDatabase
        db.execSQL("UPDATE $TABLE_NAME SET $COL_STATE = $state, $COL_TEMP = $temp, $COL_SPEED = $speed WHERE $COL_ID = $id")

    }
    fun readData(id: Int): User {
        val db = this.readableDatabase
        val user = User(id)
        val query = "Select * from $TABLE_NAME WHERE $COL_ID = $id"
        val result = db.rawQuery(query, null)
        if (result.moveToFirst()) {
            do {
                user.setId(result.getInt(result.getColumnIndex(COL_ID)))
                user.setState(result.getInt(result.getColumnIndex(COL_STATE)))
                user.setTemp(result.getInt(result.getColumnIndex(COL_TEMP)))
                user.setSpeed(result.getInt(result.getColumnIndex(COL_SPEED)))
            }
            while (result.moveToNext())
        }
        return user
    }


}