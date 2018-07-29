import DSL.CommandChannel;

public class OutputChannel implements CommandChannel {

    public void send(String code){
        System.out.println(code);
    }
}
