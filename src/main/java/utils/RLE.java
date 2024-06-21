package utils;

public class RLE {

    public static String encode(int[][] input) {
        StringBuilder encoded = new StringBuilder();

        int rows = input.length;
        int cols = input[0].length;

        for (int i = 0; i < rows; i++) {
            int count = 0;
            int current = input[i][0];

            for (int j = 0; j < cols; j++) {
                if (input[i][j] == current) {
                    count++;
                } else {
                    encoded.append(count).append("x").append(current).append(" ");
                    current = input[i][j];
                    count = 1;
                }
            }

            // Append the last run
            encoded.append(count).append("x").append(current).append(" ");
            encoded.append("\n");
        }

        return encoded.toString().trim();
    }

    public static int[][] decode(String encoded) {
        String[] lines = encoded.split("\n");
        int numRows = lines.length;
        int numCols = lines[0].split(" ").length;

        int[][] decoded = new int[numRows][numCols];

        for (int i = 0; i < numRows; i++) {
            String[] tokens = lines[i].trim().split(" ");
            int count = 0;

            for (String token : tokens) {
                String[] parts = token.split("x");
                int runLength = Integer.parseInt(parts[0]);
                int value = Integer.parseInt(parts[1]);

                for (int j = 0; j < runLength; j++) {
                    decoded[i][count] = value;
                    count++;
                }
            }
        }

        return decoded;
    }
}
