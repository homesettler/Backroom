package DSL;

public class TerminalChannel implements CommandChannel {

    public void send(String code){
        System.out.println(code);
    }
}
