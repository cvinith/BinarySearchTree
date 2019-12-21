package com.binarysearchtree;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinarySearchTree {

  private class Node {

    int data;
    Node left;
    Node right;

    Node(int data) {
      this.data = data;
      left = right = null;
    }
  }

  private Node root = null;

  private Node insertRecord(Node root, int data) {
    if (root == null) {
      root = new Node(data);
    } else if (data < root.data) {
      root.left = insertRecord(root.left, data);
    } else {
      root.right = insertRecord(root.right, data);
    }
    return root;
  }

  public void iterativeInsert(int data){
    Node node =new Node(data);
    if(root==null)
      root=node;
     else {
       Node current=root,parent=null;
       while(current!=null){
         parent=current;
         if(data>=current.data){
           current =current.right;
         }
         else {
           current =current.left;
         }
       }
       if(data>=parent.data){
         parent.right=node;
       }
       else {
         parent.left=node;
       }

    }
  }


  private void preOrder(Node root) {
    if (root == null) {
      return;
    }
    System.out.println(root.data);
    preOrder(root.left);
    preOrder(root.right);
  }

  private void inOrder(Node root) {
    if (root == null) {
      return;
    }
    inOrder(root.left);
    System.out.println(root.data);
    inOrder(root.right);
  }

  private void postOrder(Node root) {
    if (root == null) {
      return;
    }
    postOrder(root.left);
    postOrder(root.right);
    System.out.println(root.data);
  }

  public void iterativePreOrder() {
    Stack<Node> stack = new Stack<>();
    if (root != null) {
      stack.push(root);
    }
    while (!stack.isEmpty()) {
      Node current = stack.pop();
      if (current.right != null) {
        stack.push(current.right);
      }
      if (current.left != null) {
        stack.push(current.left);
      }
      System.out.println(current.data);
    }
  }

  public void iterativeInOrder() {
    Node current = root;
    Stack<Node> stack = new Stack<>();
    if (current != null) {
      stack.push(current);
      current = current.left;
    }
    while (!stack.isEmpty() || current != null) {
      while (current != null) {
        stack.push(current);
        current = current.left;
      }
      current = stack.pop();
      System.out.println(current.data);
      current = current.right;
    }
  }

  public void iterativePostOrder() {
    Stack<Node> stack1 = new Stack<>();
    Stack<Node> stack2 = new Stack<>();
    if (root != null) {
      stack1.push(root);
    }
    while (!stack1.isEmpty()) {
      Node temp = stack1.pop();
      if (temp.left != null) {
        stack1.push(temp.left);
      }
      if (temp.right != null) {
        stack1.push(temp.right);
      }
      stack2.push(temp);
    }
    while (!stack2.isEmpty()) {
      System.out.println(stack2.pop().data);
    }
  }

  public void levelOrder() {
    Queue<Node> queue = new LinkedList<>();
    if (root != null) {
      queue.add(root);
    }
    while (queue.size() != 0) {
      Node temp = queue.poll();
      System.out.println(temp.data);
      if (temp.left != null) {
        queue.add(temp.left);
      }
      if (temp.right != null) {
        queue.add(temp.right);
      }
    }
  }

  private Node deleteNode(Node root, int data) {
    if (root == null) {
      return root;
    } else if (data < root.data) {
      root.left = deleteNode(root.left, data); 
    } else if (data > root.data) {
      root.right = deleteNode(root.right, data);
    } else {
      //case1 : No Child
      if (root.left == null && root.right == null) {
        root = null;
      }

      //case2 : One Child
      else if (root.left != null && root.right == null) {
        root = root.left;
      } else if (root.left == null && root.right != null) {
        root = root.right;
      }

      //case3 : Two Child
      else if (root.left != null && root.right != null) {
        int min = findMin(root.right);
        root.data = min;
        root.right = deleteNode(root.right, min);
      }
    }

    return root;
  }


  private int findMin(Node root) {
    while (root.left != null) {
      root = root.left;
    }
    return root.data;
  }

  private int findMax(Node root) {
    while(root.right !=null){
      root =root.right;
    }
    return root.data;
  }

  private int height(Node root){
    if(root==null)
      return -1;
    int leftHeight =height(root.left);
    int rightHeight =height(root.right);
    return leftHeight > rightHeight ? leftHeight+1 : rightHeight+1;
  }

  private int size(Node root){
    if(root==null)
      return 0;
    int leftSize=size(root.left);
    int rightSize=size(root.right);
    return leftSize+rightSize+1;
  }

//___________________________________________________________________________________________

  public void insert(int data) {
    root = insertRecord(root, data);
  }

  public int findMin(){
    return findMin(root);
  }

  public int findMax(){
    return findMax(root);
  }

  public void preOrder() {
    preOrder(root);
  }

  public void inOrder() {
    inOrder(root);
  }

  public void postOrder() {
    postOrder(root);
  }

  public void delete(int data) {
    root = deleteNode(root, data);
  }

  public int height(){
    return height(root);
  }

  public int size(){
    return size(root);
  }




}