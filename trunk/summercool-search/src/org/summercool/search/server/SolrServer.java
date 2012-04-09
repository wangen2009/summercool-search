package org.summercool.search.server;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.solr.client.solrj.embedded.EmbeddedSolrServer;
import org.apache.solr.core.CoreContainer;
import org.summercool.search.builder.Builder;
import org.xml.sax.SAXException;

public class SolrServer {

	public static final String BLANK_SOLRNAME = "";

	private String solrHome;

	private String solrFile = "solr.xml";

	private CoreContainer container;

	private Map<String, EmbeddedSolrServer> embeddedSolrServers = new LinkedHashMap<String, EmbeddedSolrServer>();

	private Map<String, Builder> builderMap = new LinkedHashMap<String, Builder>();

	private String firstCoreName;

	private boolean isBuildIndexOnStartup = true;

	public SolrServer() {

	}

	public CoreContainer getContainer() {
		return container;
	}

	public void setBuilderMap(Map<String, Builder> builderMap) {
		this.builderMap = builderMap;
	}

	public Map<String, Builder> getBuilderMap() {
		return builderMap;
	}

	public boolean isBuildIndexOnStartup() {
		return isBuildIndexOnStartup;
	}

	public void setBuildIndexOnStartup(boolean isBuildIndexOnStartup) {
		this.isBuildIndexOnStartup = isBuildIndexOnStartup;
	}
	
	public void setSolrFile(String solrFile) {
		this.solrFile = solrFile;
	}
	
	public void setSolrHome(String solrHome) {
		this.solrHome = solrHome;
	}

	public EmbeddedSolrServer getSolrServer() {
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

	public void start() throws Exception {
		//
		if (solrHome == null || solrHome.equals("")) {
			throw new IllegalArgumentException("SOLR_HOME can not be empty !");
		}
		File home = new File(solrHome);
		//
		if (solrFile == null || solrFile.equals("")) {
			throw new IllegalArgumentException("SOLR_FILE can not be empty !");
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
		Collection<String> coreNames = container.getCoreNames();
		for (String coreName : coreNames) {
			EmbeddedSolrServer server = new EmbeddedSolrServer(container, coreName);
			embeddedSolrServers.put(coreName, server);
			if (embeddedSolrServers.size() == 1) {
				firstCoreName = coreName;
			}

			// build
			if (builderMap == null) {
				continue;
			}
			Builder builder = builderMap.get(coreName);
			if (isBuildIndexOnStartup && builder != null) {
				builder.build(server);
			}
		}
	}

	public void stop() {
		container.shutdown();
	}
}
