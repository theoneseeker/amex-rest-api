package amex.assignment.restapi.model;

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
        expected = 3f;
        assertEquals(expected, actual);

        apple.setQuantity(-5);
        actual = apple.calcCost();
        expected = -3f;
        assertEquals(expected, actual);

        apple.setQuantity(-5);
        actual = apple.calcCost();
        expected = -3f;
        assertEquals(expected, actual);

        apple.setQuantity(Integer.MAX_VALUE);
        actual = apple.calcCost();
        expected = 0.6f*Integer.MAX_VALUE;
        assertEquals(expected,actual);

        apple.setQuantity(Integer.MIN_VALUE);
        actual = apple.calcCost();
        expected = 0.6f*Integer.MIN_VALUE;
        assertEquals(expected,actual);
    }

    @Test
    void calcCostOrange(){
        actual = orange.calcCost(); // <- First, test for base case, then edge cases
        expected = 0.25f;
        assertEquals(expected, actual);

        orange.setQuantity(5);
        actual = orange.calcCost();
        expected = 1.25f;
        assertEquals(actual,expected);

        orange.setQuantity(-5);
        actual = orange.calcCost();
        expected = -1.25f;
        assertEquals(actual,expected);

        orange.setQuantity(Integer.MIN_VALUE);
        actual = orange.calcCost();
        expected = 0.25f*Integer.MIN_VALUE;
        assertEquals(actual,expected);

        orange.setQuantity(Integer.MAX_VALUE);
        actual = orange.calcCost();
        expected = 0.25f*Integer.MAX_VALUE;
        assertEquals(actual,expected);
    }
}