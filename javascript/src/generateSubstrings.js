
function generateSubstrings(str) {
  const substrings = [];
  for (let start = 0; start < str.length; start++) {
    let substring = "";
    for (let nextCharIndex = start; nextCharIndex < str.length; nextCharIndex++) {
      substring += str[nextCharIndex];
      substrings.push(substring); // collect substrings
    }
  }
  return substrings;
}

module.exports = generateSubstrings