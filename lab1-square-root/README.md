# Лаба 1 — метод квадратного корня

Решение СЛАУ `Ax = b` с симметричной положительно определённой матрицей через разложение `A = SᵀS` (S — верхняя треугольная).

- `SquareRootMethod.decompose` — построение S
- `SquareRootMethod.forward` — `Sᵀy = b`
- `SquareRootMethod.backward` — `Sx = y`
- `SquareRootMethod.residual` — невязка `Ax − b`

Исходные данные — в `Main.java`. Ожидаемый ответ: `x = (1, 2, 3, 4, 5)`.
