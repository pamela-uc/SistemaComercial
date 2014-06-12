package is.gonher.db_con;

import is.gonher.resources.GonherConstants;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class GonherDataBaseConn extends SQLiteOpenHelper{
	private static final String MY_DATABASE = GonherConstants.DATABASE;
	private static final int VERSION = 1;
	
	public GonherDataBaseConn(Context context) {
		super(context, MY_DATABASE, null, VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		//db.execSQL(//TODO CREATE TABLES:::);
		
	}
	 
	@Override
	public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
		//db.execSQL("DROP TABLE IF EXISTS table......");
		onCreate(db);
	}
}
