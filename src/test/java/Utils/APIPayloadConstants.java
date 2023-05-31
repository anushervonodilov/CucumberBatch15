package Utils;

import org.json.JSONObject;

public class APIPayloadConstants {

//    we will pass the body in multiple formats

    public static String createEmployeePayLoad() {
        String createEmployeePayload = "{\n" +
                "  \"emp_firstname\": \"anush\",\n" +
                "  \"emp_lastname\": \"odilov\",\n" +
                "  \"emp_middle_name\": \"ok\",\n" +
                "  \"emp_gender\": \"M\",\n" +
                "  \"emp_birthday\": \"2000-02-03\",\n" +
                "  \"emp_status\": \"offered\",\n" +
                "  \"emp_job_title\": \"Tester\"\n" +
                "}";

        return createEmployeePayload;
    }

    public static String createEmployeePayLoadJson() {

        JSONObject obj = new JSONObject();
        obj.put("emp_firstname","anush");
        obj.put("emp_lastname","odilov");
        obj.put("emp_middle_name","ok");
        obj.put("emp_gender","M");
        obj.put("emp_birthday","2000-02-03");
        obj.put("emp_status","offered");
        obj.put("emp_job_title","Tester");

        return obj.toString();

    }

    public static String createEmployeePayloadDynamic
            (String emp_firstname, String emp_lastname,
             String emp_middle_name, String emp_gender, String emp_birthday,
             String emp_status, String emp_job_title){

        JSONObject obj = new JSONObject();
        obj.put("emp_firstname", emp_firstname);
        obj.put("emp_lastname", emp_lastname);
        obj.put("emp_middle_name", emp_middle_name);
        obj.put("emp_gender", emp_gender);
        obj.put("emp_birthday", emp_birthday);
        obj.put("emp_status", emp_status);
        obj.put("emp_job_title", emp_job_title);

        return obj.toString();

    }

    public static String updateEmployeePayLoadJson() {

        JSONObject obj = new JSONObject();
        obj.put("employee_id", "57574A");
        obj.put("emp_firstname","anushervon");
        obj.put("emp_lastname","odilov");
        obj.put("emp_middle_name","ao");
        obj.put("emp_gender","M");
        obj.put("emp_birthday","2000-03-03");
        obj.put("emp_status","Offered");
        obj.put("emp_job_title","SDET");

        return obj.toString();

    }

}
