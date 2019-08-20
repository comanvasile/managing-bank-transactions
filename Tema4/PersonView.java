import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;



public class PersonView extends JFrame {
	private static final long serialVersionUID=1L;
	private JPanel panel=new JPanel(new GridBagLayout());
	GridBagConstraints c=new GridBagConstraints();
	private PersonController controller=new PersonController(this);
	private JButton b1=new JButton("Add person");
	private JButton b2=new JButton("Edit person");
	private JButton b3=new JButton("Delete person");
	private JButton b4=new JButton("View persons");
	private JLabel l1=new JLabel("Nume");
	private JLabel l2=new JLabel("CNP");
	private JLabel l3=new JLabel("Adresa");
	private JTextField tf1=new JTextField(10);
	private JTextField tf3=new JTextField(10);
	private JTextField tf2=new JTextField(10);
	private JTable table=new JTable();
	public JButton getB1() {
		return b1;
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
	public JTextField getTf1() {
		return tf1;
	}
	public JTextField getTf3() {
		return tf3;
	}
	public JTextField getTf2() {
		return tf2;
	}
	public JTable getTable() {
		return table;
	}
	public PersonView(String name)
	{
		super(name);
		c.gridx=0;
		c.gridy=0;
		panel.add(l1,c);
		c.gridx=0;
		c.gridy=1;
		panel.add(l2,c);
		c.gridx=0;
		c.gridy=2;
		panel.add(l3,c);
		c.gridx=1;
		c.gridy=0;
		panel.add(tf1,c);
		c.gridx=1;
		c.gridy=1;
		panel.add(tf2,c);
		c.gridx=1;
		c.gridy=2;
		panel.add(tf3,c);
		c.gridx=2;
		c.gridy=0;
		b1.addActionListener(controller);
		panel.add(b1,c);
		c.gridx=3;
		c.gridy=0;
		b2.addActionListener(controller);
		panel.add(b2,c);
		c.gridx=4;
		c.gridy=0;
		b3.addActionListener(controller);
		panel.add(b3,c);
		c.gridx=5;
		c.gridy=0;
		b4.addActionListener(controller);
		panel.add(b4,c);
		c.gridx=6;
		c.gridy=3;
		JScrollPane p=new JScrollPane(table);
		panel.add(p,c);
		
		this.add(panel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);	
	}
	
}
