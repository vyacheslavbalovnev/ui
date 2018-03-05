package ru.vbalovnev.steam.ui.service.imp;


import org.junit.Before;
import org.junit.Test;
import ru.vbalovnev.steam.ui.service.DataService;

import static org.junit.Assert.assertEquals;

public class DataServiceTest {

    private DataService service;

    @Before
    public void before() {
        this.service = new DataServiceImpl();
    }

    @Test
    public void testValue() {

        assertEquals("Test value", "data", service.getData());
    }
}
