import org.knowm.xchart.*;
import org.knowm.xchart.style.Styler;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        ArrayList<Integer> inputData = new ArrayList<Integer>();
        ArrayList<Integer> sortedData = new ArrayList<Integer>();
        ArrayList<Integer> sortedField = new ArrayList<Integer>();
        ArrayList<Integer> reverseSortedField = new ArrayList<Integer>();
        int tries = 10;
        int[] inputSizes = {512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 131072, 251281};
        Scanner scanner = new Scanner(new File("src/TrafficFlowDataset.csv"));
        String line;
        String[] row;
        String headerLine = scanner.nextLine();
        while (scanner.hasNextLine() && (line = scanner.nextLine()) != null) {
            row = line.split(",");
            inputData.add(Integer.parseInt(row[7].trim()));
        }

        // Creating a sorted input data for experiments
        int[] inputData1 = new int[inputData.size()];
        for (int i = 0; i < inputData.size(); i++){
            inputData1[i] = inputData.get(i);
        }
        MergeSort ms0 = new MergeSort(inputData1);
        ms0.mergeSortArray();
        sortedField = ms0.getSortedArray();

        // Creating a reversely sorted input data for experiments
        for (int i = sortedField.size()-1; i >= 0; i--){
            reverseSortedField.add(sortedField.get(i));
        }

        // All experiment inputs
        ArrayList<ArrayList<Integer>> inputs = new ArrayList<ArrayList<Integer>>();
        inputs.add(inputData);
        inputs.add(sortedField);
        inputs.add(reverseSortedField);



        // Merge results
        double[] randomResultsOfMerge = new double[10];
        double[] sortedResultsOfMerge = new double[10];
        double[] reverseSortedResultsOfMerge = new double[10];
        double[][] mergeResults = new double[][]{randomResultsOfMerge,sortedResultsOfMerge, reverseSortedResultsOfMerge};

        //Merge Experiments
        for (int k = 0; k < inputs.size(); k++){
            for (int i = 0; i < 10; i++){
                int[] sizeField1 = new int[inputSizes[i]];
                for (int l = 0; l < inputSizes[i]; l ++){
                    sizeField1[l] = inputs.get(k).get(l);
                }
                int totalTimeForMerge = 0;
                for (int j = 0; j < tries; j++){
                    MergeSort ms = new MergeSort(sizeField1);
                    long start2 = System.currentTimeMillis();
                    ms.mergeSortArray();
                    long end2 = System.currentTimeMillis();
                    totalTimeForMerge += end2 - start2;
                }
                mergeResults[k][i] = totalTimeForMerge /tries;
            }
        }
        System.out.println("MERGE RESULTS:");
        for (double[] ar: mergeResults){
            for (double d:ar){
                System.out.print(d + ",");
            }
            System.out.println();
        }

        //Insertion results
        double[] randomResultsOfInsertion = new double[10];
        double[] sortedResultsOfInsertion = new double[10];
        double[] reverseSortedResultsOfInsertion = new double[10];
        double[][] insertionResults = new double[][]{randomResultsOfInsertion,sortedResultsOfInsertion, reverseSortedResultsOfInsertion};

        //Insertion Experiments
        for (int k = 0; k < inputs.size() ; k++){
            for (int i = 0; i < 10; i++){
                int[] sizeField1 = new int[inputSizes[i]];
                for (int l = 0; l < inputSizes[i]; l ++){
                    sizeField1[l] = inputs.get(k).get(l);
                }
                int totalTimeForInsertion = 0;
                for (int j = 0; j < tries; j++){
                    InsertionSort is = new InsertionSort(sizeField1);
                    long start2 = System.currentTimeMillis();
                    is.insertionSortArray();
                    long end2 = System.currentTimeMillis();
                    totalTimeForInsertion += end2 - start2;
                }
                double d = totalTimeForInsertion /tries;
                insertionResults[k][i] = d;
            }
        }
        System.out.println("INSERTION RESULTS:");
        for (double[] ar: insertionResults){
            for (double d:ar){
                System.out.print(d + ",");
            }
            System.out.println();
        }

        //PigeonHole results
        double[] randomResultsOfPigeonHole = new double[10];
        double[] sortedResultsOfPigeonHole = new double[10];
        double[] reverseSortedResultsOfPigeonHole = new double[10];
        double[][] pigeonHoleResults = new double[][]{randomResultsOfPigeonHole,sortedResultsOfPigeonHole, reverseSortedResultsOfPigeonHole};

        //PigeonHole Experiments
        for (int k = 0; k < inputs.size() ; k++){
            for (int i = 0; i < 10; i++){
                int[] sizeField1 = new int[inputSizes[i]];
                for (int l = 0; l < inputSizes[i]; l ++){
                    sizeField1[l] = inputs.get(k).get(l);
                }
                int totalTimeForPigeonHole = 0;
                for (int j = 0; j < tries; j++){
                    pigeonHoleSort ph = new pigeonHoleSort(sizeField1);
                    long start2 = System.currentTimeMillis();
                    ph.pigeonHoleSortArray();
                    long end2 = System.currentTimeMillis();
                    totalTimeForPigeonHole += end2 - start2;
                }
                double d = totalTimeForPigeonHole /tries;
                pigeonHoleResults[k][i] = d;
            }
        }
        System.out.println("PigeonHole RESULTS:");
        for (double[] ar: pigeonHoleResults){
            for (double d:ar){
                System.out.print(d + ",");
            }
            System.out.println();
        }

        //Counting results
        double[] randomResultsOfCounting = new double[10];
        double[] sortedResultsOfCounting = new double[10];
        double[] reverseSortedResultsOfCounting = new double[10];
        double[][] countingResults = new double[][]{randomResultsOfCounting,sortedResultsOfCounting, reverseSortedResultsOfCounting};

        //PigeonHole Experiments
        for (int k = 0; k < inputs.size() ; k++){
            for (int i = 0; i < 10; i++){
                int[] sizeField1 = new int[inputSizes[i]];
                for (int l = 0; l < inputSizes[i]; l ++){
                    sizeField1[l] = inputs.get(k).get(l);
                }
                int totalTimeForCounting = 0;
                for (int j = 0; j < tries; j++){
                    CountingSort cs = new CountingSort(sizeField1);
                    long start2 = System.currentTimeMillis();
                    cs.countingSortArray();
                    long end2 = System.currentTimeMillis();
                    totalTimeForCounting += end2 - start2;
                }
                double d = totalTimeForCounting /tries;
                countingResults[k][i] = d;
            }
        }
        System.out.println("Counting RESULTS:");
        for (double[] ar: countingResults){
            for (double d:ar){
                System.out.print(d + ",");
            }
            System.out.println();
        }



        //chart
        String[] titles = new String[]{"Test on Random Data", "Test on Sorted Data", "Test on Reverse Sorted Data"};
        for (int i = 0; i < 3 ; i++){
            showAndSaveChart(titles[i], inputSizes, insertionResults,mergeResults, pigeonHoleResults,countingResults,i);
        }
    }
    public static void showAndSaveChart(String title, int[] xAxis, double[][] ir ,double[][] mr, double[][] phr,double[][] cr, int experimentNO) throws IOException {
        // Create Chart
        XYChart chart = new XYChartBuilder().width(800).height(600).title(title)
                .yAxisTitle("Time in Milliseconds").xAxisTitle("Input Size").build();

        // Convert x axis to double[]
        double[] doubleX = Arrays.stream(xAxis).asDoubleStream().toArray();

        // Customize Chart
        chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideNE);
        chart.getStyler().setDefaultSeriesRenderStyle(XYSeries.XYSeriesRenderStyle.Line);

        // Add a plot for a sorting algorithm
        chart.addSeries("insertion ", doubleX, ir[experimentNO]);
        chart.addSeries("merge", doubleX, mr[experimentNO]);
        chart.addSeries("pigeonhole", doubleX, phr[experimentNO]);
        chart.addSeries("counting", doubleX, cr[experimentNO]);

        // Save the chart as PNG
        BitmapEncoder.saveBitmap(chart, title + ".png", BitmapEncoder.BitmapFormat.PNG);

        // Show the chart
        new SwingWrapper(chart).displayChart();
    }
}
