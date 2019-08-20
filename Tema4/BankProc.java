
public interface BankProc {
	public void addPerson(Person p);
	public void removePerson(Person p);
	public void editPerson(Person p,Person np);
	public void addAccount(Person p, Account a);
	public void removeAccount(Person p, Account a);
	public void editAccount(Person p, Account a, Account na,Person np);
	public void addMoney(Account a,double suma);
	public void withdrawMoney(Account a,double suma);

	
}
