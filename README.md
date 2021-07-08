# Overview


ControlAllTheThings was my intro into Android development and is an application
that I will later integrate into some simple smart devices so that I can ControlAllTheThings.

It is a simple interface that shows 2 AC units in separate rooms and their status.
I can change toggle the power and set fan speeds and set the temperature.
The state of the units is saved in a database so that I will be able to see the
status no matter if the app restarts.


[Software Demo Video](https://youtu.be/YZmDvs3yLmM)

# Development Environment

IDE Android Studio
Language Kotlin, XML

# Useful Websites

* [Kotlin Docs](https://kotlinlang.org/docs/kotlin-pdf.html)
* [Sqlite database help](https://www.geeksforgeeks.org/how-to-create-and-add-data-to-sqlite-database-in-android/)

# Future Work

* I want to mesh these with some ESP32 controllers and some relays to actually power all the things.
* Option to add more devices.
* Sync with SQL database on a server that will have the latest status from devices
