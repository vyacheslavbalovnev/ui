package ru.vbalovnev.steam.ui.service.dao.Impl;

import org.apache.commons.io.IOUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.stereotype.Service;
import ru.vbalovnev.steam.ui.service.dao.XlsReader;
import ru.vbalovnev.steam.ui.service.model.GameGenre;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static java.util.Objects.isNull;
import static org.hibernate.validator.internal.util.Contracts.assertNotNull;

@Service
public class XlsReaderImpl implements XlsReader {


    public static byte[] loadFile(String nameFile) {
        try (InputStream inputStream = FileUtils.class.getResourceAsStream(nameFile)) {
            return IOUtils.toByteArray(inputStream);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    @Override
    public List<List<String>> getData(GameGenre gameGenre) {
        try {
            List<List<String>> rows = new ArrayList<>();
            byte[] bytes = loadFile("/xlsx/Spisok.xlsx");
            final ByteArrayInputStream byteInStream = new ByteArrayInputStream(bytes);
            final XSSFWorkbook workbook = new XSSFWorkbook(byteInStream);
            final XSSFSheet sheet = workbook.getSheetAt(gameGenre.getSheetId());

            final Iterator<Row> rowIterator = sheet.rowIterator();
            DataFormatter formatter = new DataFormatter();
            while (rowIterator.hasNext()) {
                final Row row = rowIterator.next();
                final int rowNum = row.getRowNum();
                if (rowNum == 0) {
                    continue;
                }
                final Cell cell = row.getCell(1);
                if (isNull(cell)) {
                    break;
                }
                if(cell.getStringCellValue() == null || cell.getStringCellValue().length()==0) {
                    continue;
                }
                List<String> cells = new ArrayList<>();
                cells.add(cell.getStringCellValue());
                final Cell cellYear = row.getCell(2);
                cells.add(formatter.formatCellValue(cellYear));
                final Cell cellDev = row.getCell(3);
                cells.add(cellDev.getStringCellValue());
                final Cell cellPub = row.getCell(4);
                cells.add(cellPub.getStringCellValue());
                final Cell cellDesc = row.getCell(5);
                cells.add(cellDesc.getStringCellValue());

                rows.add(cells);
            }
            return rows;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
