package com.company;
import java.util.LinkedList;

public class BinarySearchTree {
    private BinarySearchTreeNode root;

    /**
     * Internal method to insert a value into a subtree.
     * @param k Value to be inserted.
     * @param t Root of the new subtree.
     * @return New root of the subtree.
     */
    private BinarySearchTreeNode privateInsert(int k, BinarySearchTreeNode t) {
        if(t == null) {
            return new BinarySearchTreeNode(k);
        }
        if(k < t.key)
            t.left = privateInsert(k, t.left);
        else if (k > t.key)
            t.right = privateInsert(k, t.right);
        else;
        return t;
    }

    /**
     * Internal method to remove a value from a subtree.
     * @param k The value to remove.
     * @param t The root of the subtree.
     * @return New root of the subtree.
     */
    private BinarySearchTreeNode privateRemove(int k, BinarySearchTreeNode t) {
        // return null if subtree is null
        if (t == null)
            return null;
        if (k < t.key)
            t.left = privateRemove(k, t.left);
        else if (k > t.key) {
            t.right = privateRemove(k, t.right);
        }
        else if (t.left != null && t.right != null) {
            t.key = findMin(t.right).key;
            t.right = privateRemove(t.key, t.right);
        }
        else {
            if (t.left != null) {
                t = t.left;
            }
            else {
                t = t.right;
            }
        }
        return t;
    }

    /**
     * Remove a value from the tree.
     * @param k The value to be removed from the tree.
     */
    public void remove(int k) {
        root = privateRemove(k, root);
    }

    private BinarySearchTreeNode findMin(BinarySearchTreeNode t) {
        BinarySearchTreeNode current = t;

        while(current.left != null) {
            current = current.left;
        }
        return current;
    }

    /**
     * Method to insert a value into the tree.
     * @param k The value to be inserted into the tree.
     */
    public void insert (int k) {
        root = privateInsert(k, root);
    }

    /**
     * Prints the tree from the children to the parent.
     */
    public void printTree() {
		System.out.println(postOrderPrint(root));
    }

    /**
     * Find the sum of all the positive keys in the tree.
     * @return The sum of the positive keys in the tree.
     */
    public int positiveKeySum() {
        return 0;
    }

    /**
     * Deletes the maximum value in the tree.
     */
    public void deleteMax() {
        if (root == null)
            return;
        BinarySearchTreeNode current = root;
        while (current.right != null)
            current = current.right;
        remove(current.key);
    }

    /**
     * Private method to create a list of values from the tree, in postorder.
     * @param treeNode Subtree to be traversed.
     * @return A LinkedList containing all the values in the tree, in postorder.
     */
    private String postOrderPrint(BinarySearchTreeNode treeNode) {
    	String out = "";
        if (treeNode == null) {
            return "";
        }
        out += postOrderPrint(treeNode.left) + " " + treeNode.key;
        out += postOrderPrint(treeNode.right) + " " + treeNode.key ;


		return out;
    }
    class BinarySearchTreeNode {
        int key;
        BinarySearchTreeNode left;
        BinarySearchTreeNode right;

        public BinarySearchTreeNode(int k) {
            key = k;
        }
    }
}
