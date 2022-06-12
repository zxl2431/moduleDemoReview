package cn.agree.iostream;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReader01 {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("E:\\testfile\\fos.txt");

        FR02(fr);
        fr.close();
    }

    public static void FR01(FileReader fr) throws IOException {
        int b;

        while ((b=fr.read()) != -1) {
            System.out.println((char) b);
        }

    }

    public static void FR02(FileReader fr) throws IOException {
        int len;
        char[] buf = new char[2];

        while ((len=fr.read(buf)) != -1) {
            System.out.println(new String(buf, 0, len));
        }
    }


}
