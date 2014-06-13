package is.gonher.db_con;

public class GonherDataBase {

	public String query = "";
	
	public String createAgent(){
		query = "CREATE TABLE agente(id INTEGER PRIMARY KEY AUTOINCREMENT, "
								  + "id_agente_ext INTEGER, "
								  + "nombre TEXT , "
								  + "password TEXT)";
		return query;
	}
}
