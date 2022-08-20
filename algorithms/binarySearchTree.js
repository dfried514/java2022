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

/**
 * DFS Inorder: (Left, CurrNode, Right)
 * Converts this BST into an array following Depth First Search inorder.
 * See debugger call stack to help understand the recursion.
 * @param {Node} node The current node during the traversal of this tree.
 * @param {Array<number>} vals The data that has been visited so far.
 * @returns {Array<number>} The vals in DFS Preorder once all nodes visited.
 */
 toArrInorder(node = this.root, vals = []) {
    if (!node) return vals;
    this.toArrInorder(node.left, vals);
    vals.push(node.data);
    this.toArrInorder(node.right, vals);
    return vals;
 }

/**
 * DFS Preorder: (CurrNode, Left, Right)
 * Converts this BST into an array following Depth First Search preorder.
 * @param {Node} node The current node during the traversal of this tree.
 * @param {Array<number>} vals The data that has been visited so far.
 * @returns {Array<number>} The vals in DFS Preorder once all nodes visited.
 */
 toArrPreorder(node = this.root, vals = []) {
    if (!node) return vals;
    vals.push(node.data);
    this.toArrPreorder(node.left, vals);
    this.toArrPreorder(node.right, vals);
    return vals;
 }

/**
 * DFS Postorder (Left, Right, CurrNode)
 * Converts this BST into an array following Depth First Search postorder.
 * @param {Node} node The current node during the traversal of this tree.
 * @param {Array<number>} vals The data that has been visited so far.
 * @returns {Array<number>} The vals in DFS Preorder once all nodes visited.
 */
 toArrPostorder(node = this.root, vals = []) {
    if (!node) return vals;
    this.toArrPostorder(node.left, vals);
    this.toArrPostorder(node.right, vals);
    vals.push(node.data);
    return vals;
 }

 /**
 * BFS order: horizontal rows top-down left-to-right.
 * Converts this BST into an array following Breadth First Search order.
 * Example on the fullTree var:
 * [25, 15, 50, 10, 22, 35, 70, 4, 12, 18, 24, 31, 44, 66, 90]
 * @param {Node} current The current node during the traversal of this tree.
 * @returns {Array<number>} The data of all nodes in BFS order.
 */
  toArrLevelorder(current = this.root) {
    if (this.isEmpty()) return [];
    const res = [];
    const nodeArr = [current];
    while (nodeArr.length > 0) {
        let curNode = nodeArr.shift();
        res.push(curNode.data);
        if (curNode.left) nodeArr.push(curNode.left);
        if (curNode.right) nodeArr.push(curNode.right);
    }
    return res;
  }

  /**
   * Recursively counts the total number of nodes in this tree.
   * - Time: O(?).
   * - Space: O(?).
   * @param {Node} node The current node during the traversal of this tree.
   * @returns {number} The total number of nodes.
   */
  size(node = this.root) {}
 
 
 //          50
 //      25      75
 //   10   40  60   90
 
 // [50, 25, 75, 10, 40, 60, 90]

 /**
   * Calculates the height of the tree which is based on how many nodes from
   * top to bottom (whichever side is taller).
   * - Time: O(?).
   * - Space: O(?).
   * @param {Node} node The current node during traversal of this tree.
   * @returns {number} The height of the tree.
   */
  height(node = this.root) {
    if (!node) return 0;
    // recursively compute max of left and right subtrees, add 1 for the current node
    return 1 + Math.max(this.height(node.left), this.height(node.right));
  }

  /**
   * Determines if this tree is a full tree. A full tree is a tree where every
   * node has both a left and a right except for the leaf nodes (last nodes)
   * - Time: O(?).
   * - Space: O(?).
   * @param {Node} node The current node during traversal of this tree.
   * @returns {boolean} Indicates if this tree is full.
   */
    isFull(node = this.root) {
        // no children
        if (!node) return true;
        // one child, not full, return false
        if ((node.left && !node.right) || (node.right && !node.left)) return false;
        // recursively check left AND right subtrees
        return this.isFull(node.left) && this.isFull(node.right);
    }

    /**
 * Removes the node that has the matching given val as its data
 * - Time: O(?).
 * - Space: O(?).
 * @param {any} The value to compare to the node's data to find the
 *    node to be removed.
 * @returns {boolean} Indicates if the node was removed or not.
 */
 removeVal( val ) {}

 /**
  * Finds all the values that are repeated in the binary search tree
  * - Time: O(?).
  * - Space: O(?).
  * @returns {Array<Number>} The values that are repeated in the binary search tree
  */
    findDuplicates(current = this.root, result = []) {
        if (!current) return result;
        let ptr = current.right;
        while (ptr) {
            if (ptr.data == current.data && !result.includes(ptr.data)) {
                result.push(ptr.data);
                break;
            }
            if (ptr.data > current.data)
                ptr = ptr.left;
            else 
                ptr = ptr.right;
        }
        this.findDuplicates(current.left, result);
        this.findDuplicates(current.right, result);
        return result;
    }
}

const root = new BinarySearchTree();
root.insert(10);
root.insert(15);
root.insert(5);
root.insert(12);
root.insert(15);
root.insert(10);
root.insert(7);
root.insert(15);
root.insert(5);

console.log(root.inorderDisplay());
// console.log(root.toArrInorder());
// console.log(root.toArrPreorder());
// console.log(root.toArrPostorder());
console.log(root.toArrLevelorder());
// console.log('height', root.height());
// console.log('is full?', root.isFull());
console.log('duplicates', root.findDuplicates());
