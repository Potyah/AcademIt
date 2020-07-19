import ru.academit.potyanikhin.Vector;

public class main {
    public static void main(String[] args)  {

        double[] array = {5.6, 4, 6.7};
        double[] array2 = {5.5, 4, 6.5,5.5, 4, 6.5, 8};

        Vector vector = new Vector(array);
        Vector vector1 = new Vector(array2);

        System.out.println (vector);
        System.out.println (vector1);

        Vector vector2 = new Vector(vector1);


        System.out.println ("сумма: " + vector.vectorSum(vector1));

        System.out.println (vector);
        System.out.println (vector1);

        System.out.println ( "сумма: " + vector1.vectorSum(vector));


       // System.out.println (vector.vectorReturn());

    }


}
