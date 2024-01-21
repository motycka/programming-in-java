package cz.motyka.practice.lesson4;

import com.motycka.java.practice.lesson4.WorldCities;
import com.motycka.java.practice.lesson6.WorldCity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class WorldCitiesTest {

    private static final String filePath = "/Users/monikaprotivova/IdeaProjects/Playground/java-programming-course/src/main/resources/worldcities.csv";
    private static final WorldCities worldCities = new WorldCities();

    @BeforeAll
    static void setup() {
        worldCities.load(filePath);
    }

    @Test
    @DisplayName("should return n top world cities by population")
    void shouldReturnToCitiesByPopulation() {
        int size = 10;

        List<WorldCity> actual = worldCities.getTopWorldCities(size);

        actual.forEach(i -> System.out.println(i.getName() + " " + i.getPopulation()));

        Assertions.assertEquals(actual.size(), size);

        Assertions.assertEquals(actual.get(0).getName(), "Tokyo");
        Assertions.assertEquals(actual.get(1).getName(), "Jakarta");
        Assertions.assertEquals(actual.get(2).getName(), "Delhi");
        Assertions.assertEquals(actual.get(3).getName(), "Guangzhou");
        Assertions.assertEquals(actual.get(4).getName(), "Mumbai");
        Assertions.assertEquals(actual.get(5).getName(), "Manila");
        Assertions.assertEquals(actual.get(6).getName(), "Shanghai");
        Assertions.assertEquals(actual.get(7).getName(), "Sao Paulo");
        Assertions.assertEquals(actual.get(8).getName(), "Seoul");
        Assertions.assertEquals(actual.get(9).getName(), "Mexico City");

    }

    @Test
    @DisplayName("should return n top country cities by population")
    void shouldGetTopCountryCities() {
        int size = 5;

        List<WorldCity> actual = worldCities.getTopCountryCities("Thailand", 5);

        actual.forEach(i -> System.out.println(i.getName() + " " + i.getPopulation()));

        Assertions.assertEquals(actual.size(), size);

        Assertions.assertEquals(actual.get(0).getName(), "Bangkok");
        Assertions.assertEquals(actual.get(1).getName(), "Chiang Mai");
        Assertions.assertEquals(actual.get(2).getName(), "Nonthaburi");
        Assertions.assertEquals(actual.get(3).getName(), "Pak Kret");
        Assertions.assertEquals(actual.get(4).getName(), "Hat Yai");
    }
}
