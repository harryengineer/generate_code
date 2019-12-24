package com.zhang.generate_code;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.zhang.generate_code.controller.RootController;
import com.zhang.generate_code.po.PersisDataPo;
import com.zhang.generate_code.util.XmlFileUtils;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * 主类 用于项目的启动
 *
 * @author 张金 474879176@qq.coom
 * @date 2019-12-13 17:32
 **/
public class MainApp extends Application {

	private Stage primaryStage;

	private List<PersisDataPo> dataPos = new ArrayList<>();

	public List<PersisDataPo> getDataPos() {
		return dataPos;
	}

	public Stage getPrimaryStage() {
		return primaryStage;
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;
		primaryStage.setTitle("java代码生成器");
		primaryStage.getIcons().add(new Image("/static/logo.jpg"));
		loadRoot();

	}


	/**
	 * 加载根页面的展示
	 *
	 * @author 张金 474879176@qq.coom
	 * @date 2019/12/23 16:28
	 */
	public void loadRoot() throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader();

		fxmlLoader.setLocation(this.getClass().getResource("/view/Root.fxml"));
		BorderPane load = fxmlLoader.load();
		Scene scene = new Scene(load, 1000, 600);
		primaryStage.setScene(scene);
		RootController controller = fxmlLoader.getController();
		controller.setMainApp(this);
		controller.setDataPoListView(dataPos);
		primaryStage.show();
	}


	public MainApp() {
		// 加载保存的数据
		List<PersisDataPo> persisDataPos = XmlFileUtils.initLoadData();
		if (persisDataPos != null && !persisDataPos.isEmpty()) {
			dataPos.addAll(persisDataPos);
		}

		dataPos.add(new PersisDataPo("链接名21","root","123456","127.0.0.1", 3306, "pachong"));
		dataPos.add(new PersisDataPo("链接名22","root","123456","127.0.0.1", 3306, "pachong"));
		dataPos.add(new PersisDataPo("链接名23","root","123456","127.0.0.1", 3306, "pachong"));
		dataPos.add(new PersisDataPo("链接名24","root","123456","127.0.0.1", 3306, "pachong"));
	}
}
