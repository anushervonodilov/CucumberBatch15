package API;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HardCodedExamples {

    String baseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";
    String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2ODQ5NzEyNTYsImlzcyI6ImxvY2Fsa" +
            "G9zdCIsImV4cCI6MTY4NTAxNDQ1NiwidXNlcklkIjoiNTIxOSJ9.kR0kaTXLizBxhL6Qn84DYH0qbvL_vySCSUdub6w8dXw";
    static String employee_id;

    @Test
    public  void bgetCreatedEmployee(){
        RequestSpecification preparedRequest = given().header("Content-Type", "application/json")
                .header("Authorization", token).queryParam("employee_id", employee_id);

//        hitting the endpoint
        Response response = preparedRequest.when().get("/getOneEmployee.php");
        response.prettyPrint();
//        verify the response
        response.then().assertThat().statusCode(200);

        String tempEmpId = response.jsonPath().getString("employee.employee_id");

//        we have 2 emp is, one is global and second is local
        Assert.assertEquals(employee_id, tempEmpId);

    }

    @Test
    public void acreateEmployee() {
        // prepare the request
        RequestSpecification preparedRequest = given().header("Content-Type", "application/json")
                .header("Authorization", token).body("{\n" +
                        "  \"emp_firstname\": \"anush\",\n" +
                        "  \"emp_lastname\": \"odilov\",\n" +
                        "  \"emp_middle_name\": \"ok\",\n" +
                        "  \"emp_gender\": \"M\",\n" +
                        "  \"emp_birthday\": \"2000-02-03\",\n" +
                        "  \"emp_status\": \"offered\",\n" +
                        "  \"emp_job_title\": \"Tester\"\n" +
                        "}");

//        hitting the endpoint/send the request

        Response response =  preparedRequest.when().post("/createEmployee.php");

        response.prettyPrint();
//        verifying the assertions/get response
        response.then().assertThat().statusCode(201);

//        we are capturing employee id from the response
        employee_id = response.jsonPath().getString("Employee.employee_id");
        System.out.println(employee_id);


        response.then().assertThat().body("Employee.emp_firstname", equalTo("anush"));
        response.then().assertThat().body("Employee.emp_lastname", equalTo("odilov"));

//        verify the response headers
        response.then().assertThat().header("Content-Type", "application/json");
        System.out.println("My test case is passed");

    }

//    in homework create a method to get all employee status and job title

    @Test
    public void cupdateEmployee() {
        RequestSpecification preparedRequest = given().header("Content-Type", "application/json").
                header("Authorization", token).body("{\n" +
                        "  \"employee_id\": \""+employee_id+"\",\n" +
                        "  \"emp_firstname\": \"masha\",\n" +
                        "  \"emp_lastname\": \"liza\",\n" +
                        "  \"emp_middle_name\": \"ms\",\n" +
                        "  \"emp_gender\": \"F\",\n" +
                        "  \"emp_birthday\": \"2023-05-20\",\n" +
                        "  \"emp_status\": \"probation\",\n" +
                        "  \"emp_job_title\": \"goofball\"\n" +
                        "}");

        //hitting the endpoint
        Response response = preparedRequest.when().put("/updateEmployee.php");
        response.then().assertThat().statusCode(200);
        //for verification
        response.then().assertThat().body("Message", equalTo("Employee record Updated"));

    }

    @Test
    public void dgetUpdatedEmployee() {
        RequestSpecification preparedRequest = given().
                header("Content-Type", "application/json").
                header("Authorization", token).
                queryParam("employee_id", employee_id);

        Response response = preparedRequest.when().get("/getOneEmployee.php");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }


}
