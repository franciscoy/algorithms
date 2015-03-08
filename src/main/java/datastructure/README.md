Data Structures
====================
-------
-------

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