public class NodeBST<T> {

  T data;
  NodeBST<T> left;
  NodeBST<T> right;

  public NodeBST(T data) {
    this.data = data;
    this.left = null;
    this.right = null;
  }
}
