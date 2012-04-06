package org.summercool.search.pojo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

/**
 * @Title: SmsMessage.java
 * @Package com.gexin.platform.web.module.gateway.controllers.config
 * @Description: TODO(添加描述)
 * @author Administrator
 * @date 2011-12-16 下午3:13:31
 * @version V1.0
 */
@XmlType(name = "tag")
public class TagSchema implements Serializable {
	private static final long serialVersionUID = 6688480397923269070L;

	/**
	 * @Fields messageId :
	 */
	@XmlAttribute(name = "type")
	private String type;

	@XmlAttribute(name = "name")
	private String name;

	@XmlValue
	private String value;

	public String getType() {
		return type;
	}

	public String getValue() {
		return value;
	}

	public String getName() {
		return name;
	}

	public String toString() {
		return "{name=" + name + ",type=" + type + ",value=" + value + "}";
	}
}
