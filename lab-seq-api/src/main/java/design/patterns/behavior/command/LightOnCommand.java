package design.patterns.behavior.command;

public class LightOnCommand implements Command {
    private final Light light;

    public LightOnCommand(final Light light){
        this.light = light;
    }
    @Override
    public void execute() {
        light.turnOn();
    }
}
