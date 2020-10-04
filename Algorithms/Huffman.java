// Huffman Coding Algorithm

import java.util.*; //importing all the classes from the "utility" at a time

class Node {
  int element;
  char c;
  Node left;
  Node right;
}

class ImplementComparator implements Comparator<Node> {
  public int compare(Node x, Node y) {
    return x.element - y.element;
  }
}

// class implementing the Huffman Algorithm
public class Huffman {
    
  public static void outCode(Node r, String s) {
    if (r.left == null && r.right == null && Character.isLetter(r.c)) {

      System.out.println(r.c + "   |  " + s);

      return;
    }
    outCode(r.left, s + "0");
    outCode(r.right, s + "1");
  }

  public static void main(String[] args) {  // main method: the execution of the program starts from here

    int n = 4;
    char[] cArray = { 'A', 'B', 'C', 'D' };
    int[] cf = { 5, 1, 6, 3 };

    PriorityQueue<Node> k = new PriorityQueue<Node>(n, new ImplementComparator());

    for (int i = 0; i < n; i++) {
      Node t = new Node();

      t.c = cArray[i];
      t.element = cf[i];

      t.left = null;
      t.right = null;

      k.add(t);
    }

    Node r = null;

    while (k.size() > 1) {

      Node x = k.peek();
      k.poll();

      Node y = k.peek();
      k.poll();

      Node f = new Node();

      f.element = x.element + y.element;
      f.c = '-';
      f.left = x;
      f.right = y;
      r = f;

      k.add(f);
    }
    System.out.println(" Char|Huffman code ");
    System.out.println("--------------------");
    outCode(r, "");
  }
}