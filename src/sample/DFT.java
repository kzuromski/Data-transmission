package sample;

public class DFT
{
    public DFTRepresentation[] sumDFT(DFTRepresentation[] values, int n, double[] x)
    {
        double angle;
        for(int i=0; i<n; i++)
        {
            values[i] = new DFTRepresentation();
            for (int j = 0; j < n; j++)
            {
                angle = (-2 * Math.PI * i * j) / n;
                values[i].real += x[j] * Math.cos(angle);
                values[i].imaginary += x[j] * Math.sin(angle);
            }
        }
        return values;
    }

    public double[] calculateModule(DFTRepresentation values[], int n)
    {
        double module[] = new double[n];
        for(int i=0; i<n; i++)
        {
            module[i] = Math.sqrt(values[i].real * values[i].real + values[i].imaginary * values[i].imaginary);
        }
        return module;
    }
}
