import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class IceCreamShop extends JPanel{

	private JLabel instructions;
	private JPanel shop;
	private int score = 0;
	
	private IceCreamLineManager manager = new IceCreamLineManager();
	private IceCreamMaker maker = new IceCreamMaker();
	
	public IceCreamShop() {
		/** use a BorderLayout **/
		setLayout(new BorderLayout());
		
		add(createInstruction(), BorderLayout.NORTH);		
		add(createShop(), BorderLayout.CENTER);
	}
	
	/**
	 * a JPanel that includes the instructions, score and the serve button
	 */
	public JPanel createInstruction () {
		
		JPanel topPanel = new JPanel( new GridLayout (2,1));
	
		/** create instructions and put at the top **/
		instructions = new JLabel("<html>Make ice cream cones to match the next order (on the top) <br> Correct: +10 points <br> Incorrect: - 5 points <br> Score: "  + score + "</html>" );

		topPanel.add(instructions);
	
		topPanel.add(createServeButton());
		
		return topPanel;
	}
	
	/**
	 * create a panel that holds part 1 and 2
	 */
	public JPanel createShop (){
		
		shop = new JPanel();
		shop.setLayout (new BorderLayout());
		
		shop.add (manager, BorderLayout.WEST);
		shop.add(maker, BorderLayout.CENTER);
	
		return shop;
	}
		
	/**
	 * When serve button clicked, the top ice cream of the random order and the ice cream of the maker will disappear
	 * which means ice cream has been served
	 
	 */
	protected JButton createServeButton() {
		// create a button
		JButton serve = new JButton( "Serve the next order" );	
		
		serve.addActionListener (
				new ActionListener() {
					public void actionPerformed (ActionEvent e) {
						
						//remove both ice creams
						IceCreamCone newCone1 = manager.line.removeOrder();
						IceCreamCone newCone2 = maker.removeAllScoop();
			
						//update the score in the instructions
						instructions.setText("<html>Make ice cream cones to match the next order (on the top) <br> Correct: +10 points <br> Incorrect: - 5 points <br> Score: "  + updateScore(newCone1, newCone2) + "</html>");
					
						validate();
						repaint();
					}
					});
		return serve;
	}
	/**
	 *  a point system to award points to the player; if the order is incorrect, points should be subtracted
	 * @param cone1
	 * @param cone2
	 * @return
	 */
	private int updateScore (IceCreamCone cone1, IceCreamCone cone2) {
	
		if (cone1 == null && cone2 == null){
			return score;
		}
		if (checkOrder(cone1, cone2)) {
			score = score + 10;
		}
		else {
			score = score - 5;
		}
		
		return score;
	}
	
	/**
	 * the order should be checked if it is correct
	 * @param cone1
	 * @param cone2
	 * @return
	 */
	public boolean checkOrder(IceCreamCone cone1, IceCreamCone cone2) {
	
		//check if the cone's null
		if (cone1 != null && cone2 != null) {
		
			System.out.println("cone1 empty" + cone1.getStack().isEmpty());
			System.out.println("cone2 empty" + cone2.getStack().isEmpty());
			
			while (!cone1.getStack().isEmpty() && !cone2.getStack().isEmpty()) {
				String pop1 = cone1.getStack().pop();
				String pop2 = cone2.getStack().pop();
				
				//check if 2 ice creams match
				if (!pop1.equals(pop2)) {

					return false;
				}			

			}
			//check if 2 ice creams have the same number of scoops
			if (!cone1.getStack().isEmpty() || !cone2.getStack().isEmpty()) {

				return false;
			}
			return true;
		}
		
		else 
			return false;
	}	
	
	/**
	 * Create a JFrame that holds the IceCreamShop.
	 * 
	 **/
	public static void main( String[] args )
	{
		JFrame guiFrame;
			
		// create a new JFrame to hold a single TreePainting
		guiFrame = new JFrame( "My Ice Cream Shop");
		
		// set size
		guiFrame.setSize( 650, 700 );

		guiFrame.add(new IceCreamShop());
		
		// exit normally on closing the window
		guiFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

		// show frame
		guiFrame.setVisible( true );
	}
}
