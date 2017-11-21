package sample;

import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

public class Signal
{

    public double[] firstEquation(double fi, double fs, double n)
    {
        double x[] = new double[(int) n];
        for(int i=0; i<n; i++)
        {
            x[i] = (double)Math.sin(2*Math.PI*fi*i/fs);
        }
        return x;
    }

    public double[] secondEquation(double fi, double fs, double n, double x[])
    {
        double z[] = new double[(int)n];
        for(int i=0; i<n; i++)
        {
            z[i] = (double) (1.22 * Math.cos(12*Math.PI * i/fs) * x[i] - i/3);
        }
        return z;
    }

    public double[] thirdEquation(double fi, double fs, double n, double x[])
    {
        double v[] = new double[(int) n];
        for(int i=0; i<n; i++)
        {
            if((x[i] -(i/3)) < 0)
            {
                v[i] = (double) Math.pow(-(x[i]-i/3), (double)2/3);
            }

        }
        return v;
    }
    public double[] fourthEquation(double fs, double n)
    {
        double u[] = new double[(int) n];
        for(int t=0; t<n; t++)
        {
            if(t < 3400*0.3)
            {
                u[t] = (double) (-Math.pow(t,2) * Math.sin(8*Math.PI * t/fs + Math.PI/2));
            }
            else
            {
                u[t] = (double) (1.1 * (Math.cos(10*Math.PI * t/fs - Math.PI)/t+1));
            }
        }
        return u;
    }
    public double[] fifthEquation(double fs, double H, double t)
    {
        double g[] = new double[(int) ((int)t*fs)];
        for(int i=0; i<40000; i++)
        {
            for(int j=0; j<=H-1; j++)
            {
                g[i] += (double) (4/Math.PI * (Math.sin(20*Math.PI * i/fs * (2*j+1)))/(2*j+1));
            }
        }
        return g;
    }

    public LineChart<Number, Number> createLineChart(double values[], double n, int chartNumber )
    {
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Częstotliwość próbkowania");
        final LineChart<Number,Number> lineChart = new LineChart<Number,Number>(xAxis,yAxis);
        lineChart.setTitle("Przebieg sinusoidalny - wykres nr " + chartNumber);
        lineChart.setCreateSymbols(false);
        XYChart.Series series = new XYChart.Series();
        for(int i=0; i<n; i++)
        {
            series.getData().add(new XYChart.Data(i, values[i]));
        }
        lineChart.getData().add(series);
        return lineChart;
    }
}
