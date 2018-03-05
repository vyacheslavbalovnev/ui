package ru.vbalovnev.steam.ui.assembly.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.vbalovnev.steam.ui.assembly.controller.GreetingController;

@Configuration
@ComponentScan(basePackageClasses = {
//    DataActorImpl.class,

    GreetingController.class
})
public class AssemblyConfig {
}
