import ru.academit.potyanikhin.Vector;

public class main {
    public static void main(String[] args) throws CloneNotSupportedException {

        double[] array = {5.6, 4, 6.7};
        double[] array2 = {5.5, 4, 6.5, 5.5, 4, 6.5, 8};

        Vector vector = new Vector(3, array);
        Vector vector1 = new Vector(7, array2);

        vector.vectorReturn();

        System.out.println(vector);
        System.out.println(vector.getVectorLength());


        vector.componentInstallation(99.99, 2);
        System.out.println(vector);

    }
}
