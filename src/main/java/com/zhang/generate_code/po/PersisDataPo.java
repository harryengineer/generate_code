package com.zhang.generate_code.po;

import java.io.Serializable;

/**
 * mysql的链接配置
 *
 * @author 张金 474879176@qq.coom
 * @date 2019-11-15 17:06
 **/
public class PersisDataPo implements Serializable {

	private static final long serialVersionUID = 3062874371397651105L;

	/**
	 * 连接名称
	 */
	private String linkName;

	/**
	 * 用户名称
	 */
	private String username;

	/**
	 * 面膜
	 */
	private String password;

	/**
	 * 主机
	 */
	private String host;

	/**
	 * 端口
	 */
	private Integer port;


	private String path;

	public PersisDataPo(String linkName, String username, String password, String host, Integer port, String path) {
		this.linkName = linkName;
		this.username = username;
		this.password = password;
		this.host = host;
		this.port = port;
		this.path = path;
	}

	@Override
	public String toString() {
		return "PersisDataPo{" +
				"linkName='" + linkName + '\'' +
				", username='" + username + '\'' +
				", password='" + password + '\'' +
				", host='" + host + '\'' +
				", port=" + port +
				", path='" + path + '\'' +
				'}';
	}

	public String getLinkName() {
		return linkName;
	}

	public void setLinkName(String linkName) {
		this.linkName = linkName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}
