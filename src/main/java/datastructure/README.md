Data Structures
====================
-------
-------

Stack, linked-list/dynamic array
---------------------

In computer science, a stack or LIFO (last in, first out) is an abstract data type that serves as a collection of elements, with two principal operations: push, which adds an element to the collection, and pop, which removes the last element that was added.

The term LIFO stems from the fact that, using these operations, each element "popped off" a stack in series of pushes and pops is the last (most recent) element that was "pushed into" within the sequence. This is equivalent to the requirement that, considered as a linear data structure, or more abstractly a sequential collection, the push and pop operations occur only at one end of the structure, referred to as the top of the stack.


|Operations | Complexity |
|----------|:-------------:|
| Push 		|  О(1)	 |
| Pop 		|  О(1)	 |
| isEmpty 	|  О(1)  |

Heap, Min-Heap/Max-Heap
---------------------

Is a specialized tree-based data structure that satisfies the heap property: If A is a parent node of B then the key of node A is ordered with respect to the key of node B with the same ordering applying across the heap.

 Heaps can be classified further as either a **"max heap"** or a **"min heap"**. In a max heap, the keys of parent nodes are always greater than or equal to those of the children and the highest key is in the root node. In a min heap, the keys of parent nodes are less than or equal to those of the children and the lowest key is in the root node. 

- Usages:
  * PriorityQueue (ADT)
  * Scheduling application
  * HeapSort

|Operations | Complexity |
|----------|:-------------:|
| Find min/max element |  О(1)  |
| Extract min/max element |    О(log n)    |
| Insert element | О(log n)  |
 
 ----

Binary Search Tree, Unbalanced
---------------------

Binary search trees (BST), sometimes called ordered or sorted binary trees, are a class of data structures used to implement lookup tables and dynamic sets. They store data items, known as keys, and allow fast insertion and deletion of such keys, as well as checking whether a key is present in a tree.

Binary search trees keep their keys in sorted order, so that lookup and other operations can use the principle of binary search: when looking for a key in a tree (or a place to insert a new key), they traverse the tree from root to leaf, making comparisons to keys stored in the nodes of the tree and deciding, based on the comparison, to continue searching in the left or right subtrees.

Since the tree is unbalanced the height may be n in the worst case

|Operations | Complexity |
|----------|:-------------:|
| Insert |  О(height) -> О(n)  |
| Search  |  О(height) -> О(n)  |
| Delete | О(height) -> О(n)  |
| Traverse | О(n) |

 ----
 
 Union-Find
---------------------

A **disjoint-set** data structure, also called a **union–find** data structure or merge–find set, is a data structure that keeps track of a set of elements partitioned into a number of disjoint (nonoverlapping) subsets. It supports two useful operations:

Find: Determine which subset a particular element is in. Find typically returns an item from this set that serves as its "representative"; by comparing the result of two Find operations, one can determine whether two elements are in the same subset.
Union: Join two subsets into a single subset.

|Operations | Complexity |
|----------|:-------------:|
| Union |  O(α(n)) |
| Find  |  O(α(n))  |

(α = Inverse Ackermann function, almost constant time)