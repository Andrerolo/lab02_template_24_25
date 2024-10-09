package pt.pa.adts.queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueLinkedListTest {

    private QueueLinkedList<Integer> queue;

    @BeforeEach
    void setUp() {
        queue = new QueueLinkedList<>();
    }

    @Test
    void enqueue() {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        assertEquals(3, queue.size());
        assertFalse(queue.isEmpty());
        assertEquals(1, queue.front());
    }

    @Test
    void dequeue() throws QueueEmptyException {
        queue.enqueue(1);
        queue.enqueue(2);

        assertEquals(1, queue.dequeue()); // Dequeue deve retornar o primeiro elemento
        assertEquals(2, queue.front()); // Agora a frente deve ser o segundo elemento
        assertEquals(1, queue.size()); // Deve haver um elemento na fila
    }

    @Test
    void front() throws QueueEmptyException {
        queue.enqueue(1);
        queue.enqueue(2);

        assertEquals(1, queue.front()); // Deve retornar o primeiro elemento sem removê-lo
        assertEquals(2, queue.size()); // O tamanho deve permanecer o mesmo
    }

    @Test
    void size() {
        assertEquals(0, queue.size()); // A fila deve estar vazia inicialmente
        queue.enqueue(1);
        assertEquals(1, queue.size()); // Após adicionar um elemento, deve ter tamanho 1
        queue.enqueue(2);
        assertEquals(2, queue.size()); // Após adicionar outro, deve ter tamanho 2
        queue.dequeue();
        assertEquals(1, queue.size()); // Após remover um elemento, deve ter tamanho 1
    }

    @Test
    void isEmpty() {
        assertTrue(queue.isEmpty()); // A fila deve estar vazia inicialmente
        queue.enqueue(1);
        assertFalse(queue.isEmpty()); // Após adicionar um elemento, não deve estar vazia
        queue.dequeue();
        assertTrue(queue.isEmpty()); // Após remover o único elemento, deve estar vazia
    }

    @Test
    void clear() {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.clear(); // Limpa a fila
        assertTrue(queue.isEmpty()); // A fila deve estar vazia após limpar
        assertEquals(0, queue.size()); // O tamanho deve ser 0 após limpar
    }
}
