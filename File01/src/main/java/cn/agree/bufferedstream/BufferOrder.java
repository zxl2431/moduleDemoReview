package cn.agree.bufferedstream;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class BufferOrder {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("E:\\readorder.txt"));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("E:\\readout.txt"));

        ArrayList<String> strings = new ArrayList<>();

        HashMap<String, String> map = new HashMap<>();

        String line;

        while ((line=bufferedReader.readLine()) != null) {
            // System.out.println(line);
            // strings.add(line);
            String[] split = line.split("\\.");
            map.put(split[0], split[1]);
        }

        bufferedReader.close();

        for (int i=1; i<=map.size(); i++) {
            String key = String.valueOf(i);
            //
            String value = map.get(key);

            bufferedWriter.write(key+"."+value);
            bufferedWriter.newLine();


        }

        bufferedWriter.close();


    }
}
