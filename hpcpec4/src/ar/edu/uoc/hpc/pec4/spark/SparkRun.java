package ar.edu.uoc.hpc.pec4.spark;

import edu.uoc.pec2.ElapsedTime;
import edu.uoc.pec2.Solution;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;


public final class SparkRun {
    private static final Logger LOG = LoggerFactory.getLogger(SparkRun.class);

    private SparkConf config;
    private JavaSparkContext sc;

    public SparkRun(String appName) {
        LOG.info("Starting {} on ");
        config = new SparkConf().setAppName(appName);
    }


    public void init() {
        sc = new JavaSparkContext(config);
    }


    public void stop() {
        sc.close();
    }

    /**
     *ejecuta el envio el trabajo de en spark
     * @param iters nro de iteraciones a ejecutar
     * @return mejor solucion
     */
    public Solution run(Integer iters) {
        long start = ElapsedTime.systemTime();
        LOG.info("Parallelism: {}", sc.defaultParallelism());
        List<Integer> jobs=Job.iterations(iters);
        LOG.info("inicio de paralelizacion");
        JavaRDD<Integer> dataSet = sc.parallelize(jobs);
        Solution sol=dataSet.map(Job::map).reduce(Job::reduce);
        LOG.info("MEJOR RUTA ALCANZADA: {} ",sol.toString());
        Double elapsed = ElapsedTime.calcElapsed(start, ElapsedTime.systemTime());
        LOG.info("el tiempo del algoritmoes de:{}",elapsed);
        return sol;
    }
}
