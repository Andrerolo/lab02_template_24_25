package pt.pa.adts.queue;

/**
 * This class must implement the Queue interface
 * @param <T>
 */
public class QueueLinkedList<T> implements Queue<T>  {

    private ListNode header, trailer;
    private int size;

    /**
     * Construtor que inicializa uma fila vazia com uma lista duplamente encadeada com dupla sentinela.
     *
     * <p>O nó sentinela {@code header} aponta para o {@code trailer}, e o {@code trailer} aponta para o {@code header},
     * formando uma lista vazia sem elementos entre eles.</p>
     */
    public QueueLinkedList() {
        //TODO: construtor deve inicializar uma fila vazia
        header = new ListNode(null, null, null);
        trailer = new ListNode(null, header, null);
        header.next = trailer;
        size = 0;
    }

    //TODO: implementar métodos da interface à custa da estrutura de dados fornecida
    /**
     * Insere um novo elemento no final da fila.
     *
     * <p>Complexidade: O(1)</p>
     *
     * @param elem o elemento a ser inserido na fila.
     * @throws NullPointerException se o elemento for nulo.
     * @throws QueueFullException atualmente não usado, pois a fila não tem limite.
     */
    @Override
    public void enqueue(T elem) throws NullNotAllowedException {
        if (elem == null){
            throw new NullNotAllowedException("Null elememts are not allowed");
        }

        // Cria um novo nó e insere no final da fila
        ListNode newNode = new ListNode(elem, trailer.prev, trailer);
        trailer.prev.next = newNode;
        trailer.prev = newNode;
        size++;
    }

    /**
     * Remove e retorna o elemento na frente da fila (após o header).
     *
     * <p>Complexidade: O(1)</p>
     *
     * @return o elemento removido da frente da fila.
     * @throws QueueEmptyException se a fila estiver vazia.
     */
    @Override
    public T dequeue() throws QueueEmptyException {
        if(isEmpty()) {
            throw new QueueEmptyException("Queue is empty. Cannot dequeue.");
        }
        ListNode frontNode = header.next; // nó que será removido
        header.next = frontNode.next; // atualiza o header
        frontNode.next.prev = header; // atualiza o próximo nó
        size--;
        return frontNode.element; // retorna o elemento removido
    }

    /**
     * Retorna o elemento na frente da fila sem removê-lo.
     *
     * <p>Complexidade: O(1)</p>
     *
     * @return o primeiro elemento da fila.
     * @throws QueueEmptyException se a fila estiver vazia.
     */
    @Override
    public T front() throws QueueEmptyException {
        if (isEmpty()) {
            throw new QueueEmptyException("Queue is empty. Cannot access front.");
        }
        return header.next.element; // retorna o elemento na frente sem removê-lo
    }

    /**
     * Retorna o número de elementos atualmente armazenados na fila.
     *
     * <p>Complexidade: O(1)</p>
     *
     * @return o número de elementos na fila.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Verifica se a fila está vazia.
     *
     * <p>Complexidade: O(1)</p>
     *
     * @return {@code true} se a fila estiver vazia, {@code false} caso contrário.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Limpa o conteúdo da fila, retornando a um estado vazio.
     *
     * <p>Complexidade: O(1)</p>
     */
    @Override
    public void clear() {
        header.next = trailer; // reseta a fila ligando o header ao trailer
        trailer.prev = header; // liga o trailer de volta ao header
        size = 0; // redefine o tamanho
    }

    /**
     * Classe interna que representa um nó da lista duplamente encadeada.
     *
     * <p>Cada nó armazena um elemento genérico e referências para o próximo e o anterior nós,
     * permitindo navegação bidirecional.</p>
     */
    private class ListNode {
        private T element;
        private ListNode next;
        private ListNode prev;

        /**
         * Construtor da classe ListNode.
         *
         * @param element o elemento armazenado no nó.
         * @param prev o nó anterior.
         * @param next o nó seguinte.
         */
        public ListNode(T element, ListNode prev, ListNode next) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
    }
}
