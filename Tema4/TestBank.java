import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class TestBank {

	@Test
	void testAddPerson() {
		Bank b=new Bank();
		Person p=new Person("Raul Oancea","1892002323456","Strada Napoca nr 22");
		b.addPerson(p);
		assertEquals(b.getPersoane().containsKey(p),true);
	}

	@Test
	void testAddAccount() {
		Bank b=new Bank();
		Person p=new Person("Stanescu Stefan","1792912323456","Strada Napoca nr 29");
		Account a=new SpendingAccount("RO1234567890ABCEKGKALOPP",0,LocalDate.now(),"Stanescu Stefan");
		b.addPerson(p);
		b.addAccount(p, a);
		assertEquals(b.getPersoane().get(p).contains(a),true);
		assertEquals(a.getIban(),"RO1234567890ABCEKGKALOPP");
		assertEquals(a.getNume(),"Stanescu Stefan");
	}

	@Test
	void testAddMoney() {
		Bank b=new Bank();
		Person p=new Person("Podar Tudor","1952907323456","Strada Lunii nr 41");
		Account a=new SpendingAccount("ROXXX4567890ABCEKGKALOPP",0,LocalDate.now(),"Podar Tudor");
		b.addPerson(p);
		b.addAccount(p, a);
		b.addMoney(a, 200);
		assertEquals(a.getAmount(),200);
	}

	@Test
	void testWithdrawMoney() {
		Bank b=new Bank();
		Person p=new Person("Andrioaia Octavian","1822101323456","Calea Floresti nr 45");
		Account a=new SpendingAccount("ROXXXAF67890ABCEKGKALOPP",500,LocalDate.now(),"Andrioaia Octavian");
		b.addPerson(p);
		b.addAccount(p, a);
		b.withdrawMoney(a, 200);
		assertEquals(a.getAmount(),300);
	}

}
