package components;

public class Sensor extends Device {
    public Sensor(Mediator mediator, String id) {
        super(mediator, id);
    }

    @Override
    public void receive(String message) {
        System.out.println("[Sensor " + id + "] recibió -> " + message);
    }

    public void detect(String data) {
        System.out.println("[Sensor " + id + "] detectó -> " + data);
        send("SENSOR:" + id + ":" + data);
    }
}
