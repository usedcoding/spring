package com.std.sbb;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.service.annotation.PatchExchange;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PersonController {
    List<Person> people;

    PersonController() {
        people = new ArrayList<>();
    }
    @GetMapping("/home/addPerson")
    @ResponseBody
    public String showAddPerson(String name, int age) {
        Person p = new Person(name, age);
        people.add(p);
        return p.getId() + "번 사람이 추가 되었습니다.";
    }

    public List<Person> showPeople() {
        return people;
    }

    @GetMapping("/home/removePerson")
    @ResponseBody
    public String showRemovePerson(int id) {
        for(int i = 0; i < people.size(); i++) {
            if(people.get(i).getId() == id) {
                people.remove(i);
            }
        }
        return id + "번 사람이 삭제 되었습니다.";
    }

    @GetMapping("/home/modifyPerson")
    @ResponseBody
    public String showModifyPerson(int id,String name, int age ) {
        for(int i = 0; i < people.size(); i++) {
            Person p = null;
            if(people.get(i).getId() == id) {
               p = people.get(i);
            }
            p.setName(name);
            p.setAge(age);
        }
        return id + "번 사람이 수정되었습니다.";

    }


}
@Getter
@AllArgsConstructor
@Setter
class Person{
    private static int lastId;
    private  int id;
    private String name;
    private  int age;

    static{
        lastId = 0;
    }

    Person(String name, int age ) {
        this.id = ++lastId;
        this.name = name;
        this.age = age;
    }

}
