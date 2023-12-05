package com.std.sbb;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.plugins.jpeg.JPEGImageReadParam;
import java.util.ArrayList;
import java.util.List;

@Controller
// HomeController는 컨트롤러 이다.
public class HomeController {
    int i = 0;




    @GetMapping("/")
    public String root() {
        return"redirect:/question/list";
    }
    //개발자가 스프링부트에게 말한다.
    //만약에 /home/main 요청이 오면 아래 메서드를 실행해줘
    @GetMapping("/home/main")
    //사용자에게
    @ResponseBody
    public String ShowMain() {
        return "안녕하세요";
    }

    @GetMapping("/home/main2")
    @ResponseBody
    public String ShowMain2() {
        return "반갑습니다";
    }

    @GetMapping("/home/main3")
    @ResponseBody
    public String ShowMain3() {
        return "즐거웠습니다.";
    }

    @GetMapping("/home/increase")
    @ResponseBody
    public int ShowMain4() {
        return i++;
    }

    //@RequestParam의 의미
    //개발자가 스프링부트에게 말한다.
    //int a는 쿼리스트링에서 a 파라미터 값을 얻은 후 정수화 한 값이어야 한다.
    //@RequestParam은 생략가능
    @GetMapping("/home/plus")
    @ResponseBody
    public int ShowMain4(@RequestParam(defaultValue = "0") int a, @RequestParam(defaultValue = "0") int b) {
        return a + b;
    }

    @GetMapping("/home/minus")
    @ResponseBody
    public int ShowMain5(@RequestParam(defaultValue = "0") int a, @RequestParam(defaultValue = "0") int b) {
        return a - b;
    }

    @GetMapping("/home/multiply")
    @ResponseBody
    public int ShowMain6(@RequestParam(defaultValue = "0") int a, @RequestParam(defaultValue = "0") int b) {
        return a * b;
    }

    @GetMapping("/home/divide")
    @ResponseBody
    public int ShowMain7(@RequestParam(defaultValue = "0") int a, @RequestParam(defaultValue = "0") int b) {
        return a / b;
    }

    @GetMapping("/home/returnBoolean")
    @ResponseBody
    public boolean returnBoolean() {
        return true;
    }

    @GetMapping("/home/returnPi")
    @ResponseBody
    public double returnPi() {
        return Math.PI;
    }

    @GetMapping("/home/returnIntArray")
    @ResponseBody
    public int[] returnIntArray() {
        int[] array = new int[]{10,20,30};
        return array;
    }

    @GetMapping("/home/returnIntList")
    @ResponseBody
    public List<Integer> showReturnIntList() {
        List<Integer> list = new ArrayList<>() {{
            add(10);
            add(20);
            add(30);
        }};
        return list;
    }







    class Car {
        private int id;
        private int speed;
        private String name;
        private List<Integer> relatedIds;

        Car(int id, int speed, String name, List<Integer> relatedIds) {
            this.id = id;
            this.speed = speed;
            this.name = name;
            this.relatedIds = relatedIds;
        }

        public int getId() {
            return id;
        }

        public int getSpeed() {
            return speed;
        }

        public String getName() {
            return name;
        }

        public List<Integer> getRelatedIds() {
            return relatedIds;
        }
    }
    @Getter
    @AllArgsConstructor
class CarV2 {
    private final int id;
    private final int speed;
    @Setter
    private String name;
    private final List<Integer> relatedIds;
}

}
