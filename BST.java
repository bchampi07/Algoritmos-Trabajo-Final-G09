


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
  if (n == null) {
    return null;
  }
  int cmp = d.compareTo(n.data);

if(cmp > 0) {
  n.right = deleteRec(n.right, d);
} else if(cmp < 0) {
  n.left = deleteRec(n.left, d);
} else {
  if(n.left == null) {
    return n.right;
  }else if(n.right == null) {
    return n.left;

  } else {
    try {
      T minimo = findMinNode(n.right);
      n.data = miniomo;
      n.right = deleteRec(n.right, minimo);
    } catch (ItemNoFound e) {
      System.out.println(e.getMessage());
    }
  }
}
  return n;
}
//---------------------------------------------------
public boolean isEmpty() {
  return this.root == null;
}
//------------------------------------------------------
public String getInOrder() {
  return inOrder(this.root);
}

private String inOrder(Node<T> n) {
  if(n == null) {
    return "";
  }
  return inOrder(n.left) + n.data + " " + inOrder(n.right);
}
//-----------------------------------------------------------------------------------------
private T findMinNode(Node<T> node) throws ItemNoFound {
  if(node == null) {
    throw new ItemNoFound ("No se encuentra el valor minimo");
  }

  Node<T> actual = node;
  while(actual.left != null) {
    actual = actual.left;
  }
  return search(actual.data);
}

  return isValidBSTRec(n.left, min, n.data) && isValidBSTRec(n.right, n.data, max);
}


  
