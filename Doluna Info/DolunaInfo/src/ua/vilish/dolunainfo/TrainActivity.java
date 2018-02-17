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
import android.text.Editable;
import android.text.Html;
import android.text.Spanned;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
 
 
public class TrainActivity extends Activity {

	final String ATTRIBUTE_Name = "name";
    final String ATTRIBUTE_NAME_IMAGE = "image";
    

	Cursor c = null;
	ListView lvSimple;
	ArrayAdapter<String> adapter;
	String[] names;
	String[] time;
	
	EditText editText;
	ArrayList<Map<String, Object>> data;
	SimpleAdapter sAdapter;

	
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.train);
    
    editText=(EditText) findViewById(R.id.txtsearch);
    
    
    


    
    DatabaseHelper myDbHelper = new DatabaseHelper(TrainActivity.this);
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
    
    myDbHelper.InitTrain();
    ListView lvSimple;
    
    names = myDbHelper.trainmanag.GetArrayNames();
    time = myDbHelper.trainmanag.GetArrayTime();

    int img = R.drawable.train_icon;
 
    //ArrayList<Map<String, Object>> 
    data = new ArrayList<Map<String, Object>>(
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
 
    //SimpleAdapter ;
    sAdapter = new SimpleAdapter(this, data, R.layout.itemtrain,
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
    		
    		AlertDialog.Builder builder = new AlertDialog.Builder(TrainActivity.this);
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

    editText.addTextChangedListener(new TextWatcher() {

		@Override

  public void beforeTextChanged(CharSequence s, int start, int count, int 
		after) {

		

		}

		

		@Override

  public void onTextChanged(CharSequence s, int start, int before, int 
		count) {

 
			if(s.toString().equals("")){

			      // reset listview

			      //initList();

					}

			   else{

			    // perform search

			     searchItem(s.toString());

			  }


		}

		

		@Override

  public void afterTextChanged(Editable s) {

		

      }

  });		


    
  }
  public void searchItem(String textToSearch)
  {
	    for(String item:names)
	    {

	       if(!item.contains(textToSearch))
	       {

	    	   data.remove(item);
	       }

		}

	    adapter.notifyDataSetChanged();

  }
  
  
}