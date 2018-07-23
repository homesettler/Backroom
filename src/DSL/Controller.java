package DSL;

/**
 * 控制器
 */
public class Controller {
    /**
     * 当前状态
     */
    private State currentState;

    /**
     * 状态机
     */
    private StateMachine machine;

    /**
     * 输出口
     */
    private CommandChannel commandChannel;

    /**
     * 获取CommandChannel
     * @return DSL.CommandChannel
     */
    public CommandChannel getCommandChannel(){
        return commandChannel;
    }

    /**
     * 处理事件:
     * 如果当前状态存在又eventCode转换到的目标状态，则发生转换
     * 否则如果是重制事件，则将当前状态转化为开始状态
     * @param eventCode 事件代码
     */
    public void handle(String eventCode){
        if(currentState.hasTransition((eventCode)))
            transitionTo(currentState.targetState(eventCode));
        else if(machine.isResetEvent(eventCode))
            transitionTo(machine.getStart());
    }

    /**
     * 转换状态
     * @param target 目标状态
     */
    public void transitionTo(State target){
        currentState = target;
        currentState.executeAction(commandChannel);
    }

}
