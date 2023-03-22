package com.example.android.kotlinooppractice

import java.util.*

fun main() {

    val saver = Saver()
    val welcomer = Welcomer()

    val usernameGetter = UsernameGetter(saver)
    usernameGetter.getUsername()

    println("Whcih user would you like to welcome to the program")
    val friendUsernameGetter = UsernameGetter(welcomer)
    friendUsernameGetter.getUsername()
}

interface UsernameProcessor {
    fun onUsernameEntered(username: String)
}

class UsernameGetter(val usernameProcessor: UsernameProcessor) {
    fun getUsername(): String {
        println("What is your name?")
        val username = Scanner(System.`in`).nextLine()
        // TODO
        usernameProcessor.onUsernameEntered(username)
        return username
    }
}

class Saver: UsernameProcessor {
    override fun onUsernameEntered(username: String) {
        println("TODO pretend this saves to a database")
    }
}

class Welcomer: UsernameProcessor {
    override fun onUsernameEntered(username: String) {
        println("Welcome $username, thanks for signing up!")
    }
}