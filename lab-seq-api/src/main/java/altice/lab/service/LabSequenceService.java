package altice.lab.service;

import altice.lab.exception.InvalidNumberException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;
import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class LabSequenceService {
    private final Map<Integer, Integer> cachMap = new HashMap<>();

    @PostConstruct
    private void fillCache() {
        for (int i = 0; i < 1000000; i++) {
            getLabSeq(i);
        }
    }


    private Integer getLabSeq(final Integer n) {

        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 0;
        if (n == 3) return 1;

        final Integer valueOnMapN = cachMap.get(n);
        final Integer valueOnMapN3 = cachMap.get(n - 3);
        final Integer valueOnMapN4 = cachMap.get(n - 4);


        if (valueOnMapN == null) {

            Integer resultN3 = valueOnMapN3;
            Integer resultN4 = valueOnMapN4;

            if (valueOnMapN3 == null) {
                resultN3 = getLabSeq(n - 3);
                cachMap.putIfAbsent(n - 3, resultN3);
            }

            if (valueOnMapN4 == null) {
                resultN4 = getLabSeq(n - 4);
                cachMap.putIfAbsent(n - 4, resultN4);
            }

            int result = resultN3 + resultN4;
            cachMap.putIfAbsent(n, result);
            return result;
        }

        return valueOnMapN;

    }

    public Integer calculateLabSeq(final Integer n) {

        if (n < 0) {
            throw new InvalidNumberException("Number must be positive");
        }

        final StopWatch watch = new StopWatch();
        watch.start("Start calculating Lab Sequence");

        final Integer labSeq = getLabSeq(n);

        watch.stop();
        log.info("Lab Sequence take {} ms to execute ", watch.getTotalTimeMillis());

        return labSeq;
    }
}
