package components;

public abstract class Device {
    protected Mediator mediator;
    protected String id;

    public Device(Mediator mediator, String id) {
        this.mediator = mediator;
        this.id = id;
        mediator.registerDevice(this);
    }

    public abstract void receive(String message);

    public void send(String message) {
        mediator.send(message, this);
    }

    public String getId() {
        return id;
    }
}
