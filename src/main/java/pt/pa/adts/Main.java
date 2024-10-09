package pt.pa.adts;

import pt.pa.adts.queue.NullNotAllowedException;
import pt.pa.adts.queue.QueueLinkedListNoNulls;

public class Main {
  public static void main(String[] args) {
    QueueLinkedListNoNulls<Integer> queue = new QueueLinkedListNoNulls<>();

    // Adicionando elementos à fila
    queue.enqueue(10);
    queue.enqueue(20);

    System.out.println("Element at front: " + queue.front()); // Deveria imprimir 10
    System.out.println("Queue size: " + queue.size()); // Deveria imprimir 2

    // Removendo um elemento
    System.out.println("Dequeued element: " + queue.dequeue()); // Deveria imprimir 10
    System.out.println("New front: " + queue.front()); // Deveria imprimir 20

    // Tentativa de adicionar um elemento null (deve lançar exceção)
    try {
      queue.enqueue(null);
    } catch (NullNotAllowedException e) {
      System.out.println(e.getMessage()); // Deveria imprimir "Null elements are not allowed"
    }
  }
}