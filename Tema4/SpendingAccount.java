import java.time.LocalDate;


@SuppressWarnings("serial")
public class SpendingAccount extends Account {

	public SpendingAccount(String iban, double amount, LocalDate date,String nume) {
		super(iban, amount, date,nume);
		
	}
	public void addMoney(double suma)
	{
		
			super.addMoney(suma);
			this.setChanged();
			this.notifyObservers(this,this.getAmount());
		
	}
	@Override
	public void withdrawMoney(double suma)
	{
		
			super.withdrawMoney(suma);
			this.setChanged();
			this.notifyObservers(this,this.getAmount());
		
	}

}
