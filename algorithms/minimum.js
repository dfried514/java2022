const minimum = (array, param) => {
    // start with 0 as minIdx
    let minIdx = 0;

    // iterate over array, and if new minVal is found
    // set minIdx to that index
    for (let i = 1; i < array.length; i++) {
        minIdx = array[i] < array[minIdx] ? i : minIdx;
    }
    // determine if we're returning value or index and return the min
    return param === 'value' ? array[minIdx] : minIdx;
}
const array = [31, 14, 9, 4, 7, 10];

console.log(minimum(array, 'value'));  //4
console.log(minimum(array, 'index'));  //3