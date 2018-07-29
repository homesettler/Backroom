import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Backroom backroom = new Backroom();
        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNext()){
            backroom.handleInput(scanner.next());
        }
    }

}
