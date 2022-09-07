public class Person {
    protected String name;
    protected String email;
    protected String mobileNumber;

    Person(){
        this("Undefined","Undefined","-1");
    }

    public Person(String name, String email, String mobileNumber) {
        this.name = name;
        this.email = email;
        this.mobileNumber = mobileNumber;
    }
}
