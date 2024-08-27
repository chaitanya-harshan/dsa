package recursion.lec3Hard;

// https://www.geeksforgeeks.org/problems/m-coloring-problem-1587115620/1

// https://youtu.be/wuVwUK25Rfc

// Function to determine if graph can be coloured with at most M colours such
// that no two adjacent vertices of graph are coloured with same colour.
public class _06_M_nodes_coloring {

    public static boolean graphColoring(boolean graph[][], int m, int n) {
        // Your code here
        int[] colors = new int[n];// contains colors of the nodes
        return solve(0, graph, colors, m, n);
    }
    
    static boolean solve(int node, boolean graph[][], int[] colors, int m, int n) {
        if (node == n) return true; // it means we have filled the all the nodes before 
        
        for (int i=1; i<=m; i++) {
            if(isValid(node, i, graph, colors)) {
                colors[node] = i;
                // calling to fill color for next node
                if (solve(node+1, graph, colors, m, n) == true) return true;
                else colors[node] = 0;
            }
        }
        return false;
    }
    
    static boolean isValid(int node, int color, boolean graph[][], int[] colors) {
        //iterating theough graph for adjacent nodes
        for (int col=0; col<graph.length; col++) {
            if (graph[node][col] == true && colors[col] == color) return false;
        }
        return true;
    }
}


