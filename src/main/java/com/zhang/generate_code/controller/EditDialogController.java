package com.zhang.generate_code.controller;

import com.zhang.generate_code.MainApp;
import com.zhang.generate_code.po.PersisDataPo;
import com.zhang.generate_code.util.GlobalBoardUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * @author 张金 474879176@qq.coom
 * @date 2019-12-27 16:37
 **/
public class EditDialogController {

	@FXML
	private TextField passwordField;
	@FXML
	private TextField hostField;
	@FXML
	private TextField portField;
	@FXML
	private TextField pathField;
	@FXML
	private TextField usernameField;
	@FXML
	private TextField linkNameField;

	private PersisDataPo persisDataPo;

	private MainApp mainApp;


	private Stage dialogStage;

	@FXML
	private Button testButton;

	@FXML
	private Button determineButton;

	@FXML
	private Button cancelButton;


	/**
	 * 初始化
	 */
	@FXML
	private void initialize() {

	}

	@FXML
	private void handleOk() {

	}

	@FXML
	private void handleTest(ActionEvent actionEvent) {
	}

	@FXML
	private void handleCancel() {
		GlobalBoardUtils.openGlobalBoardHook();
		dialogStage.close();
	}

	/**
	 * setPerson(…)方法可以从其它类中调用，用来设置编辑的人
	 *
	 * @author 张金 474879176@qq.coom
	 * @date 2019/12/10 19:33
	 */
	public void setPersisDataPo(PersisDataPo persisDataPo) {
		if (persisDataPo != null) {
			this.persisDataPo = persisDataPo;
			linkNameField.setText(persisDataPo.getLinkName());
			usernameField.setText(persisDataPo.getUsername());
			passwordField.setText(persisDataPo.getPassword());
			hostField.setText(persisDataPo.getHost());
			portField.setText(persisDataPo.getPort() + "");
			pathField.setText(persisDataPo.getPath());
		}

	}

	public void setType(Integer type) {
		int showInt = 3;
		if (showInt == type) {
			testButton.setVisible(false);
			determineButton.setVisible(false);
			cancelButton.setVisible(false);
			dialogStage.setHeight(250);
		}

	}

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}


	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

}
