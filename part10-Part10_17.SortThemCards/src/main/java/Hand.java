import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Hand implements Comparable<Hand>{

    private ArrayList<Card> cards;

    public Hand() {
        this.cards = new ArrayList<>();
    }

    public ArrayList<Card> getCards() {
        return this.cards;
    }

    public void add(Card card) {
        this.cards.add(card);
    }

    public void print() {
        for (Card temp : cards) {
            System.out.println(temp);
        }
    }

    public void sort() {
        this.cards.stream()
            .sorted()
            .forEach(System.out::println);
    }

    public void sortBySuit() {
        BySuitInValueOrder comparator = new BySuitInValueOrder();
        Collections.sort(cards, comparator);
    }

    public int sumOfValues() {
        int sum = this.cards.stream()
            .mapToInt(Card::getValue)
            .sum();
        return sum;
    }
    
    @Override
    public int compareTo(Hand o) {
        return Integer.compare(this.sumOfValues(), o.sumOfValues());
    }
}
