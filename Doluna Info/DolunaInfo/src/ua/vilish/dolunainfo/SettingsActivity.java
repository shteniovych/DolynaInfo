package ua.vilish.dolunainfo;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
 
 
public class SettingsActivity extends Activity {
 
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.settings);
    
    Button btnRemark= (Button) findViewById(R.id.btnRemark);
    Button btnVK= (Button) findViewById(R.id.btnVK);
    Button btnEstimate= (Button) findViewById(R.id.btnEstimate);
    Button btnSayt= (Button) findViewById(R.id.btnSayt);
    Button btnApplause= (Button) findViewById(R.id.btnApplause);
    
    OnClickListener oclBtnVK = new OnClickListener() 
	{
		public void onClick(View v) 
		{
			Intent intent;
			intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://developer.android.com"));
		      startActivity(intent);
		}
	};
	btnVK.setOnClickListener(oclBtnVK);
    
	
    OnClickListener oclBtnSayt = new OnClickListener() 
	{
		public void onClick(View v) 
		{
			Intent intent;
			intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://developer.android.com"));
		    startActivity(intent);
		}
	};
	btnSayt.setOnClickListener(oclBtnSayt);
	
	
	OnClickListener oclBtnGP = new OnClickListener() 
	{
		public void onClick(View v) 
		{
			Intent intent;
			intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/newsstand/news/Roem_ru?id=CAowoYTpBw&hl=ru"));
		    startActivity(intent);
		}
	};
	btnEstimate.setOnClickListener(oclBtnGP);
	
	
  }
}
