package cn.agree.iostream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamDemo01 {
    public static void main(String[] args) throws IOException {
        File file0_0 = new File("E:\\testfile");
        File file0_1 = new File(file0_0, "fos.txt");

        file0_0.mkdir();
        file0_1.createNewFile();

        System.out.println(file0_1.exists());
        FileOutputStream fos = new FileOutputStream(file0_1);
        // 是否追加写入完全取决于 构造的时候 参数
        FileOutputStream fos1 = new FileOutputStream(file0_1, true);

        FileOut0(fos);
        // FileOut1(fos);
        // FileOut2(fos1);
       // FileOut3(fos);

        fos.close();
        fos1.close();
    }

    public static void FileOut0(FileOutputStream fos) throws IOException {
        fos.write(97);
        fos.write(98);
        fos.write(99);
        fos.write(100);

        // fos.close();
    }

    public static void FileOut1(FileOutputStream fos) throws IOException {
        byte[] bytes = "你说行不行".getBytes();
        fos.write(bytes);
        // fos.close();
    }

    public static void FileOut2(FileOutputStream fos) throws IOException {
        byte[] bytes = "abcdefg".getBytes();
        fos.write(bytes, 2, 2);
        // fos.close();

    }

    /*
    *  换行写
    *
    * */
    public static void FileOut3(FileOutputStream fos) throws IOException {
        byte[] bytes = "sdhfjsdfjskj".getBytes();
        for (int i=0; i<bytes.length; i++) {
            fos.write(bytes[i]);
            fos.write("\r\n".getBytes());
        }
    }

}
