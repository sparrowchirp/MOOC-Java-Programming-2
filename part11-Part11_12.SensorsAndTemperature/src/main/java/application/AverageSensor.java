package application;

import java.util.ArrayList;
import java.util.List;

public class AverageSensor implements Sensor{

    private ArrayList<Sensor> sensors;
    private List<Integer> readings;

    public AverageSensor() {
        this.sensors = new ArrayList<>();
        this.readings = new ArrayList<>();
    }

    public void addSensor(Sensor toAdd) {
        this.sensors.add(toAdd);
    }
    
    public boolean isOn() {
        for(Sensor temp : this.sensors) {
            if(!temp.isOn()) {
                return false;
            }
        }
        return true;
    }
    
    public void setOn() {
        for(Sensor temp : this.sensors) {
            temp.setOn();
        }
    }
    public void setOff() {
        this.sensors.get(0).setOff();
    }
    
    public int read() {
        if (!this.isOn()) {
            throw new IllegalStateException("Average timer is off");
        }
        int sum = 0;
        for(Sensor temp : this.sensors) {
            sum += temp.read();
        }

        int average = sum/this.sensors.size();
        this.readings.add(average);
        return average;
    }
    
    public List<Integer> readings() {
        return readings;
    }
}
