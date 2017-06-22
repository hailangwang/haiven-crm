/**
 * Created by hlwang on 2017/6/12.
 */
public class Test {


    public static void main(String[] args) {

      /*  String s ="a,b,c,,";
        String[] sList = s.split(",");
        System.out.println(s.split(",").length);

        String a = "a,b,,c";
        System.out.println(a.split(",").length);*/

//        System.out.println("1717052310560309993".length());
//        System.out.println("1217052218160349781".length());
        String c="1717060111561088218|1217052717212182169|100|20170601|20170601|20170601|00000002|N|1017052717195063713|4063658812344113|C|100|300|null|2017060111525400000180028001|";

        String[] cList = c.split("\\|");
        for(String cc:cList){
            System.out.println(cc.length());
        }



    }
}
