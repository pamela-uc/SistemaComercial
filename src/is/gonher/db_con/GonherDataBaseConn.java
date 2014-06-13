package is.gonher.db_con;

import is.gonher.resources.GonherConstants;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class GonherDataBaseConn extends SQLiteOpenHelper{
	private static final String MY_DATABASE = GonherConstants.DATABASE;
	private static final int VERSION = 1;
	GonherDataBase create_db = new GonherDataBase();
	
	public GonherDataBaseConn(Context context) {
		super(context, MY_DATABASE, null, VERSION);
		Log.e("db", "se inicia la conexion");
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		Log.e("db", "se crea las tablas");
		db.execSQL(create_db.createAgent());
	}
	 
	@Override
	public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
		db.execSQL("DROP TABLE IF EXISTS agente");
		onCreate(db);
	}
	
	public void onClose(){
		super.close();
	}
}
