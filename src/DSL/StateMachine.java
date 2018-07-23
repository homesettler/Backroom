package DSL;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 状态机
 */
public class StateMachine {
    /**
     * 初始状态
     */
    private State start;

    /**
     * 重制事件
     */

    private List<Event> resetEvents = new ArrayList<Event>();

    public State getStart(){
        return start;
    }

    /**
     * 构造函数
     * @param start 开始事件
     */
    public StateMachine(State start){
        this.start = start;
    }

    /**
     * 获取所有状态
     * @return 所有状态
     */
    public Collection<State> getStates(){
        List<State> result = new ArrayList<State>();
        collectStates(result,start);
        return result;
    }

    /**
     * 私有方法，根据初始状态递归获取所有状态
     * @param result 所有状态集合
     * @param s 原状态
     */
    private void collectStates(Collection<State> result, State s){
        if(result.contains(s)) return;
        result.add(s);
        for(State next : s.getAllTargets())
            collectStates(result,next);
    }

    /**
     * 是否是重制事件
     * @param eventCode
     * @return
     */
    public boolean isResetEvent(String eventCode){
        return resetEventCodes().contains(eventCode);
    }

    /**
     * 获取重制事件的代码
     * @return 重制事件代码的List
     */
    private List<String> resetEventCodes(){
        List<String> result = new ArrayList<String>();
        for(Event e:resetEvents)
            result.add(e.getCode());
        return result;
    }
}
