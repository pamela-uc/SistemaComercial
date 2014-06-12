package is.gonher.network_resource;

import is.gonher.custom_view.GonherCustomView;
import is.gonher.resources.GonherConstants;
import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class GonherNetworkHelper {
	public static Context context;
    
    private GonherNetworkHelper(Context context){
    	GonherNetworkHelper.context = context;
    }
    
    public static int getConnectivityStatus() {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        
        if (null != activeNetwork) {
            if(activeNetwork.getType() == ConnectivityManager.TYPE_WIFI)
                return GonherConstants.TYPE_WIFI;
             
            if(activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE)
                return GonherConstants.TYPE_MOBILE;
        } 
              
        showNoNetworkAlertDialog();
        return GonherConstants.TYPE_NOT_CONNECTED;
    }
    
    public static void showNoNetworkAlertDialog(){
    	final Activity activity = (Activity) context;
    	activity.runOnUiThread(new Runnable(){

			@Override
			public void run() {				 	
				GonherCustomView view = new GonherCustomView(context);				
				view.alertDialogGeneric(GonherConstants.ACCEPTANCE_BUTTON, "msg network not found", "title network not found", "Aceptar");			
			}
    	});
    }
    
    public static String getConnectivityStatusString(Context context) {
        int conn = getConnectivityStatus();
        String status = null;
        
        if(conn == GonherConstants.TYPE_WIFI) {
            status = "Wifi enabled";
        }else if (conn == GonherConstants.TYPE_MOBILE) {
            status = "Mobile data enabled";
        }else if (conn == GonherConstants.TYPE_NOT_CONNECTED) {
            status = "Not connected to Internet";
        }
        
        return status;
    }  
}
