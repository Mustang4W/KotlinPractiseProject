package com.mustang4w.wang.kotlinpractiseproject.entity

class ChatMessageEntity(val content: String, val type: Int) {
    companion object {
        const val TYPE_RECEIVED = 0
        const val TYPE_SEND = 1
    }
}
