package org.summercool.search.query;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;

public class QueryImpl implements Query {

	private SolrServer server;

	public QueryImpl(SolrServer server) {
		this.server = server;
	}

	public QueryResponse query(SolrQuery solrQuery) throws SolrServerException {
		return server.query(solrQuery);
	}

}
