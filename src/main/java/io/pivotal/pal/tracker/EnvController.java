package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EnvController {

    private String a;
    private String b;
    private String c;
    private String d;
    private Map<String, String> myMap;

    public EnvController( @Value("${PORT:NOT SET}") String PORT,
                          @Value("${MEMORY_LIMIT:NOT SET}")       String MEMORY_LIMIT,
                          @Value("${CF_INSTANCE_INDEX:NOT SET}")       String CF_INSTANCE_INDEX,
                          @Value("${CF_INSTANCE_ADDR:NOT SET}")       String CF_INSTANCE_ADDR) {
        a = PORT;
        b = MEMORY_LIMIT;
        c = CF_INSTANCE_INDEX;
        d = CF_INSTANCE_ADDR;
        myMap = new HashMap<>();
        myMap.put("PORT", a);
        myMap.put("MEMORY_LIMIT",b);
        myMap.put("CF_INSTANCE_INDEX",c);
        myMap.put("CF_INSTANCE_ADDR",d);
    }

    @GetMapping("/env")
    public Map getEnv(){
        return myMap;
    }
}
