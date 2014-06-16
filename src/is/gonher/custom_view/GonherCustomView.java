package is.gonher.custom_view;

import java.util.ArrayList;
import is.gonher.resources.GonherConstants;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class GonherCustomView {

	Context context;
	ProgressDialog progress_dialog;
	Dialog dialog;
	
	public GonherCustomView(Context context){
		this.context = context;
		this.progress_dialog = new ProgressDialog(this.context);
	}
	
	public void dialogLinear(ArrayList<?> list, String title){
		LinearLayout dialog_layout = new LinearLayout(context);
        dialog_layout.setOrientation(LinearLayout.VERTICAL);
        dialog_layout.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        
        dialog = new Dialog(context);
        dialog.setContentView(dialog_layout);
        
        if(list != null){
			 for(Object o: list){
				 dialog_layout.addView((View) o);
			 }
	     }
       
        dialog.setCancelable(true);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setTitle(title);
        dialog.show();
	}
        
	public void dialogRelative(ArrayList<?> list, String title){
		RelativeLayout dialog_layout = new RelativeLayout(context);
		
		RelativeLayout.LayoutParams dialog_layout2 = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		///need to be more efective
		 
        dialog = new Dialog(context);
        dialog.setContentView(dialog_layout);
        
        if(list != null){
			 for(Object o: list){
				 dialog_layout2.addRule(RelativeLayout.ALIGN_PARENT_END, ((View) o).getId());
				 dialog_layout.addView((View) o, dialog_layout2);
			 }
	     }
       
        dialog.setCancelable(true);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setTitle(title);
        dialog.show();
	}
	
	public void alertDialog(int positive, int neutral, int cancel, int exit, String message, String title, boolean cancelable, ArrayList<?> list){
		AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
		 builder.setMessage(Html.fromHtml(message))
		 		.setCancelable(cancelable);
		 
		 if(title != null){
			 builder.setTitle(title);
		 }
		 
		 if(list != null){
			 for(Object o: list){
				 builder.setView((View) o);
			 }
	     }
		 
		 if(positive == GonherConstants.ACCEPTANCE_BUTTON){
			 builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
				 public void onClick(DialogInterface dialog, int id) {
					dialog.cancel();
		         }
		     });
		 }
		 
		 if(neutral == GonherConstants.GENERIC_BUTTON){
			 builder.setNeutralButton("neutral", new DialogInterface.OnClickListener(){
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
					 System.exit(0);
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
		this.dialog.cancel();
	}
}
