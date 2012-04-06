package normal;

import java.text.SimpleDateFormat;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.embedded.EmbeddedSolrServer;
import org.apache.solr.common.SolrDocumentList;
import org.summercool.search.builder.AbstractBuilder;
import org.summercool.search.builder.Builder;
import org.summercool.search.server.SolrServer;

public class EmbeddedServer {

	public final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	private String SOLR_HOME = "d:/solr/home";
	private String SOLR_FILE = "solr.xml";
	SolrServer ss;

	public void init() {
		ss = new SolrServer(new String[] { "user" });
		EmbeddedSolrServer server = ss.getSolrServerByCoreName("user");
		//
		Builder builder = new AbstractBuilder(server) {
			@Override
			public void build(EmbeddedSolrServer server) {
				// TODO
			}
		};
	}

	public void execute() throws SolrServerException {
		

		/**                                                      */
		long beginTime = System.currentTimeMillis();
		SolrQuery query = new SolrQuery();
		// 多列查询
		// query.setQuery("id:4 AND status:true");
		
		// 多列查询范围
		// query.setQuery("id:[99001 TO 100000] AND status:false AND age:0");
		
		// 多列查询范围（时间）
		// String beginDate = DateUtil.getThreadLocalDateFormat().format(sdf.parse("2012-04-05 12:12:12"));
		// String endDate =  DateUtil.getThreadLocalDateFormat().format(sdf.parse("2012-04-05 15:00:43"));
		// query.setQuery("createTime:[" + beginDate + " TO " + endDate +"] AND status:true");

		// query.setQuery("*:*");

		// 排序查询

		EmbeddedSolrServer server = ss.getSolrServer();
		SolrDocumentList results = server.query(query).getResults();

		System.err.println("num：" + results.getNumFound());
		/**                                                      */

		System.out.println("time : " + (System.currentTimeMillis() - beginTime));
	}

	public void stop() {
		ss.stop();
	}

}
