package com.rezoo.roomdb_test.data.local

import androidx.lifecycle.LiveData
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

interface MyListDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMyList(myList: MyList)

    @Delete
    suspend fun deleteMyList(myList: MyList)

    @Query("SELECT * FROM shopping_list")
    fun observeAllMyList(): LiveData<List<MyList>>

    @Query("SELECT SUM(price * amount) FROM shopping_list ")
    fun observeTotalMyList(): LiveData<Float>
}