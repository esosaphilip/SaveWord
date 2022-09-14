package com.example.saveword

import android.app.Application
import com.example.saveword.repo.WordRepository
import com.example.saveword.roomDb.WordDataBase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob


class WordsApplication : Application() {
    private val applicationScope = CoroutineScope(SupervisorJob())
    // Using by lazy so the database and the repository are only created when they're needed
    // rather than when the application starts
    private val database by lazy { WordDataBase.getDatabase(this, applicationScope) }
    val repository by lazy { WordRepository(database.wordDao()) }
}