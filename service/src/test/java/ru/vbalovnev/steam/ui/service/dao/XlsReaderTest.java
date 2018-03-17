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

    //@Test
    public void test() {
        XlsReader xlr = new XlsReaderImpl();
        for (GameGenre gameGenre : GameGenre.values()) {
            List<List<String>> data = xlr.getData(gameGenre);
            assertFalse(data.isEmpty());
        }
    }
}
