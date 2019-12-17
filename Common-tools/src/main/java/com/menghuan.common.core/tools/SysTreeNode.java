package com.menghuan.common.core.tools;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: DZL
 * @Date: 2019/11/25
 * @Description:
 */
@Data
public class SysTreeNode {
    protected String menuId;
    protected String parentId;
    protected List<SysTreeNode> children = new ArrayList<SysTreeNode>();

    public void add(SysTreeNode node) {
        children.add(node);
    }
}
