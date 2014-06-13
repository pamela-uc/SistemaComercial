package is.gonher.db_con;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class GonherQueryHandler extends GonherDataBaseConn implements OnQueryInterface{
	
	private SQLiteDatabase db;
	Context context;
	
	public GonherQueryHandler(Context context) {
		super(context);
		this.context = context;
	}

	@Override
	public Cursor select(String query) {
		db = this.getReadableDatabase();
		Cursor cursor = db.rawQuery(query, null);	
		
		if (cursor != null)
			cursor.moveToFirst();
		
		return cursor;
	}

	@Override
	public Cursor getContentById(String tableName, Integer id){
		db = this.getReadableDatabase();
		Cursor cursor = db.query(tableName, null, "id=?", new String[] { String.valueOf(id) }, null, null, null, null);
		
		if (cursor != null)
			cursor.moveToFirst();	
		
		return cursor;
	}

	@Override
	public void insert(String query) {
		db = this.getWritableDatabase();
		db.execSQL(query);
		db.close();
		Log.e("ux","insert");
	}
	
	@Override
	public void update(String query) {
		db = this.getWritableDatabase();
		db.execSQL(query);
		db.close();
	}
	
	@Override
	public void updateContentById(String tableName, ContentValues content, Integer id){
		db = this.getWritableDatabase();
		db.update(tableName, content, "id = " + id, null);
		db.close();
	}
	
	public void selectClose(Cursor cursor){
		cursor.close();
		db.close();
		super.onClose();
		
	}
}
