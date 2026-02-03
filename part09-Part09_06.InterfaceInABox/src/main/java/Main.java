
public class Main {

    public static void main(String[] args) {
        // test your classes here
        Box box = new Box(10);

        box.add(new CD("Pink Floyd", "Dark Side of the Moon", 1973));
        box.add(new CD("Wigwam", "Nuclear Nightclub", 1975));
        box.add(new CD("Rendezvous Park", "Closer to Being Here", 2012));

        System.out.println(box);

        Box smallBox = new Box(4);

        smallBox.add(new Book("darrell", "BitterLemons", 1.2));
        System.out.println(smallBox);

        box.add(smallBox);
        System.out.println(box);
    }

}
