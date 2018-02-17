package ua.vilish.dolunainfo;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {
	 
	TaxiManager taxmanag=new TaxiManager();
	TrainManager trainmanag=new TrainManager();
	IFDirectionManager IFD=new IFDirectionManager();
	CommuterFlightsManager CF=new CommuterFlightsManager();
	InternationalTransportManager IT=new InternationalTransportManager();
	LvivDirectionManager LV=new LvivDirectionManager();
	
	//public Cursor c=null;
    String DB_PATH = null;
    
    private static String DB_NAME = "DolunaInfo4.sqlite";
    private SQLiteDatabase myDataBase;
    private final Context myContext;
 
    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, 10);
        this.myContext = context;
        this.DB_PATH = "/data/data/" + context.getPackageName() + "/" + "databases/";
        Log.e("Path 1", DB_PATH);
    }
 
 
    public void createDataBase() throws IOException {
        boolean dbExist = checkDataBase();
        if (dbExist) {
        } else {
            this.getReadableDatabase();
            try {
                copyDataBase();
            } catch (IOException e) {
                throw new Error("Error copying database");
            }
        }
    }
 
    private boolean checkDataBase() {
        SQLiteDatabase checkDB = null;
        try {
            String myPath = DB_PATH + DB_NAME;
            checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        } catch (SQLiteException e) {
        }
        if (checkDB != null) {
            checkDB.close();
        }
        return checkDB != null ? true : false;
    }
 
    private void copyDataBase() throws IOException {
        InputStream myInput = myContext.getAssets().open(DB_NAME);
        String outFileName = DB_PATH + DB_NAME;
        OutputStream myOutput = new FileOutputStream(outFileName);
        byte[] buffer = new byte[10];
        int length;
        while ((length = myInput.read(buffer)) > 0) {
            myOutput.write(buffer, 0, length);
        }
        myOutput.flush();
        myOutput.close();
        myInput.close();
 
    }
 
    public void openDataBase() throws SQLException {
        String myPath = DB_PATH + DB_NAME;
        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
 
    }
 
    @Override
    public synchronized void close() {
        if (myDataBase != null)
            myDataBase.close();
        super.close();
    }
 
 
    @Override
    public void onCreate(SQLiteDatabase db) {
    }
 
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (newVersion > oldVersion)
            try {
                copyDataBase();
            } catch (IOException e) {
                e.printStackTrace();
 
            }
    }
 
    public Cursor queryTaxi(String table, String[] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBy) {
    	
        return myDataBase.query("taxi", null, null, null, null, null, null);
    }
    
public Cursor queryTrain(String table, String[] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBy) {
    	
        return myDataBase.query("train", null, null, null, null, null, null);
    }

    public void InitTaxi ()
    {
    	
        Cursor c;
        TaxiProperty temp;
        c=myDataBase.query("taxi", null, null, null, null, null, null);
        if (c.moveToFirst()) 
        {
            do {
            	temp=new TaxiProperty();
            	
            	temp.name=c.getString(1);
            	temp.homeNumberPhone=c.getString(2);
            	temp.mobileNumberPhone=c.getString(3);
            	temp.address=c.getString(4);
            	
            	taxmanag.Add(temp);
                                
                        
            } while (c.moveToNext());
        }
        
    }
    
    public void InitTrain ()
    {
    	
    	Cursor c;
        TrainProperty temp;
        c=myDataBase.query("train", null, null, null, null, null, null);
        if (c.moveToFirst()) 
        {
            do {
            	temp=new TrainProperty();
            	
            	temp.name=c.getString(1);
            	temp.time=c.getString(2);

            	
            	
            	trainmanag.Add(temp);
                                
                        
            } while (c.moveToNext());
        }

    }
    
    public void InitIFDirection ()
    {
    	
    	Cursor c;
    	IFDirectionProperty temp;
        c=myDataBase.query("IFDirection", null, null, null, null, null, null);
        if (c.moveToFirst()) 
        {
            do {
            	temp=new IFDirectionProperty();
            	
            	temp.name=c.getString(1);
            	temp.time=c.getString(2);

            	IFD.Add(temp);
                                
                        
            } while (c.moveToNext());
        }

    }
    
    public void InitCommuterFlights ()
    {
    	
    	Cursor c;
    	CommuterFlightsProperty temp;
        c=myDataBase.query("CommuterFlights", null, null, null, null, null, null);
        if (c.moveToFirst()) 
        {
            do {
            	temp=new CommuterFlightsProperty();
            	
            	temp.name=c.getString(1);
            	temp.time=c.getString(2);

            	
            	
            	CF.Add(temp);
                                
                        
            } while (c.moveToNext());
        }

    }
    
    public void InitInternationalTransport ()
    {
    	
    	Cursor c;
    	InternationalTransportProperty temp;
        c=myDataBase.query("InternationalTransport", null, null, null, null, null, null);
        if (c.moveToFirst()) 
        {
            do {
            	temp=new InternationalTransportProperty();
            	
            	temp.name=c.getString(1);
            	temp.time=c.getString(2);

            	
            	
            	IT.Add(temp);
                                
                        
            } while (c.moveToNext());
        }

    }
    
    public void InitLvivDirection()
    {
    	
    	Cursor c;
    	LvivDirectionProperty temp;
        c=myDataBase.query("LvivDirection", null, null, null, null, null, null);
        if (c.moveToFirst()) 
        {
            do {
            	temp=new LvivDirectionProperty();
            	
            	temp.name=c.getString(1);
            	temp.time=c.getString(2);

            	
            	
            	LV.Add(temp);
                                
                        
            } while (c.moveToNext());
        }

    }
 
 
}