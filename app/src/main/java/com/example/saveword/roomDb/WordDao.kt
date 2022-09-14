package com.example.saveword.roomDb

import androidx.room.*
import kotlinx.coroutines.flow.Flow


@Dao
interface WordDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertWord(vararg words: Word)

    @Query("SELECT * FROM word_table ORDER BY word ASC")
    fun getAlphabetizedWords(): Flow<List<Word>>

    @Query("DELETE FROM word_table")
    suspend fun deleteAll()

}