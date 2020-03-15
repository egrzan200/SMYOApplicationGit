package smyo.app

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

val DATABASE_NAME = "SMYODB"

val ITEM_TABLE_NAME = "ItemTable"
val COL_ITEM_ID = "id"
val COL_ITEM_NAME = "ItemName"
val COL_ITEM_PATH = "ItemPath"
val COL_ITEM_TAGS = "ItemTags"
val COL_ITEM_PRICE = "ItemPrice"

class DataBaseHandler(var context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, 1){
    override fun onCreate(db: SQLiteDatabase?) {

        val createTable = "CREATE TABLE " + ITEM_TABLE_NAME + " (" +
                COL_ITEM_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COL_ITEM_NAME + " VARCHAR(256)," +
                COL_ITEM_PATH + "VARCHAR(256)," +
                COL_ITEM_TAGS + "VARCHAR(256)," +
                COL_ITEM_PRICE + "INTEGER)";

        db?.execSQL(createTable)

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun insertItemData(item : ItemObject){
        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put(COL_ITEM_NAME, item.itemName)
        cv.put(COL_ITEM_PATH, item.itemPath)
        cv.put(COL_ITEM_TAGS, item.itemTags)
        cv.put(COL_ITEM_PRICE, item.itemPrice)

        var result = db.insert(ITEM_TABLE_NAME, null, cv)
        if(result == -1.toLong()){
            Toast.makeText(context, "Failed",Toast.LENGTH_SHORT).show()
        }
        else{
            Toast.makeText(context, "Success",Toast.LENGTH_SHORT).show()
        }
    }
}