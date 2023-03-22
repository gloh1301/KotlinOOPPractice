package com.example.android.kotlinooppractice

import java.util.*
import kotlin.concurrent.schedule

class DeciduousTree(name: String, state: String): Tree(name, state) {

    override var leaves = 0

    fun growLeaves() {
        Timer().schedule(0, 500) {
            leaves += 10000
            if (leaves > leaves*10) {
                this.cancel()
            }
            println("$name tree has $leaves leaves")
        }
    }

    fun dropLeaves() {
        leaves = 0
    }

}
// constructor
// open modifier for creating subclasses
open class Tree(val name: String, var state: String) {

    init {
        if (name.isBlank() || state.isBlank()) {
            throw Exception("Name and state must be provided.")
        }
        println("Creating a tree $name for state $state")
    }

    open val leaves = 10000

    val stateUppercase: String
        get() {
            return state.uppercase()
        }
    var spotted: Boolean = false
        set(value) {
            field = value
            if (spotted) {
                dateSpotted = Date()
            } else {
                dateSpotted = null
            }
        }

    var dateSpotted: Date? = null
        set(value) {
            if (value != null) {
                if (value > Date())
                    throw Exception("You can't see a tree in the future.")
            }
            field = value
        }

    override fun toString(): String {
        return "$name - $state"
    }
}

fun main() {

    val tress = mutableListOf("fir")
    val oak = DeciduousTree("Oak", "Iowa")
    println(oak.name)
    val fir = Tree("Fir", "Oregon")
    println(fir.name)
    var palm = Tree("Palm", "Florida")
    println(palm.name)
    println("Oak spotted on ${oak.dateSpotted}")
    oak.spotted = true
    println("Oak spotted on ${oak.dateSpotted}")
    oak.growLeaves()
    println(oak.leaves)
    oak.dropLeaves()
    println(oak.leaves)

    val pine = Tree("Pine", "Wisconsin")
}