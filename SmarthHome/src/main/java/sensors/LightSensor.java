package sensors;

import components.Mediator;
import components.Sensor;

public class LightSensor extends Sensor{
    
    public LightSensor(Mediator mediator, String id){
        super(mediator, id);
    }

    public void detectLight(String time) {
        System.out.println("[Light Sensor " + id + "] detectó -> " + time);
        send("SENSOR:" + id + ":" + time);
    }

    @Override
    public void receive (String data){
        System.out.println("[Light Sensor " + id + "] recibió -> " + data);
    }

}
