package com.zhang.generate_code.po;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

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
	private final StringProperty linkName;

	/**
	 * 用户名称
	 */
	private final StringProperty username;

	/**
	 * 面膜
	 */
	private final StringProperty password;

	/**
	 * 主机
	 */
	private final StringProperty host;

	/**
	 * 端口
	 */
	private final IntegerProperty port;


	private final StringProperty path;

	public PersisDataPo(String linkName, String username, String password, String host, Integer port, String path) {
		this.linkName =  new SimpleStringProperty(linkName);
		this.username = new SimpleStringProperty(username);
		this.password = new SimpleStringProperty(password);
		this.host = new SimpleStringProperty(host);
		this.port = new SimpleIntegerProperty(port);
		this.path = new SimpleStringProperty(path);
	}

	public String getLinkName() {
		return linkName.get();
	}

	public StringProperty linkNameProperty() {
		return linkName;
	}

	public void setLinkName(String linkName) {
		this.linkName.set(linkName);
	}

	public String getUsername() {
		return username.get();
	}

	public StringProperty usernameProperty() {
		return username;
	}

	public void setUsername(String username) {
		this.username.set(username);
	}

	public String getPassword() {
		return password.get();
	}

	public StringProperty passwordProperty() {
		return password;
	}

	public void setPassword(String password) {
		this.password.set(password);
	}

	public String getHost() {
		return host.get();
	}

	public StringProperty hostProperty() {
		return host;
	}

	public void setHost(String host) {
		this.host.set(host);
	}

	public int getPort() {
		return port.get();
	}

	public IntegerProperty portProperty() {
		return port;
	}

	public void setPort(int port) {
		this.port.set(port);
	}

	public String getPath() {
		return path.get();
	}

	public StringProperty pathProperty() {
		return path;
	}

	public void setPath(String path) {
		this.path.set(path);
	}
}
