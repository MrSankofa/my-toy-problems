

function bubbleSort(a) {

  let swaps = 0;
  for(let i = 0; i < a.length; i++) {
    for( let j = 0; j < a.length - i - 1; j++) {
      if(a[j] > a[j + 1]) {
        const temp = a[j];
        a[j] = a[j + 1];
        a[j + 1] = temp;
        swaps++;
      }
    }
  }

  const result = `Array is sorted in ${swaps} swaps.
  First Element: ${a[0]}
  Last Element: ${a[a.length - 1]}
  `
  return result
}

module.exports = bubbleSort