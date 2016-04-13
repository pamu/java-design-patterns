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

### Scala to the rescue

Scala provides `Object` keyword to create a singleton object and cuts lot of complexity and errors

```scala

  object Singleton {

  }

```

Scala runtime ensures that there is only one object of `Singleton`.
