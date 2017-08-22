/*
public class Person {
    private String name;
    private int age;
    private static int numPeople = 0;
    
    public Person() {
        this("UNKNOWN", 0);
    }
    
    public Person(String name, int age){
        this.name = name;
        this .age = age;
        numPeople++;
    }
    
    //getters
    
    public String getName() { return name;}
    public int getAge() { return age;}
    public int numPeople() { return numPeople;}
    
    public String toString(){
        String s = "Person: ";
        s += this.getName();
        s += " ";
        s += this.getAge();
        return s;
    }
    
    public static void main(String[] args) {
        System.out.println("Testing constructors");
        Person p1 = new Person();
        System.out.println(p1);
        //System.out.println(p1.getName() + " " + p1.getAge());
        Person p2 = new Person("Bob", 10);
        System.out.println(p2);
        
        System.out.println("Testing getters");
        boolean passedAllTest = true;
        //unit tests, automated tests
        if (!p1.getName().equals("UNKNOWN")) passedAll Tests = false;
        if (!p2.getName().equals("Bob")) passedAll Tests = false;
        if (passedAllTests)
        System.out.println(getName(): passed);
        else
            System.out.println("getName(): FAILED");
        
        System.out.println(p1.getNumPeople());
        //IF you make numPeople static, you can call Person.getNumPeople and
        //get the same answer
    }
    */