import org.w3c.dom.ls.LSOutput;
import ru.academit.potyanikhin.vector.Vector;

import java.util.Arrays;

public class Matrix {
    private int n;
    private int m;
    private double[][] matrixArray;

    public Matrix(int n, int m) {
        matrixArray = new double[n][m];
    }

    public Matrix(double[][] matrixArray) {
        this.matrixArray = matrixArray;
    }


    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < matrixArray.length; i++) {
            string.append(matrixArray[i]);

            if (i == matrixArray.length - 1) {
                break;
            }

            string.append(", ");
        }

        return "{ " + string + " }";
    }
}

