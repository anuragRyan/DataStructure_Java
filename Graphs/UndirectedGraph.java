package Graphs;

public class UndirectedGraph {
    int[][] adjMatrix;

    public UndirectedGraph(int nodes) {
        this.adjMatrix = new int[nodes][nodes];
    }

    private void addEdge(int r, int c) {
        this.adjMatrix[r][c] = 1;
        this.adjMatrix[c][r] = 1;
    }

    public void printMatrix(int[][] matrix, int nodes) {
        for (int i = 0; i < nodes; i++) {
            for (int j : adjMatrix[i]) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        UndirectedGraph ug = new UndirectedGraph(4);
        ug.addEdge(0, 1);
        ug.addEdge(1, 2);
        ug.addEdge(2, 3);
        ug.addEdge(3, 0);

        ug.printMatrix(ug.adjMatrix, 4);
    }

}
