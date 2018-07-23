package DSL;

/**
 * 命令输出类
 */
public interface CommandChannel {
    /**
     * 返回当前触发的COMMAND
     * @param code COMMAND的代码
     */
    void send(String code);
}
