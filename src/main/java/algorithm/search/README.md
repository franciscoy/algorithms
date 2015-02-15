Searching Algorithms
====================
-------
-------

Linear Search
---------------------
**Linear search** or **sequential search** is a method for finding a particular value in a list that checks each element in sequence until the desired element is found or the list is exhausted. The list need not be ordered.

Linear search is the simplest search algorithm; it is a special case of brute-force search. Its worst case cost is proportional to the number of elements in the list. Its expected cost is also proportional to the number of elements if all elements are searched equally.

- No need for ordered array.

|Complexity|            |
|----------|:-------------:|
| Worst Case |  О(n)  |
| Avg. Case |  О(n)  |
| Total space |  О(n)  |
| Aux space |  О(1)  |


Binary Search
---------------------
**Binary search** algorithm finds the position of a specified input value (the search "key") within an array sorted by key value. For binary search, the array should be arranged in ascending or descending order. In each step, the algorithm compares the search key value with the key value of the middle element of the array. If the keys match, then a matching element has been found and its index, or position, is returned.

Otherwise, if the search key is less than the middle element's key, then the algorithm repeats its action on the sub-array to the left of the middle element or, if the search key is greater, on the sub-array to the right. If the remaining array to be searched is empty, then the key cannot be found in the array and a special "not found" indication is returned.

|Complexity|            |
|----------|:-------------:|
| Worst Case |  О(log n)  |
| Avg. Case |  О(log n)  |
| Total space |  О(n)  |
| Aux space |  О(1)  |
