export function determinant(matrix: number[][]): number {
  const n = matrix.length;
  if (n === 1) return matrix[0][0];
  if (n === 2) return matrix[0][0]*matrix[1][1] - matrix[0][1]*matrix[1][0];
  let det = 0;
  for (let col = 0; col < n; col++) {
    const sub: number[][] = [];
    for (let i = 1; i < n; i++) {
      const row: number[] = [];
      for (let j = 0; j < n; j++) {
        if (j === col) continue;
        row.push(matrix[i][j]);
      }
      sub.push(row);
    }
    const subDet = determinant(sub);
    det += ((col % 2 === 0) ? 1 : -1) * matrix[0][col] * subDet;
  }
  return det;
}
