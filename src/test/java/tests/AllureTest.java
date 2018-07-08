package tests;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertTrue;

public class AllureTest {

    @Test
    public void test(){
        assertTrue(true);
        stepWithParams(10, 20);
        second();
    }

    @Test
    public void throwAnException(){
        throw new IllegalStateException("some exception");
    }

    @Step("This is step with paranmetres")
    public void stepWithParams(int first, int second){
        System.out.println(first + second);
    }

    @Step("Interesting step")
    public void second(){

    }

    @Attachment(value = "Sample csv file", type = "text/csv")
    public byte[] saveAttachment() throws URISyntaxException, IOException {
        return Files.readAllBytes(Paths.get(getClass().getClassLoader().getResource("sample.csv").toURI()));
    }
}
