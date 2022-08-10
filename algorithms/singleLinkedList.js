//metaphor: node === each person in chipotle line
class Node{
    constructor(valueInput){
        this.value = valueInput;
        this.next = null;
    }
}
//A data structure that represents a list. The list is made out of "nodes". 
//Each node will have a value and a .next. 
//The .next of a node will point to the address of the node "behind" it in "line"
//metaphor: SLL === the line at chipotle

class SLL{
    constructor(){
        this.head = null;
    }

    isEmpty(){
        return this.head === null;
    }

    insertAtFront(valueInput){
        //create a person/node with that valueInput
        if (this.isEmpty())
            this.head = new Node(valueInput);
        else {
            let newPerson = new Node(valueInput);
            newPerson.next = this.head;
            this.head = newPerson;
        }
    }

    insertAtBack(valueInput) {
        if (this.isEmpty())
            this.head = new Node(valueInput);
        else {
            let ptr = this.head;
            while (ptr.next) {
                ptr = ptr.next;
            }
            ptr.next = new Node(valueInput);
        }
    }

    removeFromFront(){
        if (!this.isEmpty()) 
            this.head = this.head.next;
    }

    display(){
        let output = '';
        let ptr = this.head;
        while (ptr) {
            output += ptr.value;
            output += ' --> ';
            ptr = ptr.next;
        }
        output += 'null';
        console.log(output);
    }

    /**
   * Calls insertAtBack on each item of the given array.
   * - Time: O(n * m) n = list length, m = arr.length.
   * - Space: O(1) constant.
   * @param {Array<any>} vals The data for each new node.
   * @returns {SinglyLinkedList} This list.
   */
    seedFromArr(vals) {
        for (const v of vals) {
            this.head.insertAtBack(v);
        }
    }

    /**
     * Converts this list into an array containing the data of each node.
     * - Time: O(n) linear.
     * - Space: O(n).
     * @returns {Array<any>} An array of each node's data.
     */
    toArr() {
        const arr = [];
        let ptr = this.head;
        while (ptr) {
            arr.push(v);
        }
        return arr;
    }

    /**
    * Creates a new node with the given data and inserts it at the back of
    * this list.
    * - Time: O(?).
    * - Space: O(?).
    * @param {any} data The data to be added to the new node.
    * @param {?ListNode} runner The current node during the traversal of this list
    *    or null when the end of the list has been reached.
    * @returns {SinglyLinkedList} This list.
    */
    insertAtBackRecursive(data, runner = this.head) {
        if (!runner) {
            this.head = new Node(data);
            return;
        }
        if (!runner.next) {
            runner.next = new Node(data);
            return;
        }
        this.insertAtBackRecursive(data, runner.next);
    }

    /**
 * Removes the last node of this list.
 * - Time: O(?).
 * - Space: O(?).
 * @returns {any} The data from the node that was removed.
 */
removeBack() {
    if (this.isEmpty()) return null;
    if (!this.head.next) {
        const val = this.head.value;
        this.head = null;
        return val;
    }
    let ptr = this.head;
    while (ptr.next.next) {
        ptr = ptr.next;
    }
    const val = ptr.next.value;
    ptr.next = null;
    return val;
}

/**
 * Determines whether or not the given search value exists in this list.
 * - Time: O(?).
 * - Space: O(?).
 * @param {any} val The data to search for in the nodes of this list.
 * @returns {boolean}
 */
contains(val) {
    let ptr = this.head;
    while (ptr) {
        if (ptr.value == val) return true;
        ptr = ptr.next;
    }
    return false;
}

/**
 * Determines whether or not the given search value exists in this list.
 * - Time: O(?).
 * - Space: O(?).
 * @param {any} val The data to search for in the nodes of this list.
 * @param {?ListNode} current The current node during the traversal of this list
 *    or null when the end of the list has been reached.
 * @returns {boolean}
 */
containsRecursive(val, current = this.head) {
    if (!!current) return false;
    if (current.value === val) return true;
    this.containsRecursive(val, current.next);
}

/**
 * Retrieves the data of the second to last node in this list.
 * - Time: O(?).
 * - Space: O(?).
 * @returns {any} The data of the second to last node or null if there is no
 *    second to last node.
 */
    secondToLast() {
        if (this.head == null || this.head.next == null)
            return null;
        let ptr = this.head;
        while(ptr.next.next != null) {
            ptr = ptr.next;
        }
        return ptr.value;
    }

/**
  * Removes the node that has the matching given val as it's data.
  * - Time: O(?).
  * - Space: O(?).
  * @param {any} val The value to compare to the node's data to find the
  *    node to be removed.
  * @returns {boolean} Indicates if a node was removed or not.
  */
    removeVal(val) {
        if (this.head == null) 
            return false;
        if (this.head.value == val) {
            this.head = this.head.next;
            return true;
        }
        let ptr = this.head;
        while (ptr.next != null) {
            if (ptr.next.value == val) {
                ptr.next = ptr.next.next;
                return true;
            } 
            ptr = ptr.next;
        }
        return false;
    }

    /**
 * Inserts a new node before a node that has the given value as its data.
 * - Time: O(?).
 * - Space: O(?).
 * @param {any} newVal The value to use for the new node that is being added.
 * @param {any} targetVal The value to use to find the node that the newVal
 *    should be inserted in front of.
 * @returns {boolean} To indicate whether the node was pre-pended or not.
 */
 prepend(newVal, targetVal) {
    if (this.head == null) return;
    if (this.head.value == targetVal) {
        const newNode = new Node(newVal);
        newNode.next = this.head;
        this.head = newNode;
        return;
    }
    let ptr = this.head;
    while (ptr.next != null) {
        if (ptr.next.value == targetVal) {
            const newNode = new Node(newVal);
            newNode.next = ptr.next;
            ptr.next = newNode;
            break;
        }
        ptr = ptr.next;
    }
 }

 /**
 * Finds the node with the smallest data and moves that node to the front of
 * this list.
 * - Time: O(?).
 * - Space: O(?).
 * @returns {SinglyLinkedList} This list.
 */
moveMinToFront() {
    if (this.head == null) return;
    let min = this.head.value;
    let ptr = this.head.next;
    // find min value in list
    while (ptr != null) {
        min = Math.min(min, ptr.value);
        ptr = ptr.next;
    }
    if (this.head.value == min) return;
    // remove node with min value
    this.removeVal(min);
    // add node with min value to front
    this.insertAtFront(min);
}

/**
 * Concatenates the nodes of a given list onto the back of this list.
 * - Time: O(?).
 * - Space: O(?).
 * @param {SinglyLinkedList} addList An instance of a different list whose
 *    whose nodes will be added to the back of this list.
 * @returns {SinglyLinkedList} This list with the added nodes.
 */
 concat(addList) {
    if (this.head == null) {
        this.head = addList.head;
        return;
    }
    let ptr = this.head;
    while (ptr.next != null) {
        ptr = ptr.next;
    }
    ptr.next = addList.head;
 }

 /**
 * Splits this list into two lists where the 2nd list starts with the node
 * that has the given value.
 * splitOnVal(5) for the list (1=>3=>5=>2=>4) will change list to (1=>3)
 * and the return value will be a new list containing (5=>2=>4)
 * - Time: O(?).
 * - Space: O(?).
 * @param {any} val The value in the node that the list should be split on.
 * @returns {SinglyLinkedList} The split list containing the nodes that are
 *    no longer in this list.
 */
splitOnVal(val) {
    let ptr = this.head;
    while (ptr != null && ptr.next.value != val) {
        ptr = ptr.next;
    }
    if (ptr == null) return;
    let res = ptr.next;
    ptr.next = null;
    return res;
}

/**
 * Recursively finds the maximum integer data of the nodes in this list.
 * - Time: O(?).
 * - Space: O(?).
 * @param {ListNode} runner The start or current node during traversal, or null
 *    when the end of the list is reached.
 * @param {ListNode} maxNode Keeps track of the node that contains the current
 *    max integer as it's data.
 * @returns {?number} The max int or null if none.
 */
recursiveMax(runner = this.head, maxNode = this.head) {
    if (this.isEmpty()) return null;
    if (runner == null) return maxNode.value;
    if (maxNode.value < runner.value) 
        return this.recursiveMax(runner.next, runner);
    return this.recursiveMax(runner.next, maxNode);
}
}

let head = new SLL();
head.insertAtBack(5);
head.insertAtBack(10);
head.insertAtBack(15);
head.insertAtBack(3);
head.insertAtBack(12);

console.log("-------");
head.display();
head.prepend(7, 5);
head.display();
head.prepend(17, 3);
head.display();
head.prepend(19, 4);
head.display();
head.prepend(6, 12);
head.display();

console.log("-------");
head.moveMinToFront();
head.display();

head.insertAtBack(2);
head.display();
head.moveMinToFront();
head.display();
head.moveMinToFront();
head.display();

console.log("...........");
let newHead = head.splitOnVal(15);
head.display();
let ptr = newHead;
let output = "";
while (ptr != null) {
    output += ptr.value + " --> ";
    ptr = ptr.next;
}
output += "null";
console.log(output);

console.log(".......");
head.display();
const difHead = new SLL();
difHead.insertAtBack(6);
difHead.insertAtBack(12);
difHead.insertAtBack(18);
head.concat(difHead);
head.display();

console.log(head.recursiveMax(this.head, this.head));