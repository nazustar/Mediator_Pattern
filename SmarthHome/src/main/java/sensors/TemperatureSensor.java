package sensors;

import components.Mediator;
import components.Sensor;

public class TemperatureSensor extends Sensor{
    
    public TemperatureSensor(Mediator mediator, String id){
        super(mediator, id);
    }

    public void detectTemperature(int temperature) {
        System.out.println("[Temperature Sensor " + id + "] detectó -> " + temperature + "°C");
        send("SENSOR:" + id + ":" + temperature);
    }

    @Override
    public void receive (String data){
        System.out.println("[Temperature Sensor " + id + "] recibió -> " +  data);
    }

}
