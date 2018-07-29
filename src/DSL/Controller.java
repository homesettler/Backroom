package DSL;

public abstract class Controller {

    public Controller(){
        init();
        if(machine==null){
            System.err.println("状态机未设置");
            System.exit(-1);
        }
        currentState = machine.getStart();
        if(currentState==null){
            System.err.println("状态机初始状态未设置");
            System.exit(-1);
        }
        currentState.executeAction(commandChannel);
    }

    private State currentState;

    public State getCurrentState() {
        return currentState;
    }

    private StateMachine machine;

    public StateMachine getMachine() {
        return machine;
    }

    public void setMachine(StateMachine stateMachine){
        this.machine = stateMachine;
    }

    private CommandChannel commandChannel = new TerminalChannel();

    public CommandChannel getCommandChannel(){
        return commandChannel;
    }

    public void setCommandChannel(CommandChannel commandChannel){
        this.commandChannel = commandChannel;
    }

    protected void handle(String eventCode){
        if(currentState.hasTransition((eventCode)))
            transitionTo(currentState.targetState(eventCode));
        else if(machine.isResetEvent(eventCode))
            transitionTo(machine.getStart());
    }

    public abstract void handleInput(String input);

    public abstract void init();

    public void transitionTo(State target){
        currentState = target;
        currentState.executeAction(commandChannel);
    }

}
