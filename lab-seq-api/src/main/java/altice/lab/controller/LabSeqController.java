package altice.lab.controller;

import altice.lab.service.LabSequenceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.math.BigInteger;

@Slf4j
@RestController
@RequestMapping(LabSeqController.LAB_SEQ_URL)
@RequiredArgsConstructor
@Tag(name = "Lab Sequence API")
public class LabSeqController implements BaseController {
    public static final String LAB_SEQ_URL = BaseController.BASE_URL + "/labseq";

    public final LabSequenceService service;

    @Operation(summary = "Get Lab Sequence")
    @GetMapping(value = "/{n}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> getLabSeq(@Valid @NotNull @PathVariable("n") final Integer n){
        log.info("Received a Get Lab Sequence request");

        final Integer nFinal = service.calculateLabSeq(n);

        log.info("Sending a Get Lab Sequence response");

        return ok(nFinal);
    }


}
