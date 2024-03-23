package altice.lab.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.Inet6Address;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class LabSequenceService {
    private Map<Integer, Integer> map = new HashMap<>();
    @PostConstruct
    private void fillCache(){
        for(int i = 0; i< 10000; i++){
            getLabSeq(i, map);
        }
    }



    public Integer getLabSeq(final Integer n, final Map<Integer,Integer> map) {
        if(n ==0) return 0;
        if(n ==1) return 1;
        if(n ==2) return 0;
        if(n ==3) return 1;
        final Integer valueOnMap = map.get(n);

        final Integer valueOnMap1 = map.get(n - 3);
        final Integer valueOnMap2 = map.get(n - 4);


        if (valueOnMap == null) {
            int result1;
            int result2;
            if(valueOnMap1 == null){
                result1 = getLabSeq(n - 3, map);
                map.put(n - 3, result1);
            }else{
                result1 = valueOnMap1;
            }

            if(valueOnMap2 == null){
                result2 = getLabSeq(n - 4, map);
                map.put(n - 4, result2);
            }else{
                result2 = valueOnMap2;
            }

            int result = result1 + result2;
            map.putIfAbsent(n, result);
            return result;
        }

        return valueOnMap;

    }

    public Integer calculateLabSeq(final Integer n) {
        StopWatch watch = new StopWatch();
        watch.start("Start");

        Integer labSeq = getLabSeq(n, map);

        watch.stop();
        log.info("Lab Sequence take {} ms to execute ", watch.getTotalTimeMillis());

        return labSeq;
    }

}
