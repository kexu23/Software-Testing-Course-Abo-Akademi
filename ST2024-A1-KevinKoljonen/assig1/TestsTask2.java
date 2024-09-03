import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestsTask2 {

    @Test
    public void T1(){
        double[] incomeList = new double[0];
        int[] childAgeList = new int[]{4};

        assertEquals(0, TaxCalculator.computeTax(incomeList, childAgeList));
    }

    @Test
    public void T2(){
        double[] incomeList = new double[]{500, -50};
        int[] childAgeList = new int[0];

        incomeList = new double[]{500, -50};


        assertEquals(-1, TaxCalculator.computeTax(incomeList, childAgeList));
    }

    @Test
    public void T3(){
        double[] incomeList = new double[]{500};
        int[] childAgeList = new int[]{2, 20, 25};

        assertEquals(0, TaxCalculator.computeTax(incomeList, childAgeList));
    }

    @Test
    public void T4(){
        double[] incomeList = new double[0];
        int[] childAgeList = new int[0];

        assertEquals(0, TaxCalculator.computeTax(incomeList, childAgeList));
    }

}