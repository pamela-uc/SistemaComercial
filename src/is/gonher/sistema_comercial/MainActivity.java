package is.gonher.sistema_comercial;

import is.gh.sistemacomercial.R;
import is.gonher.custom_view.GonherCustomView;
import is.gonher.network_resource.GonherNetworkHelper;
import is.gonher.resources.GonherConstants;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		/*GonherCustomView cv = new GonherCustomView(this);
		cv.alertDialog(GonherConstants.ACCEPTANCE_BUTTON, GonherConstants.GENERIC_BUTTON, GonherConstants.EMPTY_BUTTON, GonherConstants.EMPTY_BUTTON, "Prueba del alert dialog", "prueba 1");
		//cv.alertDialogGeneric(GonherConstants.ACCEPTANCE_BUTTON, "Prueba del alert dialog generico", "Prueba 2", "Clic");
		//cv.progressDialog("Cargando");*/
		
		
		GonherNetworkHelper.context = this;		
		Toast.makeText(this, GonherNetworkHelper.getConnectivityStatusString(this), Toast.LENGTH_LONG).show();
		
	}

}
