public class ConstructorExamples {
    
    public static int MAIN_INSTANCE_COUNT = 0;

    public String instanceVar;

    public ConstructorExamples() {
        System.out.println("Hi, I'm a no argument constructor.");
        this.instanceVar = "I'm an instance variable in no Arg main.";
        MAIN_INSTANCE_COUNT++;
    }

    public ConstructorExamples(int arg) {
        System.out.println("Hi, I'm a single argument constructor.");
        this.instanceVar = "I'm an instance variable in one Arg main.";
        MAIN_INSTANCE_COUNT++;
    }

    public ConstructorExamples(boolean arg1, double arg2, int... args) {
        System.out.println("Hi, I'm a multi argument constructor.");
        this.instanceVar = "I'm an instance variable in multi Arg main.";
        MAIN_INSTANCE_COUNT++;
    }

    public static void main(String[] args) {

        System.out.println("Hello new programmers.");

        ConstructorExamples noArgMainObj = new ConstructorExamples();
        System.out.println(noArgMainObj.instanceVar);
        System.out.println("We created " + ConstructorExamples.MAIN_INSTANCE_COUNT + " instance objects.");
        System.out.println();

        ConstructorExamples notNewMainObj = noArgMainObj;
        System.out.println("notNewMainObj did not create a new instance of Main.");
        System.out.println(notNewMainObj.instanceVar);
        System.out.println("We created " + ConstructorExamples.MAIN_INSTANCE_COUNT + " instance objects.");
        System.out.println();

        ConstructorExamples oneArgMainObj = new ConstructorExamples(1);
        System.out.println(oneArgMainObj.instanceVar);
        System.out.println("We created " + ConstructorExamples.MAIN_INSTANCE_COUNT + " instance objects.");
        System.out.println();

        ConstructorExamples multiArgMainObj = new ConstructorExamples(true, 1.5, 1, 2, 3);
        System.out.println(multiArgMainObj.instanceVar);

        System.out.println("We created " + ConstructorExamples.MAIN_INSTANCE_COUNT + " instance objects.");

    }
}

interface ExampleInterface {

}

class ExampleSuperClass {

    public ExampleSuperClass() {

    }
}

class ExampleSubClass {

    public ExampleSubClass() {

    }
}
