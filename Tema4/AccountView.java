import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class AccountView extends JFrame {
	private static final long serialVersionUID=1L;
	private JPanel panel=new JPanel(new GridBagLayout());
	GridBagConstraints c=new GridBagConstraints();
	private AccountController controller=new AccountController(this);
	private JLabel l1=new JLabel("Titularul contului");
	private JLabel l2=new JLabel("Tip");
	private JLabel l3=new JLabel("Dobanda");
	private JLabel l4=new JLabel("Suma");
	private JTextField tf1=new JTextField(5);
	private JTextField tf2=new JTextField(5);
	private JComboBox<String> cb2=new JComboBox<String>();
	private JButton b1=new JButton("Add account");
	private JButton b2=new JButton("Edit account");
	private JButton b3=new JButton("Delete account");
	private JButton b4=new JButton("View accounts");
	private JButton b5=new JButton("Add money");
	private JButton b6=new JButton("Withdraw money");
	private JTable table=new JTable();
	private JTable table2=new JTable();
	public JComboBox<String> getCb() {
		return cb;
	}
	private JComboBox<String> cb=new JComboBox<String>();
	
	public AccountView(String name)
	{
		super(name);
		Bank b=new Bank();
		for(Person p:b.getPersoane().keySet())
		{
			cb.addItem(p.getNume());
		}
		c.gridx=0;
		c.gridy=0;
		panel.add(l1,c);
		c.gridx=1;
		c.gridy=0;
		panel.add(cb,c);
		cb2.addItem("Spending Account");
		cb2.addItem("Saving Account");
		c.gridx=0;
		c.gridy=1;
		panel.add(l2,c);
		c.gridx=1;
		c.gridy=1;
		panel.add(cb2,c);
		c.gridx=0;
		c.gridy=2;
		panel.add(l3,c);
		c.gridx=1;
		c.gridy=2;
		panel.add(tf1,c);
		c.gridx=2;
		c.gridy=0;
		panel.add(b1,c);
		b1.addActionListener(controller);
		c.gridx=3;
		c.gridy=0;
		panel.add(b2,c);
		b2.addActionListener(controller);
		c.gridx=4;
		c.gridy=0;
		panel.add(b3,c);
		b3.addActionListener(controller);
		c.gridx=5;
		c.gridy=0;
		panel.add(b4,c);
		b4.addActionListener(controller);
		JScrollPane s=new JScrollPane(table);
		c.gridx=0;
		c.gridy=3;
		panel.add(s,c);
		JScrollPane s2=new JScrollPane(table2);
		c.gridx=1;
		c.gridy=3;
		panel.add(s2,c);
		c.gridx=2;
		c.gridy=1;
		panel.add(l4,c);
		c.gridx=3;
		c.gridy=1;
		panel.add(tf2,c);
		c.gridx=4;
		c.gridy=1;
		panel.add(b5,c);
		b5.addActionListener(controller);
		b6.addActionListener(controller);
		c.gridx=5;
		c.gridy=1;
		panel.add(b6,c);
		this.add(panel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);	
	}
	public JTextField getTf2() {
		return tf2;
	}
	public JButton getB5() {
		return b5;
	}
	public JButton getB6() {
		return b6;
	}
	public JTable getTable2() {
		return table2;
	}
	public JButton getB2() {
		return b2;
	}
	public JButton getB3() {
		return b3;
	}
	public JButton getB4() {
		return b4;
	}
	public JTable getTable() {
		return table;
	}
	public JButton getB1() {
		return b1;
	}
	public JLabel getL3() {
		return l3;
	}
	public JTextField getTf1() {
		return tf1;
	}
	public JComboBox<String> getCb2() {
		return cb2;
	}
	public void setComboBox()
	{
		Bank b=new Bank();
		cb.removeAllItems();
		for(Person p:b.getPersoane().keySet())
		{
			cb.addItem(p.getNume());
		}
	}
}
