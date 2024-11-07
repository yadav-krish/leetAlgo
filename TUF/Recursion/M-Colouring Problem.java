// You are given an undirected graph consisting of v vertices and a list of edges, along with an integer m. Your task is to determine whether it is possible to color the graph using at most m different colors such that no two adjacent vertices share the same color. Return true if the graph can be colored with at most m colors, otherwise return false.

// Note: The graph is indexed with 0-based indexing.

// Examples:

// Input: v = 4, edges[] = [(0,1),(1,2),(2,3),(3,0),(0,2)], m = 3
// Output: true
// Explanation: It is possible to color the given graph using 3 colors, for example, one of the possible ways vertices can be colored as follows:
// Vertex 0: Color 3
// Vertex 1: Color 2
// Vertex 2: Color 1
// Vertex 3: Color 2
// Input: v = 3, edges[] = [(0,1),(1,2),(0,2)], m = 2
// Output: false
// Explanation: It is not possible to color the given graph using only 2 colors because vertices 0, 1, and 2 form a triangle.
// Expected Time Complexity: O(mV)
// Expected Auxiliary Space: O(v2)

// Constraints:
// 1 ≤ v ≤ 20
// 1 ≤ edges.size() ≤ (v*(v-1))/2
// 0 ≤ edges[i][j] ≤ n-1
// 1 ≤ m ≤ v

class Solution {
    // Check if it's safe to color vertex `i` with color `j`
    boolean isSafe(int i, int j, int[][] graph, int[] colour) {
        for (int k = 0; k < colour.length; k++) {
            // If `i` is adjacent to `k` and `k` has the same color `j`
            if (graph[i][k] == 1 && colour[k] == j) {
                return false;
            }
        }
        return true;
    }

    // Recursive function to color the graph
    boolean func(int[][] graph, int[] colour, int i, int v, int m) {
        if (i == v) {
            return true; // All vertices are colored successfully
        }

        // Try all colors from 0 to m-1 for vertex `i`
        for (int j = 0; j < m; j++) {
            if (isSafe(i, j, graph, colour)) {
                colour[i] = j; // Assign color `j` to vertex `i`

                // Recur to assign colors to the rest of the vertices
                if (func(graph, colour, i + 1, v, m)) {
                    return true; // If coloring is successful, return true
                }

                // Backtrack
                colour[i] = -1;
            }
        }
        return false; // No valid coloring found for this configuration
    }

    // Main function to check if the graph can be colored with `m` colors
    boolean graphColoring(int v, List<int[]> edges, int m) {
        int[][] graph = new int[v][v]; // Initialize adjacency matrix for `v` vertices
        int[] colour = new int[v];
        Arrays.fill(colour, -1); // Initialize all vertices as uncolored

        // Populate the adjacency matrix
        for (int[] edge : edges) {
            graph[edge[0]][edge[1]] = 1;
            graph[edge[1]][edge[0]] = 1; // Since it's an undirected graph
        }

        // Start recursive coloring from vertex 0
        return func(graph, colour, 0, v, m);
    }
}
