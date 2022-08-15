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

/**
   * Retrieves the smallest integer data from this tree.
   * - Time: O(?).
   * - Space: O(?).
   * @param {Node} current The node that is currently accessed from the tree as
   *    the tree is being traversed.
   * @returns {number} The smallest integer from this tree.
   */
 minRecursive(current = this.root) {
    if (!current) return null;
    if (!current.left) return current.data;
    return this.minRecursive(current.left);   
 }

 /**
 * Determines if this tree contains the given searchVal.
 * - Time: O(?).
 * - Space: O(?).
 * @param {number} searchVal The number to search for in the node's data.
 * @returns {boolean} Indicates if the searchVal was found.
 */
contains(searchVal) {
    let ptr = this.root;
    while (ptr) {
        if (ptr.data == searchVal) return true;
        if (ptr.data > searchVal) ptr = ptr.left;
        else ptr = ptr.right;
    }
    return false;
}

/**
 * Determines if this tree contains the given searchVal.
 * - Time: O(?).
 * - Space: O(?).
 * @param {number} searchVal The number to search for in the node's data.
 * @returns {boolean} Indicates if the searchVal was found.
 */
containsRecursive(searchVal, current = this.root) {
    if (!current) return false;
    if (current.data == searchVal) return true;
    if(current.data > searchVal) return this.containsRecursive(searchVal, current.left);
    return this.containsRecursive(searchVal, current.right);
}

/**
 * Calculates the range (max - min) from the given startNode.
 * - Time: O(?).
 * - Space: O(?).
 * @param {Node} startNode The node to start from to calculate the range.
 * @returns {number|null} The range of this tree or a sub tree depending on if the
 *    startNode is the root or not.
 */
 range() {}
 // Advice: make a max() and use it together with min()

 /**
 * Inserts a new node with the given newVal in the right place to preserver
 * the order of this tree.
 * - Time: O(?).
 * - Space: O(?).
 * @param {number} newVal The data to be added to a new node.
 * @param {Node} curr The node that is currently accessed from the tree as
 *    the tree is being traversed.
 * @returns {BinarySearchTree} This tree.
 */
insertRecursive(newVal, curr = this.root) {}
}

const root = new BinarySearchTree();
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
console.log('recursive min:', root.minRecursive());
console.log('contains 13?', root.contains(13));
console.log('contains 15?', root.contains(15));
console.log('recursive contains 1?', root.containsRecursive(17));
console.log('recursive contains 7?', root.containsRecursive(7));
