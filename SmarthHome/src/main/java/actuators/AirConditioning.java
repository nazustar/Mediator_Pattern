package actuators;

import components.Actuator;
import components.Mediator;

public class AirConditioning extends Actuator {
    // Constructor.
    public AirConditioning(Mediator mediator, String id) {
        super(mediator, id);
    }

    // Método para ejecutar comandos específicos, del aire acondicionado.
    @Override
    public void performAction(String cmd) {
        System.out.println("[Air Conditioning " + id + "] ejecutando comando -> " + cmd);

        if (cmd.equalsIgnoreCase("ON")) {
            turnOn();
        } else if (cmd.equalsIgnoreCase("OFF")) {
            turnOff();
        } else {
            System.out.println("Comando ingresado desconocido:" + cmd);
        }
    }

    // Métodos del aire acondicionado.
    public void turnOn() {
        System.out.println("El aire acondicionado ha sido encendido.");
    }

    public void turnOff() {
        System.out.println("El aire acondicionado ha sido apagado.");
    }
}