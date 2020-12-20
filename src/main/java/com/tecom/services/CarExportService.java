package com.tecom.services;

import com.tecom.database.model.Car;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Service
public class CarExportService {
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;

    private void writeHeaderRow() {
        Row row = sheet.createRow(0);
        Cell cell = row.createCell(0);
        cell.setCellValue("Car id");

        cell = row.createCell(1);
        cell.setCellValue("Brand");

        cell = row.createCell(2);
        cell.setCellValue("Model");

        cell = row.createCell(3);
        cell.setCellValue("Year");

        cell = row.createCell(4);
        cell.setCellValue("Month");

        cell = row.createCell(5);
        cell.setCellValue("Engine Volume");

        cell = row.createCell(6);
        cell.setCellValue("Turbocharger");

        cell = row.createCell(7);
        cell.setCellValue("Engine Power");

        cell = row.createCell(8);
        cell.setCellValue("Transmission");

        cell = row.createCell(9);
        cell.setCellValue("Drive Unit");

        cell = row.createCell(10);
        cell.setCellValue("Body");

        cell = row.createCell(11);
        cell.setCellValue("Color");

    }

    private void writeDataRows(Iterable<Car> cars) {
        int rowCount = 1;

        for (Car car: cars) {
            Row row = sheet.createRow(rowCount);
            Cell cell = row.createCell(0);
            cell.setCellValue(car.getCarId());

            cell = row.createCell(1);
            cell.setCellValue(car.getBrand());

            cell = row.createCell(2);
            cell.setCellValue(car.getModel());

            cell = row.createCell(3);
            cell.setCellValue(car.getReleaseYear());

            cell = row.createCell(4);
            cell.setCellValue(car.getReleaseMonth());

            cell = row.createCell(5);
            cell.setCellValue(car.getEngineVolume());

            cell = row.createCell(6);
            cell.setCellValue(car.isTurbocharger());

            cell = row.createCell(7);
            cell.setCellValue(car.getEnginePower());

            cell = row.createCell(8);
            cell.setCellValue(car.getTransmission().toString());

            cell = row.createCell(9);
            cell.setCellValue(car.getDriveUnit().toString());

            cell = row.createCell(10);
            cell.setCellValue(car.getBody().toString());

            cell = row.createCell(11);
            cell.setCellValue(car.getColor());
            rowCount++;
        }
    }

    public void export(HttpServletResponse response, Iterable<Car> cars) throws IOException {
        workbook = new XSSFWorkbook();
        sheet = workbook.createSheet("Cars");

        writeHeaderRow();
        writeDataRows(cars);

        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }
}
