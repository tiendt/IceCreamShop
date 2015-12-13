
// awt
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// swing 
import javax.swing.JButton;
import javax.swing.JPanel;

public class IceCreamMaker extends JPanel {

	protected IceCreamCone cone;
	
	public IceCreamMaker() {
		super();
		cone= new IceCreamCone();
		initGUI();	
	}
	
		/**
		 * private method to create the GUI components
		 * returns the created main panel
		 */
	
		private void initGUI()
		{
			// use a border layout
			setLayout( new BorderLayout() );
			
			// create panel for "ordering" the cone
			// and add to center
			
			add( createTopPanel(), BorderLayout.NORTH );
			
			// create panel for drawing the ice cream cone
			// and add to center
			add(  cone, BorderLayout.CENTER );	
		}
		
		/**
		 * getter for the cone
		 * @return cone
		 */
		protected IceCreamCone getCone() {
			return cone;
		}
		
		/**
		 * method to remove all scoops of the ice cream
		 * @return
		 */
		public IceCreamCone removeAllScoop() {
			
			if (cone.getStack().isEmpty()) {
				return null;
			}
			//a temporary ice cream cone
			IceCreamCone coneLocal = new IceCreamCone();
			
			//set stack of coneLocoal to be the stack of original cone
			coneLocal.setStack(cone.getStack()) ;
			
			//cone is now pointing to a new stack -- remove scoops
			cone.setStack(new StackLL<String>());
			cone.repaint();
			return coneLocal;
		}
		
		public JPanel createTopPanel() {
			JPanel topP = new JPanel(); 
			topP.setLayout(new BorderLayout());
			topP.add( createFlavorPanel(), BorderLayout.NORTH );
			topP.add (createTrashButton(), BorderLayout.SOUTH);
			return topP;
			
		}
		
		/**
		 * If the wrong scoop is accidentally added, 
		 * clicking the "trash the top scoop button" will remove it
		 */
		
		private JButton createTrashButton () {
			// create a button
			JButton trashB = new JButton( "Trash the top scoop" );	

			trashB.addActionListener (
					new ActionListener() {
						public void actionPerformed (ActionEvent e) {
						
							cone.trashScoop ();
							cone.repaint();
						}
						});
			return trashB;
		}
		
		/**
		 * add 4 buttons to a panel
		 */
		private JPanel createFlavorPanel() {
			
			JPanel flavorPanel = new JPanel( new GridLayout (0,4));
			flavorPanel.add(createVanillaButton());
			flavorPanel.add(createStrawberryButton());
			flavorPanel.add(createChocolateButton());
			flavorPanel.add(createGreenteaButton());
			
			return flavorPanel;
		}
		
		/**
		 * 4 flavor buttons
		 * Clicking on the flavor buttons should add a scoop of that flavor
		 * and add data back to main stack
		 */
		private JButton createVanillaButton () {
			// create a button
			JButton vanilla = new JButton( "Vanilla" );	
			vanilla.setBackground(Color.WHITE);
			vanilla.setOpaque(true);
			vanilla.setBorderPainted(false);
			vanilla.addActionListener (
					new ActionListener() {
						public void actionPerformed (ActionEvent e) {
					
							cone.addScoop( "vanilla" );
							cone.repaint();
						}
						});
			return vanilla;
		}

		private JButton createStrawberryButton () {
			// create a button
			JButton strawberry = new JButton( "Strawberry" );	
			strawberry.setBackground(new Color( 255, 204, 229));
			strawberry.setOpaque(true);
			strawberry.setBorderPainted(false);
			strawberry.addActionListener (
					new ActionListener() {
						public void actionPerformed (ActionEvent e) {
							cone.addScoop( "strawberry" );
							cone.repaint();
						}
						});
			return strawberry;
		}

		private JButton createChocolateButton () {
			// create a button
			JButton chocolate = new JButton( "Chocolate" );	
			chocolate.setBackground(new Color( 153, 76, 0 ));
			chocolate.setOpaque(true);
			chocolate.setBorderPainted(false);
			chocolate.addActionListener (
					new ActionListener() {
						public void actionPerformed (ActionEvent e) {

							cone.addScoop( "chocolate" );
							cone.repaint();
						}
						});
			return chocolate;
		}
		
		private JButton createGreenteaButton () {
			// create a button
			JButton greentea = new JButton( "Greentea" );	
			greentea.setBackground(new Color( 204, 255, 204));
			greentea.setOpaque(true);
			greentea.setBorderPainted(false);
			greentea.addActionListener (
					new ActionListener() {
						public void actionPerformed (ActionEvent e) {

							cone.addScoop( "greentea" );
							cone.repaint();
						}
						});
			return greentea;
		}
}
