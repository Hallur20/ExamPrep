package randomdata;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Hallur
 */
public class Generator {

    String[] names = {"Karl", "Pia", "Birthe", "Hallur", "Per", "Lasse", "John", "Mo", "Anette",
        "Poul", "Klaus", "Gurli", "Lars", "Søren", "Jógvan", "Pætur", "Kári", "Herbjørn", ""};
    String[] surNames = {"Poulsen", "Andersen", "við Neyst", "På loftet", "Under skuret", "Persen", "Kofoed",
        "Jespersen", "Jackson", "Ymer", "Under buen", "Ved siden af skoven"};

    public String generate(int amount, int startId) {
        List<Person> pl = new ArrayList();
//        JsonArray jArray = new JsonArray();
//        JsonObject jO = new JsonObject();
//        jO.addProperty(fname, Boolean.FALSE);
//        jArray.add(jO);

        for (int i = 0; i < amount; i++) {
            Random random = new Random();
            int firstName = random.nextInt(names.length);
            int lastName = random.nextInt(surNames.length);
            int age = random.nextInt(70 - 17 + 1) + 17; //age from 
            pl.add(new Person(names[firstName], surNames[lastName],startId,age));
            startId++;
        }
        String json = "[";
        for (int j = 0; j < pl.size(); j++) {
            if (j+1 != pl.size()) {
                json += "{\"fname\": \"" + pl.get(j).getFname() +"\", \"lname\": \"" + pl.get(j).getLname() + "\", \"id\": " + pl.get(j).getId() + ", \"age\": " + pl.get(j).getAge() + "},";
            } else {
                json += "{\"fname\": \"" + pl.get(j).getFname() +"\", \"lname\": \"" + pl.get(j).getLname() + "\", \"id\": " + pl.get(j).getId() + ", \"age\": " + pl.get(j).getAge() + "}]";
            }
        }
        return json;
    }

    public static void main(String[] args) {
        Generator generate = new Generator();
        System.out.println(generate.generate(4, 0));
    }
}
