package top.timebook.core.result;

/**
 * @author xiongzl
 * @version 1.0
 * @date 2021/3/18 16:12
 */
public class ResponseResult<T> {

    /**
     * 状态码
     */
    public int code;

    /**
     * 返回描述信息
     */
    private String msg;

    /**
     * 响应内容
     */
    private T data;

    public ResponseResult<T> setCode(ResultCode retCode) {
        this.code = retCode.code;
        return this;
    }

    public int getCode() {
        return code;
    }

    public ResponseResult<T> setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public ResponseResult<T> setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public T getData() {
        return data;
    }

    public ResponseResult<T> setData(T data) {
        this.data = data;
        return this;
    }

}
