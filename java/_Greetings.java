class Person {
    String name;
    int age;

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public void greet(){
        System.out.println("Hi I'm "+name+ "\n and I'm "+age+"years old");    
    }
}

class Hello {
    public static void main(String args[]){
        System.out.print("Hello World!");
    }
}

public class _Greetings {

    public static void main(String[] args) {
        // Create a Person object
        Person likhit = new Person("Likhit", 21);
        // Print Likhit's information
        likhit.greet();

        Hello.main(null);  // static classes can be called directly 
                                // since no need of args we can give null - empty array ('new String[0]')
    }
}

