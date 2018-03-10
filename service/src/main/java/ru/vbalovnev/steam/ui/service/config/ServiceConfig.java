package ru.vbalovnev.steam.ui.service.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.vbalovnev.steam.ui.service.GameService;
import ru.vbalovnev.steam.ui.service.dao.Impl.XlsReaderImpl;
import ru.vbalovnev.steam.ui.service.imp.DataServiceImpl;
import ru.vbalovnev.steam.ui.service.imp.GameServiceImpl;

@Configuration
@ComponentScan(basePackageClasses = {
    DataServiceImpl.class,
    GameServiceImpl.class,
    XlsReaderImpl.class
})
public class ServiceConfig {
}
