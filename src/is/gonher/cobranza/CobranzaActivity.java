package is.gonher.cobranza;

import android.support.v7.app.ActionBar.Tab;
import android.support.v7.app.ActionBar.TabListener;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import android.os.Build;

public class CobranzaActivity extends ActionBarActivity {
	 
	 ActionBar actionBar =null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(is.gonher.R.layout.activity_cobranza);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(is.gonher.R.id.container, new PlaceholderFragment())
                    .commit();
            
            this.getSupportFragmentManager().executePendingTransactions(); 
        }
        
        actionBar = this.getSupportActionBar();
        
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);   
        
        
       // String label1 = getResources().getString(R.string.label1);
        Tab tab = actionBar.newTab();
        tab.setText("Concentrado");
        TabListener<Tab1Cobranza> tl1 = new TabListener<Tab1Cobranza>(this,
                "tab1" , Tab1Cobranza.class);
        tab.setTabListener(tl1);
        actionBar.addTab(tab);
 
        //String label2 = getResources().getString(R.string.label2);
        tab = actionBar.newTab();
        tab.setText("Cobranza");
        TabListener<Tab2Cobranza> tl2 = new TabListener<Tab2Cobranza>(this,
                "tab2" , Tab2Cobranza.class);
        tab.setTabListener(tl2);
        actionBar.addTab(tab);        
        
        
        tab = actionBar.newTab();
        tab.setText("Facturas");
        TabListener<Tab3Cobranza> tl3 = new TabListener<Tab3Cobranza>(this,
                "tab3" , Tab3Cobranza.class);
        tab.setTabListener(tl3);
        actionBar.addTab(tab);    
        
        actionBar.selectTab(tab);
        
        if( savedInstanceState!=null ){
        
           int idx=savedInstanceState.getInt("tabSelected");
           actionBar.setSelectedNavigationItem(idx);
        
        
        }
        
        
         

        
        
        
    }
    
    
    @Override
    public void onSaveInstanceState(Bundle savedState) {

        super.onSaveInstanceState(savedState);
         
        // Note: getValues() is a method in your ArrayAdaptor subclass
         
       // savedState.put ("tabSelected", facturasList);
        savedState.putInt("tabSelected", actionBar.getSelectedNavigationIndex()  );
        

    }        
    
    
    
   


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(is.gonher.R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == is.gonher.R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
    
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        
        // Checks the orientation of the screen for landscape and portrait
       
    }    

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
    	/*

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }*/
    }
    
    
    private class TabListener<T extends Fragment> implements
    ActionBar.TabListener {
private Fragment mFragment;
private final Activity mActivity;
private final String mTag;
private final Class<T> mClass;

/**
 * Constructor used each time a new tab is created.
 *
 * @param activity
 *            The host Activity, used to instantiate the fragment
 * @param tag
 *            The identifier tag for the fragment
 * @param clz
 *            The fragment's Class, used to instantiate the fragment
 */
public TabListener(Activity activity, String tag, Class<T> clz ) {
    mActivity = activity;
    mTag = tag;
    mClass = clz;
    
}

public void onTabSelected(Tab tab, FragmentTransaction ft) {
    // Check if the fragment is already initialized
	mFragment = getSupportFragmentManager().findFragmentByTag(mTag);
    if (mFragment == null) {
        // If not, instantiate and add it to the activity
        mFragment = Fragment.instantiate(mActivity, mClass.getName());
        ft.add(android.R.id.content, mFragment, mTag);
    } else {
        // If it exists, simply attach it in order to show it
      //  ft.attach(mFragment);
        ft.show(mFragment);
    }
}

public void onTabUnselected(Tab tab, FragmentTransaction ft) {
	mFragment = getSupportFragmentManager().findFragmentByTag(mTag);
    if (mFragment != null) {
        // Detach the fragment, because another one is being attached
      //  ft.detach(mFragment);
        ft.hide(mFragment);
    }
}

public void onTabReselected(Tab tab, FragmentTransaction ft) {
    // User selected the already selected tab. Usually do nothing.
	//Toast.makeText(CobranzaActivity.this, "Reselected!", Toast.LENGTH_SHORT).show();
}
}    
    
    

}
