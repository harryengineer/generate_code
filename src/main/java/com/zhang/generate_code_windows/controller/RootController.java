package com.zhang.generate_code_windows.controller;

import java.util.stream.Collectors;

import com.jfoenix.controls.JFXMasonryPane;
import com.zhang.generate_code_windows.po.PersisDataPo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.stage.Stage;

/**
 * root的controller的控制器
 *
 * @author 张金 474879176@qq.coom
 * @date 2019-12-16 14:12
 **/
public class RootController {

    private Stage primaryStage;

    @FXML
    private ListView<String> dataPoListView;

    private ObservableList<PersisDataPo> dataPos;


	@FXML
	private ListView<String> tableView;

	@FXML
    private JFXMasonryPane  jfxMasonryPane;



    @FXML
    private void initialize(){
//        this.tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);


    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;

    }

    /**
     * 简单的设置初始化数据
     *
     * @author 张金 474879176@qq.coom
     * @date 2019/12/16 14:46
     */
    public void setDataPoListView(ObservableList<PersisDataPo> dataPos) {
        this.dataPos = dataPos;
        ObservableList<String> stringObservableList = FXCollections.observableArrayList(dataPos.stream().map(PersisDataPo::getLinkName).collect(Collectors.toList()));
        this.dataPoListView.setItems(stringObservableList);
//	    tableView.setItems(stringObservableList);

    }

}
