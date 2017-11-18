package com.example.quickhealthmob;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class DatabaseOperations extends SQLiteOpenHelper {
    public static final String id = "id";
    public static final String DOC_NAME = "name";
    public static final String USER_NAME = "user_name";
    public static final String USER_PASS = "user_pass";
    public static final String DATABASE_NAME = "user_info";
    public static final String TABLE_NAME = "reg_info";
        private SQLiteDatabase ourDatabase;
        private DatabaseOperations ourHelper;
        final private Context mContext;
    public static final int database_version = 2;
    public String CREATE_QUERY = "CREATE TABLE "+ UserTable.TableInfo.TABLE_NAME +
            "("+ UserTable.TableInfo.id + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + UserTable.TableInfo.DOC_NAME +" TEXT,"
            + UserTable.TableInfo.USER_NAME +" TEXT,"
            + UserTable.TableInfo.USER_PASS +" TEXT ); ";


    public DatabaseOperations(Context context) {
        super(context, UserTable.TableInfo.DATABASE_NAME, null, database_version);
        this.mContext =context;
        Log.d("Database operations", "Successfully created");

    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(CREATE_QUERY);
        Log.d("Database operations", "Table created");
    }

    public DatabaseOperations open(){
        ourHelper=new DatabaseOperations(mContext);
        ourDatabase = ourHelper.getWritableDatabase();
        return  this;
    }
    public Cursor getAllContacts(){
        return ourDatabase.query(UserTable.TableInfo.TABLE_NAME, new String[] {id, DOC_NAME, USER_NAME,USER_PASS}, null, null, null, null, null);
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2) {

    }
    //method to insert information into the database
    public void putInformation(DatabaseOperations databaseOperations, String name, String user_name, String pass){
        SQLiteDatabase sqLiteDatabase = databaseOperations.getReadableDatabase();
        ContentValues contentValues = new ContentValues();

        //Use put to add values by specifying a key add values
        contentValues.put(UserTable.TableInfo.DOC_NAME, name);
        contentValues.put(UserTable.TableInfo.USER_NAME, user_name);
        contentValues.put(UserTable.TableInfo.USER_PASS, pass);

        //insert the data and store the line inserted into variable
        Long k = sqLiteDatabase.insert(UserTable.TableInfo.TABLE_NAME, null, contentValues);
        //Log value
        Log.d("Database operations", "One row inserted");
    }
    //method to retrieve information
    //public void
}
