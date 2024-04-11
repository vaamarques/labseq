package lab.seq.aop;

import org.aspectj.lang.annotation.Pointcut;

public class CommonAspect {

    @Pointcut("@annotation(lab.seq.aop.TrackTime)")
    public void pointCutWithAnnotation(){

    }
}
