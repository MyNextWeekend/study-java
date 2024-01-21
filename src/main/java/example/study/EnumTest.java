package example.study;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 枚举
 * @author weekend
 */
@Getter
@AllArgsConstructor
public enum EnumTest {
    ONE(100, "壹", "一"),
    TWO(200, "贰", "二"),
    THREE(300, "叁", "三");

    private final int code;
    private final String msg;
    private final String userName;

    public static void main(String[] args) {
        System.out.println(EnumTest.ONE.code);
        System.out.println(EnumTest.ONE.msg);
        System.out.println(EnumTest.ONE.userName);

        EnumTest yi = EnumTest.valueOf("ONE"); // 通过枚举名称获取对象，如无就报错
        switch (yi) {
            case ONE:
                System.out.println(EnumTest.ONE);
                break;
            case TWO:
                System.out.println(EnumTest.TWO);
                break;
            default:
                System.out.println(EnumTest.THREE);
                break;
        }
    }

}
