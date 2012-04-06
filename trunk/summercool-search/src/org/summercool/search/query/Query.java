package org.summercool.search.query;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;

public interface Query {

	QueryResponse query(SolrQuery solrQuery) throws SolrServerException;

}
