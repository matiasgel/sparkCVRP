package ar.edu.uoc.hpc.pec4.spark;


import edu.uoc.pec2.Inputs;
import edu.uoc.pec2.InputsManager;
import edu.uoc.pec2.Solution;
import edu.uoc.pec2.Test;
import edu.uoc.pec2.biasedCWS.BiasedRandomCWS;
import edu.uoc.pec2.biasedCWS.ObjectCloner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Job implements Serializable {
    private static final Logger LOG = LoggerFactory.getLogger(Job.class);




    public Job() {

    }


    /**
     * Operación map inicializa y ejecuta el algoritmo par ala solucion al CVRP
     * @param index
     * @return
     */
    public  static Solution map(Integer index) {
        Test test=new Test("Kelly 5",1800);
        Inputs inputs = InputsManager.readInputsK();
        BiasedRandomCWS bs = new BiasedRandomCWS(inputs,test);
        return  bs.randomSolve();

    }

    /**
     * Genera una lista de enteros
     * @param maxIters maximo de iteraciones
     * @return
     */
    public static List<Integer> iterations(int maxIters) {
        List<Integer> list = new ArrayList<>(maxIters);
        for (int i = 0; i < maxIters; i++) {
            list.add(i);
        }
        return list;
    }


    /**
     * Operacion reductora, obtiene la mejor solución
     * @param sol1
     * @param sol2
     * @return solución de menor costo
     */
    public static Solution reduce(Solution sol1, Solution sol2) {
        return sol1.getCosts()<=sol2.getCosts()?sol1.clone():sol2.clone();
    }





}
