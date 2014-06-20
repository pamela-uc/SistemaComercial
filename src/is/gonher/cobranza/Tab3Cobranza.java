package is.gonher.cobranza;

 
import is.gonher.cobranza.bos.Cobranza;
import is.gonher.cobranza.bos.Factura;
 

import is.gonher.custom_view.GonherCustomView;
import is.gonher.resources.GonherConstants;
import is.gonher.sistema_comercial.FacturasListAdapter;

import java.util.ArrayList;
import java.util.List;

 

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;
import android.view.View.OnClickListener;


public class Tab3Cobranza extends Fragment {
	 
	  private ListView listViewFacturas;
	    private Context ctx;	

	    @Override
	    public View onCreateView(LayoutInflater inflater, ViewGroup container,
	            Bundle savedInstanceState) {
	 
	    	
	    	   View view= inflater.inflate(is.gonher.R.layout.tab3_cobranza, container, false);
	    	   ctx=this.getActivity(); 
	           List<Factura> facturasList= new ArrayList<Factura>();
	           facturasList.add(new Factura("40","7,890.89","2,340","Efectivo" , "Bancomer"));
	           facturasList.add(new Factura("25","4,560.90","3,230","Efectivo","Bancomer"));
	           facturasList.add(new Factura("30","1325.70","4,500,","Cheque","Banamex"));
	           facturasList.add(new Factura("40","11,237.00","3,590.00","Cheque","Banorte"));
	           facturasList.add(new Factura("43","3,945.00","5600.00","Efectivo","Bancomer"));
	           facturasList.add(new Factura("25","699.35","2,490.00","Efectivo","Bancomer"));
	           facturasList.add(new Factura("80","7,890.89","1,207.00","Efectivo" , "Bancomer"));
	           facturasList.add(new Factura("98","4,560.90","2,590.00","Efectivo","Bancomer"));
	           facturasList.add(new Factura("56","1325.70","1,450.00","Cheque","Banamex"));
	           facturasList.add(new Factura("53","11,237.00","3,490.00","Cheque","Banorte"));
	           facturasList.add(new Factura("94","3,945.00","2.560.00","","Bancomer"));
	           facturasList.add(new Factura("100","699.35","1,489.00","","Bancomer"));
	           
	           
	           listViewFacturas = ( ListView ) view.findViewById( is.gonher.R.id.Facturas_list);
	           
	            
	           listViewFacturas.setOnItemClickListener(new OnItemClickListener() 
	           {
	               @Override
	               public void onItemClick(AdapterView<?> a, View v,int position, long id) 
	               {
	                 //  Toast.makeText(v.getContext(), "Click", Toast.LENGTH_LONG).show();
	                   askAmountApply(v);

	               }
	           });
	      	           
	           
	           System.out.println("Se llama adapter ");
	           listViewFacturas.setAdapter( new FacturasListAdapter(ctx, is.gonher.R.layout.facturas_row_item, facturasList ) );
	           
	           
	           
	           
	           
	
	            

	    	
	       // return (LinearLayout) inflater.inflate(is.gonher.R.layout.tab1_fragment, container, false);
	            return view;
	    }
	    
	    
	    protected void askAmountApply(View view){
	    	
	    	 
	    	
	    	final Dialog dialog = new Dialog(this.ctx);
			dialog.setContentView(is.gonher.R.layout.main_dlg_authentication );
			dialog.setTitle("Aplicar Abono");
			dialog.setCancelable(false);

			 
			
			Button btnAceptar = (Button) dialog.findViewById(is.gonher.R.id.btnAcpetar);
			// if button is clicked, close the custom dialog
			 
			btnAceptar.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					dialog.dismiss();
				}
			}); 
			
			Button btnCancelar = (Button) dialog.findViewById(is.gonher.R.id.btnCancelar);
			btnCancelar.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					dialog.dismiss();
				}
			}); 
			

			dialog.show();  
	    }
	    	    
	  
	    
	    
	    
 
}