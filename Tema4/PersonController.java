import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;





public class PersonController implements ActionListener {
	private PersonView view;
	public PersonController(PersonView view)
	{
		this.view=view;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source=e.getSource();
		Bank b=new Bank();
		if(source==view.getB1())
		{
			view.getTable().setVisible(false);
			Person p=new Person(view.getTf1().getText(),view.getTf2().getText(),view.getTf3().getText());
			b.addPerson(p);
			view.getTf1().setText(null);
			view.getTf2().setText(null);
			view.getTf3().setText(null);
		}
		else if(source==view.getB2())
		{
			Person np=new Person(view.getTf1().getText(),view.getTf2().getText(),view.getTf3().getText());
			int index=view.getTable().getSelectedRow();
			int i=0;
			for(Person p:b.getPersoane().keySet())
			{
				if(i==index)
				{
					b.editPerson(p, np);
					return;
				}
				i++;
			}
			view.getTf1().setText(null);
			view.getTf2().setText(null);
			view.getTf3().setText(null);
		}
		else if(source==view.getB3())
		{
			int index=view.getTable().getSelectedRow();
			int i=0;
			for(Person p:b.getPersoane().keySet())
			{
				if(index==i)
				{
					b.removePerson(p);
					return;
				}
					i++;
			}
			
		}
		else if(source==view.getB4())
		{
			List<Object> o=new ArrayList<Object>();
			o.addAll(b.getPersoane().keySet());
			view.getTable().setModel(new TableConstruct<Person>(o));
			view.getTable().setVisible(true);
		}
	}


}
