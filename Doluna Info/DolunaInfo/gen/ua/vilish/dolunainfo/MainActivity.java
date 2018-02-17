package ua.vilish.dolunainfo;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	Button btnBus;
	Button btnTaxi;
	Button btnTrain;
	Button btnCafe;
	Button btnPhone;
	Button btnMap;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		btnBus = (Button) findViewById(R.id.btnBus);
		btnTaxi = (Button) findViewById(R.id.btnTaxi);
		btnTrain = (Button) findViewById(R.id.btnTrain);
		btnCafe = (Button) findViewById(R.id.btnCafe);
		btnPhone = (Button) findViewById(R.id.btnTel);
		btnMap = (Button) findViewById(R.id.bntMap);
		
		OnClickListener oclBtnTaxi = new OnClickListener() 
		{
			public void onClick(View v) 
			{
				Intent intent = new Intent(MainActivity.this,TaxiActivity.class);
				  startActivity(intent);
			}
		};
		btnTaxi.setOnClickListener(oclBtnTaxi);
		
		OnClickListener oclBtnBus = new OnClickListener() 
		{
			public void onClick(View v) 
			{
				Intent intent = new Intent(MainActivity.this,BusChoiseActivity.class);
				  startActivity(intent);
			}
		};
		btnBus.setOnClickListener(oclBtnBus);
		
		OnClickListener oclBtnMap = new OnClickListener() 
		{
			public void onClick(View v) 
			{
				Intent intent;
				intent = new Intent();
			      intent.setAction(Intent.ACTION_VIEW);
			      intent.setData(Uri.parse("geo:48.976626,23.986993"));
			      startActivity(intent);
			}
		};
		btnMap.setOnClickListener(oclBtnMap);
		
		
		OnClickListener oclBtnTrain = new OnClickListener() 
		{
			public void onClick(View v) 
			{
				Intent intent = new Intent(MainActivity.this,TrainActivity.class);
				  startActivity(intent);
			}
		};
		btnTrain.setOnClickListener(oclBtnTrain);

	}
	public void ClickAbout() 
	{
		String message = "Developer: Victor Shteniovych<br/>Vikish Corporation, 2016<br/>";
		Spanned myMessage = Html.fromHtml(message);
		
		AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
		builder.setTitle("Про програму")
			.setMessage(myMessage)
			.setIcon(R.drawable.about)
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
	
		public void ClickSettings() 
		{
			Intent intent = new Intent(MainActivity.this,SettingsActivity.class);
			startActivity(intent);
		}
		public void ClickNotes() 
		{
			Intent intent = new Intent(MainActivity.this,NotesActivity.class);
			startActivity(intent);
		}

		public void ClickHelp() 
		{
			String link1 = "<a href=\"http://www.google.com\">http://www.google.com</a>";
	        String message = "<p><b>Долинський довідник</b><br/><br/>" +
	                "Програма призначена для пошуку транспорту, також доступна функція знаходження номерів телефону закладів Долини і карта міста.</p>" +
	                "Ви можете дізнатися більш детально про функції програми на офіційному сайті компанії, залишити свої пропозиції та скарги.<br/><br/>" +
	                "Посилання на сайт:</p><br/>"
	                 +link1;
	        Spanned myMessage = Html.fromHtml(message);


	        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
	        builder.setTitle("Допомога");
	        builder.setIcon(R.drawable.help);
	        builder.setMessage(myMessage);
	        builder.setCancelable(true);
	        builder.setNegativeButton("Закрити",
					new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int id) {
					dialog.cancel();
				}
			});
	        AlertDialog alertDialog = builder.create();
	        alertDialog.show();
	        TextView msgTxt = (TextView) alertDialog.findViewById(android.R.id.message);
	        msgTxt.setMovementMethod(LinkMovementMethod.getInstance());
		}
	
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
		  menu.add(0, 1, 1, "Нотатки");
		  menu.add(0, 2, 2, "Про програму");
	      menu.add(0, 3, 3, "Довідка");
	      menu.add(0, 4, 4, "Налаштування");
	      menu.add(0, 5, 5, "Вихід");
       
      return super.onCreateOptionsMenu(menu);
    }
	 public boolean onOptionsItemSelected(MenuItem item) 
	 {
	      // TODO Auto-generated method stub

	     switch(item.getItemId())
	     {
	     case 1:

	    	 ClickNotes();
	    	 break;
	     case 2:
	    	 ClickAbout();
	    	 break;
	     case 3:
	    	 ClickHelp();
	    	 break;
	     case 4:
	    	 ClickSettings();
	    	 break;
	     case 5:
	    	 finish();
	    	 break;
	     }
	      
	     return super.onOptionsItemSelected(item);
	   }
}
