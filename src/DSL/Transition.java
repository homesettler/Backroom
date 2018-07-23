package DSL;

public class Transition {

    private final State source, target;
    private final Event trigger;

    /**
     * 构造函数
     * @param source 源状态
     * @param trigger 触发事件
     * @param target 目标状态
     */
    public Transition(State source, Event trigger, State target){
        this.source = source;
        this.target = target;
        this.trigger = trigger;
    }

    public State getSource(){
        return source;
    }

    public State getTarget(){
        return target;
    }

    public Event getTrigger(){
        return trigger;
    }

    public String getEventCode(){
        return trigger.getCode();
    }
}
