package is.gonher.cobranza;

 
import is.gonher.cobranza.bos.Cobranza;
import is.gonher.cobranza.bos.Factura;
 

import is.gonher.custom_view.GonherCustomView;
import is.gonher.resources.GonherConstants;
import is.gonher.sistema_comercial.FacturasListAdapter;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;
 





import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;
import android.view.View.OnClickListener;


public class Tab3Cobranza extends Fragment {
	 
	  private ListView listViewFacturas;
	    private Context ctx;	
	    List<Factura> facturasList= null;
	    Dialog dlgPago =null ;
	    FacturasListAdapter facturasListAdapter;
	    View view;

	    @Override
	    public View onCreateView(LayoutInflater inflater, ViewGroup container,
	            Bundle savedInstanceState) {
	    	   setRetainInstance(true);
	    	    view= inflater.inflate(is.gonher.R.layout.tab3_cobranza, container, false);
	    	   ctx=this.getActivity(); 
	    	   dlgPago = new Dialog(this.ctx);
	           facturasList= new ArrayList<Factura>();
	           facturasList.add(new Factura("40",new BigDecimal(0), new BigDecimal("2340"),"Efectivo" , "Bancomer",new BigDecimal(3456.09)));
	           facturasList.add(new Factura("25",new BigDecimal(0), new BigDecimal("3230"),"Efectivo","Bancomer",new BigDecimal(4589.98)));
	           facturasList.add(new Factura("30",new BigDecimal(0), new BigDecimal("4500"),"Cheque","Banamex",new BigDecimal(3767.50)));
	           facturasList.add(new Factura("40",new BigDecimal(0), new BigDecimal("3590.00"),"Cheque","Banorte",new BigDecimal(1278.30)));
	           facturasList.add(new Factura("43",new BigDecimal(0), new BigDecimal("5600.00"),"Efectivo","Bancomer",new BigDecimal(4590.23)));
	           facturasList.add(new Factura("25",new BigDecimal(0), new BigDecimal("2490.00"),"Efectivo","Bancomer",new BigDecimal(2761.24)));
	           facturasList.add(new Factura("80",new BigDecimal(0), new BigDecimal("1207.00"),"Efectivo" , "Bancomer",new BigDecimal(8935.45)));
	           facturasList.add(new Factura("98",new BigDecimal(0), new BigDecimal("2590.00"),"Efectivo","Bancomer",new BigDecimal(2843.00)));
	           facturasList.add(new Factura("56",new BigDecimal(0), new BigDecimal("1450.00"),"Cheque","Banamex",new BigDecimal(5278.19)));
	           facturasList.add(new Factura("53",new BigDecimal(0), new BigDecimal("3490.00"),"Cheque","Banorte",new BigDecimal(7367.92)));
	           facturasList.add(new Factura("94",new BigDecimal(0), new BigDecimal("2560.00"),"","Bancomer",new BigDecimal(3789.45)));
	           facturasList.add(new Factura("100",new BigDecimal(0),new BigDecimal("1489.00"),"","Bancomer",new BigDecimal(6834.74)));
	           
	           
	           listViewFacturas = ( ListView ) view.findViewById( is.gonher.R.id.Facturas_list);
	           setTotalPagos();
	           
	            
	           listViewFacturas.setOnItemClickListener(new OnItemClickListener() 
	           {
	               @Override
	               public void onItemClick(AdapterView<?> a, View v,int position, long id) 
	               {
	                 //  Toast.makeText(v.getContext(), "Click", Toast.LENGTH_LONG).show();
	            	   Factura fact = (Factura) a.getItemAtPosition(position); 
	                   askAmountApply(v,fact,position);
	                   

	               }
	           });
	      	           
	           
	           System.out.println("Se llama adapter ");
	           facturasListAdapter= new FacturasListAdapter(ctx, is.gonher.R.layout.facturas_row_item, facturasList );
	           listViewFacturas.setAdapter( facturasListAdapter );
	           
	           
	           
	           
	           
	
	            

	    	
	       // return (LinearLayout) inflater.inflate(is.gonher.R.layout.tab1_fragment, container, false);
	            return view;
	    }
	    
	    
	    protected void setTotalPagos(){
	        TextView txtImpTotal = (TextView) view.findViewById(is.gonher.R.id.txtFactImpTotal );
	       
	        BigDecimal impTotal=new BigDecimal(0.0);
	    	for( Factura factura : facturasList ){
	    		impTotal=  impTotal.add(factura.getPago() );
	    		
	    	}
	    	
	    	DecimalFormat df = new DecimalFormat();
	    	df.setMaximumFractionDigits(2);
	    	df.setMinimumFractionDigits(2);
	    	df.setGroupingUsed(true);	    		    	
	    	txtImpTotal.setText( df.format(impTotal) );  
	    	
	    }
	    
	    protected void askAmountApply(View view , Factura factura, int pos){
	    	
	    	 
	    	
	    	// Dialog dialog = new Dialog(this.ctx);
	    	final Factura fact=factura;
	    	final int currPos=pos;
			dlgPago.setContentView(is.gonher.R.layout.main_dlg_authentication );
			dlgPago.setTitle("Aplicar Abono");
			dlgPago.setCancelable(false);

			 
			
			Button btnCancelar = (Button) dlgPago.findViewById(is.gonher.R.id.btnCancelar);
			EditText edPago= (EditText) dlgPago.findViewById(is.gonher.R.id.edPago);						
			// if button is clicked, close the custom dialog
			 
			btnCancelar.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					
					dlgPago.dismiss();
				}
			}); 
			
			Button btnAceptar = (Button) dlgPago.findViewById(is.gonher.R.id.btnAcpetar);
			btnAceptar.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					 
					
					EditText edPago= (EditText) dlgPago.findViewById(is.gonher.R.id.edPago);
					try{  
					   fact.setPago(new BigDecimal(edPago.getText().toString().trim() ));
					   facturasList.set( currPos , fact);					  
					   //Toast.makeText(v.getContext(), edPago.getText().toString()  , Toast.LENGTH_LONG).show();
					   facturasListAdapter.notifyDataSetChanged();
					   setTotalPagos();
					}catch(Exception e){}
					dlgPago.dismiss();
				}
			}); 
			

			dlgPago.show();  
	    }
	    	    
	  
	    
	    
	    
 
}