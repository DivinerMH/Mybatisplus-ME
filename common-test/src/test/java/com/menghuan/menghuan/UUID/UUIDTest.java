package java.com.menghuan.menghuan.UUID;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.UUID;

/**
 * @Author: menghuan
 * @Date: 2022/9/13 10:01
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class UUIDTest implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.INPUT)
    // private Integer id;
    private String id;

    private String name;


    public static void main(String[] args) {
        UUIDTest uuidTest = new UUIDTest();
        uuidTest.setName("测试");
        // uuidTest.setId(null);
        uuidTest.setId(UUID.randomUUID().toString());
        System.out.println("Result ID 信息：" + uuidTest.getId());
    }


}


