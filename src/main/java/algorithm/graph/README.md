Graph Algorithms
====================
-------
-------

Kerger Min-cut
---------------------

**Randomized Algorithm**

The idea of the algorithm is based on the concept of contraction of an edge (u, v) in an undirected graph G = (V, E). Informally speaking, the contraction of an edge merges the nodes u and v into one, reducing the total number of nodes of the graph by one. All other edges connecting either u or v are "reattached" to the merged node, effectively producing a multigraph. Karger's basic algorithm iteratively contracts randomly chosen edges until only two nodes remain; those nodes represent a cut in the original graph. 

By iterating this basic algorithm a sufficient number of times, a minimum cut can be found with high probability.

|Complexity|            |
|----------|:-------------:|
| Avg Case |  О(n^2 log^3 n)  |

Breadth First Search
---------------------

Breadth-first search (BFS) is an algorithm for traversing or searching tree or graph data structures. It starts at the tree root (or some arbitrary node of a graph) and explores the neighbor nodes first, before moving to the next level neighbours.

|Complexity|            |
|----------|:-------------:|
| Worst Case |  О(|N|+|E|)  |

(|N| = vertices count
|E| = edges count)

Basic Shortest Path (BFS)
---------------------

Basic Shortest path based on Breadth First Search,
in which neighbors from current vertex get current vertex distance to root + 1

|Complexity|            |
|----------|:-------------:|
| Worst Case |  О(|N|+|E|)  |

Count Connected Components (BFS)
---------------------

It is straightforward to compute the connected components of a graph in linear time (in terms of the numbers of the vertices and edges of the graph) using either **breadth-first search** or **depth-first search**. In either case, a search that begins at some particular vertex v will find the entire connected component containing v (and no more) before returning. To find all the connected components of a graph, loop through its vertices, starting a new breadth first or depth first search whenever the loop reaches a vertex that has not already been included in a previously found connected component.

|Complexity|            |
|----------|:-------------:|
| Worst Case |  О(|N|+|E|)  |



---------------------------------------------------------------
---------------------

Graph representations
---------------------
Different data structures for the representation of graphs are used in practice:

**Adjacency list** (used for sparse matrices)

Vertices are stored as records or objects, and every vertex stores a list of adjacent vertices. This data structure allows the storage of additional data on the vertices. Additional data can be stored if edges are also stored as objects, in which case each vertex stores its incident edges and each edge stores its incident vertices.

