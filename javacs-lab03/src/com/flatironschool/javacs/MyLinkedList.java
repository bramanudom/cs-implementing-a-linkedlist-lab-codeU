/**
 * 
 */
package com.flatironschool.javacs;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * @author downey
 * @param <E>
 *
 */
public class MyLinkedList<E> implements List<E> {
  
  /**
   * Node is identical to ListNode from the example, but parameterized with T
   * 
   * @author downey
   *
   */
  private class Node {
    public E cargo;
    public Node next;
    
    public Node() {
      this.cargo = null;
      this.next = null;
    }
    public Node(E cargo) {
      this.cargo = cargo;
      this.next = null;
    }
    public Node(E cargo, Node next) {
      this.cargo = cargo;
      this.next = next;
    }
    public String toString() {
      return "Node(" + cargo.toString() + ")";
    }
  }
  
  private int size;            // keeps track of the number of elements
  private Node head;           // reference to the first node
  
  /**
   * 
   */
  public MyLinkedList() {
    head = null;
    size = 0;
  }
  
  /**
   * @param args
   */
  public static void main(String[] args) {
    
    // run a few simple tests
//      List <String> test = new MyLinkedList<String>();
//      test.add("a");
//      test.add("b");
//      test.add("c");
//      test.add("d");
//      test.add("e");
//      System.out.println(Arrays.toString(test.toArray()) + " size = " + test.size());
//      System.out.println("Removing the node at the 0th index");
//      System.out.println("The node removed was " + test.remove(0));
//      System.out.println(Arrays.toString(test.toArray()) + " size = " + test.size());
//      
//      
//      System.out.println("Removing the node at the 3rd index");
//      System.out.println("The node removed was " + test.remove(3));
//      System.out.println(Arrays.toString(test.toArray()) + " size = " + test.size());
//      
//      System.out.println("Removing the node at the 1st index");
//      System.out.println("The node removed was " + test.remove(1));
//      System.out.println(Arrays.toString(test.toArray()) + " size = " + test.size());
//      
//    List<Integer> mll = new MyLinkedList<Integer>();
//    mll.add(1);
//    mll.add(2);
//    mll.add(3);
//    System.out.println(Arrays.toString(mll.toArray()) + " size = " + mll.size());
//    
//    //mll.remove(new Integer(2));
//    //System.out.println(Arrays.toString(mll.toArray()) + " size = " + mll.size());
//    mll.add(1, 3);
//    System.out.println("Adding the integer 3 at index 1 in the linked list...");
//    System.out.println(Arrays.toString(mll.toArray()) + " size = " + mll.size()); //expected [1,3.2,3]
//    mll.add(0, 5); 
//        System.out.println(Arrays.toString(mll.toArray()) + " size = " + mll.size()); //expected [1,3.2,3]
//    
//
//    mll.add(5, 3);     System.out.println(Arrays.toString(mll.toArray()) + " size = " + mll.size()); //expected [1,3.2,3]
//    List<String> mll2 = new MyLinkedList<String>();
//    mll2.add("hello");
//    mll2.add("im");
//    mll2.add("pet");
//    mll2.add("haha");
//    System.out.println("The index of 'hello' in the LL is " + mll2.indexOf("hello"));
//    System.out.println(Arrays.toString(mll2.toArray()) + " size = " + mll2.size());// expected ["hello","im","pet"] size = 3
//    System.out.println("hello can be removed from the LL: " + mll2.remove("hello"));
//    System.out.println("Removing the first node that contains 'hello'");
//    System.out.println(Arrays.toString(mll2.toArray()) + " size = " + mll2.size()); //expected ["hello","pet"] size = 2
//    System.out.println("yo can be removed from the LL: " + mll2.remove("yo"));
//    System.out.println(Arrays.toString(mll2.toArray()) + " size = " + mll2.size()); //expected ["hello","pet"] size = 2
//    
//    
//    System.out.println("Removing the node at index 1");
//    System.out.println(mll2.remove(1));
//    System.out.println( mll2.size());
//    System.out.println(Arrays.toString(mll2.toArray()) + " size = " + mll2.size()); //expected ["hello"] size = 1
//    
// 
//    System.out.println("Removing the node at index 0");
//    mll2.remove(0);
//    System.out.println(Arrays.toString(mll2.toArray()) + " size = " + mll2.size()); //expected ERROR
    
 
  }
  
  @Override
  public boolean add(E element) {
    if (head == null) {
      head = new Node(element);
    } else {
      Node node = head;
      // loop until the last node
      for ( ; node.next != null; node = node.next) {}
      node.next = new Node(element);
      
    }
    size++;
    return true;
  }
  
  @Override
  public void add(int index, E element) {
    
    Node temp = new Node(element);
    //System.out.println("The temp's cargo is "+ temp.cargo);
    Node current = head;
    
    if (index == 0){
      temp.next = head;
      head = temp;
      size ++;
    }
    
    //if (current != null)
      //System.out.println("got into the if statement");
    else if ((index > 0) && (index <= size)){
      for (int i = 0; i < index-1 ; i++){
        System.out.println(i);
        current = current.next;
      }
      
      //System.out.println("Exited the for loop, the current's index " + current.cargo);
    
    
    //System.out.println("the current node is " + current);
    //System.out.println("the temp is " + temp.cargo);
    //System.out.println(
    temp.next = current.next;
    //System.out.println("the temp's next's cargo is :" + temp.next);
    current.next = temp;
    
    size ++;
    }
    
    else {
      throw new IndexOutOfBoundsException();
    }
    
    
  }
  
  
  @Override
  public boolean addAll(Collection<? extends E> collection) {
    boolean flag = true;
    for (E element: collection) {
      flag &= add(element);
    }
    return flag;
  }
  
  @Override
  public boolean addAll(int index, Collection<? extends E> collection) {
    throw new UnsupportedOperationException();
  }
  
  @Override
  public void clear() {
    head = null;
    size = 0;
  }
  
  @Override
  public boolean contains(Object obj) {
    return indexOf(obj) != -1;
  }
  
  @Override
  public boolean containsAll(Collection<?> collection) {
    for (Object obj: collection) {
      if (!contains(obj)) {
        return false;
      }
    }
    return true;
  }
  
  @Override
  public E get(int index) {
    Node node = getNode(index);
    return node.cargo;
  }
  
  /** Returns the node at the given index.
    * @param index
    * @return
    */
  private Node getNode(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException();
    }
    Node node = head;
    for (int i=0; i<index; i++) {
      node = node.next;
    }
    return node;
  }
  
  @Override
  public int indexOf(Object target) {
    Node node = head;
    int index = -1;
    for (int i=0; i <size; i++) {
      if (equals(target, node.cargo)) {
        return i;
      }
      node = node.next;
    }
    return index;
  }
  
  
  /** Checks whether an element of the array is the target.
    * 
    * Handles the special case that the target is null.
    * 
    * @param target
    * @param object
    */
  private boolean equals(Object target, Object element) {
    if (target == null) {
      return element == null;
    } else {
      return target.equals(element);
    }
  }
  
  @Override
  public boolean isEmpty() {
    return size == 0;
  }
  
  @Override
  public Iterator<E> iterator() {
    E[] array = (E[]) toArray();
    return Arrays.asList(array).iterator();
  }
  
  @Override
  public int lastIndexOf(Object target) {
    Node node = head;
    int index = -1;
    for (int i=0; i<size; i++) {
      if (equals(target, node.cargo)) {
        index = i;
      }
      node = node.next;
    }
    return index;
  }
  
  @Override
  public ListIterator<E> listIterator() {
    return null;
  }
  
  @Override
  public ListIterator<E> listIterator(int index) {
    return null;
  }
  
  @Override
  public boolean remove(Object obj) {
    int index = indexOf(obj);
    Node current = head;
    if (index >= 0){
      if (index == 0){
        head = current.next;
        size--;
        return true;

      }
      for (int i = 0; i< index-1; i++){
        current = current.next;
      }
      current.next = current.next.next;
      size--;
      return true;
    }
    
    return false; 
  }
  
  
  @Override
  public E remove(int index) {
    
    //this method could be greatly improved (there is a lot of repititon)
    Node current = head;
    E removedNode = null;
     
    if (index == 0){
        removedNode = current.cargo;
        head = current.next;
        size--;
        return removedNode;

      }
    
    if (index == (size-1)) {
      
      for (int i = 0; i< index-1; i++){

        current = current.next;
        removedNode = current.next.cargo;      
      }

      
      
      current.next = current.next.next;
      size--;
      return removedNode;
    }
    
    if (index < (size-1)) {
      
      for (int i = 0; i< index-1; i++){
        removedNode = current.next.cargo;  
        current = current.next;        
        
        
      }
      
      if (removedNode == null){ //this means that the current was the head 
        removedNode = current.next.cargo;
      }

      
      current.next = current.next.next;
      size--;
      return removedNode;
    }
    
    
    throw new IndexOutOfBoundsException();
  }
   
 
  @Override
  public boolean removeAll(Collection<?> collection) {
    boolean flag = true;
    for (Object obj: collection) {
      flag &= remove(obj);
    }
    return flag;
  }
  
  @Override
  public boolean retainAll(Collection<?> collection) {
    throw new UnsupportedOperationException();
  }
  
  @Override
  public E set(int index, E element) {
    Node node = getNode(index);
    E old = node.cargo;
    node.cargo = element;
    return old;
  }
  
  @Override
  public int size() {
    return size;
  }
  
  @Override
  public List<E> subList(int fromIndex, int toIndex) {
    if (fromIndex < 0 || toIndex >= size || fromIndex > toIndex) {
      throw new IndexOutOfBoundsException();
    }
    // TODO: classify this and improve it.
    int i = 0;
    MyLinkedList<E> list = new MyLinkedList<E>();
    for (Node node=head; node != null; node = node.next) {
      if (i >= fromIndex && i <= toIndex) {
        list.add(node.cargo);
      }
      i++;
    }
    return list;
  }
  
  @Override
  public Object[] toArray() {
    Object[] array = new Object[size];
    Node current = head;
    for (int i = 0; i < size; i++) {
      array[i] = current.cargo;
      current = current.next;
    }
    return array;
  }
  
  @Override
  public <T> T[] toArray(T[] a) {
    throw new UnsupportedOperationException();  
  }
}
