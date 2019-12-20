package com.zhang.generate_code_windows.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.jfoenix.controls.JFXMasonryPane;
import com.jfoenix.svg.SVGGlyph;
import com.zhang.generate_code_windows.po.PersisDataPo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import lc.kra.system.keyboard.GlobalKeyboardHook;
import lc.kra.system.keyboard.event.GlobalKeyAdapter;
import lc.kra.system.keyboard.event.GlobalKeyEvent;

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
    private volatile Integer choosedIndex = null;

    private  volatile boolean ctrlAndClick = false;

    private Set<Integer> indexList = new HashSet<>();
    /**
     * root  初始化，想其中插入数据
     */
    @FXML
    private void initialize(){


        for (int i = 0; i < 20; i++) {
            Label label = new Label("bs_proxydfggggggggggggggggg");
            SVGGlyph glyph = new SVGGlyph(-1,
                    "",
                    "M292.571 164.571v109.714q0 8-5.143 13.143t-13.143 5.143h-182.857q-8 0-13.143-5.143t-5.143-13.143v-109.714q0-8 5.143-13.143t13.143-5.143h182.857q8 0 13.143 5.143t5.143 13.143zM292.571 384v109.714q0 8-5.143 13.143t-13.143 5.143h-182.857q-8 0-13.143-5.143t-5.143-13.143v-109.714q0-8 5.143-13.143t13.143-5.143h182.857q8 0 13.143 5.143t5.143 13.143zM585.143 164.571v109.714q0 8-5.143 13.143t-13.143 5.143h-182.857q-8 0-13.143-5.143t-5.143-13.143v-109.714q0-8 5.143-13.143t13.143-5.143h182.857q8 0 13.143 5.143t5.143 13.143zM292.571 603.428v109.714q0 8-5.143 13.143t-13.143 5.143h-182.857q-8 0-13.143-5.143t-5.143-13.143v-109.714q0-8 5.143-13.143t13.143-5.143h182.857q8 0 13.143 5.143t5.143 13.143zM585.143 384v109.714q0 8-5.143 13.143t-13.143 5.143h-182.857q-8 0-13.143-5.143t-5.143-13.143v-109.714q0-8 5.143-13.143t13.143-5.143h182.857q8 0 13.143 5.143t5.143 13.143zM877.714 164.571v109.714q0 8-5.143 13.143t-13.143 5.143h-182.857q-8 0-13.143-5.143t-5.143-13.143v-109.714q0-8 5.143-13.143t13.143-5.143h182.857q8 0 13.143 5.143t5.143 13.143zM585.143 603.428v109.714q0 8-5.143 13.143t-13.143 5.143h-182.857q-8 0-13.143-5.143t-5.143-13.143v-109.714q0-8 5.143-13.143t13.143-5.143h182.857q8 0 13.143 5.143t5.143 13.143zM877.714 384v109.714q0 8-5.143 13.143t-13.143 5.143h-182.857q-8 0-13.143-5.143t-5.143-13.143v-109.714q0-8 5.143-13.143t13.143-5.143h182.857q8 0 13.143 5.143t5.143 13.143zM877.714 603.428v109.714q0 8-5.143 13.143t-13.143 5.143h-182.857q-8 0-13.143-5.143t-5.143-13.143v-109.714q0-8 5.143-13.143t13.143-5.143h182.857q8 0 13.143 5.143t5.143 13.143zM950.857 786.286v-621.714q0-37.714-26.857-64.571t-64.571-26.857h-768q-37.714 0-64.571 26.857t-26.857 64.571v621.714q0 37.714 26.857 64.571t64.571 26.857h768q37.714 0 64.571-26.857t26.857-64.571z",
                    Color.BLACK);
            glyph.setSize(15, 15);
            label.setGraphic(glyph);
            String labelStype = "-fx-label-padding: 0; -fx-text-alignment: center; -fx-alignment: baseline-center; -fx-font-size: 75%;-fx-border-radius: .25em;-fx-background-radius: .25em;";
            label.setStyle(labelStype);
            label.setMaxSize(40, 40);

            //  ?
            int tempI = i;
            label.setOnMouseClicked(event -> {
                // 只要ctrl成立，所有的都被选中
                if (ctrlAndClick) {
                    indexList.add(tempI);
                    choosedIndex = tempI;
                    label.setStyle("-fx-background-color: #0099ff;-fx-text-fill: #FFFFFF;" + labelStype);

                } else {
                    // ctrl + 点击，换到  单击的时候， 其他的选中全部消失
                    if ( indexList.size() > 0) {
                        indexList.forEach(x -> jfxMasonryPane.getChildren().get(x).setStyle(labelStype));
                        indexList.clear();
                    } else{
                        indexList.remove(choosedIndex);
                    }


                    if (choosedIndex != null) {
                        jfxMasonryPane.getChildren().get(choosedIndex).setStyle(labelStype);
                        choosedIndex = tempI;
                    } else {
                        choosedIndex = tempI;
                    }

                    indexList.add(choosedIndex);
                    label.setStyle("-fx-background-color: #0099ff;-fx-text-fill: #FFFFFF;" + labelStype);

                }

                System.out.println(indexList.stream().map(x -> x + ",").reduce((x, y) -> x + y).orElse(""));
            });


            label.setPadding(new Insets(1));
            jfxMasonryPane.getChildren().addAll(label);
        }

    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
        GlobalKeyboardHook globalKeyboardHook = new GlobalKeyboardHook(true);
        globalKeyboardHook.addKeyListener(new GlobalKeyAdapter() {
            @Override
            public void keyPressed(GlobalKeyEvent event) {
                if (event.getVirtualKeyCode() == GlobalKeyEvent.VK_CONTROL) {
                    ctrlAndClick = true;
                }
            }

            @Override
            public void keyReleased(GlobalKeyEvent event) {
                if (event.getVirtualKeyCode() == GlobalKeyEvent.VK_CONTROL) {
                    ctrlAndClick = false;
                }
            }
        });


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
