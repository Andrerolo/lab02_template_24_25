package pt.pa.adts.queue;

/**
 * A Queue implementation that does not allow null elements.
 *
 * This class extends QueueLinkedList to ensure that null values cannot be enqueued.
 */
public class QueueLinkedListNoNulls<T> extends QueueLinkedList<T> {

    /**
     * Inserts a new element at the end of the queue.
     *
     * @param elem the element to be inserted in the queue.
     * @throws NullNotAllowedException if the element is null.
     */
    @Override
    public void enqueue(T elem) throws NullNotAllowedException {
        if (elem == null) {
            throw new NullNotAllowedException("Null elements are not allowed");
        }
        super.enqueue(elem); // Calls the parent class enqueue method
    }
}
