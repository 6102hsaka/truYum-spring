package com.cognizant.truyum.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemServiceTest {

	static {
		System.setProperty("org.slf4j.simpleLogger.defaultLogLevel", "debug");
	}
	
	private static MenuItemService menuItemService;
	private static final Logger LOGGER = LoggerFactory.getLogger(MenuItemServiceTest.class);
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		menuItemService = context.getBean(MenuItemService.class);
	}

	@Test
	public void testGetMenuItemListAdmin() {
		LOGGER.info("start");
		List<MenuItem> items = menuItemService.getMenuItemListAdmin();
		assertNotNull(items);
		int size = items.size();
		assertNotEquals(0, size);
		LOGGER.debug("Items{}", items);
		LOGGER.info("end");
	}
	
	@Test
	public void testGetMenuItemListCustomer() {
		LOGGER.info("start");
		List<MenuItem> items = menuItemService.getMenuItemListCustomer();
		assertNotNull(items);
		int size = items.size();
		assertNotEquals(0, size);
		LOGGER.debug("Items{}", items);
		LOGGER.info("end");
	}
	
	@Test
	public void testGetMenuItem() {
		LOGGER.info("start");
		MenuItem item = menuItemService.getMenuItem(6);
		assertNotNull(item);
		LOGGER.debug("Item{}", item);
		LOGGER.info("end");
	}
	
	@Test
	public void testEditMenuItem() {
		LOGGER.info("start");
		int previous_size = menuItemService.getMenuItemListAdmin().size();
		MenuItem menuItem = new MenuItem(2, "Hotdog", 129f, true, DateUtil.convertToDate("23/12/2017"), "Main Course",
				false);
		menuItemService.editMenuItem(menuItem);
		int new_size = menuItemService.getMenuItemListAdmin().size();
		assertEquals(new_size, previous_size);
		MenuItem item = menuItemService.getMenuItem(2);
		assertNotNull(item);
		LOGGER.debug("Items{}", item);
		LOGGER.info("end");
	}

}
