import java.util.Arrays;

public class BusiestBusRow {

    public static void main(String[] args) {
        int[][] grid = {
            {2, 0, 1},
            {3, 3, 1},
            {1, 1, 1}
        };

        System.out.println("Grid:");
        for (int[] row : grid) {
            System.out.println(Arrays.toString(row));
        }

        int[] result = busiestRow(grid);
        System.out.printf("Row %d, Total %d%n", result[0], result[1]);
    }

    public static int[] busiestRow(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return new int[]{-1, 0};
        }

        int bestRowIndex = 0;
        int maxTotal = -1;

        for (int r = 0; r < grid.length; r++) {
            int rowTotal = 0;
            for (int c = 0; c < grid[r].length; c++) {
                rowTotal += grid[r][c];
            }

            // Strictly greater ensures tie-breaking goes to the smaller index
            if (rowTotal > maxTotal) {
                maxTotal = rowTotal;
                bestRowIndex = r;
            }
        }

        return new int[]{bestRowIndex, maxTotal};
    }
}