package ar.edu.uoc.hpc.pec4;


import ar.edu.uoc.hpc.pec4.spark.SparkRun;

public class Main {
    public static void main(String... argv) throws Exception {
        SparkRun spark = new SparkRun("uocHpcPec4");
        spark.init();
        spark.run(0);
        spark.stop();

    }


}
