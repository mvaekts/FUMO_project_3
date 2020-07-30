package sample;

import java.util.Arrays;
import java.util.Random;

public class PointsRow
{
    private final int[] values;

    public PointsRow(int minVal, int maxVal)
    {
        Random generator = new Random();
        values = new int[4];
        for (int i = 0; i < 4; ++i)
        {
            values[i] = generator.nextInt(1 + maxVal - minVal) + minVal;
        }
    }

    public int getFirst()
    {
        return  values[0];
    }

    public int getSecond()
    {
        return  values[1];
    }

    public int getThird()
    {
        return  values[2];
    }

    public int getFourth()
    {
        return  values[3];
    }

    public int getMaximum()
    {
        return Arrays.stream(values).max().getAsInt();
    }

    public int getMinimum()
    {
        return Arrays.stream(values).min().getAsInt();
    }

    public void solveRow()
    {
        for (int i = 0; i < 4; ++i)
        {
            if (values[i] < 0)
                values[i] = -values[i];

            if (values[i] == 0)
                values[i] = 1;
        }
    }

}
