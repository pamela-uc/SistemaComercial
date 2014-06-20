package is.gonher.sistema_comercial;

import is.gonher.cobranza.bos.Cobranza;

import java.util.List;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class CobranzasListAdapter extends ArrayAdapter<Cobranza> {
    private int                             resource;
    private LayoutInflater  inflater;
    private Context                 context;
    public CobranzasListAdapter ( Context ctx, int resourceId, List<Cobranza> objects) {
            super( ctx, resourceId, objects );
            resource = resourceId;
            inflater = LayoutInflater.from( ctx );
            context=ctx;
    }
    @Override
    public View getView ( int position, View convertView, ViewGroup parent ) {
    	
        convertView = ( View ) inflater.inflate( resource, null );
        Cobranza cobranza = getItem( position );
        TextView legendName = (TextView) convertView.findViewById(is.gonher.R.id.cob_concentrado_col_folio);
        legendName.setText(cobranza.getFolio() );
         
        TextView txtImporte = (TextView) convertView.findViewById(is.gonher.R.id.cob_concentrado_col_importe);
        txtImporte.setText(cobranza.getImporte() );
        
        TextView txtTipo = (TextView) convertView.findViewById(is.gonher.R.id.cob_concentrado_col_tipo);
        txtTipo.setText(cobranza.getTipo() );
            
                         
        TextView txtBanco = (TextView) convertView.findViewById(is.gonher.R.id.cob_concentrado_col_banco);
        txtBanco.setText(cobranza.getBanco() );
        
        /*
        ImageView NationImage = (ImageView) convertView.findViewById(is.gonher.R.id.Nation);
            uri = "drawable/" + Legend.getNation();
        imageResource = context.getResources().getIdentifier(uri, null, context.getPackageName());
        image = context.getResources().getDrawable(imageResource);
        NationImage.setImageDrawable(image); */

            return convertView;
    }
}