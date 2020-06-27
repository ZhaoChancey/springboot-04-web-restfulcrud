package cn.bjtu.springboot.exception;

/**
 * @author chancey
 * @create 2020-04-27 20:35
 */
public class UserNotExistException extends RuntimeException {
    public UserNotExistException() {
        super("用户不存在!");
    }
}
