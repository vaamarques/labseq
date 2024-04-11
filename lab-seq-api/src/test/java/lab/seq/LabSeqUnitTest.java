package lab.seq;

import lab.seq.service.LabSequenceService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StopWatch;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigInteger;

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
    void testLabSequence1() {
        Assertions.assertEquals(service.calculateLabSeq(BigInteger.valueOf(1)), BigInteger.valueOf(1));
    }
    @Test
    void testLabSequence10() {
        Assertions.assertEquals(service.calculateLabSeq(BigInteger.valueOf(10)), BigInteger.valueOf(3));
    }

    @Test
    void testLabSequence10000() {
        final StopWatch watch = new StopWatch();
        watch.start("Testing 10000");
        standardOut.println("Testing 10000");
        standardOut.println(service.calculateLabSeq(BigInteger.valueOf(10000)));
        watch.stop();
        standardOut.println(String.format("Takes %s s", watch.getTotalTimeSeconds()));
    }

    @Test
    void testLabSequence100000() {
        final StopWatch watch = new StopWatch();
        watch.start("Testing 100000");
        standardOut.println("Testing 100000");
        standardOut.println(service.calculateLabSeq(BigInteger.valueOf(100000)));
        watch.stop();
        standardOut.printf("Takes %s s%n", watch.getTotalTimeSeconds());
    }

    @Test
    void testLabSequence_Print() {
        standardOut.println(service.calculateLabSeq(BigInteger.valueOf(0)));
        standardOut.println(service.calculateLabSeq(BigInteger.valueOf(1)));
        standardOut.println(service.calculateLabSeq(BigInteger.valueOf(2)));
        standardOut.println(service.calculateLabSeq(BigInteger.valueOf(3)));
        standardOut.println(service.calculateLabSeq(BigInteger.valueOf(4)));
        standardOut.println(service.calculateLabSeq(BigInteger.valueOf(5)));
        standardOut.println(service.calculateLabSeq(BigInteger.valueOf(6)));
        standardOut.println(service.calculateLabSeq(BigInteger.valueOf(7)));
        standardOut.println(service.calculateLabSeq(BigInteger.valueOf(8)));
        standardOut.println(service.calculateLabSeq(BigInteger.valueOf(9)));
        standardOut.println(service.calculateLabSeq(BigInteger.valueOf(10)));

    }

}
