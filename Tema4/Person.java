import java.io.Serializable;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class Person implements Serializable,Observer {
	
	private String nume;
	private String cnp;
	private String adresa;
	public Person()
	{
		
	}
	public Person(String nume,String cnp,String adresa)
	{
		this.nume=nume;
		this.adresa=adresa;
		this.cnp=cnp;
		
	}
	public String getNume() {
		return nume;
	}
	public void setNume(String nume) {
		this.nume = nume;
	}
	public String getCnp() {
		return cnp;
	}
	public void setCnp(String cnp) {
		this.cnp = cnp;
	}
	public String getAdresa() {
		return adresa;
	}
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	@Override
	public int hashCode()
	{
		return Integer.parseInt(cnp.substring(0,8));
	}
	@Override 
	public boolean equals(Object p)
	{	
		if(this.hashCode()==((Person)p).hashCode())
			return true;
		else
			return false;
	}
	@Override
	public void update(Observable o, Object arg) {
		
		JOptionPane.showMessageDialog(null,"Contul a fost modificat, noua suma este "+ (double)arg);
		
		
	}

}
