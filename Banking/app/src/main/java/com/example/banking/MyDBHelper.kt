package com.example.banking

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class MyDBHelper(context: Context): SQLiteOpenHelper(context,"CUSTOMERS_DATA",null,1) {

    companion object{
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "CUSTOMERS_DATA"
        private const val TABLE_NAME = "CUSTOMERS"

        private const val CUSTOMER_ID = "cid"
        private const val FNAME = "FirstName"
        private const val LNAME = "LastName"
        private const val EMAIL = "email"
        private const val BALANCE = "balance"
    }


    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE CUSTOMERS(cid INTEGER PRIMARY KEY AUTOINCREMENT, FNAME TEXT, LNAME TEXT,EMAIL TEXT,BALANCE INTEGER)")

        db?.execSQL("INSERT INTO CUSTOMERS(FNAME,LNAME,EMAIL,BALANCE) VALUES('Sokia','Akhter','sokia@gmail.com',10000)")
        db?.execSQL("INSERT INTO CUSTOMERS(FNAME,LNAME,EMAIL,BALANCE) VALUES('Aaditya','Sharma','aadi@gmail.in',10000)")
        db?.execSQL("INSERT INTO CUSTOMERS(FNAME,LNAME,EMAIL,BALANCE) VALUES('Jagdish','Gour','jagdish@gmail.com',10000)")
        db?.execSQL("INSERT INTO CUSTOMERS(FNAME,LNAME,EMAIL,BALANCE) VALUES('Jyotsana','Tarai','jyotsana@gmail.com',10000)")
        db?.execSQL("INSERT INTO CUSTOMERS(FNAME,LNAME,EMAIL,BALANCE) VALUES('Priyanka','Kumari','priyanka@gmail',10000)")
        db?.execSQL("INSERT INTO CUSTOMERS(FNAME,LNAME,EMAIL,BALANCE) VALUES('Devendra','Mahto','dev@yahoo.in',10000)")
        db?.execSQL("INSERT INTO CUSTOMERS(FNAME,LNAME,EMAIL,BALANCE) VALUES('Raj','Shankar','raj@yahoo.in',10000)")
        db?.execSQL("INSERT INTO CUSTOMERS(FNAME,LNAME,EMAIL,BALANCE) VALUES('Ajay','Kumar','ajkr@gmail.com',10000)")
        db?.execSQL("INSERT INTO CUSTOMERS(FNAME,LNAME,EMAIL,BALANCE) VALUES('Prakash','Raj','prakash@yahoo.com',10000)")
        db?.execSQL("INSERT INTO CUSTOMERS(FNAME,LNAME,EMAIL,BALANCE) VALUES('Rashmita','Sahoo','rshsaho@abc',10000)")
        db?.execSQL("INSERT INTO CUSTOMERS(FNAME,LNAME,EMAIL,BALANCE) VALUES('Rajat','Mahapatra','rajat@abc',10000)")
        db?.execSQL("INSERT INTO CUSTOMERS(FNAME,LNAME,EMAIL,BALANCE) VALUES('Brajesh','Singh','brajesh@gmail.com',10000)")
        db?.execSQL("INSERT INTO CUSTOMERS(FNAME,LNAME,EMAIL,BALANCE) VALUES('Birendra','Sharma','biru@gmail.com',10000)")
        db?.execSQL("INSERT INTO CUSTOMERS(FNAME,LNAME,EMAIL,BALANCE) VALUES('Sai','Ram','sairam@abc.com',10000)")
        db?.execSQL("INSERT INTO CUSTOMERS(FNAME,LNAME,EMAIL,BALANCE) VALUES('Jay','prakash','jay@gmail.com',10000)")
        db?.execSQL("INSERT INTO CUSTOMERS(FNAME,LNAME,EMAIL,BALANCE) VALUES('Sai','Krishna','saikrishna@xyz',10000)")
        db?.execSQL("INSERT INTO CUSTOMERS(FNAME,LNAME,EMAIL,BALANCE) VALUES('Amitesh','Pandey','amitesh@gmail.com',10000)")
        db?.execSQL("INSERT INTO CUSTOMERS(FNAME,LNAME,EMAIL,BALANCE) VALUES('Biplab','Kumar','biplab@gmail.com',10000)")
        db?.execSQL("INSERT INTO CUSTOMERS(FNAME,LNAME,EMAIL,BALANCE) VALUES('Rakesh','Mahto','rakesh@gmail.com',10000)")


    }

    override fun onUpgrade(db:SQLiteDatabase, oldVersion: Int,newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME)
        onCreate(db)
    }

    fun updateBalance(c: Customer) {
        val values = ContentValues()
        values.put(BALANCE, c.getBalance())

        val db: SQLiteDatabase = this.writableDatabase
        //val success = db.update(TABLE_CONTACTS, contentValues,"id="+emp.userId,null)
        val success = db.update(
            TABLE_NAME,
            values,
             " cid = " + c.getId(),
            null)

    }

}