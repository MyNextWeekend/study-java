package example.design_patterns.creation.builderPattern;

import java.util.ArrayList;

//产品类
public class Product {
    ArrayList<String> parts = new ArrayList<>();

    // 添加产品零部件
    public void add(String part) {
        parts.add(part);
    }

    // 展示所有产品零件
    public void show() {
        for (String part : parts) {
            System.out.println(part);
        }
    }
}
