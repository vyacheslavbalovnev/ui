package ru.vbalovnev.steam.ui.service.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.vbalovnev.steam.ui.service.imp.DataServiceImpl;

@Configuration
@ComponentScan(basePackageClasses = {
    DataServiceImpl.class,
})
public class ServiceConfig {
}
