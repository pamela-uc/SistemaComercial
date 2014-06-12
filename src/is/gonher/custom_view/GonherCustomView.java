package is.gonher.custom_view;

import is.gonher.resources.GonherConstants;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.Html;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;

public class GonherCustomView {

	Context context;
	ProgressDialog progress_dialog;
	Dialog dialog_view;
	
	public GonherCustomView(Context context){
		this.context = context;
		this.progress_dialog = new ProgressDialog(this.context);
	}
	
	public void dialog(){
		LinearLayout dialog_layout = new LinearLayout(context);
        dialog_layout.setOrientation(LinearLayout.VERTICAL);
        dialog_layout.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        
        Dialog dialog = new Dialog(context);
        dialog.setContentView(dialog_layout);
        dialog.setCancelable(true);
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
	}
	
	public void alertDialog(int positive, int neutral, int cancel, int exit, String message, String title){
		AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
		 builder.setMessage(Html.fromHtml(message))
		 		.setTitle(title)
		 		.setCancelable(false);
		 
		 if(positive == GonherConstants.ACCEPTANCE_BUTTON){
			 builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
				 public void onClick(DialogInterface dialog, int id) {
					dialog.cancel();
		         }
		     });
		 }
		 
		 if(neutral == GonherConstants.GENERIC_BUTTON){
			 builder.setNeutralButton("Login", new DialogInterface.OnClickListener(){
				 public void onClick(DialogInterface dialog, int id) {
					 dialog.cancel();
		         }
			 });
		 }
		 
		 if(cancel == GonherConstants.CANCEL_BUTTON){
			 builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener(){
				 public void onClick(DialogInterface dialog, int id) {
					 dialog.cancel();
		         }
			 });
		 }
		 
		 if(exit == GonherConstants.EXIT_BUTTON){
			 builder.setNegativeButton("Salir", new DialogInterface.OnClickListener(){
				 public void onClick(DialogInterface dialog, int id) {
					 dialog.cancel();
		         }
			 });
		 }
		 
		 AlertDialog alert = builder.create();
		 alert.show();
	}
	
	public void alertDialogGeneric(int positive, String message, String title, String buttonName){
		AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
		 builder.setMessage(Html.fromHtml(message))
		 		.setTitle(title)
		 		.setCancelable(false);
		 
		 if(positive == GonherConstants.ACCEPTANCE_BUTTON){
			 builder.setPositiveButton(buttonName, new DialogInterface.OnClickListener() {
				 public void onClick(DialogInterface dialog, int id) {
					 dialog.cancel();
		         }
		     });
		 }
		 
		 AlertDialog alert = builder.create();
		 alert.show();
	}
	
	public void progressDialog(String message){
		this.progress_dialog.setMessage(message);
		this.progress_dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
		this.progress_dialog.setCancelable(false);
		this.progress_dialog.show(); 
	}
	
	public void dismissProgressDialog(){
		this.progress_dialog.dismiss();
	}
	
	public void CancelDialog(){
		this.dialog_view.cancel();
	}
}
