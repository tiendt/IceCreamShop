import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class IceCreamCone extends JComponent {

	// instance properties
	private int flavorIndex; // value must be -1 to indicate no scoop or in [0,FLAVORS.length)
	protected StackLL<String> scoop = new StackLL<String>();
	
	// class properties
	public static final String[] FLAVORS = {"vanilla", "strawberry", "chocolate", "greentea"};
	public static final Color[] PAINT_COLORS = {Color.WHITE, new Color( 255, 204, 229), new Color( 153, 76, 0 ), new Color( 204, 255, 204)};
	public static final int CONE_WIDTH = 40/2;
	public static final int CONE_HEIGHT = 70/2;	
	public static final int SCOOP_DIAMETER = 60/2;	
	public static final int SCOOP_OVERLAP = 10/2;	

	public int currentHeight ;
	
	public IceCreamCone() {
		super();
	}
	
	/**
	 * getter to return the stackLL
	 */
	public StackLL<String> getStack() {
		return scoop;
	}
	
	/**
	 * setter for stackLL
	 * @param stack
	 */
	public void setStack (StackLL<String> stack) {
		this.scoop = stack;
		
	}
	/**
	 * adding a scoop to the top of the cone:
	 * one that takes a String indicating the flavor to be added
	 * and one that takes no arguments and adds a scoop of a random flavor
	 */
	public void addScoop(){

		int random = (int) (Math.random() * 4);
		scoop.push (FLAVORS[random]);
		
		System.out.println(FLAVORS[random]);
	}
	
	public void addScoop( String flavor) {
		System.out.println("added");
		scoop.push (flavor);
	}
	
	public void trashScoop () {
		scoop.pop();
	}
	
	/** 
	 * Given a flavor, returns the corresponding index in FLAVORS.
	 * Valid parameter values: "none" or one of FLAVORS
	 * If invalid parameter is passed, defaults to -1
	 **/
	private int findFlavorIndex( String flavor )
	{

			// for each allowed flavor
			for ( int i = 0; i < FLAVORS.length; i++ )
			{
				// if found a match, ignoring case
				if ( flavor.toLowerCase().equals( FLAVORS[i] ) )
					// found flavor index
					return i;
			}
			
			// if we get here, passed flavor did not match any element 
			// set to none
			return -1;
		}

	
	/**
	 * Override the paint method to draw an ice cream cone.
	 **/
	public void paint( Graphics g )
	{

		// draw the cone
		paintCone( g );
		currentHeight =  getHeight() - CONE_HEIGHT - SCOOP_DIAMETER + SCOOP_OVERLAP ;

		//temporary stack that helps painting in correct order
		StackLL<String> temp = new StackLL<String>();
		while (!scoop.isEmpty() ) {
			temp.push(scoop.pop());
		}
		
		//find flavor index and push back from temporary to main stack
		while (!temp.isEmpty()) {
			flavorIndex = findFlavorIndex (temp.peek());
			scoop.push(temp.pop());
			
			// draw the scoop
			paintScoop( g );

		}
	}
	
	/**
	 * paint the cone
	 **/
	private void paintCone( Graphics g )
	{
		int[] xPoints = new int[3];
		int[] yPoints = new int[3];
		
		// center bottom point
		xPoints[0] = getWidth() / 2;
		yPoints[0] = getHeight();
		
		// upper left point
		xPoints[1] = xPoints[0] - (CONE_WIDTH/2);
		yPoints[1] = yPoints[0] - CONE_HEIGHT;
		
		// upper right point
		xPoints[2] = xPoints[0] + (CONE_WIDTH/2);
		yPoints[2] = yPoints[0] - CONE_HEIGHT;
		
		// set the paint color
		g.setColor( Color.YELLOW );
		
		// draw triangle
		g.fillPolygon( xPoints, yPoints, 3 );
	}
	
	/**
	 * paint the scoop
	 **/
	private void paintScoop( Graphics g )
	{
		if ( flavorIndex != -1 )
		{
			
			// set the paint color based on the flavor
			g.setColor( PAINT_COLORS[ flavorIndex] );
		
			// fill oval (upper left x, upper left y, width, height)
			g.fillOval( 
				// upper left x is center minus half diameter
				getWidth()/2 - SCOOP_DIAMETER/2,
				// upper left y accounts for cone height and a bit of overlap
				currentHeight, SCOOP_DIAMETER, SCOOP_DIAMETER );
			
				//update height of scoop
				currentHeight  = currentHeight - SCOOP_DIAMETER + SCOOP_OVERLAP;
			    
		}
		

	}
}
