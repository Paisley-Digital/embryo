package digital.paisley.embryo.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import digital.paisley.embryo.services.DummyService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

class ApiControllerTest {

    @Mock
    private ObjectMapper mockObjectMapper;
    @Mock
    private HttpServletRequest mockRequest;
    @Mock
    private DummyService mockDummyService;

    private ApiController apiControllerUnderTest;

    @BeforeEach
    void setUp() {
        initMocks(this);
        apiControllerUnderTest = new ApiController(mockObjectMapper, mockRequest, mockDummyService);
    }

    @Test
    void testGetObjectMapper() {
        // Setup

        // Run the test
        final Optional<ObjectMapper> result = apiControllerUnderTest.getObjectMapper();

        // Verify the results
    }

    @Test
    void testGetRequest() {
        // Setup

        // Run the test
        final Optional<HttpServletRequest> result = apiControllerUnderTest.getRequest();

        // Verify the results
    }

    @Test
    void testGetDummyById() {
        // Setup
        when(mockDummyService.getDummyById(0L)).thenReturn("result");

        // Run the test
        final ResponseEntity<?> result = apiControllerUnderTest.getDummyById("auth", 0L);

        // Verify the results
    }
}
