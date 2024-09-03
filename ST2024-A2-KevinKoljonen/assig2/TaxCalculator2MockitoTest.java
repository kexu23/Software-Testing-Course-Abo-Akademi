package assigs.assig2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;


@ExtendWith(MockitoExtension.class)
class MockitoTests {

        @Mock
        Exemption exemptionMock;

        @InjectMocks
        TaxCalculator2 calculator;


    @Test
    public void MockitoTest1() {

        when(exemptionMock.getExemptionValue(1)).thenReturn(1.0);
        when(exemptionMock.getExemptionValue(2)).thenReturn(2.0);

        double[] income = {40000};
        int[] ages = {10, 12, 18, 20}; //two minor children
        double expectedOutput = 7997.0; //40 000 * 0.2 - 1 - 2 = 8 000 - 3 = 7997
        double actual = calculator.computeTax(income, ages);

        assertEquals(expectedOutput, actual);

        InOrder inOrder = inOrder(exemptionMock);

        inOrder.verify(exemptionMock, calls(1)).getExemptionValue(1);
        inOrder.verify(exemptionMock, calls(1)).getExemptionValue(2);


    }

    @Test
    public void MockitoTest2() {

        when(exemptionMock.getExemptionValue(1)).thenReturn(1.0);
        when(exemptionMock.getExemptionValue(2)).thenReturn(2.0);
        when(exemptionMock.getExemptionValue(3)).thenReturn(3.0);
        when(exemptionMock.getExemptionValue(4)).thenReturn(4.0);

        double[] income = {40000};
        int[] ages = {7, 11, 13, 15, 19}; //4 minor children
        double expectedOutput = 7990.0; //40 000 * 0.2 - 1 - 2 - 3 - 4 = 8 000 - 10 = 7990
        double actual = calculator.computeTax(income, ages);

        assertEquals(expectedOutput, actual);

        InOrder inOrder = inOrder(exemptionMock);

        inOrder.verify(exemptionMock, calls(1)).getExemptionValue(1);
        inOrder.verify(exemptionMock, calls(1)).getExemptionValue(2);
        inOrder.verify(exemptionMock, calls(1)).getExemptionValue(3);
        inOrder.verify(exemptionMock, calls(1)).getExemptionValue(4);


    }

    @Test
    public void MockitoTest3() {

        //when(exemptionMock.getExemptionValue(0)).thenReturn(0.0);

        double[] income = {40000};
        int[] ages = {19, 22, 24}; //no minor children
        double expectedOutput = 8000.0; //40 000 * 0.2 = 8 000
        double actual = calculator.computeTax(income, ages);

        assertEquals(expectedOutput, actual);

        InOrder inOrder = inOrder(exemptionMock);

        //inOrder.verify(exemptionMock, calls(1)).getExemptionValue(1);
        inOrder.verifyNoMoreInteractions();


    }
}