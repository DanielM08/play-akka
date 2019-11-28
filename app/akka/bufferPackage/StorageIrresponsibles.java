package akka.bufferPackage;

import java.util.List;
import java.util.Vector; 

public class StorageIrresponsibles 
{
	private List<BufferRow> storage;
	private int count;

	public StorageIrresponsibles()
	{
		storage = new Vector<BufferRow>();
		this.count = 0;
	}
	
	public synchronized int set(BufferRow i) 
	{
		storage.add(i);
		return count++;
	}
	
	public List<BufferRow> get()
	{
		return storage;
	}
		
    public void printBuffer()
    {
    	for(BufferRow i : storage)
    	{
    		System.out.println(i.toString());
    	}
    }
    
    public int bufferSize()
    {
    	return storage.size();
    }
	
}
