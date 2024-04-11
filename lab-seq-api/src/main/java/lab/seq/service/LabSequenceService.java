package lab.seq.service;

import lab.seq.aop.TrackTime;
import lab.seq.exception.InvalidNumberException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class LabSequenceService {
    private final Map<BigInteger, BigInteger> cachMap = new HashMap<>();

    @TrackTime
    private BigInteger getLabSeq(final BigInteger n) {

        if (n.intValue() == 0) return BigInteger.ZERO;
        if (n.intValue() == 1) return BigInteger.ONE;
        if (n.intValue() == 2) return BigInteger.ZERO;
        if (n.intValue() == 3) return BigInteger.ONE;

        final BigInteger valueOnMapN = cachMap.get(n);
        final BigInteger valueOnMapN3 = cachMap.get(BigInteger.valueOf(n.intValue() - 3));
        final BigInteger valueOnMapN4 = cachMap.get(BigInteger.valueOf(n.intValue() - 4));


        if (valueOnMapN == null) {

            BigInteger resultN3 = valueOnMapN3;
            BigInteger resultN4 = valueOnMapN4;

            if (valueOnMapN3 == null) {
                resultN3 = getChildLabSeq(BigInteger.valueOf(n.intValue() - 3));
                cachMap.putIfAbsent(BigInteger.valueOf(n.intValue() - 3), resultN3);
            }

            if (valueOnMapN4 == null) {
                resultN4 = getChildLabSeq(BigInteger.valueOf(n.intValue() - 4));
                cachMap.putIfAbsent(BigInteger.valueOf(n.intValue() - 4), resultN4);
            }

            BigInteger result = resultN3.add(resultN4);
            cachMap.putIfAbsent(n, result);
            return result;
        }

        return valueOnMapN;

    }

    private BigInteger getChildLabSeq(final BigInteger n) {

        if (n.intValue() == 0) return BigInteger.ZERO;
        if (n.intValue() == 1) return BigInteger.ONE;
        if (n.intValue() == 2) return BigInteger.ZERO;
        if (n.intValue() == 3) return BigInteger.ONE;

        BigInteger seqN0 = BigInteger.ZERO;
        BigInteger seqN1 = BigInteger.ONE;
        BigInteger seqN2 = BigInteger.ZERO;
        BigInteger seqN3 = BigInteger.ONE;
        BigInteger result = BigInteger.ZERO;

        for (int i = 4; i <= n.intValue(); i++) {
            result = seqN0.add(seqN1);
            seqN0 = seqN1;
            seqN1 = seqN2;
            seqN2 = seqN3;
            seqN3 = result;
        }
        return result;
    }


    public BigInteger calculateLabSeq(final BigInteger n) {

        if (n.intValue() < 0) {
            throw new InvalidNumberException("Number must be positive");
        }

        final StopWatch watch = new StopWatch();
        watch.start("Start calculating Lab Sequence");

        final BigInteger labSeq = getLabSeq(n);

        watch.stop();
        log.info("Lab Sequence take {} ms to execute ", watch.getTotalTimeMillis());

        return labSeq;
    }
}
