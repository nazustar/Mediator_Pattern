package app;

import components.*;

public class Main {
    public static void main(String[] args) {
        SmartHub hub = new SmartHub();

        Sensor tempSensor = new Sensor(hub, "TempSensor1");
        Actuator heater = new Actuator(hub, "Heater1");
        Actuator cooler = new Actuator(hub, "Cooler1");

        // Flujo de ejemplo
        tempSensor.detect("temperature=30");
        // El hub reenvía el mensaje; en un caso real el hub decidiría si enviar CMD a actuadores
        heater.performAction("standby");
        cooler.performAction("start");

        // Simular que el hub recibe un comando externo (por ejemplo, desde una app)
        // Para esto podemos enviar un mensaje desde un dispositivo que actúe como "remitente"
        // o extender SmartHub con un método que inyecte comandos. Aquí usamos heater para enviar.
        heater.send("CMD:Heater1:turn_on");
        cooler.requestStatus();
    }
}
