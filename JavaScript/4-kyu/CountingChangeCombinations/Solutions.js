function countChange(money, nCoins, coins) {
  if (money === 0) return 1;
  if (money < 0 || nCoins === 0) return 0;
  return countChange(money - coins[nCoins - 1], nCoins, coins) +
         countChange(money, nCoins - 1, coins);
}

console.log(countChange(10, [5,2,3].length, [5,2,3]));

module.exports = { countChange };
