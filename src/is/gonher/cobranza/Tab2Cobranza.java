package is.gonher.cobranza;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
 
public class Tab2Cobranza extends Fragment {
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);

      // Retain this fragment across configuration changes.
      setRetainInstance(true);

      
    }	
 
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
    	setRetainInstance(true);
        return (View) inflater.inflate(is.gonher.R.layout.tab2_cobranza , container, false);
    }
 
}