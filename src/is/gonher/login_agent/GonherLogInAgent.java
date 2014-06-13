package is.gonher.login_agent;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.text.method.PasswordTransformationMethod;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import is.gonher.custom_view.GonherCustomView;
import is.gonher.db_con.GonherQueryHandler;

public class GonherLogInAgent {

	Context context, contextHandler;
	GonherCustomView cv;
	GonherQueryHandler qh;
	
	public GonherLogInAgent(Activity context, Context contextHandler){
		this.context = context;
		this.contextHandler = contextHandler;
	}
	
	public void logIn(){
		EditText et = new EditText(this.context);
        et.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        et.setEms(30);
        et.setInputType(1);
        et.setPadding(40, 120, 40, 30);
        et.setId(1);
        et.setHint("Nombre");
        
                
        EditText et_pass = new EditText(this.context);
        et_pass.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        et_pass.setEms(30);
        et_pass.setInputType(2);
        et_pass.setTransformationMethod(PasswordTransformationMethod.getInstance());
        et_pass.setPadding(40, 100, 40, 30);
        et_pass.setId(2);
        et_pass.setHint("Contraseña");
        
        
        Button log = new Button(this.context);
        log.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
        log.setEms(30);
        log.setText("Entrar");
        
        ArrayList<Object> logIn = new ArrayList<Object>();
        
        qh = new GonherQueryHandler(this.contextHandler);
        Cursor getAgent = qh.select("SELECT id FROM agente WHERE id = 1");
    	
        if(getAgent.getCount() <= 0){ 
        	logIn.add(et);
        }
        
        qh.selectClose(getAgent);
		
        logIn.add(et_pass);
        logIn.add(log);
        
        cv = new GonherCustomView(this.context);
        //cv.dialogRelative(logIn, "Bienvenido");  aqui
        cv.dialogLinear(logIn, "Bienvenido");;
        //cv.alertDialog(GonherConstants.EMPTY_BUTTON, GonherConstants.GENERIC_BUTTON, GonherConstants.EMPTY_BUTTON, GonherConstants.EXIT_BUTTON, "Prueba del alert dialog", null, false, logIn);
	}
	
	
	/*GonherQueryHandler qh = new GonherQueryHandler(this.getBaseContext());
	
	String name = "Jorge palacio";
	String pass = "123456";
	qh.insert("INSERT INTO agente(id_agente_ext, nombre, password) VALUES(44, '"+name+"', '"+pass+"')");
	
	Cursor find_agent = qh.select("SELECT * FROM agente WHERE id = 1");
	Log.e("db",find_agent.getString(0)+" "+find_agent.getString(2));
	
	qh.selectClose(find_agent);*/
}