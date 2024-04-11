package design.patterns.behavior.command;

public class MainCommand {

    public static void main(String[] args) {

        final RemoteControl remoteControl = new RemoteControl();
        final Light light = new Light();
        remoteControl.setCommand(new LightOnCommand(light));

        remoteControl.pressButton();
    }
}
