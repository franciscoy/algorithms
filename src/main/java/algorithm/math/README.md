Math Algorithms
====================
-------
-------

Karatsuba Multiplication
---------------------

It reduces the multiplication of two n-digit numbers to at most  n^(log 3) single-digit multiplications in general. It is therefore faster than the classical algorithm, which requires n^2 single-digit products.
Works by using the divide and sort approach, recursively dividing in 3 smaller subproblems.

|Complexity|            |
|----------|:-------------:|
| Worst Case |  О(n^(log 3))  |

