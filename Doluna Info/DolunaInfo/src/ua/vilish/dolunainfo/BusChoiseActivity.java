package ua.vilish.dolunainfo;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
 
 
public class BusChoiseActivity extends Activity {
 
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.buschoise);
    
    
    ActionBar actionBar = getActionBar();
    actionBar.setHomeButtonEnabled(true);
    actionBar.setDisplayHomeAsUpEnabled(true);
    
    Button btnIF;
    btnIF = (Button) findViewById(R.id.bntIF);
    
    Button btnRD;
    btnRD = (Button) findViewById(R.id.btnRD);
    
    Button btnZAK;
    btnZAK = (Button) findViewById(R.id.btnZAK);
    
    Button btnPrum;
    btnPrum = (Button) findViewById(R.id.btnPrum);
    
    Button btnInter;
    btnInter=(Button) findViewById(R.id.btnInter);
    
    Button btnLviv;
    btnLviv = (Button) findViewById(R.id.btnLviv);
    
    OnClickListener oclBtnIF = new OnClickListener() 
	{
		public void onClick(View v) 
		{
			Intent intent = new Intent(BusChoiseActivity.this,IFDirectionActivity.class);
			startActivity(intent);
		}
	};
	btnIF.setOnClickListener(oclBtnIF);
	
	OnClickListener oclBtnRD = new OnClickListener() 
	{
		public void onClick(View v) 
		{
			Intent intent = new Intent(BusChoiseActivity.this,RemDedActivity.class);
			startActivity(intent);
		}
	};
	btnRD.setOnClickListener(oclBtnRD);
	
	
	OnClickListener oclBtnPrum = new OnClickListener() 
	{
		public void onClick(View v) 
		{
			Intent intent = new Intent(BusChoiseActivity.this,CommuterFlightsActivity.class);
			startActivity(intent);
		}
	};
	btnPrum.setOnClickListener(oclBtnPrum);
	
	
	OnClickListener oclBtnZak = new OnClickListener() 
	{
		public void onClick(View v) 
		{
			Intent intent = new Intent(BusChoiseActivity.this,TranscarpDirectionActivity.class);
			startActivity(intent);
		}
	};
	btnZAK.setOnClickListener(oclBtnZak);
	
	
	OnClickListener oclBtnInter = new OnClickListener() 
	{
		public void onClick(View v) 
		{
			Intent intent = new Intent(BusChoiseActivity.this,InternationalTransportActivity.class);
			startActivity(intent);
		}
	};
	btnInter.setOnClickListener(oclBtnInter);
	
	
	OnClickListener oclBtnLviv = new OnClickListener() 
	{
		public void onClick(View v) 
		{
			Intent intent = new Intent(BusChoiseActivity.this,LvivDirectionActivity.class);
			startActivity(intent);
		}
	};
	btnLviv.setOnClickListener(oclBtnLviv);
  }
  //Повернення назад
  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
      switch (item.getItemId()) {
          case android.R.id.home:
              startActivity(new Intent(this, MainActivity.class));
              return true;
          default:
              return super.onOptionsItemSelected(item);
      }
  }
}
