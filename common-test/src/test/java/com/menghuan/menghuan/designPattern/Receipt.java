package java.com.menghuan.menghuan.designPattern;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 模拟一个回执类
 *
 * @Author: menghuan
 * @Date: 2021/5/7 10:30
 */
@Data
@AllArgsConstructor
public class Receipt {

    /** 回执信息 */
    String message;

    /** 回执类型(`MT1101、MT2101、MT4101、MT8104、MT8105、MT9999`) */
    String type;

}
