Sorting Algorithms
====================
-------
-------

Insertion Sort
---------------------

Is a simple sorting algorithm that builds the final sorted array (or list) one item at a time, it compares the current element with the left element, if it's smaller, they are swaped, and repeats until the first element. It continues the process iteratively for each element.

 It is much less efficient on large lists than more advanced algorithms such as **QuickSort**, **Heapsort**, or **Merge sort**.

For smaller arrays its the preferred algorithm.

 - *Online*
 - *Stable*
 - *Adaptative*
 - *In-place*

|Complexity|            |
|----------|:-------------:|
| Avg. Time |  О(n2)  |
| Space total |    О(n)    |
| Aux | О(1)  |
 
 ----
 Selection Sort
---------------------
 
 The algorithm divides the input list into two parts: the sublist of items already sorted, which is built up from left to right at the front (left) of the list, and the sublist of items remaining to be sorted that occupy the rest of the list.
 
 **Selection Sort** swaps at most n times but needs to scan every element to know how is the lower, since it cant get  helped by the ordernes of an array **Insertion Sort** is faster.
 
 - *unstable*
 - *In-place*
 
|Complexity		|            |
|----------		|:-------------:|
| Avg. Time 	|  О(n2)  |
| Space total 	|    О(n)    |
| Aux | О(1)  	|
 
 
 -------
  Bubble Sort
---------------------
 
 Is a simple sorting algorithm that repeatedly steps through the list to be sorted, compares each pair of adjacent items and swaps them if they are in the wrong order. The pass through the list is repeated until no swaps are needed, which indicates that the list is sorted. 
 
 **Bubble Sort** swap n * n(n -1), therefore **Selection sort** is faster.
 
 - *Stable*
 - *Adaptative*
 - *In-place*
 
|Complexity		|            |
|----------		|:-------------:|
| Avg. Time 	|  О(n2)  |
| Space total 	|    О(n)    |
| Aux | О(1)  	|
 
 
 -------  
  Shell Sort
---------------------
 
 Its an **Insertion Sort** optimized to move small elements in the tail of the array to te top faster by increasing the gap of comparisons between elements.
 We could see insertion sort as an selection sort with gap 1;
 There are serveral gap algorithms for the Shell Sort.
 
 - *Unstable*
 - *Adaptative*
 - *In-place*
 
|Complexity		|            |
|----------		|:-------------:|
| Avg. Time 	|  depends on gap |
| worst case	|  O(n2) |
| Space total 	|    О(n)    |
| Aux | О(1)  	|
 
 
 -------  
 Merge Sort
---------------------


Conceptually, a merge sort works as follows:

* Divide the unsorted list into n sublists, each containing 1 element (a list of 1 element is considered sorted).
*	Repeatedly merge sublists to produce new sorted sublists until there is only 1 sublist remaining. This will be the sorted list.


|Complexity|            |
|----------|:-------------:|
| Avg. Time |  O(n log n)  |
| Space |    O(n)    |