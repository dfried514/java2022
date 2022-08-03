const removeRottenFruits = fruits => {
    // create a new array to return by mapping over the input array
    return fruits.map(fruit => 
        fruit.startsWith('rotten')
        // if a fruit starts with 'rotten', remove 'rotten',
        // and convert the fruit to lower case 
        ? fruit.substring(6).toLowerCase()
        // otherwise, leave the fruit as is
        : fruit
    );
}
const fruits = ['pear', 'rottenApple', 'rottenTomato', 'banana'];
const noFruits = [];

console.log(removeRottenFruits(fruits));
console.log(removeRottenFruits(noFruits));