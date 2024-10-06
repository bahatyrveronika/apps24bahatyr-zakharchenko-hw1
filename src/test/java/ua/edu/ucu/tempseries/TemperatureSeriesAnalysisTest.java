package ua.edu.ucu.tempseries;

import java.util.InputMismatchException;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

import ua.edu.ucu.apps.tempseries.TempSummaryStatistics;
import ua.edu.ucu.apps.tempseries.TemperatureSeriesAnalysis;

public class TemperatureSeriesAnalysisTest {

    @Test
    public void test() {
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -1.0;

        double actualResult = seriesAnalysis.average();
        assertEquals(expResult, actualResult, 0.00001);
    }

   @Test
   public void testAverageWithOneElementArray() {
       // setup input data and expected result
       double[] temperatureSeries = {-1.0};
       TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
       double expResult = -1.0;

       // call tested method
       double actualResult = seriesAnalysis.average();

       // compare expected result with actual result
       assertEquals(expResult, actualResult, 0.00001);
   }

   @Test(expected = IllegalArgumentException.class)
   public void testAverageWithEmptyArray() {
       double[] temperatureSeries = {};
       TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

       // expect exception here
       seriesAnalysis.average();
   }

   @Test
   public void testAverage() {
       double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
       TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
       double expResult = 1.0;

       double actualResult = seriesAnalysis.average();

       assertEquals(expResult, actualResult, 0.00001);
   }

   @Test
    public void testMinWithOneElementArray() {
        double[] temperatureSeries = {3.5};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 3.5;
        double actualResult = seriesAnalysis.min();
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testMinWithMultipleElementsArray() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -5.0;
        double actualResult = seriesAnalysis.min();
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMinWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        seriesAnalysis.min();
    }
    
    @Test
    public void testMaxWithOneElementArray() {
        double[] temperatureSeries = {7.5};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 7.5;
        double actualResult = seriesAnalysis.max();
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testMaxWithMultipleElementsArray() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 10.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 10.0;
        double actualResult = seriesAnalysis.max();
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMaxWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        seriesAnalysis.max();
    }


    @Test
    public void testFindTempClosestToZeroWithPositiveAndNegative() {
        double[] temperatureSeries = {-1.0, 2.0, 3.0, -0.5};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -0.5;
        double actualResult = seriesAnalysis.findTempClosestToZero();
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testFindTempClosestToZeroWithEqualDistance() {
        double[] temperatureSeries = {-1.0, 1.0, 3.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 1.0;
        double actualResult = seriesAnalysis.findTempClosestToZero();
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testFindTempClosestToZeroWithOnlyPositiveValues() {
        double[] temperatureSeries = {3.0, 1.0, 0.5};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 0.5;
        double actualResult = seriesAnalysis.findTempClosestToZero();
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testFindTempClosestToZeroWithOnlyNegativeValues() {
        double[] temperatureSeries = {-3.0, -1.0, -0.5};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -0.5;

        double actualResult = seriesAnalysis.findTempClosestToZero();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindTempClosestToZeroWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        seriesAnalysis.findTempClosestToZero();
    }

    @Test
    public void testFindTempClosestToValue() {
        double[] temperatureSeries = {-1.0, 2.0, 3.0, -0.5};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double tempValue = 1.0;
        double expResult = 2.0;
        double actualResult = seriesAnalysis.findTempClosestToValue(tempValue);
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testFindTempClosestToValueWithEqualDistance() {
        double[] temperatureSeries = {-2.0, 2.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double tempValue = 0.0;
        double expResult = 2.0;
        double actualResult = seriesAnalysis.findTempClosestToValue(tempValue);
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testFindTempClosestToValueWithOnlyPositiveValues() {
        double[] temperatureSeries = {3.0, 1.0, 0.5};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double tempValue = 0.8;
        double expResult = 1.0;
        double actualResult = seriesAnalysis.findTempClosestToValue(tempValue);
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testFindTempClosestToValueWithOnlyNegativeValues() {
        double[] temperatureSeries = {-3.0, -1.0, -0.5};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double tempValue = -0.8;
        double expResult = -1.0;
        double actualResult = seriesAnalysis.findTempClosestToValue(tempValue);
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testFindTempClosestToValueSingleElement() {
        double[] temperatureSeries = {5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double tempValue = 2.0;
        double expResult = 5.0;  // only one element, so it should return this

        double actualResult = seriesAnalysis.findTempClosestToValue(tempValue);

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindTempClosestToValueWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        seriesAnalysis.findTempClosestToValue(0.0);
    }

    @Test
    public void testFindTempsLessThen() {
        double[] temperatureSeries = {-3.0, 5.0, 1.0, 0.0, -1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        double[] expResult = {-3.0, 0.0, -1.0};
        double[] actualResult = seriesAnalysis.findTempsLessThen(1.0);

        assertArrayEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testFindTempsGreaterThen() {
        double[] temperatureSeries = {-3.0, 5.0, 1.0, 0.0, -1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        double[] expResult = {5.0, 1.0}; // temps greater than or equal to 1.0
        double[] actualResult = seriesAnalysis.findTempsGreaterThen(1.0);

        assertArrayEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testFindTempsInRange() {
        double[] temperatureSeries = {-3.0, 5.0, 1.0, 0.0, -1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = {1.0, 0.0, -1.0}; // temps between -1.0 and 1.0
        double[] actualResult = seriesAnalysis.findTempsInRange(-1.0, 1.0);
        assertArrayEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testAddTemps() {
        double[] temperatureSeries = {-3.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        int newSize = seriesAnalysis.addTemps(1.0, -2.0, 0.0);
        int expResult = 5;
        // int actualResult = seriesAnalysis.getTemperatures();
        assertEquals(5, newSize);
        assertEquals(expResult, newSize, 0.00001);
    }

    @Test(expected = InputMismatchException.class)
    public void testAddTempsWithInvalidTemperature() {
        double[] temperatureSeries = {0.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        seriesAnalysis.addTemps(-273.5);
    }

    @Test
    public void testReset() {
        double[] initialTemps = {15.0, -5.0, 10.5};
        TemperatureSeriesAnalysis analysis = new TemperatureSeriesAnalysis(initialTemps);
        assertEquals(3, analysis.getSize());
        assertArrayEquals(initialTemps, analysis.getTemperatures(), 0.0001);
        analysis.reset();
        assertEquals(10, analysis.getTemperatures().length);
        for (double temp : analysis.getTemperatures()) {
            assertEquals(0.0, temp, 0.0001);
        }
        assertEquals(0, analysis.getSize());
    }

    @Test
    public void testSortTempsWithUnsortedArray() {
        double[] temps = {3.5, -1.0, 2.0, -4.0, 0.0};
        TemperatureSeriesAnalysis analysis = new TemperatureSeriesAnalysis(temps);
        double[] sortedTemps = analysis.sortTemps();        
        double[] expected = {-4.0, -1.0, 0.0, 2.0, 3.5};
        assertArrayEquals(expected, sortedTemps, 0.0001);
    }
    @Test
    public void testSortTempsWithEmptyArray() {
        TemperatureSeriesAnalysis analysis = new TemperatureSeriesAnalysis(new double[] {});
        double[] sortedTemps = analysis.sortTemps();
        assertArrayEquals(new double[] {}, sortedTemps, 0.0001);
    }

    @Test
    public void testSortTempsWithSingleElement() {
        double[] temps = {1.0};
        TemperatureSeriesAnalysis analysis = new TemperatureSeriesAnalysis(temps);
        double[] sortedTemps = analysis.sortTemps();
        assertArrayEquals(new double[] {1.0}, sortedTemps, 0.0001);
    }

    @Test
    public void testSummaryStatisticsNonEmptySeries() {
        double[] temps = {3.0, -5.0, 1.0, 7.0, -3.0};
        TemperatureSeriesAnalysis analysis = new TemperatureSeriesAnalysis(temps);
        TempSummaryStatistics stats = analysis.summaryStatistics();

        assertEquals(0.6, stats.getAvgTemp(), 0.0001);
        assertEquals(4.27083, stats.getDevTemp(), 0.0001);
        assertEquals(-5.0, stats.getMinTemp(), 0.0001);
        assertEquals(7.0, stats.getMaxTemp(), 0.0001);
    }

    @Test
    public void testDeviationWithData() {
        double[] temps = {1.0, 2.0, 3.0, 4.0, 5.0};
        TemperatureSeriesAnalysis analysis = new TemperatureSeriesAnalysis(temps);
        double expected = Math.sqrt(((1-3)*(1-3) + (2-3)*(2-3) + (3-3)*(3-3) + (4-3)*(4-3) + (5-3)*(5-3)) / 5.0);
        double actual = analysis.deviation();
        assertEquals(expected, actual, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDeviationWithEmptyArray() {
        TemperatureSeriesAnalysis analysis = new TemperatureSeriesAnalysis();
        analysis.deviation();
    }
}
