const printCharWithFreq = s => {
    // initialize a Map to hold counts of characters in the string
    // a Map will keep keys sorted in the order in which they are added
    const charCounts = new Map();

    // iterate over the string, increment each char's count in the Map
    // or set char count to 1, if it's not yet in the Map
    for (c of s) {
        charCounts.set(c, charCounts.get(c) + 1 || 1);
    }
    console.log(charCounts.values().join(''));
    // create and return array with key, value pairs of char counts in the Map
    return Array.from(charCounts.entries());
}

const s = 'abracadabra';

console.log(printCharWithFreq(s));
console.log(printCharWithFreq("abracadabra"))// [['a', 5], ['b', 2], ['r', 2], ['c', 1], ['d', 1]]
console.log(printCharWithFreq("Code Wars")) // [['C', 1], ['o', 1], ['d', 1], ['e', 1], [' ', 1], ['W', 1], ['a', 1], ['r', 1], ['s', 1]]
console.log(printCharWithFreq("233312")) // [ [ '2', 2 ], [ '3', 3 ], [ '1', 1 ] ]

