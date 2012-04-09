package org.summercool.search.server;

import java.io.Serializable;
import java.util.List;

import org.summercool.search.builder.Builder;

/**
 * @Title: SolrCoreEntry.java
 * @Package org.summercool.search.server
 * @Description: TODO(添加描述)
 * @author Administrator
 * @date 2012-4-6 下午10:36:43
 * @version V1.0
 */
public class SolrBuilderEntry implements Serializable {
	private static final long serialVersionUID = -6175863399193499596L;

	private String name;
	private List<Builder> builderList;
	private boolean buildIndexOnStartup;

	public SolrBuilderEntry() {

	}

	public SolrBuilderEntry(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Builder> getBuilderList() {
		return builderList;
	}

	public void setBuilderList(List<Builder> builderList) {
		this.builderList = builderList;
	}

	public boolean isBuildIndexOnStartup() {
		return buildIndexOnStartup;
	}

	public void setBuildIndexOnStartup(boolean buildIndexOnStartup) {
		this.buildIndexOnStartup = buildIndexOnStartup;
	}

}
