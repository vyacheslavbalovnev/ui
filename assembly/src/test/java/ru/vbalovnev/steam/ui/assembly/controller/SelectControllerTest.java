package ru.vbalovnev.steam.ui.assembly.controller;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.vbalovnev.steam.ui.assembly.repository.RepositoryData;
import ru.vbalovnev.steam.ui.service.DataService;
import ru.vbalovnev.steam.ui.service.GameService;
import ru.vbalovnev.steam.ui.service.model.Game;
import ru.vbalovnev.steam.ui.service.model.GameGenre;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.doAnswer;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class SelectControllerTest {

    @InjectMocks
    private SelectController controller;

    @Mock
    private GameService gameService;

    @Mock
    private RepositoryData repositoryData;


    private MockMvc mockMvc;

    @BeforeMethod
    public void setUp() throws Exception {

        controller = new SelectController();
        MockitoAnnotations.initMocks(this);

        final MappingJackson2HttpMessageConverter messageConverter = new MappingJackson2HttpMessageConverter();

        mockMvc = standaloneSetup(controller)
                .setMessageConverters(messageConverter)
                .build();
    }
    @Test
    public void testGet() throws Exception {

        doAnswer(
            i -> {
                List<Game> list = new ArrayList<>();
                list.add(new Game("id1", "nameOfGame", 1999, "Dev", "Publ"));
                list.add(new Game("id2","nameOfGame1", 2000, "ev", "Publ1"));
                return list;
            }
        ).when(gameService)
            .select(GameGenre.FPS);

        final MockHttpServletRequestBuilder requestBuilder = get("/select")
                .param("query", "FPS");

        this.mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(content().json("[{\"name\":\"nameOfGame\",\"yearOfRelease\":1999,\"developer\":\"Dev\",\"publisher\":\"Publ\"},{\"name\":\"nameOfGame1\",\"yearOfRelease\":2000,\"developer\":\"ev\",\"publisher\":\"Publ1\"}]"));
    }
}
