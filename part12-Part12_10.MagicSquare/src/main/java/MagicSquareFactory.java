
public class MagicSquareFactory {

    public MagicSquare createMagicSquare(int size) {
        // implement the creation of a magic square with the Siamese method algorithm here
        MagicSquare square = new MagicSquare(size);
        int number = 1;
        int i = 0;
        int k = size / 2;

        int s = 0;
        while (s < size * size){
            if (square.readValue(i, k) != 0) {
                i++;
            }
            square.placeValue(i, k, number);

            i--;
            if (i < 0) {
                i = size - 1;
            }

            k++;
            if (k >= size) {
                k = 0;
            }
            s++;
            number++;
        }
        return square;
    }

}
