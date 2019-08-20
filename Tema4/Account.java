import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;


@SuppressWarnings("serial")
public class Account extends Observable implements Serializable {
	private ArrayList<Observer> observers = new ArrayList<Observer>();
	private String iban;
	private double amount;
	private LocalDate date;
	private String nume;
	public Account(String iban,double amount,LocalDate date,String nume)
	{
		this.iban=iban;
		this.date=date;
		this.amount=amount;
		this.nume=nume;
	}
	public void addMoney(double suma)
	{
		this.setAmount(amount+suma);
		
	}
	public void withdrawMoney(double suma)
	{
		this.setAmount(amount-suma);
	}
	
	public String getIban() {
		return iban;
	}

	public String getNume() {
		return nume;
	}
	public void setNume(String nume) {
		this.nume = nume;
	}
	public void setIban(String iban) {
		this.iban = iban;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public LocalDate getDate() {
		return date;
	}
	
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public void notifyObservers(Observable observable,Object obj)
	{
		for(Observer o: observers)
		{
			o.update(observable,obj);
		}
	}
	public void registerObserver(Observer observer) {
		 observers.add(observer);
		
	}
	public void removeObserver(Observer observer)
	{
		observers.remove(observer);
	}
}
