package ru.vbalovnev.steam.ui.assembly;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import ru.vbalovnev.steam.ui.assembly.config.AssemblyConfig;
import ru.vbalovnev.steam.ui.service.config.ServiceConfig;

@SpringBootApplication
@Import({
    AssemblyConfig.class,
    ServiceConfig.class
})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
