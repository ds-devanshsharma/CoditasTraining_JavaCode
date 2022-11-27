import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ListTest {
    @Test
    public void letsMockListSizeMethod(){
        List listMock = mock(List.class);
        when(listMock.size()).thenReturn(2);
        assertEquals(2,listMock.size());
        assertEquals(2,listMock.size());
        assertEquals(2,listMock.size());
    }

    @Test
    public void letsMockListSizeReturnMultipleValues(){
        List listMock = mock(List.class);
        when(listMock.size()).thenReturn(2).thenReturn(3);
        assertEquals(2,listMock.size());
        assertEquals(3,listMock.size());
    }

    @Test
    public void letsMockListGet(){
        List listMock = mock(List.class);
//        when(listMock.get(0)).thenReturn("Devansh").thenReturn("sharma");
//        assertEquals("Devansh",listMock.get(0));

        //default behaviour of mockito
//        assertEquals(null,listMock.get(1));

        //Argument Matcher anyInt
        when(listMock.get(anyInt())).thenReturn("NumberFound");
        assertEquals("NumberFound",listMock.get(10));
    }

    @Test(expected = RuntimeException.class)
    public void letsMockListThrowException(){
        List listMock = mock(List.class);

        //Argument Matcher anyInt
        when(listMock.get(anyInt())).thenThrow(new RuntimeException("SOMETHING"));
        listMock.get(0);
    }
}
