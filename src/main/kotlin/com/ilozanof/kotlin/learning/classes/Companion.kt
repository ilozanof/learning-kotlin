package com.ilozanof.kotlin.learning.classes

/**
 * Example of use of Companion Objects, which allows us to implements functionality similar to
 * static methods in Java
 */

class WebUser {
    val nickname: String

    private constructor(_nickname: String) {
        nickname = _nickname
    }

    companion object {
        fun newSubscribingUser(email: String): WebUser  = WebUser(email.substringBefore('@'))
        fun newFacebookUser(accountId: Int)  : WebUser  = WebUser("Facebookuser-$accountId")
    }
}


/**
 * Main function
 */
fun main(vararg args: String) {
    var user: WebUser = WebUser.newSubscribingUser("dummyUser@yahoo.es")
    println("User created: ${user.nickname}")
}