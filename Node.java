class Node<T>{
  private T data;
  private Node<T> next;

  public Node(T data){
    this.data=data;
    this.next=null;
  }
  public getData(){
    return this.data;
  }
  public getNext(){
    return this.next;
  }
}
