package org.summercool.search.platform.server;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.embedded.EmbeddedSolrServer;
import org.apache.solr.common.SolrInputDocument;
import org.apache.solr.core.CoreContainer;
import org.summercool.search.platform.pojo.User;
import org.xml.sax.SAXException;

public class SolrServer {

	private static String SOLR_HOME = "D:/solr/home";

	private CoreContainer container;

	private EmbeddedSolrServer server;

	public void start() throws ParserConfigurationException, IOException, SAXException, SolrServerException {
		File home = new File(SOLR_HOME);
		File f = new File(home, "solr.xml");

		container = new CoreContainer();
		container.setPersistent(true);
		container.load(SOLR_HOME, f);

		server = new EmbeddedSolrServer(container, "user");

//		int temp = 1;
//		for (int j = 1; j <= 1000; j++) {
//			List<SolrInputDocument> docs = new ArrayList<SolrInputDocument>();
//			for (int i = 1; i <= 1000; i++) {
//				//
//				User user = new User();
//				user.setId(temp);
//				user.setCreateTime(new Date());
//				user.setStatus((i % 2) != 0 ? true : false);
//				user.setName(UUID.randomUUID().toString());
//				user.setAge((int) Math.random() * 100);
//				//
//				SolrInputDocument doc = new SolrInputDocument();
//				doc.setField("id", user.getId());
//				doc.setField("createTime", user.getCreateTime());
//				doc.setField("status", user.isStatus());
//				doc.setField("name", user.getName());
//				doc.setField("age", user.getAge());
//				//
//				docs.add(doc);
//				
//				//
//				temp = temp +1;
//			}
//			server.add(docs);
//			server.commit();
//		}

	}

	public void stop() {
		container.shutdown();
	}

	public EmbeddedSolrServer getServer() {
		return server;
	}
}
