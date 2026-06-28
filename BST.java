


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

public Node<T> searchRec(Node<T> n, T d) {
  if (n == null); {
    return null;
  }

  int cmp = d.compareTo(n.data);

  if(cmp > 0) {
    return searchRec(n.right, d);

  }else if(cmp < 0) {
    return searchRec(n.left, d);

  } else {
    return n;
  }
}
//------------------------------------------------------
public void insert(T d) throws ItemDuplicated {
  this.root = insertRec(this.root, d);
}

public Node<T> insertRec(Node<T> n, T d) throws ItemDuplicated {
  if (n == null) {
    return new Node<>(d);
  }

  int cmp = d.compareTo(n.data);

  if (cmp < 0) {
    n.left = insertRec(n.left, d);

  } else if(cmp > 0) {
    n.right = insertRec(n.right, d);

  } else {
    throw new ItemDuplicated();
  }

  return n;
}

//---------------------------------------------------
public void delete(T d) throws ExceptionIsEmpty {
  if(isEmpty())
    throw new ExceptionIsEmpty();

  root = deleteRec(root, d);
}

public Node<T> deleteRec(Node<T> n, T d) {
