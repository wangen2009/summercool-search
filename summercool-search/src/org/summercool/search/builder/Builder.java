package org.summercool.search.builder;

import org.apache.solr.client.solrj.embedded.EmbeddedSolrServer;

public interface Builder {
	
	void build(EmbeddedSolrServer server);
	
}
