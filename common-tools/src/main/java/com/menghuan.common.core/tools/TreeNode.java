package com.menghuan.common.core.tools;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yang
 * @date 2017年11月9日23:33:45
 */
@Data
public class TreeNode {

	protected int id;

	protected int parentId;

	protected List<TreeNode> children = new ArrayList<TreeNode>();

	public void add(TreeNode node) {
		children.add(node);
	}
}
