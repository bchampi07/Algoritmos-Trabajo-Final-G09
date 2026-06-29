public class Node<T> {
    private T data;
    private Node<T> next;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }

    public T getData() {
        return data;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
}


public class LinkedQueue<T> {
  private Node<T> first;
  private Node<T> last;
  private int size;

  public LinkedQueue(){
    this.first = null;
    this.last = null;
    this.size = 0;
  }

  public void enqueue(T dato) {
    Node<T> nuevoNodo = new Node<> (data);
    if(isEmpty()){
      first = last = nuevoNodo;
    } else {
      last.setNext() = nuevoNodo;
      last = nuevoNodo;
    }
    size++;
  }

  public T dequeue() {
    if(isEmpty()) {
      System.out.println("La cola esta vacia");
      return null;
    }
    T data = first.getData();
    first = first.getNext();

    if(first == null) {
      last = null;
    }
    size--;
    return data;
  }

  public T peek() {
    if(isEmpty()) {
      System.out.println("La cola esta vacia");
      return null;
    }
    return first.getData();
  }

  public boolean isEmpty(){
    return fisrt == null;
  }

  public int size(){
    return size;
  }
    public void mostrar() {
        if (isEmpty()) {
            System.out.println("No hay elementos en la cola.");
            return;
        }

        Node<T> actual = first;

        while (actual != null) {
            System.out.println(actual.getData());
            actual = actual.getNext();
        }
    }
}














