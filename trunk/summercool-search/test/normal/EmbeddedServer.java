package normal;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.embedded.EmbeddedSolrServer;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.util.DateUtil;
import org.summercool.search.server.SolrServer;
import org.xml.sax.SAXException;

public class EmbeddedServer {

	public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException,
			SolrServerException, ParseException {

		SolrServer solrServer = new SolrServer();
		solrServer.start();

		String beginDate = "2012-04-05 12:12:12";
		String endDate = "2012-04-05 15:00:43";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date1 = DateUtil.getThreadLocalDateFormat().format(sdf.parse(beginDate));
		String date2 = DateUtil.getThreadLocalDateFormat().format(sdf.parse(endDate));

		try {
			/**                                                      */
			long beginTime = System.currentTimeMillis();
			SolrQuery query = new SolrQuery();
			// 多列查询
			// query.setQuery("id:4 AND status:true");
			// 多列查询范围
			// query.setQuery("id:[99001 TO 100000] AND status:false AND age:0");
			// 多列查询范围（时间）
//			query.setQuery("createTime:[" + date1 + " TO " + date2 + "] AND status:true");

			// query.setQuery("*:*");
			

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
