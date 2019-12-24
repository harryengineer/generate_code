package com.zhang.generate_code.util;

import java.io.File;
import java.util.List;
import java.util.prefs.Preferences;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import com.zhang.generate_code.MainApp;
import com.zhang.generate_code.po.PersisDataPo;
import com.zhang.generate_code.po.PersisDataPoWrapper;

import javafx.scene.control.Alert;

/**
 * 用于xml的数据持久化的类
 *
 * @author 张金 474879176@qq.coom
 * @date 2019-12-23 15:30
 **/
public class XmlFileUtils {

	private final static String DEFAULT_PATH = "gc_filePath";

	/**
	 * 使用jaxb的初始化加载数据
	 *
	 * @author 张金 474879176@qq.coom
	 * @date 2019/12/11 16:19
	 */
	public static List<PersisDataPo> initLoadData() {
		Preferences preferences = Preferences.userNodeForPackage(MainApp.class);
		String defaultPath = preferences.get(DEFAULT_PATH, "");
		File file = new File(defaultPath);
		try {
			if (!file.exists()) {
				return null;
			}

			JAXBContext context = JAXBContext.newInstance(PersisDataPoWrapper.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			PersisDataPoWrapper wrapper = (PersisDataPoWrapper) unmarshaller.unmarshal(file);
			return wrapper.getTableList();
		} catch (Exception e) {
			showErrorDialog(file);
		}

		return null;
	}

	/**
	 * 展示异常弹框
	 *
	 * @author 张金 474879176@qq.coom
	 * @date 2019/12/23 15:48
	 */
	private static void showErrorDialog(File file) {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle("ERROR");
		alert.setContentText("Could not load data from file:\n" + file.getPath());
		alert.show();
	}

	/**
	 * 使用jaxb的加载数据模型
	 *
	 * @author 张金 474879176@qq.coom
	 * @date 2019/12/11 16:19
	 */
	public static List<PersisDataPo> loadPersonDataFromFile(File file) {
		try {
			JAXBContext context = JAXBContext.newInstance(PersisDataPoWrapper.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			PersisDataPoWrapper wrapper = (PersisDataPoWrapper) unmarshaller.unmarshal(file);
			setPersonFilePath(file);
			return wrapper.getTableList();
		} catch (Exception e) {
			showErrorDialog(file);
		}

		return null;
	}

	/**
	 * 设置文章的路径到系统函数中
	 *
	 * @author 张金 474879176@qq.coom
	 * @date 2019/12/11 16:04
	 */
	private static void setPersonFilePath(File file) {
		Preferences preferences = Preferences.userNodeForPackage(MainApp.class);
		if (file != null) {
			preferences.put(DEFAULT_PATH, file.getPath());
		} else {
			preferences.remove(DEFAULT_PATH);
		}
	}

}
