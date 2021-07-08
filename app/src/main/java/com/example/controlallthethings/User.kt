package com.example.controlallthethings

import android.text.Editable

class User {
    private var id : Int = 0
    private var state : Int = 0
    private var temp : Int = 0
    private var speed : Int = 0
    constructor(id: Int) {
        this.id = id
    }

    fun getId(): Int {
        return this.id
    }
    fun setId(id: Int) {
        this.id = id
    }

    fun getState(): Int {
        return this.state
    }
    fun setState(state: Int) {
        this.state = state
    }

    fun getTemp(): Int {
        return this.temp
    }
    fun setTemp(temp: Int) {
        this.temp = temp
    }

    fun getSpeed(): Int {
        return this.speed
    }
    fun setSpeed(speed: Int) {
        this.speed = speed
    }
}