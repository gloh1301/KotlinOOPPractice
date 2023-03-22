package com.example.android.kotlinooppractice

abstract class BannerPrinter {

    private fun stars(number: Int): String {
        return "*".repeat(number)
    }

    fun print(message: String) {
        val outputMessage = emphasizeMessage(message)
        println(stars(outputMessage.length))
        println(outputMessage)
        println(stars(outputMessage.length))
    }

    abstract fun emphasizeMessage(message: String): String
}

class UppercaseBannerPrinter: BannerPrinter() {
    override fun emphasizeMessage(message: String): String {
        return message.uppercase()
    }
}

class ExclamationBannerPrinter: BannerPrinter() {
    override fun emphasizeMessage(message: String): String {
        return message + "!!!!!!!!!!"
    }
}

fun main() {

    val bannerPrinter = UppercaseBannerPrinter()
    bannerPrinter.print("hello world")

    val exclamationBannerPrinter = ExclamationBannerPrinter()
    exclamationBannerPrinter.print("Hello World")

    displayWelcomeMessage(exclamationBannerPrinter, "hello")
    displayWelcomeMessage(bannerPrinter, "hello")
}

fun displayWelcomeMessage(bannerPrinter: BannerPrinter, message: String) {
    bannerPrinter.print(message)
}