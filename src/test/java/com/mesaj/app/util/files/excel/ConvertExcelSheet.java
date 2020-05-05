package com.mesaj.app.util.files.excel;

import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConvertExcelSheet {

    //TESTS:
    //integer, double values in the cells
    //objects with more properties than the excel file
    //excel with more properties than the object
    //what happen if there is an empty column
    //what happen if the sheet name doesn't exist.
    //add support for different data types.
    private static final int HEADER_ROW = 0;
    private static final int HEADER_ROW_COUNT = 1;

    private final String filePath;
    private final String sheetName;
    private Sheet currentSheet;

    public ConvertExcelSheet(String filePath, String sheetName) {
        this.filePath = filePath;
        this.sheetName = sheetName;
    }

    public <T> List<T> to(Class<T> type) throws Exception {

        List<T> castObjects = new ArrayList<>();

        File excelFile = new File(filePath);

        try (Workbook workbooks = WorkbookFactory.create(excelFile)) {

            currentSheet = workbooks.getSheet(sheetName);
            castObjects = convertFileTo(type);

        } catch (Exception e) {
            throw new Exception("Unable to map the datasource to the provided class. " + e.getMessage());
        }

        return castObjects;
    }


    private <T> List<T> convertFileTo(Class<T> clazz) throws IllegalAccessException, InstantiationException {

        List<Map<String, Object>> mapObjects = excelRowsToMaps();

        List<T> objectsAlreadyCast = new ArrayList<>();

        mapObjects.forEach(mapObject -> {
            try {
                Object instance = clazz.newInstance();
                mapObject.keySet().forEach(property -> {
                            try {

                                Field field = clazz.getDeclaredField(property);
                                field.setAccessible(true);
                                field.set(instance, mapObject.get(property));

                            } catch (Exception ex) {
                                System.out.println("property doesn't exist: " + property);
                            }
                        }
                );

                objectsAlreadyCast.add(clazz.cast(instance));

            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        });


        return objectsAlreadyCast;
    }

    private int getNumberOfRows() {
        return currentSheet.getPhysicalNumberOfRows() - HEADER_ROW_COUNT;
    }

    private Map<Integer, String> getColumns(Sheet sheet) {
        Map<Integer, String> columns = new HashMap<>();
        sheet.getRow(HEADER_ROW).forEach(cell -> {
            columns.put(cell.getColumnIndex(), cell.getStringCellValue());
        });
        return columns;
    }

    private List<Map<String, Object>> excelRowsToMaps() {

        int rowsNumber = getNumberOfRows();

        List<Map<String, Object>> allObjects = new ArrayList<>();

        //second row. there is where the data starts.
        int firstRowWithDataIndex = 1;

        Map<Integer, String> columns = getColumns(currentSheet);

        //for each row we're going to create an object
        for (int i = 0; i < rowsNumber; i++) {

            Map<String, Object> rowInfo = new HashMap<>();

            //go through the columns to set the properties to our object.
            for (int colum = 0; colum < columns.size(); colum++) {

                String columnName = columns.get(colum);
                rowInfo.put(columnName, getCellByType(currentSheet.getRow(firstRowWithDataIndex).getCell(colum)));
            }

            allObjects.add(rowInfo);

            firstRowWithDataIndex++;

        }
        return allObjects;
    }

    //right now only support for string properties.
    private Object getCellByType(Cell cell) {
        if (cell.getCellType() == CellType.NUMERIC)
            return String.valueOf(cell.getNumericCellValue());

        return cell.getStringCellValue();
    }
}
