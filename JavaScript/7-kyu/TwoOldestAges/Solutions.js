// TwoOldestAges - JavaScript
function twoOldestAges(ages){
  let oldest = -Infinity, second = -Infinity;
  for (const v of ages){
    if (v > oldest){ second = oldest; oldest = v; }
    else if (v > second) second = v;
  }
  return [second, oldest];
}
module.exports = { twoOldestAges };
