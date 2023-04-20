import com.fasterxml.jackson.databind.ObjectMapper;
import com.wsh.domain.Student;
import com.wsh.domain.User;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Test {
    @org.junit.Test
    public void test1() throws Exception {
        //1、创建java对象
        User user = new User("wsh","123456");
        //2、创建Jackson的核心对象 ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();

        /*
        //3、转换（字符串）
        String string = objectMapper.writeValueAsString(user);
        System.out.println(string);
        */

        //3、转换(关联到文件)
        //objectMapper.writeValue(new File("/Users/wushuhong/IdeaProjects/java_web/JavaWebTest/src/main/webapp/a.txt"),user);

        //3、转换（关联到流）
        objectMapper.writeValue(new FileWriter("/Users/wushuhong/IdeaProjects/java_web/JavaWebTest/src/main/webapp/a.txt"),user);
    }

    @org.junit.Test
    public void test2() throws Exception {
        //创建java对象
        Student student = new Student("wsh","女",new Date());
        //创建Jackson的核心对象 ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();
        //转换
        String string = objectMapper.writeValueAsString(student);
        System.out.println(string);
    }

    @org.junit.Test
    public void test3() throws Exception {
        //创建java对象
        Student student1 = new Student("wsh","女",new Date());
        Student student2 = new Student("wsh","女",new Date());
        Student student3 = new Student("wsh","女",new Date());
        //创建list集合
        ArrayList<Student> al =new ArrayList<Student>();
        al.add(student1);
        al.add(student2);
        al.add(student3);
        //创建Jackson的核心对象 ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();
        //转换List集合为json对象
        String string = objectMapper.writeValueAsString(al);
        System.out.println(string);
    }

    @org.junit.Test
    public void test4() throws Exception {
        //创建java对象的map集合
        Map<String,String> hm=new HashMap<>();
        hm.put("name","wsh");
        hm.put("age","23");
        hm.put("hobby","swim");
        //创建Jackson的核心对象 ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();
        //转换
        String string = objectMapper.writeValueAsString(hm);
        System.out.println(string);
    }

    @org.junit.Test
    public void test5() throws Exception {
       //初始化json字符串
        String json ="{\"name\":\"wsh\",\"password\":\"123456\"}";
        //创建objectMapper对象
        ObjectMapper objectMapper = new ObjectMapper();
        //转化
        User user = objectMapper.readValue(json, User.class);
        System.out.println(user);
    }
}
