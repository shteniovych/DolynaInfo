package ua.vilish.dolunainfo;

import java.util.ArrayList;
import java.util.List;

public class IFDirectionManager 
{
	public List<IFDirectionProperty> _entries;
	
	public IFDirectionManager()
	{
		 _entries = new ArrayList<IFDirectionProperty>();
	}
	public void Add(IFDirectionProperty bus)
	{
		_entries.add(bus);
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
	public String[] GetArrayTime()
	{
		String[] time=new String[_entries.size()];
		for(int i=0;i<_entries.size();i++)
		{
			time[i]=_entries.get(i).time;
		}
		
		return time;
	}

}
