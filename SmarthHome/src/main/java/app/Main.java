package app;

import components.Mediator;
import sensors.*;
import actuators.*;

public class Main {

    public static void main(String[] args) {

        Mediator hub = new SmartHub();

        TemperatureSensor tempSensor = new TemperatureSensor(hub, "TS1");
        RainSensor rainSensor = new RainSensor(hub, "RS1");
        LightSensor lightSensor = new LightSensor(hub, "LS1");

        AirConditioning ac = new AirConditioning(hub, "AC1");
        SmartAwning awning = new SmartAwning(hub, "AW1");
        SmartCurtains curtains = new SmartCurtains(hub, "SC1");

        hub.registerDevice(tempSensor);
        hub.registerDevice(rainSensor);
        hub.registerDevice(lightSensor);

        hub.registerDevice(ac);
        hub.registerDevice(awning);
        hub.registerDevice(curtains);

        //Pruebas de funcionamiento.

        System.out.println("\nPRUEBA: TEMPERATURA ALTA");
        //Para encender el aire acondicionado.
        tempSensor.detectTemperature(35);

        System.out.println("\nPRUEBA: LLUVIA AFUERA");
        //Se coloca el toldo para protegerse de la lluvia.
        rainSensor.detectRain(true);

        System.out.println("\nPRUEBA: TIEMPO");
        //Para cerrar las cortinas.
        lightSensor.detect("DIA");

        System.out.println("\nPRUEBA: MOSTRAR CONDICIONES ACTUALES");
        //Para mostrar el estado actual de los dispositivos.
        ac.requestStatus();
        awning.requestStatus();
        curtains.requestStatus();
    }
}