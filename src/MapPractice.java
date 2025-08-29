import java.util.HashMap;
import java.util.Map;

public class MapPractice {


    public static void main(String[] args) {

        //put
        Map<Integer,String> map = new HashMap<Integer,String>();
        map.put(1,"one");
        map.put(2,"two");
        map.put(3,"three");
        System.out.println(map);
        map.put(3,"four"); //this will overwrite the key 3
        System.out.println(map);




        //putIfAbsent(k,V)
        //inserts only if key not already mapped
        // this will return the value at key = 3 i.e four
        System.out.println(map.putIfAbsent(3,"five")); //returns the value type
        System.out.println(map);

        //this will return null because key 4 us not present
        System.out.println("lets see what this returns " + map.putIfAbsent(4,"four"));
        System.out.println(map);


        //get(Object key)
        //returns null if not present
        System.out.println(map.get(2));

        //getOrDefault(Object key, V defaultValue)
        //avoids null checks
        System.out.println(map.getOrDefault(4,"five"));
        System.out.println(map.getOrDefault(5,"four"));


        //containsKey(Object key) / contains(Object value)
        //checks if the key/value exists
        System.out.println("ConatinsKey returns : " + map.containsKey(4));
        System.out.println("ConatinsValue returns : " + map.containsValue("Four"));


        //remove(Object key) / remove(Object key, Object value)
        //REMOVES BY KEY OR ONLY IF MAPPING MATCHES
        System.out.println(map.remove(4));   // returns the value which is removed
        System.out.println(map.remove(3,"four")); //returns boolean


        //replace(K key, V newValue) / replcae(K key, V oldValue, V newValue)
        //Replce if key exits
        System.out.println(map.replace(1,"OOne")); //returns the old value
        System.out.println(map);

        //returns boolean to check if the object is present or not
        System.out.println(map.replace(1,"OOne","One"));


        //keySet
        for(Integer key : map.keySet()){
            System.out.println("Key : " + key);
        }

        //values
        for(String value : map.values()){
            System.out.println("Value : " + value);

        }

        //forEach with map

        map.forEach((key,value)->{
            System.out.print("Key : " + key);
            System.out.println(" Value : " + value);

        });

        //iterating over key set
        map.keySet().forEach((key)->{
            System.out.println("Key : " + key);
        });

        //iterating over values
        map.values().forEach(value->{
            System.out.println("Value : " + value);
        });

        //entrySet
        for(Map.Entry<Integer,String> entry : map.entrySet()){
            System.out.println("Key : " + entry.getKey());
            System.out.println("Value : " + entry.getValue());

            if(entry.getKey().equals(1)){
                entry.setValue("OneUpdated");
            }
        }

       map.forEach((k,value)->{
           System.out.println("Key : " + k);
           System.out.println("Value : " + value);
       });

Map<Integer,String> employees = new  HashMap<>();
employees.put(1,"Rohan");
employees.put(2,"Akshay");
employees.put(3,"Akanksha");
        System.out.println("Before Computing " + employees);

        //Update key = 1
        //returns the value after computing
        System.out.println(employees.compute(1,(id,name) -> name + " Backend"));
        System.out.println(employees.compute(1,(id,name)-> name +"developer " ));
        System.out.println(employees);

        //gives null when key is not present
        System.out.println(employees.compute(4,(id,name) -> name + " Backend"));
        System.out.println(employees);
        //removes key and mapping associated with it when returned null
        System.out.println(employees.compute(3,(id,name)-> null ));



        //returns the old value which was associated
        System.out.println("If the key is not present :" + employees.computeIfAbsent(4, id -> "Shreyaaa"));
        System.out.println(employees);

        //if present returns the value which were present
        System.out.println("If the key is  present it returns : " +employees.computeIfAbsent(1 , id -> "Rohan + dev"));
        System.out.println(employees.computeIfAbsent(5,id -> "Shreya dev"));
        System.out.println(employees);
        employees.merge(4,"Akash",(old, newV)-> newV);
        System.out.println(employees);


        //merge(K key, V value, BiFunction<V,V,V>)
        Map<String, Integer> wordCount = new HashMap<>();
        String[] words = {"apple","banana","apple","orange","banana","apple"};
        for (String word : words){

            //if absent -> insert +1
            // if present -> old + new
            wordCount.merge(word, 1, (oldVal, newVal) -> oldVal + newVal);

        }
        System.out.println(wordCount);

        //for removing
        //second parameter is considered as newV
        wordCount.merge("orange",3,(old,newV)-> newV + old);
        System.out.println(wordCount);


        //removal of key value
        wordCount.merge("apple",2,(o,n)-> null);

        System.out.println(wordCount);



        //replaceAll
        wordCount.replaceAll((name,count)-> {
            if(count > 1){
                return count + 1;
            }
            return count;
        });

        System.out.println(wordCount);
        System.out.println(wordCount.size());
        System.out.println(wordCount.isEmpty());

        //returns void
        wordCount.clear();

    }
}
