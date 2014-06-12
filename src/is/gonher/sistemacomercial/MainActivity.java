package is.gonher.sistemacomercial;

import is.gh.sistemacomercial.R;
import is.gonher.custom_view.GonherCustomView;
import is.gonher.resources.GonherConstants;
import android.support.v7.app.ActionBarActivity;
import android.content.Context;
import android.os.Bundle;

public class MainActivity extends ActionBarActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		GonherCustomView cv = new GonherCustomView(this);
		cv.alertDialog(GonherConstants.ACCEPTANCE_BUTTON, GonherConstants.GENERIC_BUTTON, GonherConstants.EMPTY_BUTTON, GonherConstants.EMPTY_BUTTON, "Prueba del alert dialog", "prueba 1");
		//cv.alertDialogGeneric(GonherConstants.ACCEPTANCE_BUTTON, "Prueba del alert dialog generico", "Prueba 2", "Clic");
		//cv.progressDialog("Cargando");
		
	}

}
