package ec.edu.ups.ppw63.demo63.services;

import io.jaegertracing.Configuration;
import io.opentracing.Tracer;
import io.opentracing.util.GlobalTracer;

public class JaegerConfig {
	public static void initTracer() {
        Configuration config = new Configuration("jaegertracing")
        		.withSampler(Configuration.SamplerConfiguration.fromEnv().withType("const").withParam(1))
        		.withReporter(Configuration.ReporterConfiguration.fromEnv().withLogSpans(true));
        
        Tracer tracer = config.getTracer();
        
        System.out.println(tracer);
        
        GlobalTracer.registerIfAbsent(tracer);
    }
}
