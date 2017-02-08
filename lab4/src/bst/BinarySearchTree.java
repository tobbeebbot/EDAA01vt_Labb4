package bst;

public class BinarySearchTree<E extends Comparable<? super E>> {
	BinaryNode<E> root;
    int size;

	public static void main(String[] args) {
		BinarySearchTree<Integer> intTree = new BinarySearchTree<>();
		System.out.println("Size: " + intTree.size());
		System.out.println("Height: " + intTree.height());
		intTree.add(42);
		intTree.add(12);
		intTree.add(24);
		intTree.add(25);
		intTree.add(26);
		intTree.add(3425);
		intTree.add(325235);
		intTree.add(26);
		intTree.add(26);
		intTree.add(26);
		intTree.add(2);
		intTree.add(84);
		intTree.add(25);
		intTree.add(87);
		intTree.add(234);
		intTree.printTree();
		System.out.println("Size: " + intTree.size());
		System.out.println("Height: " + intTree.height());
		BSTVisualizer bst = new BSTVisualizer("Träd", 500, 500);
		bst.drawTree(intTree);

		Integer[] a = new Integer[100];
		intTree.toArray(intTree.root, a, 0);
		for(int i: a) System.out.print(" " + i + " ");
	}
    
	/**
	 * Constructs an empty binary searchtree.
	 */
	public BinarySearchTree() {
		size = 0;
		root = null;
	}

	/**
	 * Inserts the specified element in the tree if no duplicate exists.
	 * @param x element to be inserted
	 * @return true if the the element was inserted
	 */
	public boolean add(E x) {
		if (root != null) return add(root, x);
		else {
			root = new BinaryNode<>(x);
			size++;
			return true;
		}
	}
	private boolean add(BinaryNode<E> actNode, E x) {
		if (x.compareTo(actNode.element) < 0) {
			//Kolla höger gren
			if (actNode.left != null) {
				return add(actNode.left, x);
			} else {
				actNode.left = new BinaryNode<>(x);
				size++;
				return true;
			}
		}
		else if (x.compareTo(actNode.element) > 0) {
			//Kolla vänster gren
			if (actNode.right != null) {
				return add(actNode.right, x);
			} else {
				actNode.right = new BinaryNode<>(x);
				size++;
				return true;
			}
		}
		else return false;
	}
	
	/**
	 * Computes the height of tree.
	 * @return the height of the tree
	 */
	public int height() {
		return height(root);
	}
	private int height(BinaryNode<E> n) {
		if (n == null) {
			return 0;
		}
		else {
			int leftHeight = height(n.left);
			int rightHeight = height(n.right);
			if (leftHeight > rightHeight) return  leftHeight + 1;
			else return rightHeight + 1;
		}
	}
	
	/**
	 * Returns the number of elements in this tree.
	 * @return the number of elements in this tree
	 */
	public int size() {
		return size;
	}
	
	/**
	 * Print tree contents in inorder.
	 */
	public void printTree() {
		printTree(root);
	}
	private void printTree(BinaryNode<E> n) {
		if (n != null) {
			printTree(n.left);
			System.out.println(n.element);
			printTree(n.right);
		}
	}

	/** 
	 * Builds a complete tree from the elements in the tree.
	 */
	public void rebuild() {

	}
	
	/*
	 * Adds all elements from the tree rooted at n in inorder to the array a
	 * starting at a[index].
	 * Returns the index of the last inserted element + 1 (the first empty
	 * position in a).
	 */
	private int toArray(BinaryNode<E> n, E[] a, int index) {
		if (n != null) {
			index += toArray(n.left, a, index);
			a[index] = n.element;
			System.out.println("Index: " + index);
			index++;
			index += toArray(n.right, a, index++);
			return index;
		}
		else return 0;
	}
	
	/*
	 * Builds a complete tree from the elements a[first]..a[last].
	 * Elements in the array a are assumed to be in ascending order.
	 * Returns the root of tree.
	 */
	private BinaryNode<E> buildTree(E[] a, int first, int last) {
		return null;
	}
	


	static class BinaryNode<E> {
		E element;
		BinaryNode<E> left;
		BinaryNode<E> right;

		private BinaryNode(E element) {
			this.element = element;
		}	
	}
	
}
