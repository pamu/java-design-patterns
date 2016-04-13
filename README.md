# Java Design Patterns

## Singleton Pattern

```java


  class DataSource {
    //Nobody can create this object using new operator
    private static DataSource dataSource;
    private DataSource() {}
    public static DataSource getInstance() {
      if (dataSource == null) dataSource = new DataSource();
      return dataSource;
    }
  }

```


```java
  public class Singleton {
    public static void main(String ... args) {
      //DataSource ds = new DataSource(); Compilation Error
      DataSource ds1 = DataSource.getInstance();
      DataSource ds2 = DataSource.getInstance();
      if (ds1.hashCode() == ds2.hashCode()) {
        System.out.println("Same hashCode");
      } else {
        System.out.println("Different hashCode");
      }
    }
  }
```

## Caveats

Ensure thread safety.

Multi threaded access may lead to multiple objects.

[Can the object be created using java reflection in case of private constructor](http://stackoverflow.com/questions/2599440/how-can-i-access-a-private-constructor-of-a-class)


### Warning

Class having a private constructor can be instantiated using reflection in java

This can be achieved using reflection.

Consider for a class Test, with a private constructor:

```java

  Constructor<?> constructor  = Test.class.getDeclaredConstructor(Context.class, String[].class);
  Assert.assertTrue(Modifier.isPrivate(constructor.getModifiers()));
  constructor.setAccessible(true);
  Object instance = constructor.newInstance(context, (Object)new String[0]);

```

```java

  import java.lang.reflect.Constructor;

  public class Example {
    public static void main(final String[] args) throws Exception {
      Constructor<Foo> constructor = Foo.class.getDeclaredConstructor(new Class[0]);
      constructor.setAccessible(true);
      Foo foo = constructor.newInstance(new Object[0]);
      System.out.println(foo);
    }
  }

  class Foo {
    private Foo() {
      // private!
    }

    @Override
    public String toString() {
      return "I'm a Foo and I'm alright!";
    }
  }

```

### Scala to the rescue

Scala provides `Object` keyword to create a singleton object and cuts lot of complexity and errors

```scala

  object Singleton {

  }

```

Scala runtime ensures that there is only one object of `Singleton`.

## Decorator Pattern

Decorator Pattern adds extra functionality to the plain inner core object of some type.

For example a `Cat` can be made into a `Shiny Cat` which glows

Another example is, a `PlainSoda` can be made into a `SweetSoda` with better taste and added cost :P.

Decorator.java
```java

  public class Decorator {
    public static void main(String ... args) {
      CoolDrink coolDrink = new ChilledSoda(new SweetSoda(new PlainSoda()));
      System.out.println(coolDrink.taste());
      System.out.println(coolDrink.cost());
    }
  }

```

Lets take a cool drink which is a Soda and add a quality called as `chilled` and then make it sweet

interface `CoolDrink`
```java
  interface CoolDrink {
    String taste();
    float cost();
  }
```
Above interface has two methods `taste` and `cost`


PlainSoda.java
```java
  class PlainSoda implements CoolDrink {

    public PlainSoda() {
    }

    public String taste() {
      return "Soda";
    }

    public float cost() {
      return 10;
    }

  }
```

Note: `PlainSoda` implements `CoolDrink` but do not take any parameters through the constructor.


ChilledSoda.java
```java
  class ChilledSoda implements CoolDrink {
    CoolDrink coolDrink;

    public ChilledSoda(CoolDrink coolDrink) {
      this.coolDrink = coolDrink;
    }

    public String taste() {
      return "Chilled " + coolDrink.taste();
    }

    public float cost() {
      return 10 +  coolDrink.cost();
    }
  }
```

`ChilledSoda` implements `CoolDrink` and has a constructor which can take other coolDrink. this is how it improves the behavior of the coolDrink inside it.

Same with `SweetSoda`. `SweetSoda` takes other coolDrink inside and then add more functionality to it.

SweetSoda.java
```java
  class SweetSoda implements CoolDrink {

    CoolDrink coolDrink;

    public SweetSoda(CoolDrink coolDrink) {
      this.coolDrink = coolDrink;
    }

    public String taste() {
      return "Sweet " + coolDrink.taste();
    }

    public float cost() {
      return 10 +  coolDrink.cost();
    }

  }
```
