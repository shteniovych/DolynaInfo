package ua.vilish.dolunainfo;

import java.util.ArrayList;
import java.util.List;

public class TrainManager 
{
public List<TrainProperty> _entries;
	
	public TrainManager()
	{
		 _entries = new ArrayList<TrainProperty>();
	}
	public void Add(TrainProperty train)
	{
		_entries.add(train);
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
