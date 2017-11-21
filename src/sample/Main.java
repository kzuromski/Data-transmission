package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.LinkedList;

public class Main extends Application
{

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        int fi = 12;
        int fs = 10000;
        int  n = 40000;
        int h = 5;
        int t = 4;
        Stage anotherStage = new Stage();
        Signal equation = new Signal();

        double g[] = equation.firstEquation(fi, fs, n);
        //double x[] = equation.firstEquation(fi, fs, n);
        //double x[] = equation.secondEquation(fi, fs, n, g);
        //double x[] = equation.thirdEquation(fi, fs, n, g);
       // double x[] = equation.fourthEquation(fs, n);
        double x[] = equation.fifthEquation(fs, h, t);
//        double x[] = equation.fifthEquation(fs, h, t);
//        double x[] = equation.fifthEquation(fs, h, t);


        DFTRepresentation values[] = new DFTRepresentation[n];
        DFT dft = new DFT();
        DFTRepresentation[] representation = dft.sumDFT(values, n, x);
        double module[] = dft.calculateModule(representation, n);

        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        final LineChart<Number,Number> lineChart = new LineChart<Number,Number>(xAxis,yAxis);
        lineChart.setCreateSymbols(false);
        XYChart.Series series = new XYChart.Series();
        for(int i=0; i<n; i++)
        {
            series.getData().add(new XYChart.Data(i, module[i]));
        }
        lineChart.getData().add(series);
        Scene scene  = new Scene(lineChart, 1000, 800);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args)
    {
        launch(args);
    }
}