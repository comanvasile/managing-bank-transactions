import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;



public class MenuView extends JFrame {
	private static final long serialVersionUID=1L;
	private JPanel panel=new JPanel(new GridBagLayout());
	GridBagConstraints c=new GridBagConstraints();
	private JButton b1=new JButton("Persoane");
	public JButton getB1() {
		return b1;
	}
	public JButton getB2() {
		return b2;
	}
	
	private JButton b2=new JButton("Conturi");

	private MenuController controller=new MenuController(this);
	public MenuView(String nume)
	{
		super(nume);
		c.gridx=0;
		c.gridy=0;
		panel.add(b1, c);
		b1.addActionListener(controller);
		c.gridx=0;
		c.gridy=1;
		panel.add(b2, c);
		b2.addActionListener(controller);
		this.add(panel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);	
	}
}
