package application;

public class StandardSensor implements Sensor {
    private int index;

    public StandardSensor(int index) {
        this.index = index;
    }
    
    public boolean isOn() {
        return true;
    }
    
    public void setOn() {}
    public void setOff() {}
    
    public int read() {
        return this.index;
    }     
    
}
