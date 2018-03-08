package ru.vbalovnev.steam.ui.assembly.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.vbalovnev.steam.ui.assembly.controller.GreetingController;
import ru.vbalovnev.steam.ui.assembly.controller.SelectController;

@Configuration
@ComponentScan(basePackageClasses = {
//    DataActorImpl.class,

    GreetingController.class,
    SelectController.class
})
public class AssemblyConfig {
}
