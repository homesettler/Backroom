package DSL;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class StateMachine {

    private State start;

    private List<Event> resetEvents = new ArrayList<Event>();

    public State getStart(){
        return start;
    }

    public StateMachine(State start){
        this.start = start;
    }

    public Collection<State> getStates(){
        List<State> result = new ArrayList<State>();
        collectStates(result,start);
        return result;
    }

    private void collectStates(Collection<State> result, State s){
        if(result.contains(s)) return;
        result.add(s);
        for(State next : s.getAllTargets())
            collectStates(result,next);
    }

    public boolean isResetEvent(String eventCode){
        return resetEventCodes().contains(eventCode);
    }

    private List<String> resetEventCodes(){
        List<String> result = new ArrayList<String>();
        for(Event e:resetEvents)
            result.add(e.getCode());
        return result;
    }
}
