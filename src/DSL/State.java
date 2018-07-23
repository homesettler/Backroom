package DSL;

import java.util.*;

/**
 * 状态类
 */
public class State {
    /**
     * 名字
     */
    private String name;
    /**
     * 状态对应的动作
     */
    private List<Command> actions = new ArrayList<Command>();
    /**
     * 命令对应的转换
     */
    private Map<String,Transition> transitions = new HashMap<String,Transition>();

    /**
     * 添加一个新的转换
     * @param event 控制器接收的事件
     * @param targetState 目标状态
     */
    public void addTransition(Event event,State targetState){
        assert null != targetState;
        transitions.put(event.getCode(),new Transition(this, event,targetState));
    }

    /**
     * 获取该状态所能到达的所有状态
     * @return 该状态所能到达的所有状态
     */
    Collection<State> getAllTargets(){
        List<State> result = new ArrayList<State>();
        for(Transition t: transitions.values())
            result.add(t.getTarget());
        return result;
    }

    /**
     * 对于当前事件和传入进来的事件代码。是否存在相应的转换
     * @param eventCode 事件代码
     * @return 是否存在相应转换
     */
    public boolean hasTransition(String eventCode){
        return transitions.containsKey(eventCode);
    }

    /**
     * 获取当前状态以及传入的事件代码对应的目标状态
     * @param eventCode 事件代码
     * @return 目标状态
     */
    public State targetState(String eventCode){
        return transitions.get(eventCode).getTarget();
    }

    /**
     * 执行动作
     * @param commandChannel 输出类
     */
    public void executeAction(CommandChannel commandChannel){
        for(Command c : actions)
            commandChannel.send(c.getCode());
    }
}
