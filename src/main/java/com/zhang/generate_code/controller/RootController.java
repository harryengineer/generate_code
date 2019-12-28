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

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;

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
    private JFXMasonryPane jfxMasonryPane;

    private List<PersisDataPo> dataPos;

    private volatile Integer choosedIndex = null;

    public static volatile boolean ctrlAndClick = false;

    private Set<Integer> indexList = new HashSet<>();

    /**
     * root 初始化，想其中插入数据
     */
    @FXML
    private void initialize() {
        for (int i = 0; i < 20; i++) {
            Label label = new Label("bs_proxydfggggggggggggggggg");
            SVGGlyph glyph = new SVGGlyph(-1, "",
                    "M292.571 164.571v109.714q0 8-5.143 13.143t-13.143 5.143h-182.857q-8 0-13.143-5.143t-5.143-13.143v-109.714q0-8 5.143-13.143t13.143-5.143h182.857q8 0 13.143 5.143t5.143 13.143zM292.571 384v109.714q0 8-5.143 13.143t-13.143 5.143h-182.857q-8 0-13.143-5.143t-5.143-13.143v-109.714q0-8 5.143-13.143t13.143-5.143h182.857q8 0 13.143 5.143t5.143 13.143zM585.143 164.571v109.714q0 8-5.143 13.143t-13.143 5.143h-182.857q-8 0-13.143-5.143t-5.143-13.143v-109.714q0-8 5.143-13.143t13.143-5.143h182.857q8 0 13.143 5.143t5.143 13.143zM292.571 603.428v109.714q0 8-5.143 13.143t-13.143 5.143h-182.857q-8 0-13.143-5.143t-5.143-13.143v-109.714q0-8 5.143-13.143t13.143-5.143h182.857q8 0 13.143 5.143t5.143 13.143zM585.143 384v109.714q0 8-5.143 13.143t-13.143 5.143h-182.857q-8 0-13.143-5.143t-5.143-13.143v-109.714q0-8 5.143-13.143t13.143-5.143h182.857q8 0 13.143 5.143t5.143 13.143zM877.714 164.571v109.714q0 8-5.143 13.143t-13.143 5.143h-182.857q-8 0-13.143-5.143t-5.143-13.143v-109.714q0-8 5.143-13.143t13.143-5.143h182.857q8 0 13.143 5.143t5.143 13.143zM585.143 603.428v109.714q0 8-5.143 13.143t-13.143 5.143h-182.857q-8 0-13.143-5.143t-5.143-13.143v-109.714q0-8 5.143-13.143t13.143-5.143h182.857q8 0 13.143 5.143t5.143 13.143zM877.714 384v109.714q0 8-5.143 13.143t-13.143 5.143h-182.857q-8 0-13.143-5.143t-5.143-13.143v-109.714q0-8 5.143-13.143t13.143-5.143h182.857q8 0 13.143 5.143t5.143 13.143zM877.714 603.428v109.714q0 8-5.143 13.143t-13.143 5.143h-182.857q-8 0-13.143-5.143t-5.143-13.143v-109.714q0-8 5.143-13.143t13.143-5.143h182.857q8 0 13.143 5.143t5.143 13.143zM950.857 786.286v-621.714q0-37.714-26.857-64.571t-64.571-26.857h-768q-37.714 0-64.571 26.857t-26.857 64.571v621.714q0 37.714 26.857 64.571t64.571 26.857h768q37.714 0 64.571-26.857t26.857-64.571z",
                    Color.BLACK);
            glyph.setSize(15, 15);
            label.setGraphic(glyph);
            String labelStype = "-fx-label-padding: 0; -fx-text-alignment: center; -fx-alignment: baseline-center; -fx-font-size: 75%;-fx-border-radius: .25em;-fx-background-radius: .25em;";
            label.setStyle(labelStype);
            label.setMaxSize(40, 16);

            // ?
            int tempI = i;
            label.setOnMouseClicked(event -> {
                // 只要ctrl成立，所有的都被选中
                if (ctrlAndClick) {
                    indexList.add(tempI);
                    choosedIndex = tempI;
                    label.setStyle("-fx-background-color: #0099ff;-fx-text-fill: #FFFFFF;" + labelStype);

                } else {
                    // ctrl + 点击，换到 单击的时候， 其他的选中全部消失
                    if (indexList.size() > 0) {
                        indexList.forEach(x -> jfxMasonryPane.getChildren().get(x).setStyle(labelStype));
                        indexList.clear();
                    } else {
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
            label.setContextMenu(tablerightClickMenuEvent());
            label.setPadding(new Insets(1));
            jfxMasonryPane.getChildren().addAll(label);
        }

    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    /**
     * 右击鼠标显示菜单（目前没有任何的功能）
     */
    public ContextMenu tablerightClickMenuEvent() {
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
            // 优化由于加载图片过大导致内存消耗过大
            ImageView folderIcon = new ImageView();
            // 添加图标
            folderIcon.setImage(image);
            folderIcon.setFitWidth(16);
            folderIcon.setFitHeight(16);
            stringTreeItem.setGraphic(folderIcon);

            // 添加右击菜单显示
            return stringTreeItem;
        }).collect(Collectors.toList());
        item.getChildren().addAll(items);
        // 展示父类的内容
        this.treeView.setRoot(item);
        this.treeView.setShowRoot(false);
        addTreeViewDoubleClickedEvent();
        treeView.setContextMenu(databaseRightClickMenuEvent());
    }

    /**
     * 右击数据库的页面
     * @return 内容表单
     */
    private ContextMenu databaseRightClickMenuEvent() {
        ContextMenu contextMenu = new ContextMenu();
        // 菜单项
        MenuItem editCon = new MenuItem("编辑连接");
        SVGGlyph svgGlyph = new SVGGlyph("M505.72 20.7c-270.62 0-490 219.38-490 490s219.38 490 490 490 490-219.38 490-490-219.38-490-490-490z m224.33 234.01a27.804 27.804 0 0 1 21.02 21.02 27.782 27.782 0 0 1-9.99 27.99L427.12 617.64c-9.97 9.48-25.6 9.48-35.57 0v0.04a32.174 32.174 0 0 1 0-35.57l310.52-317.42a27.78 27.78 0 0 1 27.98-9.98z m40.27 423.42c-0.02 53.83-43.67 97.46-97.5 97.46H337.89c-53.83-0.02-97.46-43.67-97.46-97.5V343.2c0-53.83 43.63-97.48 97.46-97.5H526.1c7.13-0.83 14.28 1.41 19.66 6.15a25.315 25.315 0 0 1 8.59 18.73c0.39 7.58-2.28 15-7.42 20.59a28.308 28.308 0 0 1-19.89 9.14H337.92c-23.59 0.25-42.66 19.3-42.93 42.89v336.38c0.27 23.59 19.34 42.65 42.93 42.89h335.39c23.58-0.27 42.63-19.32 42.89-42.89V494.32c-0.12-7.58 2.8-14.89 8.12-20.3 5.32-5.4 12.58-8.45 20.17-8.45v-0.08c14.15 0 24.84 13.2 25.83 30.72v181.92z");
        svgGlyph.setSize(14, 14);
        editCon.setGraphic(svgGlyph);
        MenuItem conDetail = new MenuItem("查新详情");
        MenuItem removeCon= new MenuItem("删除连接");
        contextMenu.getItems().addAll(editCon, conDetail, removeCon);
        editCon.setOnAction(x -> editConnection());
        conDetail.setOnAction(x -> connectionDetail());
        removeCon.setOnAction(x ->reomveConnection());
        return contextMenu;
    }


    /**
     * 编辑代理商
     */
    public void editConnection() {
        mainApp.newConnction(dataPos.get(treeView.getSelectionModel().getSelectedIndex()), 2);
    }

    /**
     *  连接详情
     */
    public void connectionDetail() {
        mainApp.newConnction(dataPos.get(treeView.getSelectionModel().getSelectedIndex()), 3);
    }

    /**
     *  删除连接
     */
    public void reomveConnection() {

    }

    /**
     * 获取表的图标
     *
     * @author 张金 474879176@qq.coom
     * @date 2019/12/24 18:58
     */
    private Image getTableIconImageView() {
        InputStream stream = MainApp.class.getClass().getResourceAsStream("/static/img/database_pic.png");
        // 加载的时候对图片进行压缩处理
        return new Image(stream, 16, 16, true, true);
    }

    /**
     * 双击事件
     */
    private void addTreeViewDoubleClickedEvent() {
        treeView.setOnMouseClicked(x -> {
            if (x.getClickCount() == 2) {
                // 获取treeView那个被获取了
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

    /**
     * 打开新建连接按钮
     * 
     * @param actionEvent
     */
    public void newConnction(ActionEvent actionEvent) {
        mainApp.newConnction(null, 1);
    }
}
