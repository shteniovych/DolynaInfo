package ua.vilish.dolunainfo;

import java.util.ArrayList;
import java.util.List;

public class TaxiManager 
{
	public List<TaxiProperty> _entries;
	
	public TaxiManager()
	{
		 _entries = new ArrayList<TaxiProperty>();
	}
	public void Add(TaxiProperty taxi)
	{
		_entries.add(taxi);
	}
	public String[] GetArrayNames()
	{
		String[] names=new String[_entries.size()];
		for(int i=0;i<_entries.size();i++)
		{
			names[i]=_entries.get(i).name;
		}
		
		return names;
	}
	public String[] GetArrayHomeNumber()
	{
		String[] homeNumbers=new String[_entries.size()];
		for(int i=0;i<_entries.size();i++)
		{
			homeNumbers[i]=_entries.get(i).homeNumberPhone;
		}
		
		return homeNumbers;
	}
	public String[] GetArrayMobileNumber()
	{
		String[] mobileNumbers=new String[_entries.size()];
		for(int i=0;i<_entries.size();i++)
		{
			mobileNumbers[i]=_entries.get(i).mobileNumberPhone;
		}
		
		return mobileNumbers;
	}
	public String[] GetArrayAddress()
	{
		String[] addresses=new String[_entries.size()];
		for(int i=0;i<_entries.size();i++)
		{
			addresses[i]=_entries.get(i).address;
		}
		
		return addresses;
	}
	
}