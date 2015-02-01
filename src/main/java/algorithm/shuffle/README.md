Sorting Algorithms
====================
-------
-------

Insertion Sort
---------------------
<br/> 

Is a simple sorting algorithm that builds the final sorted array (or list) one item at a time. It is much less efficient on large lists than more advanced algorithms such as quicksort, heapsort, or merge sort.

For smaller arrays its the preferred algorithm.

|Complexity|            |
|----------|:-------------:|
| Avg. Time |  О(n2)  |
| Space total |    О(n)    |
| Aux | О(1)  |
 
 ----
 Selection Sort
---------------------
 
 The algorithm divides the input list into two parts: the sublist of items already sorted, which is built up from left to right at the front (left) of the list, and the sublist of items remaining to be sorted that occupy the rest of the list.
 
 Selection Sort swaps at most n times but needs to scan every element to know how is the lower, since it cant get  helped by the ordernes of an array Insertion Sort is faster.
 
|Complexity		|            |
|----------		|:-------------:|
| Avg. Time 	|  О(n2)  |
| Space total 	|    О(n)    |
| Aux | О(1)  	|
 
 
 -------
  Bubble Sort
---------------------
 
 Is a simple sorting algorithm that repeatedly steps through the list to be sorted, compares each pair of adjacent items and swaps them if they are in the wrong order. The pass through the list is repeated until no swaps are needed, which indicates that the list is sorted. 
 
 Bubble Sort swap n * n(n -1), therefore Selection sort is faster.
 
|Complexity		|            |
|----------		|:-------------:|
| Avg. Time 	|  О(n2)  |
| Space total 	|    О(n)    |
| Aux | О(1)  	|
 
 
 -------
 Merge Sort
---------------------
<br/> 

Conceptually, a merge sort works as follows:

* Divide the unsorted list into n sublists, each containing 1 element (a list of 1 element is considered sorted).
*	Repeatedly merge sublists to produce new sorted sublists until there is only 1 sublist remaining. This will be the sorted list.


|Complexity|            |
|----------|:-------------:|
| Avg. Time |  O(n log n)  |
| Space |    O(n)    |