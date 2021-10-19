import java.util.HashSet;
import java.util.TreeMap;

public class Cricket {

    public static void main(String[] args){
        TreemapHandson th = new TreemapHandson();
        //String actual = th.getQuery( "3,Dhoni,100|1,Virat,50|5,Jadeja,90|2,Rohit,70|4,Pandya,30", "1 3 5");
        //String actual = th.getQuery("3,Dhoni,120|1,Virat,103|5,Jadeja,90|2,Rohit,70|4,Pandya,30|6,Rahul,150",  "1 4 6");
        //String actual = th.getQuery( "3,Dhoni,100|1,Virat,50|5,Jadeja,90|2,Rohit,70|4,Pandya,30", "2 50");
        //String actual = th.getQuery("3,Dhoni,120|1,Virat,103|5,Jadeja,90|2,Rohit,70|4,Pandya,30|6,Rahul,150", "2 100" );
        /*String actual = th.getQuery("1,Rohit,100|2,Virat,56|3,Dhoni,150\n3,Rahul,90|2,Virat,100|1,Rohit,99\n" +
                        "1,Rahul,50|2,Virat,64|3,Rohit,78\n1,Dhoni,95|2,Virat,30|3,Rohit,45\n1,Jadeja,43|2,Virat,54|3,Rohit,78" +
                        "|4,Dhoni,59\n1,Rahul,60|2,Virat,56|3,Rohit,69", "3");*/
        String actual = th.getQuery( "3,Rohit,100|2,Virat,56|1,Dhoni,150\n3,Rahul,90|2,Virat,100|1,Rohit,99" +
                        "\n1,Rahut,50|2,Virat,64|3,Rohit,78\n1,Dhoni,95|2,Virat,30|3,Rohit,45\n1,Jadeja,43|2,Virat,54|3,Rohit,78|" +
                        "4,Dhoni,59\n1,Rahul,60|2,Virat,56|3,Rohit,69", "3");
        System.out.println(actual);
    }
}






