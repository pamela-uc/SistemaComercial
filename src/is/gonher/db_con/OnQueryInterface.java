package is.gonher.db_con;

import android.content.ContentValues;
import android.database.Cursor;

public interface OnQueryInterface {

	public abstract Cursor select(String query);
	public abstract Cursor getContentById(String tableName, Integer id);
	public abstract void insert(String query);
	public abstract void update(String query);
	public abstract void updateContentById(String tableName, ContentValues content, Integer id);
	//public abstract Object setDelete(String query);
}