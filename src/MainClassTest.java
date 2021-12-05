import org.junit.Assert;
import org.junit.Test;
public class MainClassTest extends MainClass
{
    @Test
    public void testGetClassString() {
        int search_hello_result = this.getClassString().indexOf("hello",0);
        int search_Hello_result = this.getClassString().indexOf("Hello",0);
        int search_result = search_hello_result + search_Hello_result;
        Assert.assertTrue("getClassString returns a string that does not contain hello", search_result > -2);
    }
}
