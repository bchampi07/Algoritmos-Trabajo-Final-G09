public class LinkedBST<T extends Comparable<T>> {

  private NodeBST<T> root;

  public LinkedBST() {
    this.root = null;
  }

  public boolean isEmpty() {
    return root == null;
  }

  public void insert(T data) throws ItemDuplicated {
    root = insertRec(root, data);
  }

  private NodeBST<T> insertRec(NodeBST<T> node, T data) throws ItemDuplicated {
    if(node == null) {
      return new NodeBST<>(data);
    }

    int cmp = data.compareTo(node.data);

    if(cmp < 0) {
      node.left = insertRec(node.left, data);
    } else if(cmp > 0) {
      node.right = insertRec(node.right, data);
    } else {
      throw new ItemDuplicated();
    }

    return node;
  }

  public T search(T data) throws ItemNotFound {
    NodeBST<T> result = searchRec(root, data);

    if(result == null) {
      throw new ItemNotFound();
    }

    return result.data;
  }

  private NodeBST<T> searchRec(NodeBST<T> node, T data) {
    if(node == null) {
      return null;
    }

    int cmp = data.compareTo(node.data);

    if(cmp < 0) {
      return searchRec(node.left, data);
    } else if(cmp > 0) {
      return searchRec(node.right, data);
    } else {
      return node;
    }
  }

  public void delete(T data) throws ExceptionIsEmpty {
    if(isEmpty()) {
      throw new ExceptionIsEmpty();
    }

    root = deleteRec(root, data);
  }

  private NodeBST<T> deleteRec(NodeBST<T> node, T data) {
    if(node == null) {
      return null;
    }

    int cmp = data.compareTo(node.data);

    if(cmp < 0) {
      node.left = deleteRec(node.left, data);
    } else if(cmp > 0) {
      node.right = deleteRec(node.right, data);
    } else {
      if(node.left == null) {
        return node.right;
      }

      if(node.right == null) {
        return node.left;
      }

      NodeBST<T> min = findMin(node.right);
      node.data = min.data;
      node.right = deleteRec(node.right, min.data);
    }

    return node;
  }

  private NodeBST<T> findMin(NodeBST<T> node) {
    while(node.left != null) {
      node = node.left;
    }

    return node;
  }

  public String getInOrder() {
    return inOrder(root);
  }

  private String inOrder(NodeBST<T> node) {
    if(node == null) {
      return "";
    }

    return inOrder(node.left) + node.data + "\n" + inOrder(node.right);
  }

  public int countAllNodes() {
    return countAllNodesRec(root);
  }

  private int countAllNodesRec(NodeBST<T> node) {
    if(node == null) {
      return 0;
    }

    return 1 + countAllNodesRec(node.left) + countAllNodesRec(node.right);
  }
}
