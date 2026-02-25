
import java.util.ArrayList;
import java.util.Collections;

public class MagicSquare {

    private int[][] square;

    // ready constructor
    public MagicSquare(int size) {
        if (size < 2) {
            size = 2;
        }

        this.square = new int[size][size];
    }

    // implement these three methods
    public ArrayList<Integer> sumsOfRows() {
        ArrayList<Integer> sumsOfRows = new ArrayList<>();
        int sum = 0;
        int size = this.square.length;
        for (int i = 0; i < size; i++) {
            for (int k = 0; k < size; k++) {
                sum += square[i][k];
            }
           sumsOfRows.add(sum);
           sum = 0;
        }
        return sumsOfRows;
    }

    public ArrayList<Integer> sumsOfColumns() {
        ArrayList<Integer> sumsOfColumns = new ArrayList<>();
        int sum = 0;
        int size = this.square.length;
        for (int i = 0; i < size; i++) {
            for (int k = 0; k < size; k++) {
                sum += square[k][i];
            }
            sumsOfColumns.add(sum);
            sum = 0;
        }
        return sumsOfColumns;
    }

    public ArrayList<Integer> sumsOfDiagonals() {
        ArrayList<Integer> sumsOfDiagonals = new ArrayList<>();
        int sum = 0;
        int size = this.square.length;

        for (int i = 0; i < size; i++) {
            sum += this.square[i][i];
        }
        sumsOfDiagonals.add(sum);

        sum = 0;
        for (int i = size-1; i >= 0; i--) {
            sum += this.square[i][size - i - 1];
        }
        sumsOfDiagonals.add(sum);

        return sumsOfDiagonals;
    }

    // ready-made helper methods -- don't touch these
    public boolean isMagicSquare() {
        return sumsAreSame() && allNumbersDifferent();
    }

    public ArrayList<Integer> giveAllNumbers() {
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int row = 0; row < square.length; row++) {
            for (int col = 0; col < square[row].length; col++) {
                numbers.add(square[row][col]);
            }
        }

        return numbers;
    }

    public boolean allNumbersDifferent() {
        ArrayList<Integer> numbers = giveAllNumbers();

        Collections.sort(numbers);
        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i - 1) == numbers.get(i)) {
                return false;
            }
        }

        return true;
    }

    public boolean sumsAreSame() {
        ArrayList<Integer> sums = new ArrayList<>();
        sums.addAll(sumsOfRows());
        sums.addAll(sumsOfColumns());
        sums.addAll(sumsOfDiagonals());

        if (sums.size() < 3) {
            return false;
        }

        for (int i = 1; i < sums.size(); i++) {
            if (sums.get(i - 1) != sums.get(i)) {
                return false;
            }
        }

        return true;
    }

    public int readValue(int x, int y) {
        if (x < 0 || y < 0 || y >= getWidth() || x >= getHeight()) {
            return - 1;
        }

        return this.square[x][y];
    }

    public void placeValue(int x, int y, int value) {
        if (x < 0 || y < 0 || y >= getWidth() || x >= getHeight()) {
            return;
        }

        this.square[x][y] = value;
    }

    public int getWidth() {
        return this.square.length;
    }

    public int getHeight() {
        return this.square.length;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int row = 0; row < square.length; row++) {
            for (int col = 0; col < square[row].length; col++) {
                result.append(square[row][col]).append("\t");
            }

            result.append("\n");
        }

        return result.toString();
    }
}
