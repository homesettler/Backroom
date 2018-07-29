package DSL;

public class Command extends AbstractEvent {
    public Command(String name,String code){
        this.setName(name);
        this.setCode(code);
    }
}
