package is.gonher.cobranza;


import java.util.ArrayList;
import java.util.List;

import is.gonher.cobranza.bos.Cobranza;
import is.gonher.resources.GonherConstants;
import is.gonher.sistema_comercial.FootballLegend;
import is.gonher.sistema_comercial.CobranzasListAdapter;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;
import is.gonher.custom_view.GonherCustomView;

public class Tab1Cobranza extends Fragment { 
	 
    private ListView listViewCobranza;
    private Context ctx;	

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
    	
    	   View view= inflater.inflate(is.gonher.R.layout.tab1_cobranza, container, false);
    	   ctx=this.getActivity(); 
           List<Cobranza> cobrosList= new ArrayList<Cobranza>();
           cobrosList.add(new Cobranza("53890","7,890.89","Efectivo" , "Bancomer"));
           cobrosList.add(new Cobranza("53891","4,560.90","Efectivo","Bancomer"));
           cobrosList.add(new Cobranza("53892","1325.70","Cheque","Banamex"));
           cobrosList.add(new Cobranza("53893","11,237.00","Cheque","Banorte"));
           cobrosList.add(new Cobranza("53894","3,945.00","Efectivo","Bancomer"));
           cobrosList.add(new Cobranza("53895","699.35","Efectivo","Bancomer"));
           cobrosList.add(new Cobranza("53890","7,890.89","Efectivo" , "Bancomer"));
           cobrosList.add(new Cobranza("53891","4,560.90","Efectivo","Bancomer"));
           cobrosList.add(new Cobranza("53892","1325.70","Cheque","Banamex"));
           cobrosList.add(new Cobranza("53893","11,237.00","Cheque","Banorte"));
           cobrosList.add(new Cobranza("53894","3,945.00","Efectivo","Bancomer"));
           cobrosList.add(new Cobranza("53895","699.35","Efectivo","Bancomer"));
           
           
           listViewCobranza = ( ListView ) view.findViewById( is.gonher.R.id.Cobranzas_list);
           listViewCobranza.setAdapter( new CobranzasListAdapter(ctx, is.gonher.R.layout.cobranza_row_item, cobrosList ) );
      
           // Click event for single list row
          // OnItemClickListener a;
           listViewCobranza.setOnItemClickListener(new OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                   Cobranza o = (Cobranza) parent.getItemAtPosition(position); 
                      //Toast.makeText(Tab1Cobranza.this, "" ).show();
                      GonherCustomView cv=new GonherCustomView(  view.getContext() );
                      cv.alertDialog(GonherConstants.ACCEPTANCE_BUTTON , 0, GonherConstants.CANCEL_BUTTON , 0 , "Desea modificar el registro ?", "Afectar cobranza");
                   }
           });              	
    	  
    	
       // return (LinearLayout) inflater.inflate(is.gonher.R.layout.tab1_fragment, container, false);
            return view;
    }
 
}