Counting Algorithms
====================
-------
-------

Count Inversions (Naive)
---------------------
It counts the number of split inverions iterating each element and comparing with the rest of the array.
**It's not as performant as the MergeSort version.**

|Complexity|            |
|----------|:-------------:|
| Avg. Time |  О(n^2)  |
| Space total |    О(n)    |
| Aux | О(n)  |
 

Count Inversions (MergeSort)
---------------------
It counts the number of split inversions between arrays using mergesort.
Using the merge function, we recursively keep counting inversions and adding them up to the ending of the merge.

|Complexity|            |
|----------|:-------------:|
| Avg. Time |  О(n logn)  |
| Space total |    О(n)    |
| Aux | О(n)  |
 