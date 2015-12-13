
public class StackLL<T> implements Stack<T> {
	
	protected LinkedList<T> stackLL;
	
	public StackLL(){
		stackLL= new LinkedList<T>();
	}
	
	/** 
	 * Tests if the stack is empty.
	 * @return true iff the stack is empty
	 **/
	public boolean isEmpty() {
		return stackLL.isEmpty();
	}
 
	/** 
	 * Gets the element at the top of the stack without removing it.
	 * @return the peeked data
	 **/
	public T peek() {
		return stackLL.getFirst();
	}
 
	/**
	 * Removes the top of the stack and returns it.
	 * @return the popped data
	 **/
	public T pop() {
		if (!isEmpty()){
		
			T poppedData = stackLL.getFirst();
		
			stackLL.deleteFirst();
			return poppedData;
		}
		return null;
		
	}
 
	/**
	 * Pushes an element onto the top of the stack.
	 **/
	public void push( T data ) {
		stackLL.insertFirst(data);
	}
 
	/** 
	 * Returns a String representation of the stack.
	 * @return stack as String
	 **/
	public String toString() {
		return stackLL.toString();
	}
}
