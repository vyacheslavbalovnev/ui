package ru.vbalovnev.steam.ui.assembly.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.vbalovnev.steam.ui.assembly.controller.FileDownloadController;
import ru.vbalovnev.steam.ui.assembly.controller.GreetingController;
import ru.vbalovnev.steam.ui.assembly.controller.SelectController;
import ru.vbalovnev.steam.ui.assembly.repository.RepositoryData;

@Configuration
@ComponentScan(basePackageClasses = {
//    DataActorImpl.class,

    GreetingController.class,
    SelectController.class,
    FileDownloadController.class,
    RepositoryData.class
})
public class AssemblyConfig {
}
