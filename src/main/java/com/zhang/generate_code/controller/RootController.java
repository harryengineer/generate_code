package com.zhang.generate_code.controller;

import java.io.File;
import java.io.InputStream;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.jfoenix.controls.JFXMasonryPane;
import com.jfoenix.svg.SVGGlyph;
import com.zhang.generate_code.MainApp;
import com.zhang.generate_code.po.PersisDataPo;
import com.zhang.generate_code.util.XmlFileUtils;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
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

    private MainApp mainApp;

    @FXML
    private TreeView<String> treeView;

	@FXML
    private JFXMasonryPane  jfxMasonryPane;

    private List<PersisDataPo> dataPos;

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

            // 鼠标悬浮展示菜单
            label.setOnMousePressed(mouse -> {
                if (mouse.isSecondaryButtonDown()) {
                    ContextMenu contextMenu = rightClickMenuEvent();
                    System.out.println(mouse.getX() + "==" + mouse.getY());
                    System.out.println(mouse.getSceneX() + "==" + mouse.getSceneY());
                    System.out.println(mouse.getScreenX() + "==" + mouse.getScreenY());
                    contextMenu.show(label, Side.BOTTOM, mouse.getX(), mouse.getY() - 30);
                }
            });

            label.setPadding(new Insets(1));
            jfxMasonryPane.getChildren().addAll(label);
        }

    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        // 全局的键盘监听事件 监听ctrl
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
     * 右击鼠标显示菜单（目前没有任何的功能）
     */
    public ContextMenu rightClickMenuEvent() {
        final Label label = new Label("一个即将被添加右键菜单的Label");
        label.setAlignment(Pos.CENTER);
        label.setStyle("-fx-background-color:gray");
        ContextMenu contextMenu = new ContextMenu();
        // 菜单项
        MenuItem redBg = new MenuItem("目前没有功能");
        redBg.setOnAction(x -> label.setStyle("-fx-background-color:black; -fx-text-fill:white;"));
        contextMenu.getItems().addAll(redBg);
        // 添加右键菜单到label
        label.setContextMenu(contextMenu);
        return contextMenu;
    }

    /**
     * 简单的设置初始化数据
     *
     * @author 张金 474879176@qq.coom
     * @date 2019/12/16 14:46
     */
    public void setDataPoListView(List<PersisDataPo> dataPos) {
        this.dataPos = dataPos;
        TreeItem<String> item = new TreeItem<>();
        // 添加treeItem的类目
        Image image = getTableIconImageView();

        List<TreeItem<String>> items = dataPos.stream().map(x -> {
            TreeItem<String> stringTreeItem = new TreeItem<>(x.getLinkName());
            ImageView folderIcon = new ImageView();
            // 添加图标
            folderIcon.setImage(image);
            folderIcon.setFitWidth(16);
            folderIcon.setFitHeight(16);

            stringTreeItem.setGraphic(folderIcon);
            return stringTreeItem;
        }).collect(Collectors.toList());
        item.getChildren().addAll(items);
        // 展示父类的内容
        this.treeView.setRoot(item);
        this.treeView.setShowRoot(false);

        addTreeViewSelectedEvent();
    }

    /**
     * 获取表的图标
     *
     * @author 张金 474879176@qq.coom
     * @date 2019/12/24 18:58
     */
    private Image getTableIconImageView() {
        InputStream stream = MainApp.class.getClass().getResourceAsStream("/static/img/database_pic.png");
        return new Image(stream);
    }

    private void addTreeViewSelectedEvent() {
        treeView.setOnMouseClicked(x -> {
            if (x.getClickCount() == 2) {
                int selectedIndex = treeView.getSelectionModel().getSelectedIndex();
                System.out.println(selectedIndex);
            }

        });
    }

    /**
     * 打开文件并加载相关的配置文件
     */
    @FXML
    private void handleOpen() {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extensionFilter = new FileChooser.ExtensionFilter("XML files (*.xml)", "*.xml");
        fileChooser.getExtensionFilters().add(extensionFilter);
        // 获取选中的文件
        File file = fileChooser.showSaveDialog(mainApp.getPrimaryStage());
        if (file != null) {
            // 加载数据到对象中去
            List<PersisDataPo> persisDataPos = XmlFileUtils.loadPersonDataFromFile(file);
            if (persisDataPos != null && !persisDataPos.isEmpty()) {
                mainApp.getDataPos().addAll(persisDataPos);
            }
        }
    }

}
