package amex.assignment.restapi;

import amex.assignment.restapi.model.Apple;
import amex.assignment.restapi.model.Orange;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    Orange orange;
    Apple apple;
    float actual;
    float expected;

    @BeforeEach
    void setup(){
        orange = new Orange("orange", 1);
        apple = new Apple("apple", 1);
    }

    @Test
    void calcCostApple() {
        actual = apple.calcCost(); // <- First, test for base case, then edge cases
        expected = 0.6f;
        assertEquals(expected, actual);

        apple.setQuantity(5);
        actual = apple.calcCost();
        expected = 1.8f;
        assertEquals(expected, actual);

        apple.setQuantity(-5);
        actual = apple.calcCost();
        expected = 0f;
        assertEquals(expected, actual);

        apple.setQuantity(1000);
        actual = apple.calcCost();
        expected = 300.0f;
        assertEquals(expected,actual);

    }

    @Test
    void calcCostOrange(){
        actual = orange.calcCost(); // <- First, test for base case, then edge cases
        expected = 0.25f;
        assertEquals(expected, actual);

        orange.setQuantity(5);
        actual = orange.calcCost();
        expected = 1.0f;
        assertEquals(actual,expected);

        orange.setQuantity(-5);
        actual = orange.calcCost();
        expected = 0f;
        assertEquals(actual,expected);

        orange.setQuantity(1000);
        actual = orange.calcCost();
        expected = 166.75f;
        assertEquals(actual,expected);

    }
}