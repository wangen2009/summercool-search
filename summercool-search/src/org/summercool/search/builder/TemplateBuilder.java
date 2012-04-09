package org.summercool.search.builder;

import org.apache.solr.client.solrj.SolrServer;

/**
 * @Title: TemplateBuilder.java
 * @Package org.summercool.search.builder
 * @Description: TODO(添加描述)
 * @author Administrator
 * @date 2012-4-7 上午1:01:04
 * @version V1.0
 */
public abstract class TemplateBuilder<T> implements Builder {

	public void build(SolrServer server) throws Exception {
		//
		T data = getData();
		//
		build(server, data);
	}

	protected abstract void build(SolrServer server, T data) throws Exception;

	protected abstract T getData();

}
