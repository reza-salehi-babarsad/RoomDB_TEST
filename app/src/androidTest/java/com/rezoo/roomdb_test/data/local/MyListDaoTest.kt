package com.rezoo.roomdb_test.data.local

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@SmallTest
class MyListDaoTest {


    private lateinit var dataBase: MyListDataBase
    private lateinit var dao: MyListDao

    @Before
    fun setup(){

        dataBase =Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            MyListDataBase::class.java
        ).allowMainThreadQueries().build()
        dao= dataBase.myListDao()
    }

    @After
    fun teardown(){
        dataBase.close()
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun insertMyListItem() = runBlockingTest {

        
    }


}