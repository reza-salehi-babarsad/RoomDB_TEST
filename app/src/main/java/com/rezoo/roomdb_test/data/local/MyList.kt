package com.rezoo.roomdb_test.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "Shopping_List")
data class MyList(
    var name:String,
    var amount:Int,
    var price:Float,
    var imagUrl:String,
    @PrimaryKey(autoGenerate = true)
    val id:Int? = null
)
