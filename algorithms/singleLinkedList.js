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

}

//metaphor: node === each person in chipotle line
class Node{
    constructor(valueInput){
        this.value = valueInput;
        this.next = null;
    }
}

let chipotleLine = new SLL();
console.log(chipotleLine.isEmpty());

chipotleLine.insertAtFront("David");
chipotleLine.insertAtFront("Mack");
chipotleLine.display();

chipotleLine.removeFromFront();
chipotleLine.display();