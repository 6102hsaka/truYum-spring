package com.cognizant.truyum;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.MenuItemService;
import com.cognizant.truyum.util.DateUtil;

/**
 * Hello world!
 *
 */
public class App {
	
	static {
		System.setProperty("org.slf4j.simpleLogger.defaultLogLevel", "debug");
	}

	private static MenuItemService menuItemService;
	private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		menuItemService = context.getBean(MenuItemService.class);
		
		getMenuItemListAdmin();
		getMenuItemListCustomer();
		getMenuItem(6);
		MenuItem menuItem = new MenuItem(2, "Hotdog", 129f, true, DateUtil.convertToDate("23/12/2017"), "Main Course",
				false);
		editMenuItem(menuItem);
	}
	
	public static void getMenuItemListAdmin() {
		LOGGER.info("start");
		List<MenuItem> items = menuItemService.getMenuItemListAdmin();
		LOGGER.debug("Items{}", items);
		LOGGER.info("end");
	}

	public static void getMenuItemListCustomer() {
		LOGGER.info("start");
		List<MenuItem> items = menuItemService.getMenuItemListCustomer();
		LOGGER.debug("Items{}", items);
		LOGGER.info("end");
	}

	public static void getMenuItem(long id) {
		LOGGER.info("start");
		MenuItem item = menuItemService.getMenuItem(id);
		LOGGER.debug("Item{}", item);
		LOGGER.info("end");
	}

	public static void editMenuItem(MenuItem menuItem) {
		LOGGER.info("start");
		menuItemService.editMenuItem(menuItem);
		MenuItem item = menuItemService.getMenuItem(menuItem.getId());
		LOGGER.debug("Item{}", item);
		LOGGER.info("end");
	}

}
