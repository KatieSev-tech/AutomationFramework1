package testcases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class CourseGalleryTest extends BaseTest{
    @Test
    public void courseGalleryPage (){
        homePage.openCourseGalleryPage();
        List<Integer> codes = homePage.urlVerification();
        SoftAssert softAssert = new SoftAssert();
        Integer expected = 200;
        for (Integer code: codes){
            softAssert.assertEquals(code, expected);
        }
    }
}
