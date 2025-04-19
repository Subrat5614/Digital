package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
    private static final String EXCEL_PATH = "Configuration/Digital.xlsx";
    private static Workbook workbook;

    static {
        try (FileInputStream fis = new FileInputStream(new File(EXCEL_PATH))) {
            workbook = new XSSFWorkbook(fis);
        } catch (IOException e) {
            throw new RuntimeException("Error loading Excel file: " + EXCEL_PATH, e);
        }
    }

    public static Object[][] getExcelData(String sheetName) {
        Sheet sheet = workbook.getSheet(sheetName);
        if (sheet == null) {
            throw new IllegalArgumentException("Sheet \"" + sheetName + "\" does not exist.");
        }

        int rowCount = sheet.getLastRowNum();
        int colCount = sheet.getRow(0).getLastCellNum();
        // System.out.println("sheetName---------->" + sheetName);
        // System.out.println("rowCount---------->" + rowCount);
        // System.out.println("colCount---------->" + colCount);

        Object[][] data = new Object[rowCount][colCount];

        for (int i = 1; i <= rowCount; i++) { // Start at 1 to skip headers
            Row row = sheet.getRow(i);
            for (int j = 0; j < colCount; j++) {
                data[i - 1][j] = getCellValue(row.getCell(j, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL));
                // System.out.println("------------->"+data[i - 1][j]);
            }
        }
        return data;
    }

    private static Object getCellValue(Cell cell) {
        if (cell == null)
            return "";
        return switch (cell.getCellType()) {
        case STRING -> cell.getStringCellValue().trim();
        case NUMERIC -> DateUtil.isCellDateFormatted(cell) ? cell.getDateCellValue() : cell.getNumericCellValue();
        case BOOLEAN -> cell.getBooleanCellValue();
        default -> "";
        };
    }
    

    /**
     * Closes the workbook resource.
     */
    public static void closeWorkbook() {
        try {
            if (workbook != null) {
                workbook.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
