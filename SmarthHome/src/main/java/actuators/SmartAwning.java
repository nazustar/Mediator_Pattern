package actuators;

import components.Actuator;
import components.Mediator;

public class SmartAwning extends Actuator {

    public SmartAwning(Mediator mediator, String id) {
        super(mediator, id);
    }

    @Override
    public void performAction(String cmd) {
        System.out.println("[Smart Awning " + id + "] esta ejecutando el comando -> " + cmd);
        if (cmd.equals("DEPLOY")) {
            deploy();
        } else if (cmd.equals("CLOSE")) {
            close();
        } else {
            System.out.println("Comando ingresado desconocido: " + cmd);
        }

    }

    public void deploy(){
        System.out.println("El toldo ha sido desplegado.");
    }

    public void close(){
        System.out.println("El toldo se ha cerrado.");
    }
}