import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;

import java.util.List;
import java.util.Random;

import javax.swing.JOptionPane;


public class AccountController implements ActionListener {

	private AccountView view;
	public AccountController(AccountView view)
	{
		this.view=view;
		
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		Bank b=new Bank();
	
		final String alphabet = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	    final int N = alphabet.length();
	    Random r = new Random();
	    String iban=new String("RO");
	    Account a;
		Object source=e.getSource();
		
		if(source==view.getB1())
		{
			view.getTable().setVisible(false);
			view.getTable2().setVisible(false);
			for (int i = 0; i < 22; i++) {
				iban=iban+alphabet.charAt(r.nextInt(N));
		    }
			
			if(view.getCb2().getSelectedItem().equals("Spending Account"))
			{
				 a=new SpendingAccount(iban,0,LocalDate.now(), (String)view.getCb().getSelectedItem());
			}
			else
			{
				 a=new SavingAccount(iban,0,LocalDate.now(),new Double(view.getTf1().getText()),(String)view.getCb().getSelectedItem());
				 view.getTf1().setText(null);
			}
			Person p=new Person();
			for(Person pers: b.getPersoane().keySet())
			{
				if(pers.getNume().equals(view.getCb().getSelectedItem()))
					p=pers;
			}
			b.addAccount(p,a);
		}
		else if(source==view.getB2())
		{
			for (int i = 0; i < 22; i++) {
				iban=iban+alphabet.charAt(r.nextInt(N));
		    }
			Account na;
			if(view.getCb2().getSelectedItem().equals("Spending Account"))
			{
				 na=new SpendingAccount(iban,0,LocalDate.now(), (String)view.getCb().getSelectedItem());
			}
			else
			{
				 na=new SavingAccount(iban,0,LocalDate.now(),new Double(view.getTf1().getText()),(String)view.getCb().getSelectedItem());
				 view.getTf1().setText(null);
			}
			
			int index=view.getTable().getSelectedRow();
			int i=0;
			Person p=new Person();
			Person np=new Person();
			for(ArrayList<Account> list: b.getPersoane().values())
			{	
				for(Account ac: list)
				{	
					
					if(ac instanceof SavingAccount)
					{
						if(i==index)
						{
							for(Person pers: b.getPersoane().keySet())
							{
								if(pers.getNume().equals(ac.getNume()))
								p=pers;
								if(pers.getNume().equals(na.getNume()))
								np=pers;
							}
							na.setAmount(ac.getAmount());
							b.editAccount(p, ac, na,np);
							return;
						}
					i++;
					}
				}
				
			}
			for(ArrayList<Account> list: b.getPersoane().values())
			{
				for(Account ac: list)
				{
					if(ac instanceof SpendingAccount)
					{
						if(i==index)
						{
							for(Person pers: b.getPersoane().keySet())
							{
								if(pers.getNume().equals(ac.getNume()))
								p=pers;
								if(pers.getNume().equals(na.getNume()))
									np=pers;
							}
							na.setAmount(ac.getAmount());
							b.editAccount(p, ac, na,np);
							return;
						}
						i++;
					}
				}
			}
		}
		else if(source==view.getB3())
		{
			int i=0;
			Person p=new Person();
			int index=view.getTable().getSelectedRow();
			for(ArrayList<Account> list: b.getPersoane().values())
			{
				for(Account ac: list)
				{
					if(ac instanceof SavingAccount)
					{
						if(index==i)
						{
							for(Person pers: b.getPersoane().keySet())
							{
								if(pers.getNume().equals(ac.getNume()))
								p=pers;
							}
							b.removeAccount(p, ac);
							return;
						}
						i++;
					}
				}
			}
			for(ArrayList<Account> list: b.getPersoane().values())
			{
				for(Account ac: list)
				{
					if(ac instanceof SpendingAccount)
					{
						if(index==i)
						{
							for(Person pers: b.getPersoane().keySet())
							{
								if(pers.getNume().equals(ac.getNume()))
								p=pers;
							}
							b.removeAccount(p, ac);
							return;
						}
						i++;
					}
				}
			}
		}
		else if(source==view.getB4())
		{
			
			for(ArrayList<Account> list: b.getPersoane().values())
			{
				for(Account ac: list)
				{
					if(ac instanceof SavingAccount)
					{
						b.refreshAccount(ac);
					}
				}
			}
			List<Object> o=new ArrayList<Object>();
			List<Object> o2=new ArrayList<Object>();
			
			for(ArrayList<Account> list:b.getPersoane().values())
			{
				for(Account ac: list)
				{
					if(ac instanceof SavingAccount)
					{
						o.add(ac);
						o2.add(new Account(ac.getIban(),ac.getAmount(),ac.getDate(),ac.getNume()));
					}
					
				}
			}
			for(ArrayList<Account> list:b.getPersoane().values())
			{
				for(Account ac: list)
				{
					if(ac instanceof SpendingAccount)
					{	
						o.add(ac);
						o2.add(new Account(ac.getIban(),ac.getAmount(),ac.getDate(),ac.getNume()));
					}
					
				}
			}
			view.setComboBox();
			view.getTable2().setModel(new TableConstruct<SavingAccount>(o));
			view.getTable().setModel(new TableConstruct<Account>(o2));
			view.getTable().setVisible(true);
			view.getTable2().setVisible(true);
		}
		else if(source==view.getB5())
		{

			int index=view.getTable().getSelectedRow(); 
			int i=0;
			
			for(ArrayList<Account> list: b.getPersoane().values())
			{
				for(Account ac: list)
				{
					if(ac instanceof SavingAccount)
					{
						if(index==i)
						{
							try {
								b.addMoney(ac,new Double(view.getTf2().getText()));
							}
							catch(Exception ex)
							{
								JOptionPane.showMessageDialog(view," Suma pe care doriti sa o retrageti nu are formatul asteptat ");
							}
							view.getTf2().setText(null);
							return;
						}
						i++;
					}
				}
			}
			for(ArrayList<Account> list: b.getPersoane().values())
			{
				for(Account ac: list)
				{
					if(ac instanceof SpendingAccount)
					{
						if(index==i)
						{
							try {
							b.addMoney(ac,new Double(view.getTf2().getText()));
							}
							catch(Exception ex)
							{
								JOptionPane.showMessageDialog(view," Suma pe care doriti sa o retrageti nu are formatul asteptat ");
							}
							view.getTf2().setText(null);
							return;
						}
						i++;
					}
				}
			}
	
		}
		else if(source==view.getB6())
		{
			int index=view.getTable().getSelectedRow(); 
			int i=0;
		
			for(ArrayList<Account> list: b.getPersoane().values())
			{
				for(Account ac: list)
				{
					if(ac instanceof SavingAccount)
					{
						if(index==i)
						{
							try
							{
							b.withdrawMoney(ac,new Double(view.getTf2().getText()));
							}
							catch (Exception ex)
							{
								JOptionPane.showMessageDialog(view,"Fonduri insuficiente");
							}
							view.getTf2().setText(null);
							return;
						}
						i++;
					}
				}
			}
			for(ArrayList<Account> list: b.getPersoane().values())
			{
				for(Account ac: list)
				{
					if(ac instanceof SpendingAccount)
					{
						if(index==i)
						{
							try
							{
							b.withdrawMoney(ac,new Double(view.getTf2().getText()));
							}
							catch (Exception ex)
							{
								JOptionPane.showMessageDialog(view,"Fonduri insuficiente");
							}
							view.getTf2().setText(null);
							return;
						}
						i++;
					}
				}
			}
	
		}
		
		
		
	}
	

}
