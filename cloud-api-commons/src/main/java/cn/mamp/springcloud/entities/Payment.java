package cn.mamp.springcloud.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author mamp
 * @data 2020/4/18
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Payment {
    private Long id;
    private String serial;
}
