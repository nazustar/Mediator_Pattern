/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package components;

/**
 *
 * @author MyM
 */
public class Sensor extends Device {
    public Sensor(Mediator mediator, String id) {
        super(mediator, id);
    }

    @Override
    public void receive(String message) {
        System.out.println("[Sensor " + id + "] recibió -> " + message);
    }

    public void detect(String data) {
        System.out.println("[Sensor " + id + "] detectó -> " + data);
        send("SENSOR:" + id + ":" + data);
    }
}
