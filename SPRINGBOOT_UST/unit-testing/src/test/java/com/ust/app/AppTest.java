package com.ust.app;
 
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;
 
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
 
@ExtendWith(MockitoExtension.class)
class AppTest {

    @Mock
    AppService service;

    @InjectMocks
    App app;

    @Test
    void testCheck() {
        when(service.checkEven(10)).thenReturn(true);
        when(service.checkEven(5)).thenReturn(false);
        assertTrue(app.check(10));
        assertFalse(app.check(5));
        verify(service,times(1)).checkEven(10);
        verify(service,times(1)).checkEven(5);


    }

    void testFindLength() {
        String str="abc";
        when(service.getStringLength(str)).thenReturn(3);
        assertEquals(3,app.findLength(str));
        verify(service,times(1)).getStringLength(str);
    }
 
}

