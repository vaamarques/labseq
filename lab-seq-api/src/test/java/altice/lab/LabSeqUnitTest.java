package altice.lab;

import altice.lab.service.LabSequenceService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@AutoConfigureMockMvc
@SpringBootTest
public class LabSeqUnitTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @Autowired
    private LabSequenceService service;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void testLabSequenceEndpoint10() {
        Assertions.assertEquals(service.calculateLabSeq(1), 1);
    }
    @Test
    void testLabSequenceEndpoint100() {
        Assertions.assertEquals(service.calculateLabSeq(10), 3);
    }

    @Test
    void testLabSequenceEndpoint_Print() {
        standardOut.println(service.calculateLabSeq(0));
        standardOut.println(service.calculateLabSeq(1));
        standardOut.println(service.calculateLabSeq(2));
        standardOut.println(service.calculateLabSeq(3));
        standardOut.println(service.calculateLabSeq(4));
        standardOut.println(service.calculateLabSeq(5));
        standardOut.println(service.calculateLabSeq(6));
        standardOut.println(service.calculateLabSeq(7));
        standardOut.println(service.calculateLabSeq(8));
        standardOut.println(service.calculateLabSeq(9));
        standardOut.println(service.calculateLabSeq(10));
    }

}
