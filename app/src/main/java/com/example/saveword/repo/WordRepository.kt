package com.example.saveword.repo

import androidx.annotation.WorkerThread
import com.example.saveword.roomDb.Word
import com.example.saveword.roomDb.WordDao
import com.example.saveword.roomDb.WordDataBase
import kotlinx.coroutines.flow.Flow

class WordRepository(private val wordDao: WordDao) {

    val allWords: Flow<List<Word>> = wordDao.getAlphabetizedWords()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(words: Word) {
        wordDao.insertWord(words)
    }


}