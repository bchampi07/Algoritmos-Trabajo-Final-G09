public class Node<T> {
  private T data;
  private Node<T> next;

  public Node(T data){
    this.data = data;
    this.next = null;
  }

  public T getData(){
    return this.data;
  }

  public Node<T> getNext(){
    return this.next;
  }
}


public class Queue<T> {
  private Node<T> first;
  private Node<T> last;
  private int size;

  public Queue(){
    this.first = null;
    this.last = null;
    this.size = 0;
  }

  public void enqueue(T dato) {
    Node<T> nuevoNodo = new Node<> (data);
    if(isEmpty()){
      first = last = nuevoNodo;
    } else {
      last.getNext() = nuevoNodo;
      last = nuevoNodo;
    }
    this.size++;
  }

  public T dequeue() {
    if(isEmpty()) {
      System.out.println("La cola esta vacia");
    }
    T data = first.getData();
    first = first.getNext();

    if(first == null) {
      last = null;
    }
    this.size--;
    return data;
  }

  public T peek() {
    if(isEmpty()) {
      System.out.println("La cola esta vacia");
    }
    return first.getData();
  }

  public boolean isEmpty(){
    return fisrt == null;
  }

  public int size(){
    return this.size;
  }
  
  
}














