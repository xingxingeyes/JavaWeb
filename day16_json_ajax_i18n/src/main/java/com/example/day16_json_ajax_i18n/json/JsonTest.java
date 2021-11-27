package com.example.day16_json_ajax_i18n.json;

import com.example.day16_json_ajax_i18n.pojo.Person;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: kai.lv
 * @date: 2021/11/25
 **/
public class JsonTest {

    // javaBean和Json的互转

    @Test
    public void test1() {
        Person person = new Person(1, "林深时见鹿");
        // 创建Gson对象实例
        Gson gson = new Gson();
        // toJson方法可以吧java对象转换成json字符串
        String personJsonString = gson.toJson(person);
        System.out.println(personJsonString);

        // fromJson把json字符串转化回java对象
        Person person1 = gson.fromJson(personJsonString, Person.class);
        System.out.println(person1);
    }

    /**
     * list 和 Json互转
     */
    @Test
    public void test2() {
        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person(1, "林深时见鹿"));
        personList.add(new Person(2, "海蓝时见鲸"));
        Gson gson = new Gson();
        // 把list集合转成json字符串
        String personListJsonString = gson.toJson(personList);
        System.out.println(personListJsonString);

        // 把json字符串转换成list集合
        List<Person> list = gson.fromJson(personListJsonString, new PersonListType().getType());
        System.out.println(list);
        Person person = list.get(0);
        System.out.println(person);
    }

    /**
     * Map和 Json互转
     */
    @Test
    public void test3() {
        Map<Integer, Person> personMap = new HashMap<Integer, Person>();

        personMap.put(1, new Person(1, "林深时见鹿"));
        personMap.put(2, new Person(2, "海蓝时见鲸"));
        Gson gson = new Gson();
        String personMapStr = gson.toJson(personMap);
        System.out.println(personMapStr);

        // Map<Integer, Person> map = gson.fromJson(personMapStr, new PersonMapType().getType());
        // 使用匿名内部类的方式就不用专门写个 PersonMapType类继承TypeToken了
        Map<Integer, Person> map = gson.fromJson(personMapStr, new TypeToken<HashMap<Integer, Person>>(){}.getType());
        System.out.println(map);
        System.out.println(map.get(1));
    }



}
