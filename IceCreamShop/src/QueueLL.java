
public class QueueLL<T> implements Queue<T> {

	protected LinkedList<T> queueLL;
	
	public QueueLL () {
		queueLL = new LinkedList<T>();
	}
	
	/** 
	 * Tests if the queue is empty.
	 * @return true iff the queue is empty
	 **/
	public boolean isEmpty() {
		return queueLL.isEmpty();
	}
 
	/** 
	 * Gets the element at the front of the queue without removing it.
	 * @return the peeked data
	 **/
	public T peek() {
		return queueLL.getFirst();
	}
 
	/**
	 * Removes the front element of the queue and returns it.
	 * @return the dequeued data
	 **/
	public T dequeue() {
		
		if (!isEmpty()) {
			T dequeuedData = queueLL.getFirst();
		
			queueLL.deleteFirst();
			return dequeuedData;
		}
		return null;
	}
 
	/**
	 * Adds an element to the end of the queue.
	 **/
	public void enqueue( T data ) {
		queueLL.insertLast(data);
	}
 
	/** 
	 * Returns a String representation of the queue.
	 * @return queue as String
	 **/
	public String toString() {
		return queueLL.toString();
	}
}
