package com.company;

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
        if (t == null)
            return null;
        if (k < t.key)
            t.left = privateRemove(k, t.left);
        else if (k > t.key) {
            t.right = privateRemove(k, t.right)
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

    public void printTree() {
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
