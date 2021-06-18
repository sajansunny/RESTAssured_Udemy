package restAssuredDemo;

import files.Payload;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SumValidation {
    @Test
    public void sumOfCourses (){
        JsonPath js = new JsonPath(Payload.CoursePrice());

        //To print total no. of courses
        int count = js.getInt("courses.size()");
        System.out.println(count);

        //To print total amount
        int totalAmount = js.getInt("dashboard.purchaseAmount");
        System.out.println(totalAmount);

        System.out.println("Verify whether the total amount matches with course amount");
        int actualTotal = 0;
        for (int i=0; i<count; i++){
            int price = js.getInt("courses["+i+"].price");
            int copies = js.getInt("courses["+i+"].copies");
            actualTotal = actualTotal + (price*copies);
        }
        System.out.println(actualTotal);
        Assert.assertEquals(actualTotal,totalAmount);
    }
}
