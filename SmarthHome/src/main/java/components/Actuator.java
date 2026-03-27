package components;

public class Actuator extends Device {
    public Actuator(Mediator mediator, String id) {
        super(mediator, id);
    }

    @Override
    public void receive(String message) {
        System.out.println("[Actuator " + id + "] recibió -> " + message);

        if (message.startsWith("CMD:")) {
            String cmd = message.substring(4);
            performAction(cmd);
        }
    }

    public void performAction(String cmd) {
        System.out.println("[Actuator " + id + "] ejecutando acción -> " + cmd);
    }

    public void requestStatus() {
        System.out.println("[Actuator " + id + "] solicitando estado");
        send("STATUS_REQUEST:" + id);
    }
}
