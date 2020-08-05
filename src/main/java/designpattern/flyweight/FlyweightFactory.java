package designpattern.flyweight;

import java.util.HashMap;
import java.util.Map;

public class FlyweightFactory {
    public static Map<String , Flyweight> flyweightMap = new HashMap<String, Flyweight>();

    public static Flyweight getFlyweight(String key){
        Flyweight flyweight = null;
        if("1".equals(key)){
            flyweight = flyweightMap.get(key);
            if(flyweight == null){
                flyweight = new ConcreteFlayweight();
                flyweightMap.put(key,flyweight);
            }
        }else if("2".equals(key)){
            flyweight = flyweightMap.get(key);
            if(flyweight == null){
                flyweight = new ConcreteFlayweight2();
                flyweightMap.put(key,flyweight);
            }

        }
        return  flyweight;
    }
}
