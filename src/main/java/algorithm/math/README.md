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

Matrix Multiplication (Naive)
---------------------

Matrix multiplication is a binary operation that takes a pair of matrices, and produces another matrix.
It's not implemented efficiently as the Strassen algorithm.

|Complexity|            |
|----------|:-------------:|
| Worst Case |  О(n^3)  |
| Avg. Case |  О(n^3)  |
| Total Space |  О(n)  |
| Aux Space |  О(1)  |

