package cn.agree.javabean;

import cn.agree.pojo.Stu;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class BeanUtilsDemo03 {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name","林青霞");
        map.put("gender","女");
        map.put("age","38");
        map.put("hobbies",new String[]{"唱歌","跳舞"});

        Stu stu = new Stu();

        System.out.println("封装前:"+stu);
        BeanUtils.populate(stu, map);
        System.out.println("封装后:"+stu);

    }
}
