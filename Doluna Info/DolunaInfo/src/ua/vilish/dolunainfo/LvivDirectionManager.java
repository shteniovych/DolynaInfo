package ua.vilish.dolunainfo;

import java.util.ArrayList;
import java.util.List;

public class LvivDirectionManager 
{
public List<LvivDirectionProperty> _entries;
	
	public LvivDirectionManager()
	{
		 _entries = new ArrayList<LvivDirectionProperty>();
	}
	public void Add(LvivDirectionProperty bus)
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
