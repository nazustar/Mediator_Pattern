package sensors;

import components.Mediator;
import components.Sensor;

public class RainSensor extends Sensor{
    
    public RainSensor(Mediator mediator, String id){
        super(mediator, id);
    }

    public void detectRain(boolean rainOutside) {
        System.out.println("[Rain Sensor " + id + "] detectó -> " + rainOutside);
        send("SENSOR:" + id + ":" + rainOutside);
    }

    @Override
    public void receive (String data){
        System.out.println("[Rain Sensor " + id + "] recibió -> " +  data);
    }

}
