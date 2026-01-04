// MaximumSubarraySum - JavaScript (Kadane)
function maxSequence(arr){
  let maxSoFar = 0, maxEndingHere = 0;
  for (let v of arr){
    maxEndingHere += v;
    if (maxEndingHere < 0) maxEndingHere = 0;
    if (maxSoFar < maxEndingHere) maxSoFar = maxEndingHere;
  }
  return maxSoFar;
}
module.exports = { maxSequence };
