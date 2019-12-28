package com.zhang.generate_code.util;

import com.zhang.generate_code.controller.RootController;
import lc.kra.system.keyboard.GlobalKeyboardHook;
import lc.kra.system.keyboard.event.GlobalKeyAdapter;
import lc.kra.system.keyboard.event.GlobalKeyEvent;

/**
 * 全局的键盘监听事件
 *
 * @author 张金 474879176@qq.coom
 * @date 2019-12-28 16:51
 **/
public class GlobalBoardUtils {

	private static GlobalKeyboardHook globalKeyboardHook = null;

	/**
	 * 打开全键盘监听事件
	 */
	public static void openGlobalBoardHook() {
		globalKeyboardHook = new GlobalKeyboardHook(true);
		globalKeyboardHook.addKeyListener(new GlobalKeyAdapter() {
			@Override
			public void keyPressed(GlobalKeyEvent event) {
				if (event.getVirtualKeyCode() == GlobalKeyEvent.VK_CONTROL) {
					RootController.ctrlAndClick = true;
				} else {
					super.keyPressed(event);
				}
			}

			@Override
			public void keyReleased(GlobalKeyEvent event) {
				if (event.getVirtualKeyCode() == GlobalKeyEvent.VK_CONTROL) {
					RootController.ctrlAndClick  = false;
				} else {
					super.keyReleased(event);
				}
			}
		});
	}


	/**
	 * 关闭全键盘监听事件，如果不关闭的话，无法进行键盘的输入
	 */
	public static void closeGlobalBoardHook() {
		if (globalKeyboardHook != null) {
			globalKeyboardHook.shutdownHook();
		}
	}
}
