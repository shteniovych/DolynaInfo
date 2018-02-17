package ua.vilish.dolunainfo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.SQLException;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.AdapterView.OnItemClickListener;
 
 
public class CommuterFlightsActivity extends Activity {
	
	final String ATTRIBUTE_Name = "name";
    final String ATTRIBUTE_NAME_IMAGE = "image";
    

	Cursor c = null;
	ListView lvSimple;
	ArrayAdapter<String> adapter;
	String[] names;
	String[] time;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.commuterflights);
    
    DatabaseHelper myDbHelper = new DatabaseHelper(CommuterFlightsActivity.this);
    try {
        myDbHelper.createDataBase();
    } catch (IOException ioe) {
    	
        throw new Error("Unable to create database");
    }
    try {
        myDbHelper.openDataBase();
    } catch (SQLException sqle) {
    	
        throw sqle;
    }

    myDbHelper.InitCommuterFlights();
    ListView lvSimple;
    
    names = myDbHelper.CF.GetArrayNames();
    time = myDbHelper.CF.GetArrayTime();

    int img = R.drawable.train_icon;
 
    ArrayList<Map<String, Object>> data = new ArrayList<Map<String, Object>>(
  		  names.length);
    
    Map<String, Object> m;
    
    for (int i = 0; i < names.length; i++) {
      m = new HashMap<String, Object>();
      m.put(ATTRIBUTE_Name, names[i]);
      m.put(ATTRIBUTE_NAME_IMAGE, img);
      data.add(m);
    }
 
    String[] from = {ATTRIBUTE_Name, 
        ATTRIBUTE_NAME_IMAGE };

    int[] to = {R.id.tvName,R.id.ivImg };
 
    SimpleAdapter sAdapter = new SimpleAdapter(this, data, R.layout.itemif,
        from, to);
 
    lvSimple = (ListView) findViewById(R.id.lvSimple);
    lvSimple.setAdapter(sAdapter);
    
    
    lvSimple.setOnItemClickListener(new OnItemClickListener() {
        public void onItemClick(AdapterView<?> parent, View view,
            int position, long id) 
        {
        	String message;
        	message="Час відправлення з станції Долина:<br/><br/> "+time[position];
    		Spanned myMessage = Html.fromHtml(message);
    		
    		AlertDialog.Builder builder = new AlertDialog.Builder(CommuterFlightsActivity.this);
    		builder.setTitle("Розклад маршуту \n"+names[position])
    			.setMessage(myMessage)
    			.setIcon(R.drawable.train_icon32)
    			.setCancelable(false)
    			.setNegativeButton("Закрити",
    					new DialogInterface.OnClickListener() {
    						public void onClick(DialogInterface dialog, int id) {
    							dialog.cancel();
    						}
    					});
    		AlertDialog alert = builder.create();
    		alert.show();
        }
      });

    
  }
}
