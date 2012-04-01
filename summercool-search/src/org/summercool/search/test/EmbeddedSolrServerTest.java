package org.summercool.search.test;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.embedded.EmbeddedSolrServer;
import org.apache.solr.common.SolrDocumentList;
import org.summercool.search.platform.server.SolrServer;
import org.xml.sax.SAXException;

public class EmbeddedSolrServerTest {

	public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException,
			SolrServerException {

		
		SolrServer solrServer = new SolrServer();
		solrServer.start();

		try {
			/**                                                      */
			long beginTime = System.currentTimeMillis();
			SolrQuery query = new SolrQuery();
			// 多列查询
//			query.setQuery("id:4 AND status:true");
			// 多列查询范围
			query.setQuery("id:[999001 TO 1000000] AND status:false AND age:0");
			// 多列查询范围（时间）
//			query.setQuery("createTime:[2012-04-01T00:00:00Z TO 2012-04-01T15:54:47Z] AND status:true");
			
//			query.setQuery("*:*");
			
			// 排序查询
	
			EmbeddedSolrServer server = solrServer.getServer();
			SolrDocumentList results = server.query(query).getResults();
	
			System.err.println("num：" + results.getNumFound());
			/**                                                      */
			
			System.out.println("time : " + (System.currentTimeMillis() - beginTime));
		
		} finally {
			solrServer.stop();
		}
		
	}

}
