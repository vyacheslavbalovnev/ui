package ru.vbalovnev.steam.ui.service.imp;

import org.springframework.stereotype.Service;
import ru.vbalovnev.steam.ui.service.DataService;

@Service
public class DataServiceImpl implements DataService {

    @Override
    public String getData() {
        return "data";
    }
}
