/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

import components.Device;
import components.Mediator;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MyM
 */
public class SmartHub implements Mediator {
    private final List<Device> devices = new ArrayList<>();

    @Override
    public void registerDevice(Device device) {
        if (!devices.contains(device)) {
            devices.add(device);
        }
    }

    @Override
    public void send(String message, Device sender) {
        // Lógica de enrutamiento centralizada
        // Ejemplo: si viene de un sensor, enviar comandos a actuadores
        System.out.println("[SmartHub] Mensaje recibido de " + sender.getId() + " -> " + message);

        if (message.startsWith("SENSOR:")) {
            // Formato esperado SENSOR:<id>:<data>
            for (Device d : devices) {
                if (d != sender) {
                    d.receive("From " + sender.getId() + " -> " + message);
                }
            }
        } else if (message.startsWith("CMD:") || message.startsWith("STATUS_REQUEST:")) {
            // Reenviar a todos menos al remitente
            for (Device d : devices) {
                if (d != sender) {
                    d.receive(message);
                }
            }
        } else {
            // Mensajes genéricos: broadcast a todos menos remitente
            for (Device d : devices) {
                if (d != sender) {
                    d.receive(message);
                }
            }
        }
    }
}
