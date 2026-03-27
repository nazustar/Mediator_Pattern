package app;

import components.Device;
import components.Mediator;
import java.util.ArrayList;
import java.util.List;

public class SmartHub implements Mediator {

    private final List<Device> devices = new ArrayList<>();
    @Override
    public void registerDevice(Device device) {
        if (!devices.contains(device)) {
            devices.add(device);
        }
    }
    // Método para enviar mensajes entre dispositivos.
    @Override
    public void send(String message, Device sender) {
        System.out.println("[SmartHub] Mensaje de " + sender.getId() + " -> " + message);

        if (message.startsWith("SENSOR:")) {

            String[] parts = message.split(":");
            String sensorId = parts[1];
            String value = parts[2];
            
            if (sensorId.startsWith("TS")) {
                int temp = Integer.parseInt(value);

                for (Device d : devices) {
                    if (d.getId().startsWith("AC")) {
                        if (temp > 30) {
                            d.receive("CMD:ON");
                        } else {
                            d.receive("CMD:OFF");
                        }
                    }
                }
            }

            else if (sensorId.startsWith("RS")) {
                boolean rain = Boolean.parseBoolean(value);

                for (Device d : devices) {
                    if (d.getId().startsWith("AW")) {
                        if (rain) {
                            d.receive("CMD:OPEN");
                        } else {
                            d.receive("CMD:CLOSE");
                        }
                    }
                }
            }

        else if (sensorId.startsWith("LS")) {
            if (value.equalsIgnoreCase("DIA")) {

                for (Device d : devices) {
                    if (d.getId().startsWith("SC")) {
                        d.receive("CMD:CLOSE");
                    }
                }

            } else if (value.equalsIgnoreCase("NOCHE")) {
                for (Device d : devices) {
                    if (d.getId().startsWith("SC")) {
                        d.receive("CMD:OPEN");
                    }
                }

            } else {
                System.out.println("[SmartHub] Valor de luz desconocido: " + value);
            }
        }
        } else if (message.startsWith("STATUS_REQUEST:")) {

            String[] parts = message.split(":");
            String requesterId = parts[1];

            for (Device d : devices) {
                if (d.getId().equals(requesterId)) {
                    d.receive("STATUS:OK");
                }
            }

        } else if (message.startsWith("CMD:")) {
            for (Device d : devices) {
                if (d != sender) {
                    d.receive(message);
                }
            }
        }
    }
}