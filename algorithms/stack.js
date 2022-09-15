class StackNode {
    constructor(data) {
        this.data = data;
        this.next = null;
    }
}
/**
 * Follows a LIFO (Last In First Out) order where new items are stacked on
 * top and removed items are removed from the top.
 */
 class Stack {
    /**
     * The constructor is executed when instantiating a new Stack() to construct
     * a new instance.
     * @returns {Stack} This new Stack instance is returned without having to
     *    explicitly write 'return' (implicit return).
     */
    constructor() {
        this.top = null;
        this.length = 0;
    }

    /**
     * Adds a new given item to the top of this stack.
     * - Time: O(1) constant.
     * - Space: O(1) constant.
     * @param {any} item The new item to be added to the top.
     * @returns {number} The new length of this stack.
     */
    push(item) {
        const newTop = new StackNode(item);
        newTop.next = this.top;
        this.top = newTop;
        return ++this.length;
    }

    /**
     * Removes the top / last item from this stack.
     * - Time: O(1) constant.
     * - Space: O(1) constant.
     * @returns {any} The removed item or undefined if this stack was empty.
     */
    pop() {
        if (this.top == null)
            return undefined;
        const topItem = this.top.data;
        this.top = this.top.next;
        this.length--;
        return topItem;
    }

    /**
     * Retrieves the top / last item from this stack without removing it.
     * - Time: O(1) constant.
     * - Space: O(1) constant.
     * @returns {any} The top / last item of this stack.
     */
    peek() {
        if (this.top == null)
            return undefined;
        return this.top.data;
    }

    /**
     * Returns whether or not this stack is empty.
     * - Time: O(1) constant.
     * - Space: O(1) constant.
     * @returns {boolean}
     */
    isEmpty() {
        return this.top == null;
    }

    /**
     * Returns the size of this stack.
     * - Time: O(1) constant.
     * - Space: O(1) constant.
     * @returns {number} The length.
     */
    size() {
        return this.length;
    }
}