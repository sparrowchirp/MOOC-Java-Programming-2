import java.util.ArrayList;

public class ChangeHistory {
    
    private ArrayList<Double> history;

    public ChangeHistory() {
        this.history = new ArrayList<>();
    }

    public void add(double amountt) {
        this.history.add(amountt);
    }

    public void clear() {
        this.history.clear();
    }

    public String toString() {
        return this.history.toString();
    }

    public double maxValue() {
        double max = this.history.get(0);
        for(Double temp : this.history) {
            if (temp > max) {
                max = temp;
            }
        }
        return max;
    }

    public double minValue() {
        double min = this.history.get(0);
        for(Double temp : this.history) {
            if (temp < min) {
                min = temp;
            }
        }
        return min;
    }

    public double average() {
        double sum = 0;
        for (double temp : this.history) {
            sum +=temp;
        }
        return sum/this.history.size();
    }
}
