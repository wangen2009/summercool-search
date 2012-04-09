package org.summercool.search.builder;

import java.util.LinkedList;
import java.util.List;

import org.apache.solr.client.solrj.SolrServer;

/**
 * @Title: BuilderGroup.java
 * @Package org.summercool.search.builder
 * @Description: TODO(添加描述)
 * @author Administrator
 * @date 2012-4-6 下午11:26:23
 * @version V1.0
 */
public class BuilderGroup implements Builder {

	private List<Builder> children = new LinkedList<Builder>();

	public void build(SolrServer server) throws Exception {
		if (children == null) {
			return;
		}
		//
		for (Builder childBuilder : children) {
			childBuilder.build(server);
		}
	}

	public void setChildren(List<Builder> children) {
		this.children = children;
	}

	public List<Builder> getChildren() {
		return children;
	}
}
