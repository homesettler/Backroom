package DSL;

/**
 * 超类
 * 存储name和code
 */
public class AbstractEvent {

    /**
     * 名字
     */
    private String name;

    /**
     * 对应的代码
     */
    private String code;

    public AbstractEvent(String name,String code){
        this.name = name;
        this.code = code;
    }
    public AbstractEvent(){

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
