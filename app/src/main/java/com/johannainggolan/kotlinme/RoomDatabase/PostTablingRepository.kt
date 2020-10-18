package com.johannainggolan.kotlinme.RoomDatabase

import com.johannainggolan.kotlinme.App
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

class PostTablingRepository(application: App) : CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main

    private var messageDao: PostTablingDao?

    init {
        val db = PostTablingDatabase.getDatabase(application)
        messageDao = db?.savedObjectDao()
    }

    fun getMessages() = messageDao?.getMessages()

    fun setMessage(message: PostTabling) {
        launch  { setMessageBG(message) }
    }

    private suspend fun setMessageBG(message: PostTabling){
        withContext(Dispatchers.IO){
            messageDao?.setMessage(message)
        }
    }

}