package is.gonher.sistema_comercial;

 

import java.util.ArrayList;


import java.util.List;

import is.gonher.cobranza.CobranzaActivity;
import is.gonher.custom_view.GonherCustomView;
import is.gonher.network_resource.GonherNetworkHelper;
import is.gonher.resources.GonherConstants;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
    private ListView listViewFootballLegend;
    private Context ctx;	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(is.gonher.R.layout.activity_main );
		
		
		Button button= (Button) findViewById(is.gonher.R.id.btnGuardar );
		button.setOnClickListener(new View.OnClickListener() {
		    @Override
		    public void onClick(View v) {
		       // DoIt(v);
		    	Intent i = new Intent(MainActivity.this, CobranzaActivity.class);                      
		    	//i.putExtra("PersonID", personID);
		    	startActivity(i);
		    }
		});		

		/*
        ctx=this;      
        List<FootballLegend> legendList= new ArrayList<FootballLegend>();
        legendList.add(new FootballLegend("Pele","October 23, 1940 (age 72)","pele","brazil"));
        legendList.add(new FootballLegend("Diego Maradona","October 30, 1960 (age 52)","maradona","argentina"));
        legendList.add(new FootballLegend("Johan Cruyff","April 25, 1947 (age 65)","cruyff","netherlands"));
        legendList.add(new FootballLegend("Franz Beckenbauer","September 11, 1945 (age 67)","beckenbauer","germany"));
        legendList.add(new FootballLegend("Michel Platini","June 21, 1955 (age 57)","platini","france"));
        legendList.add(new FootballLegend("Ronaldo De Lima","September 22, 1976 (age 36)","ronaldo","brazil"));

        listViewFootballLegend = ( ListView ) findViewById( is.gonher.R.id.FootballLegend_list);
        listViewFootballLegend.setAdapter( new FootballLegendListAdapter(ctx, is.gonher.R.layout.legend_row_item, legendList ) );
   
        // Click event for single list row
        
        listViewFootballLegend.setOnItemClickListener(new OnItemClickListener() {
@Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                FootballLegend o = (FootballLegend) parent.getItemAtPosition(position); 
                Toast.makeText(CustomlistviewActivity.this, o.getName().toString(), Toast.LENGTH_SHORT).show();
                }
        });            		*/
		
		
		GonherNetworkHelper.context = this;		
		Toast.makeText(this, GonherNetworkHelper.getConnectivityStatusString(this), Toast.LENGTH_LONG).show();
		
	}

}
