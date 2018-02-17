package ua.vilish.dolunainfo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

 
 
public class TaxiActivity extends Activity {
 
	final String ATTRIBUTE_HomeNumber = "homePhone";
	final String ATTRIBUTE_Name = "name";
    final String ATTRIBUTE_MobileNumber = "mobilePhone";
    final String ATTRIBUTE_Address = "address";
    final String ATTRIBUTE_NAME_IMAGE = "image";
    
    Button btn;
	Cursor c = null;
	ListView lvSimple;
	ArrayAdapter<String> adapter;
	String[] names;
	String[] mobilePhone;
	
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.taxi);
    
    DatabaseHelper myDbHelper = new DatabaseHelper(TaxiActivity.this);
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
    
    myDbHelper.InitTaxi();

    ListView lvSimple;
   
      names = myDbHelper.taxmanag.GetArrayNames();
      String[] homePhone = myDbHelper.taxmanag.GetArrayHomeNumber();
      mobilePhone=myDbHelper.taxmanag.GetArrayMobileNumber();
      String[] address=myDbHelper.taxmanag.GetArrayAddress();
      int img = R.drawable.taxi_icon;
   
      ArrayList<Map<String, Object>> data = new ArrayList<Map<String, Object>>(
    		  homePhone.length);
      
      Map<String, Object> m;
      
      for (int i = 0; i < homePhone.length; i++) {
        m = new HashMap<String, Object>();
        m.put(ATTRIBUTE_Name, names[i]);
        m.put(ATTRIBUTE_HomeNumber, homePhone[i]);
        m.put(ATTRIBUTE_MobileNumber , mobilePhone[i]);
        m.put(ATTRIBUTE_Address , address[i]);
        m.put(ATTRIBUTE_NAME_IMAGE, img);
        data.add(m);
      }
   
      String[] from = {ATTRIBUTE_Name, ATTRIBUTE_HomeNumber,ATTRIBUTE_MobileNumber ,ATTRIBUTE_Address,
          ATTRIBUTE_NAME_IMAGE };

      int[] to = {R.id.tvName, R.id.tvHomeNumber,R.id.tvMobileNumber,R.id.tvAddress,  R.id.ivImg };
   
      SimpleAdapter sAdapter = new SimpleAdapter(this, data, R.layout.itemtaxi,
          from, to);
   
      lvSimple = (ListView) findViewById(R.id.lvSimple);
      lvSimple.setAdapter(sAdapter);
      
      
      lvSimple.setOnItemClickListener(new OnItemClickListener() {
          public void onItemClick(AdapterView<?> parent, View view,
              int position, long id) 
          {
        	  Intent intent;
    	      intent = new Intent(Intent.ACTION_DIAL);
    	      intent.setData(Uri.parse("tel:"+mobilePhone[position]));
    	      startActivity(intent);
          }
        });
  }
}