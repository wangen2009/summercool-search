package org.summercool.search.builder;

import org.apache.solr.client.solrj.embedded.EmbeddedSolrServer;

public abstract class AbstractBuilder implements Builder {

	private EmbeddedSolrServer server;

	public AbstractBuilder(EmbeddedSolrServer server) {
		this.server = server;
		build(this.server);
	}

	public abstract void build(EmbeddedSolrServer server);


}
