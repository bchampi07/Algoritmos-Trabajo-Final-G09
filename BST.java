


public Class LinkedBST<T extends Comparable<T>> {
  private Node<T> root;
  public LinkedBST() {
    this.root = null;
  }

  public Node<T> getRoot()
    return this.root;
}

public T search(T d) throws ItemNoFound {
  Node<T> resultado = searchRec(this.root, d);

  if (resultado == null) {
    throw new ItemNoFound();
  }

  return resultado.data;
}

public Node<T>
    
