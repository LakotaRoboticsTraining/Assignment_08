# Lesson 8: Constructors

Goal: Write constructors that set up an object’s fields when you call new.

Time: About 30-40 minutes

You will learn:

- What a constructor is
- How a constructor’s name and job differ from a normal method
- Default constructor vs a constructor you write
- Constructor parameters
- Using this to tell field names from parameter names
- Overloading constructors (more than one constructor)
### Why this matters for robots

```java
When robot code does new ShootCommand() or builds a subsystem, a constructor runs first. That is where requirements are added, motors are configured, and starting values are set. If construction is wrong, the robot misbehaves before teleop even starts.
```

### The big idea

A constructor is special code that runs when the object is created.

```java
Motor left = new Motor("left", 0.0);
```



```java
new Motor("left", 0.0) calls a constructor and can set side and speed immediately.
```

### Constructor vs method

```java
public class Motor {
    String side;
    double speed;
```

```java
    public Motor(String side, double speed) {
        this.side = side;
        this.speed = speed;
    }
```

```java
    public void report() {
        System.out.println(side + " motor speed = " + speed);
    }
}
```



### Default constructor

```java
If you write no constructor, Java gives you an empty default one: new Motor() still works, and fields get default values (0, false, null).
```

If you write any constructor, Java does not add the empty one unless you write it too.

### this

this means this object.

```java
public Motor(String side, double speed) {
    this.side = side;     // field = parameter
    this.speed = speed;
}
```



Without this, side = side would only assign the parameter to itself. this.side is clearly the field.

### Overloading constructors

You can have more than one constructor if the parameter lists differ (same idea as overloaded add in Lesson 6).

```java
public Motor() {
    this.side = "unknown";
    this.speed = 0.0;
}
```

```java
public Motor(String side, double speed) {
    this.side = side;
    this.speed = speed;
}
```



```java
Motor spare = new Motor();
Motor left = new Motor("left", 0.5);
```



### Using the object after construction

```java
public class Main {
    public static void main(String[] args) {
        Motor left = new Motor("left", 0.5);
        left.report();
    }
}
```



You should not need a chain of left.side = ... lines if the constructor did its job.

### Common mistakes

1. Writing a return type on a constructor (void Motor() is a method, not a constructor)

2. Name not matching the class

3. Forgetting this. when parameters shadow field names

```java
4. Calling new Motor() after you only wrote Motor(String, double) - no no-arg constructor exists
```

5. Doing heavy work in main that belongs in the constructor

## Try it yourself

`Game` is provided. Your job is to write `Arcade` and use it from `Main`.

### Challenge 1 - Construct an Arcade

Class `Arcade` with private `String name`, `String type`, `int year`.

- Constructor `Arcade(String name, String type, int year)` that stores the values
- Method `describe()` that prints the name, type, and year

### Challenge 2 - this + setters/getters

Name constructor parameters the same as the fields and use `this.field = field`.  
Add getters and setters for all three fields.

### Challenge 3 - Wire it up in main

In `Main`:

1. `new Arcade("Arcade of Legions", "Variety", 1982)` and call `describe()`
2. Create `Game("Pokemon", 1996, "RPG")` and `Game("Spaceball", 1986, "Pinball")`
3. Print both games (for example with `toString()`)

### Bonus - ConstructorExamples demo

Also in this repo: ConstructorExamples.java shows overloaded constructors (no-arg, one-arg, multi-arg). Study it and run ConstructorExamplesTest - it checks that multiple constructors exist and a no-arg constructor creates an instance. Your graded challenges above are the Arcade work.

### Check your understanding

1. When does a constructor run?

2. Does a constructor have a return type?

3. What does this.speed mean?

```java
4. If you write only Motor(String, double), can you still call new Motor()?
```

Answers

```java
1. When you use new to create that object.
```

2. No, a constructor does not have a return type.

3. The speed field on this object.

4. No - Java will not invent the empty constructor once you wrote another one.

### Looking ahead

In Lesson 9, you will use inheritance so one class can reuse and extend another - the same idea behind WPILib types like Command and Subsystem.

Lesson complete. When you can write a constructor with parameters and this, you are ready for Lesson 9.
