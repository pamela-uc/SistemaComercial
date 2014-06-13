package is.gonher.sistema_comercial;

import is.gh.sistemacomercial.R;
import is.gonher.login_agent.GonherLogInAgent;
import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		GonherLogInAgent log_agent = new GonherLogInAgent(this, getBaseContext());
		log_agent.logIn();
	}

}
