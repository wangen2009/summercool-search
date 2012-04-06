package org.summercool.search.server;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.solr.client.solrj.embedded.EmbeddedSolrServer;
import org.apache.solr.core.CoreContainer;
import org.xml.sax.SAXException;

public class SolrServer {

	public static final String BLANK_SOLRNAME = "";

	private String solrHome;

	private String solrFile;

	private String[] coreNames;

	private CoreContainer container;

	private String firstCoreName;

	private Map<String, EmbeddedSolrServer> embeddedSolrServers = new LinkedHashMap<String, EmbeddedSolrServer>();

	public SolrServer() {
	}

	public SolrServer(String[] coreNames) {
		this.coreNames = coreNames;
	}

	public EmbeddedSolrServer getSolrServerByCoreName() {
		if (embeddedSolrServers == null || embeddedSolrServers.size() == 0) {
			return null;
		}
		return embeddedSolrServers.get(firstCoreName);
	}

	public EmbeddedSolrServer getSolrServerByCoreName(String coreName) {
		return embeddedSolrServers.get(coreName);
	}

	public Map<String, EmbeddedSolrServer> getSolrServerByCoreNames(String[] coreNames) {
		Map<String, EmbeddedSolrServer> embeddedSolrServers = new LinkedHashMap<String, EmbeddedSolrServer>();
		if (coreNames == null || coreNames.length == 0) {
			return embeddedSolrServers;
		}
		for (String coreName : coreNames) {
			embeddedSolrServers.put(coreName, this.embeddedSolrServers.get(coreName));
		}
		return embeddedSolrServers;
	}

	public void start() {
		//
		if (solrHome == null || solrHome.equals("")) {
			throw new RuntimeException("SOLR_HOME can not be empty !");
		}
		File home = new File(solrHome);
		//
		if (solrFile == null || solrFile.equals("")) {
			throw new RuntimeException("SOLR_FILE can not be empty !");
		}
		File file = new File(home, solrFile);
		//
		try {
			container = new CoreContainer();
			container.load(solrHome, file);
		} catch (ParserConfigurationException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		} catch (SAXException e) {
			throw new RuntimeException(e);
		}
		//
		if (coreNames == null || coreNames.length == 0) {
			EmbeddedSolrServer server = new EmbeddedSolrServer(container, BLANK_SOLRNAME);
			embeddedSolrServers.put(BLANK_SOLRNAME, server);
			firstCoreName = BLANK_SOLRNAME;
			return;
		}
		for (String coreName : coreNames) {
			EmbeddedSolrServer server = new EmbeddedSolrServer(container, coreName);
			embeddedSolrServers.put(coreName, server);
			if (embeddedSolrServers.size() == 1) {
				firstCoreName = coreName;
			}
		}
	}

	public void stop() {
		container.shutdown();
	}
}
