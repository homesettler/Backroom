import DSL.*;

public class Backroom extends Controller {


    @Override
    public void handleInput(String input){

        if(input.equals("151220094")){
            super.handle("RIGHT");
        }
        else{
            super.handle("ERROR");
        }
    }


    @Override
    public void init(){
        Event right = new Event("imputRight", "RIGHT");

        Event err = new Event("imputError", "ERROR");

        Command lock = new Command("LockDoor", "The door is locked");

        Command chance3 = new Command("waitInput3", "You have 3 attempts left");

        Command unlock = new Command("UnlockDoor", "The door is open");

        Command chance2 = new Command("waitInput2", "You have 2 attempts left");

        Command chance1 = new Command("waitInput1","You have 1 attempts left");

        Command chance0 = new Command("cannotInput","Sorry, the door is locked forever");

        State lockDoor = new State("LOCK");

        State unlockDoor = new State("UNLOCK");

        State wait2 = new State("TWOLEFT");

        State wait1 = new State("ONELEFT");

        State lockForever = new State("FOREVER");

        lockDoor.addAction(lock);

        lockDoor.addAction(chance3);

        unlockDoor.addAction(unlock);

        wait2.addAction(chance2);

        wait1.addAction((chance1));

        lockForever.addAction(chance0);

        lockDoor.addTransition(right,unlockDoor);

        lockDoor.addTransition(err,wait2);

        wait2.addTransition(right,unlockDoor);

        wait2.addTransition(err,wait1);

        wait1.addTransition(right,unlockDoor);

        wait1.addTransition(err,lockForever);

        StateMachine machine = new StateMachine(lockDoor);

        this.setMachine(machine);
    }
}
