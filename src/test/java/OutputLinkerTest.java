import com.napier.sem.OutputLinker;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
public class OutputLinkerTest {

    @Test
    public void testBasicUserInput(){
        OutputLinker testOutputLinker = new OutputLinker();

        assertEquals(true, testOutputLinker.SQLinititate("IFSTATEMENTTEST",null,null,null,null,null));


    }
    /*@Test
    public void testOutput(){
        OutputLinker testOutputLinker = new OutputLinker();
        System.out.format("%-18s%-8s%-8s", "Example", "Example2", "Example3", "Example4");

    }*/
}
