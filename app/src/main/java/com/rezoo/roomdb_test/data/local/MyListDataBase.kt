package com.rezoo.roomdb_test.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
@Database(
    entities = [MyList::class],
    version = 1
)
abstract class MyListDataBase:RoomDatabase() {
    abstract fun myListDao() :MyListDao
}