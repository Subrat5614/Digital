package testCases;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import utilities.ExcelUtil;

public class TestDataProvider {
	@DataProvider(name = "getUserData")
	public static Object[][] getUserData() throws IOException, Exception {
		return ExcelUtil.getExcelData("User");
	}

	@DataProvider(name = "getEventData")
	public static Object[][] getEventData() throws IOException, Exception {
		return ExcelUtil.getExcelData("Event");

	}

	@DataProvider(name = "getMasterCode")
	public static Object[][] getMasterCode() throws IOException, Exception {
		return ExcelUtil.getExcelData("Master Code");
	}

	@DataProvider(name = "getMasterDetails")
	public static Object[][] getMasterDetails() throws IOException, Exception {
		return ExcelUtil.getExcelData("Master Details");
	}

	@DataProvider(name = "getSummaryData")
	public static Object[][] getSummaryData() throws IOException, Exception {
		return ExcelUtil.getExcelData("Bhadra Account");
	}

	@DataProvider(name = "getMemoPlanData")
	public static Object[][] getMemoPlanData() throws IOException, Exception {
		return ExcelUtil.getExcelData("Plan");
	}

	@DataProvider(name = "getDimensionData")
	public static Object[][] getDimensionData() throws IOException, Exception {
		return ExcelUtil.getExcelData("Dimensions");
	}
	@DataProvider(name = "getProductionData")
	public static Object[][] getProductionData() throws IOException, Exception {
		return ExcelUtil.getExcelData("Production Data");
	}
	@DataProvider(name = "getLostHours")
	public static Object[][] getLostHours() throws IOException, Exception {
		return ExcelUtil.getExcelData("Lost Hours");
	}
	@DataProvider(name = "getPowerUsage")
	public static Object[][] getPowerUsage() throws IOException, Exception {
		return ExcelUtil.getExcelData("Power Usage");
	}
	@DataProvider(name = "getSeconds")
	public static Object[][] getSeconds() throws IOException, Exception {
		return ExcelUtil.getExcelData("Seconds");
	}
}