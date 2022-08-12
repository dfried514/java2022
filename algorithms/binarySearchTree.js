/**
 * Class to represent a Node in a Binary Search Tree (BST).
 */
 class BSTNode {
    /**
     * Constructs a new instance of a BST node.
     * @param {number} data The integer to store in the node.
     */
    constructor(data) {
      this.data = data;
      /**
       * These properties are how this node is connected to other nodes to form
       * the tree. Similar to .next in a SinglyLinkedList except a BST node can
       * be connected to two other nodes. To start, new nodes will not be
       * connected to any other nodes, these properties will be set after
       * the new node is instantiated.
       *
       * @type {BSTNode|null}
       */
      this.left = null;
      /** @type {BSTNode|null} */
      this.right = null;
    }
  }
  
  /**
   * Represents an ordered tree of nodes where the data of left nodes are <= to
   * their parent and the data of nodes to the right are > their parent's data.
   */
  class BinarySearchTree {
    constructor() {
      /**
       * Just like the head of a linked list, this is the start of our tree which
       * branches downward from here.
       *
       * @type {BSTNode|null}
       */
      this.root = null;
    }


/**
 * Determines if this tree is empty.
 * - Time: O(?).
 * - Space: O(?).
 * @returns {boolean} Indicates if this tree is empty.
 */
isEmpty() {
    return this.root == null;
}

/**
 * Inserts a new node with the given newVal in the right place to preserver
 * the order of this tree.
 * - Time: O(?).
 * - Space: O(?).
 * @param {number} newVal The data to be added to a new node.
 * @returns {BinarySearchTree} This tree.
 */
 insert(newVal) {
    if (this.root == null) {
        this.root = new BSTNode(newVal);
        return;
    }
    let ptr = this.root;
    while (true) {
        if (ptr.data > newVal) {
            if (ptr.left == null) {
                ptr.left = new BSTNode(newVal);
                return;
            }
            ptr = ptr.left;
        } else {
            if (ptr.right == null) {
                ptr.right = new BSTNode(newVal);
                return;
            }
            ptr = ptr.right;
        }
    }
 }

 /**
 * Retrieves the smallest integer data from this tree.
 * - Time: O(?).
 * - Space: O(?).
 * @param {Node} current The node that is currently accessed from the tree as
 *    the tree is being traversed.
 * @returns {number} The smallest integer from this tree.
 */
min(current = this.root) {
    if (!this.root) return null;
    let ptr = this.root;
    while (ptr.left) {
        ptr = ptr.left;
    }
    return ptr.data;
}

inorderDisplay() {
    let output = "";
    const rec = root => {
        if (!root) return;
        rec(root.left);
        output += root.data + " --> ";
        rec(root.right);
    }
    rec(this.root);
    return output + "null";
}
}

const root = new BinarySearchTree();
console.log("empty root", root.isEmpty());
console.log("min of empty root", root.min());
root.insert(10);
root.insert(15);
root.insert(5);
root.insert(12);
root.insert(18);
root.insert(16);
root.insert(7);
root.insert(3);
root.insert(4);

console.log(root.inorderDisplay());
console.log("min val", root.min());
console.log("not empty", root.isEmpty());
