package com.example.api.mockStatic;


import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

class MockStaticClass {

    public static String staticMethod() {
        return "Hello world";
    }
}

@RunWith(PowerMockRunner.class)
@PrepareForTest(MockStaticClass.class)
public class MockStaticMethodTest {

    @Test
    public void testMockStaticMethod() {
        PowerMockito.mockStatic(MockStaticClass.class);

        PowerMockito.when(MockStaticClass.staticMethod()).thenReturn("nothing");

        Assertions.assertEquals("nothing", MockStaticClass.staticMethod());
    }
}

