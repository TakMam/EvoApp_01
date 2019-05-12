package com.example.evoapp_01

import android.content.Context;
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase;
import android.util.Log
import java.io.File
import java.io.FileOutputStream
import java.io.IOException



class userDB_Helper (private val mContext: Context) {

    companion object {
        val KEY_ID = "USER_CD"
        val KEY_DAY = "day"
        val KEY_DAYTIME = "dayTime"
        val KEY_LAT = "lat"
        val KEY_LNG = "lng"
        val TAG = "DBAdapter"

        val DB_NAME = "EVO_DB.db"
        val DB_TABLE1 = "EVO_USER"
        val DB_TABLE2 = "EVO_BUMON"
        val DB_VERSION = 1.0


    }


    fun onCreate(db: SQLiteDatabase) {}

    fun openDatabase(): SQLiteDatabase {
        val dbFile = mContext.getDatabasePath(DB_NAME)

        //DBの存在チェック
        if (!dbFile.exists()) {
            try {
                //DB取得, DBコネクションのクローズ処理
                val checkDB = mContext.openOrCreateDatabase(DB_NAME, Context.MODE_PRIVATE, null)
                checkDB?.close()

                //DBコピー
                copyDatabase(dbFile)

            } catch (e: IOException) {
                //DB未存在
                throw RuntimeException("Error creating source database", e)
            }
        }
        return SQLiteDatabase.openDatabase(dbFile.path, null, SQLiteDatabase.OPEN_READWRITE)

    }

    //DBコピー
    private fun copyDatabase(dbFile: File) {
        val inputFile = mContext.assets.open(DB_NAME)
        val outputFile = FileOutputStream(dbFile)

        val buffer = ByteArray(1024)
        while (inputFile.read(buffer) > 0) {
            outputFile.write(buffer)
            Log.d("#DB", "writing>>")
        }
        outputFile.flush()
        outputFile.close()
        inputFile.close()
        Log.d("#DB", "complete..>>")
    }



    fun getAllData(): Cursor {
            //queryメソッドでデータを取得

            //引数distinctには、trueを指定すると検索結果から重複する行を削除します。
            //引数tableには、テーブル名を指定します。
            //引数columnsには、検索結果に含める列名を指定します。nullを指定すると全列の値が含まれます。
            //引数selectionには、検索条件を指定します。
            //引数selectionArgsには、検索条件のパラメータ（？で指定）に置き換わる値を指定します。
            //引数groupByには、groupBy句を指定します。
            //引数havingには、having句を指定します。
            //引数orderByには、orderBy句を指定します。
            //引数limitには、検索結果の上限レコードを数を指定します。

            val selection: String? = null //検索条件
            val cols: Array<String>? = null
            val selectionArgs: Array<String>? = null
            val groupBy: String? = null
            val having: String? = null
            val orderBy = userDB_Helper.KEY_ID + " DESC"
            val limit = "1"

            Log.d("#DB", "adb-writing>>")

            val cursor: Cursor =
                db.query(userDB_Helper.DB_NAME, cols, selection, selectionArgs, groupBy, having, orderBy, limit)


            for (i in 0..cursor.count) {
                //var sb : String = cursor.getString(0)
                Log.d("#DB", "★-writing>>")
            }

            cursor.close()


        }

}