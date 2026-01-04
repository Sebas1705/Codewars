// FindTheUniqueNumber - JavaScript
function findUniq(arr){
  const a = arr.slice(0,3);
  if (a[0] !== a[1] && a[0] !== a[2]) return a[0];
  const common = (a[0] === a[1]) ? a[0] : a[2];
  return arr.find(x => x !== common);
}
module.exports = { findUniq };
