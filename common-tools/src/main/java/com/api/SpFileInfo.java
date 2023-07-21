package com.api;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Description: TODO
 *
 * @author: CatEyes
 * @date: 2023/4/21 20:43
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SpFileInfo {
    private Integer id;

    private String bucketName;

    private String objectPath;

    private String fileName;

    private String original;

    private Date createAt;

    private String createBy;
}
