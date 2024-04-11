package lab.seq.controller;

import org.springframework.http.ResponseEntity;

public interface BaseController {
    String BASE_URL = "/altice";

    default ResponseEntity<Object> ok() {
        return ResponseEntity.ok().build();
    }

    default <V> ResponseEntity<V> ok(V entity) {
        return ResponseEntity.ok(entity);
    }


}
