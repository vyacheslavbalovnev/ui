package ru.vbalovnev.steam.ui.assembly.controller;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.vbalovnev.steam.ui.service.DataService;

import static org.mockito.Mockito.doAnswer;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class GreetingControllerTest {

    @InjectMocks
    private GreetingController controller;

    @Mock
    private DataService dataService;

    private MockMvc mockMvc;

    @BeforeMethod
    public void setUp() throws Exception {

        controller = new GreetingController();
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
              return "test_data";
            }
        ).when(dataService)
            .getData(
        );

        final MockHttpServletRequestBuilder requestBuilder = get("/greeting")
            .param("name", "everybody");

        this.mockMvc.perform(requestBuilder)
            .andExpect(status().isOk())
            .andExpect(content().contentType("application/json;charset=UTF-8"))
            .andExpect(content().json("{\"id\":1,\"content\":\"Hello, everybody!\",\"data\":\"test_data\"}"));
    }
}
