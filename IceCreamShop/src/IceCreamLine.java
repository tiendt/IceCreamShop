import javax.swing.Box;
import javax.swing.BoxLayout;

public class IceCreamLine extends Box {
	
	//maintain a queue of ice cream cone orders
	protected QueueLL<IceCreamCone> line = new QueueLL<IceCreamCone>();
	
	public IceCreamLine() {
		super(BoxLayout.Y_AXIS);
	}
	
	/**
	 * method to add a random order
	 * each order should be an ice cream cone with between 1 and 4 random scoop flavors
	 */
	public void addOrder() {
		
		IceCreamCone iceCream = new IceCreamCone();
		
		//generate a random number -- number of scoops added
		int random = (int) (Math.random()*4);
			
		for (int i = 0; i <= random; i ++) {
			iceCream.addScoop();
		}
		line.enqueue(iceCream);
		
		//add to the box
		add(iceCream);
	}
	
	/**
	 * getter to get the cone from the queue
	 */
	public IceCreamCone getCone() {		
			return line.peek();
		
	}
	
	/**
	 * method to remove an order
	 * dequeue an ice cream from the queue
	 */
	public IceCreamCone removeOrder() {
		
		IceCreamCone cone = new IceCreamCone();
		if (!line.isEmpty()) {
			cone = line.peek();
			line.dequeue();	
		}
		else 
			return null;
		remove(cone);
		return cone;
	} 

}
