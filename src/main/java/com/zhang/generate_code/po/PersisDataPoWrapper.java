package com.zhang.generate_code.po;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * xml的文件的包装类
 *
 * @author 张金 474879176@qq.coom
 * @date 2019-12-23 15:17
 **/
@XmlRootElement(name = "database")
public class PersisDataPoWrapper {

	private List<PersisDataPo> tableList;

	@XmlElement(name = "table")
	public List<PersisDataPo> getTableList() {
		return tableList;
	}

	public void setTableList(List<PersisDataPo> tableList) {
		this.tableList = tableList;
	}
}
