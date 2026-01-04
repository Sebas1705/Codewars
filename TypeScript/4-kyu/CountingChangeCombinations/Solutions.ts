export function countChange(money: number, nCoins: number, coins: number[]): number {
  if (money === 0) return 1;
  if (money < 0 || nCoins === 0) return 0;
  return countChange(money - coins[nCoins - 1], nCoins, coins) +
         countChange(money, nCoins - 1, coins);
}
