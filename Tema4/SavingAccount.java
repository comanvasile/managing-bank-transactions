import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class SavingAccount extends Account {
	private double dobanda;
	private boolean depus;
	private boolean retras;
	public SavingAccount(String iban, int amount, LocalDate date,double dobanda,String nume) {
		super(iban, amount, date,nume);
		this.dobanda=dobanda;
		this.depus=false;
		this.retras=false;
	}
	

	public double getDobanda() {
		return dobanda;
	}


	public void setDobanda(double dobanda) {
		this.dobanda = dobanda;
	}
	@Override
	public void addMoney(double suma)
	{
		if(this.depus==false)
		{
			this.depus=true;
			this.setDate( LocalDate.now());
			super.addMoney(suma);
			this.setChanged();
			this.notifyObservers(this,this.getAmount());
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Ati efectuat deja o depunere");
		}
	}
	@Override
	public void withdrawMoney(double suma)
	{
		if(this.retras==false)
		{
			this.retras=true;
			super.withdrawMoney(suma);
			this.setChanged();
			this.notifyObservers(this,this.getAmount());
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Ati efectuat deja o retragere");

		}
	}
	public void refreshAccount()
	{
		long days = ChronoUnit.DAYS.between(this.getDate(),LocalDate.now());
		this.setAmount(this.getAmount()+(double)days*this.getAmount()*dobanda);
	}
	public boolean isDepus() {
		return depus;
	}

	public void setDepus(boolean depus) {
		this.depus = depus;
	}

	public boolean isRetras() {
		return retras;
	}

	public void setRetras(boolean retras) {
		this.retras = retras;
	}
	
}
