package lixuan.test.test5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main5 {
    /**
     * 某高校学校学生的信息保存在文件student.txt中，每个学生的信息占一行，
     * 信息格式为: 学生英文名称、学院id、专业id，年级  字段通过空格分隔。
     * 例如：
     * 姓名      学院id   专业id       年级
     * moon      10          101          2018
     * lark       11          103           2019
     * chris     10          102           2017
     * label     15          108           2016
     * 面试人请按要求实现下面的类。
     * @param <T>
     * @param <K>
     */
    class Pair<T,K>{
        T CollegeId;
        K MajorId;
    }
    class Student {
        //构造函数，输入为文件名
        public Student(String filename) {
            //请面试人实现该函数体
            init(filename);

        }

        //获取学生所在学院ID和专业ID,请自行定义Pair
        public Pair<String,String> getStudentInfo(String strName) {
            //请面试人实现该函数体，时间复杂度O(1)
            return map1.get(strName);
        }
        //获取某学院的所有学生
        public List<String> getMembersOfCollege(String strCollegeId)  {
            //请面试人实现该函数体，时间复杂度O(1)
            return map2.get(strCollegeId);
        }
        //获取某专业的所有学生
        public List<String> getMembersOfMajor(String strMajorId) {
            //请面试人实现该函数体，时间复杂度O(1)
            return map3.get(strMajorId);
        }
        //获取某个年级的所有学生
        public List<String> getMembersOfGrade(String strGradeId) {
            //请面试人实现该函数体
            return map4.get(strGradeId);
        }

        //所需字段及函数请面试人自行补齐
        /*String[] name;
        String[] CollegeId;
        String[] MajorId;
        String[] Grade;*/
        Map<String, Pair<String,String>> map1;
        Map<String, List<String>>  map2;
        Map<String, List<String>>  map3;
        Map<String, List<String>>  map4;

        private void init(String filename) {
            try {
                List<String> list=new ArrayList<>();
                File file = new File(filename);
                FileReader fileReader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String value;
                while ((value = bufferedReader.readLine()) != null) {
                    list.add(value);
                }
                map1=new HashMap<>();
                map2=new HashMap<>();
                map3=new HashMap<>();
                map4=new HashMap<>();
                for (int i=1;i<list.size();i++){
                    String[] s = list.get(i).split(" ");
                    String name=s[0];
                    String CollegeId=s[1];
                    String MajorId=s[2];
                    String Grade=s[3];
                    Pair<String, String> pair = new Pair<>();
                    pair.CollegeId=CollegeId;
                    pair.MajorId=MajorId;
                    map1.put(name,pair);

                    List<String> stringList = map2.getOrDefault(CollegeId, new ArrayList<String>());
                    stringList.add(name);
                    map2.put(CollegeId,stringList);

                    List<String> stringList1 = map3.getOrDefault(MajorId, new ArrayList<String>());
                    stringList1.add(name);
                    map3.put(MajorId,stringList1);

                    List<String> stringList2 = map4.getOrDefault(Grade, new ArrayList<String>());
                    stringList2.add(name);
                    map4.put(Grade,stringList2);
                }
            }catch (IOException e){

            }

        }
    }
}
