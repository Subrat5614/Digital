package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcellConfig {
    private static final String FILE_PATH = "Configuration/Digital.xlsx";

    public static List<Map<String, String>> readExcelSheet(String sheetName) throws IOException {
        List<Map<String, String>> data = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(FILE_PATH);
             Workbook workbook = new XSSFWorkbook(fis)) {
            Sheet sheet = workbook.getSheet(sheetName);
            if (sheet == null) {
                throw new IllegalArgumentException("Sheet " + sheetName + " does not exist in " + FILE_PATH);
            }
            Iterator<Row> rowIterator = sheet.iterator();
            if (!rowIterator.hasNext()) {
                return data; // Empty sheet
            }
            // Read header row
            Row headerRow = rowIterator.next();
            List<String> headers = new ArrayList<>();
            headerRow.forEach(cell -> headers.add(cell.getStringCellValue().trim()));

            // Process data rows
            while (rowIterator.hasNext()) {
                Row currentRow = rowIterator.next();
                Map<String, String> rowData = new HashMap<>();
                boolean isRowEmpty = true;
                for (int i = 0; i < headers.size(); i++) {
                    Cell cell = currentRow.getCell(i, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    String value = cell.toString().trim(); // Trim to avoid leading/trailing spaces
                    if (!value.isEmpty()) {
                        isRowEmpty = false; // Mark row as non-empty if any cell has a value
                    }
                    rowData.put(headers.get(i), value.isEmpty() ? "" : value); // Store cell value (empty or actual)
                }
                // Stop processing if the row is entirely empty
                if (isRowEmpty) {
                    break; // Exit loop
                }
                data.add(rowData);
            }
        }
        return data;
    }

    public static void writeCellData(String filePath, String sheetName, int rowNum, int colNum, String data) {
        try (FileInputStream fis = new FileInputStream(filePath);
             XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
            XSSFSheet sheet = workbook.getSheet(sheetName);
            if (sheet == null)
                sheet = workbook.createSheet(sheetName);
            XSSFRow row = sheet.getRow(rowNum);
            if (row == null)
                row = sheet.createRow(rowNum);
            XSSFCell cell = row.getCell(colNum);
            if (cell == null)
                cell = row.createCell(colNum);
            cell.setCellValue(data);
            try (FileOutputStream fos = new FileOutputStream(filePath)) {
                workbook.write(fos);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        }
    }

