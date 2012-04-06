package org.summercool.search.query;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.embedded.EmbeddedSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;

public class QueryImpl implements Query {

	private EmbeddedSolrServer server;

	public QueryImpl(EmbeddedSolrServer server) {
		this.server = server;
	}

	public QueryResponse query(SolrQuery solrQuery) throws SolrServerException {
		return server.query(solrQuery);
	}

}
