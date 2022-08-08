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
}

const head = new SLL();
console.log(head.isEmpty());

head.insertAtFront("David");
head.insertAtFront("Mack");
head.display();

head.insertAtBack("Gail");
head.display();

head.removeFromFront();
head.display();

head.insertAtBackRecursive("Jay");
head.insertAtBackRecursive("Steve");
head.display();

head.removeBack();
head.display();

console.log(head.contains("Gail"));
console.log(head.contains("Bev"));

console.log(head.containsRecursive("David"));
console.log(head.containsRecursive("Steve"));

head.display();
console.log("secondToLast:  ", head.secondToLast());

head.removeVal("Gail");
head.display();

console.log("secondToLast: ", head.secondToLast());
