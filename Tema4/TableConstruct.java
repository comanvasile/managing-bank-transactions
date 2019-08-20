

import java.lang.reflect.Field;

import java.util.ArrayList;
import java.util.List;



import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class TableConstruct<T> extends DefaultTableModel  {
	
//	private static final long serialVersionUID = 1L;
	private List <Object> data;
	
	public TableConstruct(List<Object> o) {
		data=new ArrayList<Object>(o);
		createTable();
		
	}
	private void createTable()
	{
		for(Field field: data.get(0).getClass().getDeclaredFields())
		{
			field.setAccessible(true);
			this.addColumn(field.getName());
		}
		
		for(Object o: data)
		{	int i=0;
			Object[] vectorData=new Object[this.getColumnCount()];
			Object value=new Object();
			for(Field field: o.getClass().getDeclaredFields())
			{
				field.setAccessible(true);
				try
				{
				
				value=field.get(o);
				vectorData[i]=value;
				i++;
				}
				catch(IllegalArgumentException e)
				{
					e.printStackTrace();
				}
				catch(IllegalAccessException e)
				{
					e.printStackTrace();
				}
				
			}
			this.addRow(vectorData);
		}
	}

}
