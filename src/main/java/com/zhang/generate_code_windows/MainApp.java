package com.zhang.generate_code_windows;

import java.io.IOException;

import com.jfoenix.svg.SVGGlyphLoader;
import com.zhang.generate_code_windows.controller.RootController;

import com.zhang.generate_code_windows.po.PersisDataPo;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.SelectionMode;
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

	private ObservableList<PersisDataPo> dataPos = FXCollections.observableArrayList();

	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;
		primaryStage.setTitle("java代码生成器");
		primaryStage.getIcons().add(new Image("/static/logo.jpg"));
		loadRoot();

	}


	public void loadRoot() throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader();
		fxmlLoader.setLocation(this.getClass().getResource("/view/Root.fxml"));
		BorderPane load = fxmlLoader.load();
		Scene scene = new Scene(load, 1000, 600);
		primaryStage.setScene(scene);
		RootController controller = fxmlLoader.getController();
		controller.setPrimaryStage(primaryStage);
		controller.setDataPoListView(dataPos);
		primaryStage.show();

	}


	public MainApp() {
		dataPos.add(new PersisDataPo("链接名1", "root","123456","127.0.0.1", 3306, "pachong", "c:/"));
		dataPos.add(new PersisDataPo("链接名2","root","123456","127.0.0.1", 3306, "pachong", "c:/"));
		dataPos.add(new PersisDataPo("链接名3","root","123456","127.0.0.1", 3306, "pachong", "c:/"));
		dataPos.add(new PersisDataPo("链接名4","root","123456","127.0.0.1", 3306, "pachong", "c:/"));
		dataPos.add(new PersisDataPo("链接名5","root","123456","127.0.0.1", 3306, "pachong", "c:/"));
		dataPos.add(new PersisDataPo("链接名6","root","123456","127.0.0.1", 3306, "pachong", "c:/"));
		dataPos.add(new PersisDataPo("链接名7","root","123456","127.0.0.1", 3306, "pachong", "c:/"));
		dataPos.add(new PersisDataPo("链接名8","root","123456","127.0.0.1", 3306, "pachong", "c:/"));
		dataPos.add(new PersisDataPo("链接名9","root","123456","127.0.0.1", 3306, "pachong", "c:/"));
		dataPos.add(new PersisDataPo("链接名10","root","123456","127.0.0.1", 3306, "pachong", "c:/"));
		dataPos.add(new PersisDataPo("链接名11","root","123456","127.0.0.1", 3306, "pachong", "c:/"));
		dataPos.add(new PersisDataPo("链接名12","root","123456","127.0.0.1", 3306, "pachong", "c:/"));
		dataPos.add(new PersisDataPo("链接名13","root","123456","127.0.0.1", 3306, "pachong", "c:/"));
		dataPos.add(new PersisDataPo("链接名14","root","123456","127.0.0.1", 3306, "pachong", "c:/"));
		dataPos.add(new PersisDataPo("链接名15","root","123456","127.0.0.1", 3306, "pachong", "c:/"));
		dataPos.add(new PersisDataPo("链接名16","root","123456","127.0.0.1", 3306, "pachong", "c:/"));
		dataPos.add(new PersisDataPo("链接名17","root","123456","127.0.0.1", 3306, "pachong", "c:/"));
		dataPos.add(new PersisDataPo("链接名18","root","123456","127.0.0.1", 3306, "pachong", "c:/"));
		dataPos.add(new PersisDataPo("链接名19","root","123456","127.0.0.1", 3306, "pachong", "c:/"));
		dataPos.add(new PersisDataPo("链接名20","root","123456","127.0.0.1", 3306, "pachong", "c:/"));
		dataPos.add(new PersisDataPo("链接名21","root","123456","127.0.0.1", 3306, "pachong", "c:/"));
		dataPos.add(new PersisDataPo("链接名22","root","123456","127.0.0.1", 3306, "pachong", "c:/"));
		dataPos.add(new PersisDataPo("链接名23","root","123456","127.0.0.1", 3306, "pachong", "c:/"));
		dataPos.add(new PersisDataPo("链接名24","root","123456","127.0.0.1", 3306, "pachong", "c:/"));

		dataPos.add(new PersisDataPo("链接名1", "root","123456","127.0.0.1", 3306, "pachong", "c:/"));
		dataPos.add(new PersisDataPo("链接名2","root","123456","127.0.0.1", 3306, "pachong", "c:/"));
		dataPos.add(new PersisDataPo("链接名3","root","123456","127.0.0.1", 3306, "pachong", "c:/"));
		dataPos.add(new PersisDataPo("链接名4","root","123456","127.0.0.1", 3306, "pachong", "c:/"));
		dataPos.add(new PersisDataPo("链接名5","root","123456","127.0.0.1", 3306, "pachong", "c:/"));
		dataPos.add(new PersisDataPo("链接名6","root","123456","127.0.0.1", 3306, "pachong", "c:/"));
		dataPos.add(new PersisDataPo("链接名7","root","123456","127.0.0.1", 3306, "pachong", "c:/"));
		dataPos.add(new PersisDataPo("链接名8","root","123456","127.0.0.1", 3306, "pachong", "c:/"));
		dataPos.add(new PersisDataPo("链接名9","root","123456","127.0.0.1", 3306, "pachong", "c:/"));
		dataPos.add(new PersisDataPo("链接名10","root","123456","127.0.0.1", 3306, "pachong", "c:/"));
		dataPos.add(new PersisDataPo("链接名11","root","123456","127.0.0.1", 3306, "pachong", "c:/"));
		dataPos.add(new PersisDataPo("链接名12","root","123456","127.0.0.1", 3306, "pachong", "c:/"));
		dataPos.add(new PersisDataPo("链接名13","root","123456","127.0.0.1", 3306, "pachong", "c:/"));
		dataPos.add(new PersisDataPo("链接名14","root","123456","127.0.0.1", 3306, "pachong", "c:/"));
		dataPos.add(new PersisDataPo("链接名15","root","123456","127.0.0.1", 3306, "pachong", "c:/"));
		dataPos.add(new PersisDataPo("链接名16","root","123456","127.0.0.1", 3306, "pachong", "c:/"));
		dataPos.add(new PersisDataPo("链接名17","root","123456","127.0.0.1", 3306, "pachong", "c:/"));
		dataPos.add(new PersisDataPo("链接名18","root","123456","127.0.0.1", 3306, "pachong", "c:/"));
		dataPos.add(new PersisDataPo("链接名19","root","123456","127.0.0.1", 3306, "pachong", "c:/"));
		dataPos.add(new PersisDataPo("链接名20","root","123456","127.0.0.1", 3306, "pachong", "c:/"));
		dataPos.add(new PersisDataPo("链接名21","root","123456","127.0.0.1", 3306, "pachong", "c:/"));
		dataPos.add(new PersisDataPo("链接名22","root","123456","127.0.0.1", 3306, "pachong", "c:/"));
		dataPos.add(new PersisDataPo("链接名23","root","123456","127.0.0.1", 3306, "pachong", "c:/"));
		dataPos.add(new PersisDataPo("链接名24","root","123456","127.0.0.1", 3306, "pachong", "c:/"));
	}
}
