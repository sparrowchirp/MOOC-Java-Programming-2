package application;

import java.util.Random;

public class TemperatureSensor implements Sensor{
    private boolean isOn;

    public TemperatureSensor() {
        this.isOn = false;
    }
    
    public boolean isOn() {
        return this.isOn;
    }
    
    public void setOn() {
        this.isOn = true;
    }
    public void setOff() {
        this.isOn = false;
    }
    
    public int read() {
        if (!this.isOn) {
            throw new IllegalArgumentException();
        }
        int number = new Random().nextInt(61) - 30;
        return number;
    }     
    
}
