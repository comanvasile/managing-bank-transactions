
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;



@SuppressWarnings("serial")
public class Bank implements BankProc,Serializable {
	

	private Map <Person,ArrayList<Account>> persoane;

	public Bank()
	{		
		persoane=new Hashtable<Person,ArrayList<Account>>();
			read();
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void read()
	{
		
	      try {
	         FileInputStream fileIn = new FileInputStream("D:\\School - V\\java projects\\Tema4\\Bank.ser");
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         persoane = (Map) in.readObject();
	         in.close();
	         fileIn.close();
	      } catch (IOException i) {
	         i.printStackTrace();
	         return;
	      } catch (ClassNotFoundException c) {
	         System.out.println("Accout class or Person class not found");
	         c.printStackTrace();
	         return;
	      }
	      
	}
	public void write()
	{
		 try {
	         FileOutputStream fileOut =
	         new FileOutputStream("D:\\School - V\\java projects\\Tema4\\Bank.ser");
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(persoane);
	         out.close();
	         fileOut.close();
	         System.out.printf("Serialized data is saved in bank.ser");
	      } catch (IOException i) {
	         i.printStackTrace();
	      }
	}
	@Override
	public void addPerson(Person p) {
		
		assert p!=null:"persoana pe care dorim sa o adaugam sa fie existenta";
		int size=persoane.size();
		
		
		persoane.put(p,new ArrayList<Account>());
		write();
		assert persoane.containsKey(p)==true: "sa contina cheia  ";
		assert persoane.size()==size+1: "size-ul trebuie sa creasca cu o unitate ";
	
	}
	@Override
	public void editPerson(Person p,Person np)
	{
		assert p!=null:"persoana existenta ";
		int size=persoane.size();
		
			
			persoane.put(np,persoane.get(p));
			persoane.remove(p);
			write();
		
		assert persoane.size()==size: "dimensiune sa ramana nemodificata";
		assert persoane.containsKey(np)==true: "sa contina cheia  ";
		
	}
	@Override
	public void removePerson(Person p) {
		
		assert persoane.containsKey(p)==true: "sa contina persoana";
		int size=persoane.size();
		
		persoane.remove(p);
		write();
		
		
		assert persoane.size()==size-1: "sizeul trebuie sa fie mai mic cu o unitate";
		assert persoane.containsKey(p)==false:"nu trebuie sa se mai gaseasca acea persoana "; 
	}
	@Override
	public void addAccount(Person p,Account a) {
		
		assert p!=null && a!=null: "elemente existente";
		int size=persoane.size();
		
		persoane.get(p).add(a);
		a.registerObserver(p);
		write();
			
		assert persoane.size()==size: " size neschimbat ";
		assert persoane.get(p).contains(a)==true;
	}
	@Override
	public void editAccount(Person p,Account a,Account na,Person np)
	{
		assert a!=null && p!=null && na!=null && np!=null;
		int size=persoane.size();
		
		a.removeObserver(p);
		persoane.get(p).remove(a);
		persoane.get(np).add(na);
		na.registerObserver(np);
		write();
		assert persoane.get(np).contains(na)==true;
		assert persoane.size()==size: "size neschimbat";
	}
	@Override
	public void removeAccount(Person p,Account a) {
		
		assert a!=null;
		int size=persoane.size();
		
		a.removeObserver(p);
		persoane.get(p).remove(a);
		write();
		
		assert persoane.size()==size;
		assert persoane.get(p).contains(a)==false;
	}
	public void addMoney(Account a,double suma)
	{
		assert a!=null;
		double amount=a.getAmount();
		
		if(suma<=0)
			throw new IllegalArgumentException();
		a.addMoney(suma);
		write();
		
		assert a.getAmount()==amount+suma;
	}
	public void withdrawMoney(Account a,double suma)
	{
		assert a!=null;
		double amount=a.getAmount();
		
		if(suma>a.getAmount())
			throw new IllegalArgumentException();
		a.withdrawMoney(suma);
		write();
		
		assert a.getAmount()==amount-suma;
	}
	public void refreshAccount(Account a)
	{
		((SavingAccount) a).refreshAccount();
		write();
		
	}
	public Map<Person, ArrayList<Account>> getPersoane() {
		return persoane;
	}
	public boolean isWellFormed()
	{
		int n=0;
		Iterator<Person> iterator=persoane.keySet().iterator();
		for(Person p=iterator.next();p!=null;)
		{
			n++;
		}
		return n==persoane.size();
	}
	
	
	
	
	
}
