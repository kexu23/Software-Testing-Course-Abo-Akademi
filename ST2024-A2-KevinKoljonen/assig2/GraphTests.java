package assigs.assig2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GraphTests {


    @Test
    public void t1(){
        TaxCalculator2 taxCalculator2 = new TaxCalculator2();
        double[] incomeList = new double[0];
        int[] childAgeList = new int[0];

        Assertions.assertEquals(0, taxCalculator2.computeTax(incomeList, childAgeList));
    }

    @Test
    public void t2(){
        TaxCalculator2 taxCalculator2 = new TaxCalculator2();
        double[] incomeList = new double[0];
        int[] childAgeList = new int[]{12};

        Assertions.assertEquals(0, taxCalculator2.computeTax(incomeList, childAgeList));
    }
}
