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
| Avg. Time |  О(n^2)  |
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
| Avg. Time 	|  О(n^2)  |
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
| Avg. Time 	|  О(n^2)  |
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
| Worst case	|  O(n^2) |
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

 -------  
Quick Sort
---------------------

**Quicksort** is a comparison sort, meaning that it can sort items of any type for which a "less-than" relation (formally, a total order) is defined. In efficient implementations it is not a stable sort, meaning that the relative order of equal sort items is not preserved. Quicksort can operate in-place on an array, requiring small additional amounts of memory to perform the sorting.

Mathematical analysis of quicksort shows that, on average, the algorithm takes O(n log n) comparisons to sort n items. In the worst case, it makes O(n2) comparisons, though this behavior is rare.

 - *Unstable*
 - *In-place*

|Complexity|            |
|----------|:-------------:|
| Avg. Time |  O(n log n)  |
| Worst case	|  O(n^2) |
| Total Space |    O(n)    |
| Aux Space |    O(log n)    |

 -------   
Heap Sort
---------------------

**Heapsort** is a comparison-based sorting algorithm. Heapsort can be thought of as an improved selection sort: like that algorithm, it divides its input into a sorted and an unsorted region, and it iteratively shrinks the unsorted region by extracting the largest element and moving that to the sorted region. The improvement consists of the use of a heap data structure rather than a linear-time search to find the maximum.

Although somewhat slower in practice on most machines than a well-implemented quicksort, it has the advantage of a more favorable worst-case O(n log n) runtime. Heapsort is an in-place algorithm, but it is not a stable sort.

 - *Unstable*
 - *In-place* (but with a heap)

|Complexity|            |
|----------|:-------------:|
| Avg. Time |  O(n log n)  |
| Worst case	|  O(n log n) |
| Total Space |    O(n)    |
| Aux Space |    O(n)    |