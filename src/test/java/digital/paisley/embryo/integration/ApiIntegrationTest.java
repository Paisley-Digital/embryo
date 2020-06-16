package digital.paisley.embryo.integration;

import digital.paisley.embryo.Application;
import digital.paisley.embryo.TestSupport;
import digital.paisley.embryo.services.DummyService;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.MOCK,classes={ Application.class })
public class ApiIntegrationTest extends TestSupport {

    private MockMvc mockMvc;

    @Autowired
    private FilterChainProxy springSecurityFilterChain;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @MockBean
    private DummyService dummyService;

    private String accessToken;

    @Before
    public void setUp() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext)
                .addFilter(springSecurityFilterChain).build();
        JSONObject tokenByPasswordFlow = getTokenByPasswordFlow();
        accessToken = String.format("Bearer %s",tokenByPasswordFlow.get("access_token").toString());
    }

    @Test
    public void should_return_200_ok_when_get_dummies_by_id() throws Exception {

        when(dummyService.getDummyById(any())).thenReturn(getDummy(0L).getDummy());

        mockMvc.perform(get("/embryo/dummies/0")
                .contentType(MediaType.APPLICATION_JSON)
                .header("Authorization",  accessToken)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void should_return_401_when_get_dummies_by_id() throws Exception {

        when(dummyService.getDummyById(any())).thenReturn(getDummy(0L).getDummy());

        mockMvc.perform(get("/embryo/dummies/0")
                .contentType(MediaType.APPLICATION_JSON)
                .header("Authorization",    "Bearer accessToken"))
                .andExpect(status().isUnauthorized());
    }
}
