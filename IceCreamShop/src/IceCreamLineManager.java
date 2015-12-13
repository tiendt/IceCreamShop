import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class IceCreamLineManager extends JPanel{
	
	protected IceCreamLine line = new IceCreamLine();
	
	public IceCreamLineManager () {
		super();
		initGUI();
	}
	/**
	 * initiate GUI
	 */
	public void initGUI() {
		// use a border layout
		setLayout( new BorderLayout() );
		add(line, BorderLayout.CENTER);
		add(createRandomOrder(), BorderLayout.SOUTH);	
		
	}	
	
	/**
	 *  create a button. when button clicked, paint a new order
	 */
	protected JButton createRandomOrder () {	
		JButton order = new JButton( "Add a random order" );	
	
		order.addActionListener (
				new ActionListener() {
					public void actionPerformed (ActionEvent e) {

						line.addOrder();
						validate();
						repaint();
					}
					});
		return order;
	}


}
