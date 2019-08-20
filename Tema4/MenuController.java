import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;





public class MenuController implements ActionListener {
	private MenuView view;
	public MenuController(MenuView view)
	{
		this.view=view;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source=e.getSource();
		if(source==view.getB1())
		{
			@SuppressWarnings("unused")
			JFrame frame=new PersonView("Persoane");
		}
		else if(source==view.getB2())
		{
			@SuppressWarnings("unused")
			JFrame frame=new AccountView("Conturi");
		}
	
		
	}
	public static void main(String[] args)
	{
	
		@SuppressWarnings("unused")
		JFrame frame=new MenuView("Banca");
	}

}
