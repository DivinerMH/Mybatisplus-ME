package java.com.menghuan.test_I.codeTest_2020_11;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author:menghuan
 * @Date:2020/12/16 16:47
 */
@Data
public class TemporaryEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer configId;

    private String ruleType;

    private Integer ruleId;

}
