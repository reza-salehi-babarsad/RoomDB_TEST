package com.rezoo.roomdb_test.data.local

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.google.common.truth.Truth.assertThat
import com.rezoo.roomdb_test.getOrAwaitValue
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
@SmallTest
class MyListDaoTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

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


    @Test
    fun insertMyListItem() = runBlockingTest {
        val myList:MyList = MyList("name",1,1f,"Url",1)
        dao.insertMyList(myList)

        val allMyList = dao.observeAllMyList().getOrAwaitValue()

        assertThat(allMyList).contains(myList)
        
    }


}