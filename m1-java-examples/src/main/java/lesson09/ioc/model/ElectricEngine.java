package lesson09.ioc.model;

public class ElectricEngine implements Engine {

    @Override
    public void on() {
        System.out.println("Electric engine started");
    }

    @Override
    public void off() {
        System.out.println("Electric engine stopped");
    }
}
