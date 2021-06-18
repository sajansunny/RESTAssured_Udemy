package restAssuredDemo;

import files.Payload;
import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {
    public static void main(String[] args) {
        JsonPath js = new JsonPath(Payload.CoursePrice());

        //To print total no. of courses
        int count = js.getInt("courses.size()");
        System.out.println(count);

        //To print total amount
        int totalAmount = js.getInt("dashboard.purchaseAmount");
        System.out.println(totalAmount);

        //To print the title of first course
        String titleFirstCourse = js.get("courses[0].title");
        System.out.println(titleFirstCourse);

        //To print all courses and its price
        for (int i=0; i<count; i++){
            System.out.println(js.get("courses["+i+"].title").toString());
            System.out.println(js.get("courses["+i+"].price").toString());
            System.out.println("\n");
        }

        System.out.println("No. of copies for RPA course");
        for (int i=0; i<count; i++){
            String courseName = js.get("courses["+i+"].title");

            if (courseName.equalsIgnoreCase("RPA")){
                System.out.println(js.get("courses["+i+"].copies").toString());
                break;
            }
        }

        System.out.println("Verify whether the total amount matches with course amount");
        int actualTotal = 0;
        for (int i=0; i<count; i++){
            int price = js.getInt("courses["+i+"].price");
            int copies = js.getInt("courses["+i+"].copies");
            actualTotal = actualTotal + (price*copies);
        }
        System.out.println(actualTotal);
        if (totalAmount == actualTotal){
            System.out.println("Pass");
        }
        else {
            System.out.println("Fail");
        }


        
    }
}
