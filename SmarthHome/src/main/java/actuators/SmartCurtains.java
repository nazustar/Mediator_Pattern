package actuators;

import components.Actuator;
import components.Mediator;

public class SmartCurtains extends Actuator {

    public SmartCurtains(Mediator mediator, String id) {
        super(mediator, id);
    }

    @Override
    public void performAction(String cmd) {
        System.out.println("[Smart Curtains " + id + "] ejecutando -> " + cmd);

        if (cmd.equalsIgnoreCase("OPEN")) {
            openCurtain();

        } else if (cmd.equalsIgnoreCase("CLOSE")) {
            closeCurtain();

        } else {
            System.out.println("Comando ingresado desconocido: " + cmd);
        }
    }

    public void closeCurtain(){
        System.out.println("Cerrando cortinas.");
    }

    public void openCurtain(){
        System.out.println("Abriendo cortinas.");
    }
}