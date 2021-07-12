package lixuan.test.test5;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main4 {
    //    对一个很大的文本文件排序与去重，对应的shell命令是"cat inputFile| sort | uniq > outputFile"，请写一个函数实现该功能，方法原型如下
    public void fileUniq(String inputFileName, String outputFileName) {
        try {
            File file = new File(inputFileName);
            String path = file.getAbsolutePath();

            File[] fileArray = new File[100];
            for (int i = 0; i < 100; i++) {
                fileArray[i] = new File(path + File.separator + i + ".txt");
            }

            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                int index = str.hashCode() % 100;
                File myfile = fileArray[index];
                BufferedWriter writer = new BufferedWriter(new FileWriter(myfile));
                writer.write(str);
            }


            Set<String> distinct = distinct(fileArray);



        } catch (IOException e) {

        }

    }

    public static Set<String> distinct(File[] fileArray) {
        Set<String> unicSet = new HashSet<String>();
        try {
            for (int i = 0; i < 100; i++) {
                BufferedReader reader = new BufferedReader(new FileReader(fileArray[i]));
                String line = null;
                while ((line = reader.readLine()) != null) {
                    if (line != "") {
                        unicSet.add(line);
                    }
                }
                return unicSet;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            return unicSet;
        }
    }


}
