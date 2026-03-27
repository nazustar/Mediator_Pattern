package components;

public interface Mediator {
    void send(String message, Device sender);
    void registerDevice(Device device);
}
