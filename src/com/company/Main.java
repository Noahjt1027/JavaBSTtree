package com.company;
import java.io.*;
import java.util.Stack;

public class Main {
    public static class BST_Node<T extends Comparable<T>>{
        private T value;
        private BST_Node<T> leftNode;
        private BST_Node<T> rightNode;

        public BST_Node (T val){
            this.value = val;
        }

        public T getValue() {
            return value;
        }

        public BST_Node<T> getLeftNode() {
            return leftNode;
        }

        public BST_Node<T> getRightNode() {
            return rightNode;
        }

        public void setLeftNode(BST_Node<T> leftNode) {
            this.leftNode = leftNode;
        }

        public void setRightNode(BST_Node<T> rightNode) {
            this.rightNode = rightNode;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public int compareTo(BST_Node<T> other){
            return value.compareTo(other.getValue());
        }
    }

    public static class BSTtree <T extends Comparable<T>>{
        private BST_Node<T> Root;
        private int NumItems;
        private int Depth;

        public BST_Node<T> getRoot() {
            return Root;
        }

        public int getDepth() {
            return Depth;
        }

        public int getNumItems(){
            return NumItems;
        }

        public void setDepth(int depth) {
            Depth = depth;
        }

        public void setNumItems(int numItems) {
            NumItems = numItems;
        }

        public void setRoot(BST_Node<T> root) {
            Root = root;
        }

        public BSTtree(){
            this.Root = null;
            this.NumItems = 0;
            this. Depth = 0;
        }

        public boolean Contains(T val){
            boolean found = false;
            BST_Node<T> temp = getRoot();
            BST_Node<T> checkNode = new BST_Node<T>(val);

            while(temp != null){
                if(temp.compareTo(checkNode) == 0){ //If values are equal
                    found = true;
                    break;
                }
                else if (checkNode.compareTo(temp) == -1){ //if checkNode is less
                    temp = temp.getLeftNode();
                }
                else{ //bigger than
                    temp = temp = temp.getRightNode();
                }
            }


            return found;
        }

        public void Insert(T val){
            boolean success = false;
            BST_Node<T> newNode = new BST_Node<T>(val);
            if (getRoot() == null){
                setRoot(newNode);
                Depth = 1;
                success = true;
            }
            else{
                BST_Node<T> current = getRoot();
                int local_depth = 1;
                while(true){
                    local_depth += 1;
                    if(newNode.compareTo(current) == 1){
                        if (current.getRightNode() == null){
                            current.setRightNode(newNode);
                            success = true;
                            break;
                        }
                        else
                        {
                            current = current.getRightNode();
                        }
                    }
                    else if (newNode.compareTo(current) == -1){
                        if(current.getLeftNode() == null){
                            current.setLeftNode(newNode);
                            success = true;
                            break;
                        }
                        else
                        {
                            current = current.getLeftNode();
                        }
                    }
                }
                if(local_depth > getDepth()){
                    setDepth(local_depth);
                }
            }
            if (success == true){
                NumItems += 1;
            }
        }

        public void InOrder(){
            printInOrder(getRoot());
        }

        private void printInOrder(BST_Node<T> head){
            if (head != null){
                printInOrder(head.getLeftNode());
                System.out.println(head.getValue());
                printInOrder(head.getRightNode());
            }
        }
    }

    public static void main(String[] args) {
	// write your code here
        BSTtree <Integer> tree = new BSTtree<Integer>();
        tree.Insert(4);
        tree.Insert(3);
        tree.Insert(5);
        tree.Insert(6);
        tree.InOrder();
    }
}
