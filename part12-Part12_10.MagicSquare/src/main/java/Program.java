
public class Program {

    public static void main(String[] args) {
        // Test the MagicSquare class here
        // MagicSquare square = new MagicSquare(3);
        // System.out.println(square);
        // Factory factory = new Factory();
        
        // System.out.println(factory.createMagicSquare(3));
        
        MagicSquareFactory msFactory = new MagicSquareFactory();
        System.out.println(msFactory.createMagicSquare(5));
    }
}
