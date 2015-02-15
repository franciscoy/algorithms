Math Algorithms
====================
-------
-------

Closest Pair of Points (Naive)
---------------------
The closest pair of points problem or closest pair problem is a problem of computational geometry: given n points in metric space, find a pair of points with the smallest distance between them. 
It's implemented naivley, such as for each point the distance to all the rest is checked, **n * n**.
**There is a better approach with the divide and conquer algorithm.**


|Complexity|            |
|----------|:-------------:|
| Worst Case |  О(n^2)  |
| Avg. Case |  О(n^2)  |
| Total space |  О(n)  |
| Aux space |  О(1)  |

Closest Pair of Points (Divide and Conquer)
---------------------
Divide the array of Points until sub-array is small enough, find the closest pairs by brute force, and bottom up checking if there is a smaller closest pair with one point on each side of the divided array.


|Complexity|            |
|----------|:-------------:|
| Worst Case |  О(n log n)  |
| Avg. Case |  О(n log n)  |
| Total space |  О(n)  |

