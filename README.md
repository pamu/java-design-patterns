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
