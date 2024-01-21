package example.model;

import lombok.*;

import java.util.Date;


/**
 * @author weekend
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student {
    String name;
    Integer age;
    String sex;
    Date birthday;
}
