package org.mazhuang.groovyoomdemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scripting.ScriptSource;
import org.springframework.scripting.groovy.GroovyScriptEvaluator;
import org.springframework.scripting.support.StaticScriptSource;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author mazhuang
 */
@SpringBootApplication
public class GroovyOomDemoApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(GroovyOomDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        GroovyScriptEvaluator evaluator = new GroovyScriptEvaluator();

        ScriptSource scriptSource = new StaticScriptSource("a == 3");
        Map<String, Object> params = new HashMap<>(0);
        Random rand = new Random();

        while (true) {
            Integer a = rand.nextInt(10);
            params.put("a", a);
            Object result = evaluator.evaluate(scriptSource, params);
            System.out.printf("a = %d, result is %s%n", a, result);
        }
    }
}
