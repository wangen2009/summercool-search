package org.summercool.search.builder;

import org.apache.solr.client.solrj.SolrServer;

public interface Builder {
	
	void build(SolrServer server) throws Exception;
}
