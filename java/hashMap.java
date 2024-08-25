
import java.util.HashMap;

public class hashMap {
    public static void main(String[] args) {
        HashMap<String, Integer> employeeIds = new HashMap<>(); 

        // PUT
        // if the same key is put agina with diff value then it'll overide the value.
        employeeIds.put("John", 101);
        employeeIds.put("Frankie", 102);
        employeeIds.put("Chaitanya", 103);
        employeeIds.put("Rishav", 104);
        System.out.println(employeeIds);

        // GET
        System.out.println(employeeIds.get("Chaitanya"));
        
        // CONTAINS
        System.out.println( employeeIds.containsKey("John") );
        System.out.println( employeeIds.containsKey("Manjunath") );

        // using   PUT   to replace 'value'
        employeeIds.put("Rishav", 777);
        System.out.println(employeeIds);

        // REPLACE   key/value
        employeeIds.replace("Frankie", 888);
        System.out.println(employeeIds);

        // cannot replace non-existant key
        employeeIds.replace("U_S_E_R", 888);
        System.out.println(employeeIds);

        // PUT_IF_ABSENT
        employeeIds.putIfAbsent("Chaitanya", 000); // already exists
        System.out.println("-"+employeeIds);
        employeeIds.putIfAbsent("Ben10", 000); // new key-value pair
        System.out.println(employeeIds);

        // REMOVE
        employeeIds.remove("Frankie");
        System.out.println(employeeIds);
    }
}
