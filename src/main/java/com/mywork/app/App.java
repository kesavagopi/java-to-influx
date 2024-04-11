package com.mywork.app;

import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBFactory;
import org.influxdb.dto.Point;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class App 
{
    public static void main( String[] args )
    {
        String serverUrl = "http://localhost:8086";
        String databaseName = "employee_details";
        InfluxDB influxDB = InfluxDBFactory.connect(serverUrl);
        String s[]={"Alice", "Bob", "Charlie", "David", "Eva", "Frank", "Grace", "Henry", "Ivy", "Jack","Katherine", "Liam", "Mia", "Nathan", "Olivia", "Peter", "Quinn", "Rachel", "Samuel", "Tracy","Ursula", "Victor", "Wendy", "Xavier", "Yvonne", "Zachary", "April", "Brian", "Chloe", "Diana","Ethan", "Fiona", "George", "Hannah", "Isaac", "Julia", "Kevin", "Laura", "Michael", "Nora","Oscar", "Pamela", "Quentin", "Rita", "Stephen", "Tina", "Uma", "Vincent", "Winnie", "Xena","Yasmine", "Zara", "Andrew", "Beth", "Carl", "Daisy", "Eli", "Felicity", "Gerald", "Holly","Ian", "Jasmine", "Kyle", "Lena", "Martin", "Natalie", "Owen", "Penelope", "Quincy", "Rose","Simon", "Tanya", "Ulysses", "Violet", "William", "Xander", "Yolanda", "Zoe", "Adam", "Bella","Chris", "Dana", "Eric", "Faye", "Gary", "Heidi", "Ivan", "Jane","Omar", "Isabella", "Elijah", "Charlotte", "Noah",  "Mia", "Liam", "Evelyn", "William", "Avery", "James", "Sophia"};
        String empid[]={"EMP1", "EMP2", "EMP3", "EMP4", "EMP5", "EMP6", "EMP7", "EMP8", "EMP9", "EMP10", "EMP11", "EMP12", "EMP13", "EMP14", "EMP15", "EMP16", "EMP17", "EMP18", "EMP19", "EMP20", "EMP21", "EMP22", "EMP23", "EMP24", "EMP25", "EMP26", "EMP27", "EMP28", "EMP29", "EMP30", "EMP31", "EMP32", "EMP33", "EMP34", "EMP35", "EMP36", "EMP37", "EMP38", "EMP39", "EMP40", "EMP41", "EMP42", "EMP43", "EMP44", "EMP45", "EMP46", "EMP47", "EMP48", "EMP49", "EMP50", "EMP51", "EMP52", "EMP53", "EMP54", "EMP55", "EMP56", "EMP57", "EMP58", "EMP59", "EMP60", "EMP61", "EMP62", "EMP63", "EMP64", "EMP65", "EMP66", "EMP67", "EMP68", "EMP69", "EMP70", "EMP71", "EMP72", "EMP73", "EMP74", "EMP75", "EMP76", "EMP77", "EMP78", "EMP79", "EMP80", "EMP81", "EMP82", "EMP83", "EMP84", "EMP85", "EMP86", "EMP87", "EMP88", "EMP89", "EMP90", "EMP91", "EMP92", "EMP93", "EMP94", "EMP95", "EMP96", "EMP97", "EMP98", "EMP99", "EMP100"};
        influxDB.createDatabase("employee");
        while (true) {
            Random r=new Random();
            Point point = Point.measurement("employee")
                    .addField("empno",empid[r.nextInt(100)])
                    .addField("empname",s[r.nextInt(100)])
                    .time(System.currentTimeMillis(), TimeUnit.MILLISECONDS)
                    .build();

            influxDB.write(databaseName, "autogen", point);
           try{
            Thread.sleep(5000);
           }
           catch(InterruptedException e){
            e.printStackTrace();
           }
        }

        // Close InfluxDB connection when done
         //influxDB.close();
    }
}
