import java.util.*;

class Solution {
    private static final int[][] directions = {
        {1, 0}, {-1, 0}, {0, 1}, {0, -1}
    };

    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        if (image[sr][sc] == newColor) {
            return image;
        }

        int oldColor = image[sr][sc];

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sr, sc});

        // Change the color of the starting pixel
        image[sr][sc] = newColor;

        while (!q.isEmpty()) {
            int[] front = q.poll();
            int x = front[0], y = front[1];

            for (int[] direction : directions) {
                int nx = x + direction[0];
                int ny = y + direction[1];

                // Check boundary conditions and color match
                if (nx >= 0 && nx < image.length && 
                    ny >= 0 && ny < image[0].length && 
                    image[nx][ny] == oldColor) {

                    // Change the color and enqueue
                    image[nx][ny] = newColor;
                    q.offer(new int[]{nx, ny});
                }
            }
        }

        return image;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of rows:");
        int rows = sc.nextInt();
        System.out.println("Enter number of columns:");
        int cols = sc.nextInt();
        sc.nextLine(); // newline

        int[][] matrix = new int[rows][cols];
        System.out.println("Enter the matrix row by row (comma-separated values):");

        for (int i = 0; i < rows; i++) {
            String line = sc.nextLine().trim();
            if (!line.matches("^[0-9,\\s-]+$")) {
                System.out.println("Invalid input format. Only numbers and commas are allowed.");
                return;
            }

            String[] values = line.split(",");
            if (values.length != cols) {
                System.out.println("Invalid number of columns in row " + (i + 1));
                return;
            }

            for (int j = 0; j < cols; j++) {
                matrix[i][j] = Integer.parseInt(values[j].trim());
            }
        }

        System.out.println("Enter the starting x-coordinate");
        int starting_x = sc.nextInt(); 
        System.out.println("Enter the starting y-coordinate");
        int starting_y = sc.nextInt(); 
        System.out.println("Enter the new color value (integer).");
        int new_color = sc.nextInt(); 

        System.out.println();
        System.out.println("Input image: ");
        for(int arr[] : matrix){
            System.out.println(Arrays.toString(arr));
        }

        int newImage[][] = floodFill(matrix,starting_x,starting_y,new_color);

        System.out.println();
        System.out.println("Output image: ");
        for(int arr[] : newImage){
            System.out.println(Arrays.toString(arr));
        }

    }

}