package ru.vbalovnev.steam.ui.service.dao;

import org.apache.commons.io.IOUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.junit.Test;
import ru.vbalovnev.steam.ui.service.dao.Impl.XlsReaderImpl;
import ru.vbalovnev.steam.ui.service.model.GameGenre;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import static java.util.Objects.isNull;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertNotNull;

public class XlsReaderTest {
//
//    public static byte[] loadFile(String nameFile) {
//        try (InputStream inputStream = FileUtils.class.getResourceAsStream(nameFile)) {
//            return IOUtils.toByteArray(inputStream);
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
//        return null;
//    }
//
//    @Test
//    public void readFile() throws IOException {
//        byte[] bytes = loadFile("/xlsx/Advise-list.xlsx");
//        assertNotNull(bytes);
//        final ByteArrayInputStream byteInStream = new ByteArrayInputStream(bytes);
//        final XSSFWorkbook workbook = new XSSFWorkbook(byteInStream);
//        final XSSFSheet sheet = workbook.getSheetAt(1);
//
//        final Iterator<Row> rowIterator = sheet.rowIterator();
//        while (rowIterator.hasNext()) {
//            final Row row = rowIterator.next();
//            final int rowNum = row.getRowNum();
//            final Cell cell = row.getCell(1);
//            if (isNull(cell)) {
//                break;
//            }
//            System.out.println(cell.getStringCellValue());
//        }
//    }

//    @Test
//    public void testRPG() {
//        XlsReader xlr = new XlsReaderImpl();
//        List<List<String>> data = xlr.getData(GameGenre.RPG);
//
//        assertFalse(data.isEmpty());
//
//    }

    @Test
    public void test() {
        XlsReader xlr = new XlsReaderImpl();
        for (GameGenre gameGenre : GameGenre.values()) {
            List<List<String>> data = xlr.getData(gameGenre);
            assertFalse(data.isEmpty());
        }
    }
}
