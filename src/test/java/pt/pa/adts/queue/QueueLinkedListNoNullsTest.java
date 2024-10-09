package pt.pa.adts.queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueLinkedListNoNullsTest {

    private QueueLinkedListNoNulls<Integer> queue;

    @BeforeEach
    void setUp() {
        queue = new QueueLinkedListNoNulls<>();
    }

    @Test
    void enqueue() {
        queue.enqueue(1);
        queue.enqueue(2);

        assertEquals(1, queue.front()); // A frente deve ser o primeiro elemento inserido
        assertEquals(2, queue.size()); // A fila deve conter 2 elementos
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
    void dequeueEmptyQueueException() {
        assertThrows(QueueEmptyException.class, () -> {
            queue.dequeue(); // Tentando remover de uma fila vazia deve lançar exceção
        });
    }

    @Test
    void frontEmptyQueueException() {
        assertThrows(QueueEmptyException.class, () -> {
            queue.front(); // Tentando acessar a frente de uma fila vazia deve lançar exceção
        });
    }

    @Test
    void size() {
        assertEquals(0, queue.size()); // A fila deve estar vazia

        queue.enqueue(1);
        assertEquals(1, queue.size()); // Deve haver um elemento na fila

        queue.enqueue(2);
        assertEquals(2, queue.size()); // Deve haver dois elementos na fila

        queue.dequeue();
        assertEquals(1, queue.size()); // Deve haver um elemento na fila
    }

    @Test
    void isEmpty() {
        assertTrue(queue.isEmpty()); // A fila deve estar vazia

        queue.enqueue(1);
        assertFalse(queue.isEmpty()); // A fila não deve estar vazia

        queue.dequeue();
        assertTrue(queue.isEmpty()); // A fila deve estar vazia novamente
    }

    @Test
    void clear() {
        queue.enqueue(1);
        queue.enqueue(2);
        assertEquals(2, queue.size()); // Deve haver 2 elementos

        queue.clear();
        assertTrue(queue.isEmpty()); // A fila deve estar vazia após limpar
        assertEquals(0, queue.size()); // O tamanho deve ser 0
    }

    @Test
    void enqueueNullThrowsException() {
        assertThrows(NullNotAllowedException.class, () -> {
            queue.enqueue(null); // Tentando adicionar null deve lançar exceção
        });
    }
}
