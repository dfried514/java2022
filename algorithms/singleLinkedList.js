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
