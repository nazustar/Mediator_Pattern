/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package components;

/**
 *
 * @author MyM
 */
public class Actuator extends Device {
    public Actuator(Mediator mediator, String id) {
        super(mediator, id);
    }

    @Override
    public void receive(String message) {
        System.out.println("[Actuator " + id + "] recibió -> " + message);
        // Ejemplo simple: interpretar mensajes que empiecen con "CMD:"
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
