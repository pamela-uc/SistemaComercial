package is.gonher.sistema_comercial;

import is.gonher.cobranza.bos.Factura;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class FacturasListAdapter extends ArrayAdapter<Factura> {
    private int                             resource;
    private LayoutInflater  inflater;
    private Context                 context;
    public FacturasListAdapter ( Context ctx, int resourceId, List<Factura> objects) {
            super( ctx, resourceId, objects );
            resource = resourceId;
            inflater = LayoutInflater.from( ctx );
            context=ctx;
    }
    @Override
    public View getView ( int position, View convertView, ViewGroup parent ) {
    	
        convertView = ( View ) inflater.inflate( resource, null );
        Factura factura = getItem( position );
        TextView txtCargo = (TextView) convertView.findViewById(is.gonher.R.id.cob_facturas_col_cargo );
        txtCargo.setText(factura.getPorCargo() );
         
        TextView txtPago = (TextView) convertView.findViewById(is.gonher.R.id.cob_facturas_col_pago);
        txtPago.setText(factura.getPago() );
        
        TextView txtSaldo = (TextView) convertView.findViewById(is.gonher.R.id.cob_facturas_col_saldo);
        txtSaldo.setText(factura.getSaldo());
            
                         
        TextView txtDescrip = (TextView) convertView.findViewById(is.gonher.R.id.cob_facturas_col_descrip);
        txtDescrip.setText(factura.getDescrip() );
        
        
        TextView txtTipo = (TextView) convertView.findViewById(is.gonher.R.id.cob_facturas_col_tipo);
        txtTipo.setText(factura.getDescrip() );        
        
        /*
        ImageView NationImage = (ImageView) convertView.findViewById(is.gonher.R.id.Nation);
            uri = "drawable/" + Legend.getNation();
        imageResource = context.getResources().getIdentifier(uri, null, context.getPackageName());
        image = context.getResources().getDrawable(imageResource);
        NationImage.setImageDrawable(image); */

            return convertView;
    }
    
    
}
