## Small Utility Algorithms
this README.md contains all the small algorithm used for solving problems.
## Union Find Algorithm  
`find(x)` finds the representative of a given vertex in the graph.
```c
	function find(x):
		if Parent[x] != x:
			return find(Parent[x])
		else:
			return x
```
<hr>

`union(x, y)` merges 2 subsets. First it uses `find()` to find a vertex's representative, if the roots are same no merging is done, if they are different they are merged.  
`subset x` is put in `subset y`
```c
	function union(x, y):
		Parent[find(y)] = find(x)
```
