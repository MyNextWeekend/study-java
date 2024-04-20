package example.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 结果dto
 *
 * @author weekend
 * @date 2024/04/20
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ResultDto<T> {

    private int code;
    private String message;
    private T data;

    // public ResultDto(int code, String message, T data) {  // 私有构造方法
    //     this.code = code;
    //     this.message = message;
    //     this.data = data;
    // }

    /**
     * 操作成功，有相应数据返回
     */
    public static <T> ResultDto<T> success(T data) {
        return new ResultDto<>(0, "操作成功", data);
    }

    /**
     * 操作成功，没有相应数据返回
     */
    public static <T> ResultDto<T> success() {
        return new ResultDto<>(0, "操作成功", null);
    }

    /**
     * 操作失败
     */
    public static <T> ResultDto<T> error(int code, String message) {
        return new ResultDto<>(code, message, null);
    }


    /**
     * 操作失败
     */
    public static <T> ResultDto<T> error(int code, String message, T data) {
        return new ResultDto<>(code, message, data);
    }


}
