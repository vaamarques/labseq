package altice.lab;

import altice.lab.controller.LabSeqController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@AutoConfigureMockMvc
@SpringBootTest
public class LabSeqIntegrationTest {
    @Autowired
    protected MockMvc mockMvc;

    @Test
    void testLabSequenceEndpoint10() throws Exception {
        final String uri = LabSeqController.LAB_SEQ_URL + "/10";
        mockMvc.perform(MockMvcRequestBuilders.get(uri).contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andReturn()
                .getResponse();
    }
    @Test
    void testLabSequenceEndpoint100() throws Exception {
        final String uri = LabSeqController.LAB_SEQ_URL + "/100";
        mockMvc.perform(MockMvcRequestBuilders.get(uri).contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andReturn()
                .getResponse();
    }

    @Test
    void testLabSequenceEndpoint1000() throws Exception {
        final String uri = LabSeqController.LAB_SEQ_URL + "/1000";
        mockMvc.perform(MockMvcRequestBuilders.get(uri).contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andReturn()
                .getResponse();
    }


    @Test
    void testLabSequenceEndpoint10000() throws Exception {
        final String uri = LabSeqController.LAB_SEQ_URL + "/10000";
        mockMvc.perform(MockMvcRequestBuilders.get(uri).contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andReturn()
                .getResponse();
    }

    @Test
    void testLabSequenceEndpoint100000() throws Exception {
        final String uri = LabSeqController.LAB_SEQ_URL + "/100000";
        mockMvc.perform(MockMvcRequestBuilders.get(uri).contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andReturn()
                .getResponse();
    }

    @Test
    void testLabSequenceEndpoint1000000() throws Exception {
        final String uri = LabSeqController.LAB_SEQ_URL + "/1000000";
        mockMvc.perform(MockMvcRequestBuilders.get(uri).contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andReturn()
                .getResponse();
    }

    @Test
    void testLabSequenceEndpoint10000000() throws Exception {
        final String uri = LabSeqController.LAB_SEQ_URL + "/10000000";
        mockMvc.perform(MockMvcRequestBuilders.get(uri).contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andReturn()
                .getResponse();
    }
}
