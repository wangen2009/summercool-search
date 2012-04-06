package org.summercool.search.pojo;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @Title: SmsMessage.java
 * @Package com.gexin.platform.web.module.gateway.controllers.config
 * @Description: TODO(添加描述)
 * @author wujl
 * @date 2011-12-16 下午3:13:31
 * @version V1.0
 */
@XmlRootElement(name = "tags")
public class TagsSchema implements Serializable {
	private static final long serialVersionUID = 1492458361781166230L;

	/**
	 * @Fields messageId :
	 */
	@XmlElement(name = "tag")
	public List<TagSchema> tags;

	public String toString() {
		return tags.toString();
	}

	public List<TagSchema> getTags() {
		return tags;
	}
}
