public class Main {
    public static void main(String[] args) {
        ArrayList<String> lines = new ArrayList<>();
        lines.add("111");
        lines.add("222");
        lines.add("777");
        lines.add("555");
        lines.add("666");
        lines.add("777");




        ArrayList<String> lines2 = new ArrayList<>();
        lines2.add("4");
        lines2.add("111");
        lines2.add("222");



        lines.retainAll(lines);






        System.out.println(lines);




    }
}