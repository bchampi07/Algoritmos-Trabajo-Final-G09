


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
//---------------------------------------------
@Override
public String toString() {
  return inOrder(this.root);
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
//---------------------------------------------------
public String getPreOrder() {
  return preOrder(this.root);
}

private String preOrder(Node<T> n) {
  if(n == null) {
    return "";
  }
  return n.data + " " + preOrder(n.left) + preOrder(n.right);
}
//------------------------------------------------------------
public String getPostOder() {
  return postOrder(this.root);
}

private String postOrder(Node<T> n) {
  if(n == null) {
    return "";
  }
  return postOrder(n.left) + postOder(n.right) + n.data + " ";
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
//--------------------------------------------------------
private T findMaxNode(Node<T> node) throws ItemNoFound {
  if(node == null) {
    throw new ItemNoFound("No se encuentra el valor maximo");
  }

  Node<T> actual = node;
  while(actual.right != null) {
    actual = actual.right;
  }
  return search(actual.data);
}
//--------------------------------------------------------
public void destroyNodes() throws ExceptionIsEmpty {
  if(isEmpty()) {
    throw new ExceptionIsEmpty();
  }
  this.root = null;
}
//---------------------------------------------
public int countAllNodes() {
  return countAllNodesRec(this.root);
}

public int countAllNodesRec(Node<T> n) {
  if(n == null) {
    return 0;
  }

  return 1 + countAllNodesRec(n.left) + countAllNodesRec(n.right);
}
//----------------------------------------------
public int countNodes() {
  return countNodesRec(root);
}

public int countNodesRec(Node<T> n) {
  if (n == null) {
    return 0;
  }

  if (n.left == null && n.right == null) {
    return 0;
  }

  return 1 + countNodesRec(n.left) + countNodesRec(n.right);
}
//-----------------------------------------------------------
public int height(T x) {
  Node<T> actual = this.root;

  while (actual != null) {
    int cmp = x.compareTo(actual.data);

    if (cmp < 0) {
      actual = actual.left;
    } else if (cmp > 0) {
      actual = actual.right;

    } else {
      DequeLink<Node<T>> cola = new DequeLink<>();
      int altura = -1;
      cola.addLast(actual);

      while (!cola.isEmpty()) {
        int nivelSize = cola.count();
        altura++;

        for (int i = 0; i < nivelSize; i++) {
          try {

            Node<T> current = cola.removeFirst();

            if (current.left != null) {
              cola.addLast(current.left);
            }

            if (current.right != null) {
              cola.addLast(current.right);
            }
          } catch (ExceptionIsEmpty e) {
              System.out.println(e.getMessage()
                                 );
          }
        }
      }
      return altura;
    }
  }
  return -1;
}
//------------------------------------------------------------------------------
public int amplitude(int nivel) {
  if(this.root )) null || nivel < 0) {
    return 0;
  }

  int alturaArbol = height(this.root.data);

  if(nivel > alturaArbol) {
    return 0;
  }

  DequeLink<Node<T>> cola = new DequeLink<>();
  cola.addLast(this.root);
  int nivelActual = 0;

  while(!cola.isEmpty()) {
    int cantidadNodos = cola.count();

    if(nivelActual == nivel) {
      return cantidadNodos;
    }

    for(int i = 0; i < cantidadNodos; i++) {
      try {
        Node<T> nodoActual = cola.removeFirst();

        if(nodoActual.left != null) {
          cola.addLast(nodoActual.left);
        }

        if(nodoActual.right != null) {
          cola.addLast(nodoActual.right);
        }

      } catch(ExceptionIsEmpty e) {
        System.out.println(e.getMessage()
                           );
      }
    }

    nivelActual++;
  }

  return 0;
}
//-------------------------------------------------------------------
public int areaBST() {
  if(this.root == null) {
    return 0;
  }

  int hojas = 0;
  StackLink<Node<T>> pila = new StackLink<>();
  pila.push(this.root);

  try {
    while(!pila.isEmpty()) {
      Node<T> actual = pila.pop();

      if(actual.left == null && actual.right == null) {
        hojas++;
      }

      if(actual.right != null) {
        pila.push(actual.right);
      }

      if(actual.left != null) {
        pila.push(actual.left);
      }
    }
  } catch(ExceptionIsEmpty e) {
    System.out.println(e.getMessage());
  }

  int alturaArbol = height(this.root.data);

  return hojas * alturaArbol;
}
//-----------------------------------------------
public void drawBST() {
  drawRec(this.root, 0, "");
}

private void drawRec(Node<T> n, int nivel, String edge) {
  if (n == null) {
    return;
  }

  drawRec(n.right, nivel + 1, "┌── ");

  for (int i = 0; i < nivel; i++) {
    System.out.print("    ");
  }
  System.out.println(edge + n.data.toString());

  drawRec(n.left, nivel + 1, "└── ");
}
//---------------------------------------------------------------------
public void parenthesize() {
  parenthesizeRec(root, 0);
}

private void parenthesizeRec(Node<T> n, int nivel) {
  if(n == null) return;

  for(int i = 0; i < nivel; i++) {
    System.out.print("   ");
  }

  System.out.print(n.data);

  if(n.left != null || n.right != null) {
    System.out.println("(");
    parenthesizeRec(n.left, nivel + 1);

    if(n.right != null) {
      System.out.println();
    }

    parenthesizeRec(n.right, nivel + 1);
    System.out.println();

    for(int i = 0; i < nivel; i++) {
      System.out.print("     ");
    }
    System.out.print(")");
  } else {
    System.out.println();
  }
}
//-----------------------------------------------------------------
public boolean isValidBST() {
  return isValidBSTRec(this.root, null, null);
}

private boolean isValidBSTRec(Node<T> n, T min, T max) {
  if(n == null) {
    return true;
  }

  if(min != null && n.data.compareTo(min) <= 0) {
    return false;
  }

  if(max != null && n.data.compareTo(max) >= 0) {
    return false;
  }

  return isValidBSTRec(n.left, min, n.data) && isValidBSTRec(n.right, n.data, max);
}


  
