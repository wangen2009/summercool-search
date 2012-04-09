package org.summercool.search.builder;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.embedded.EmbeddedSolrServer;

public abstract class AbstractBuilder implements Builder {

	private SolrServer server;

	public AbstractBuilder(SolrServer server) throws Exception {
		this.server = server;
		build(this.server);
	}

	public abstract void build(EmbeddedSolrServer server);
}