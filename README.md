# java-design-patterns
Java Design Patterns

## Singleton Pattern

```java


  class DataSource {
    //Nobody can create this object using new operator
    private static DataSource dataSource;
    private DataSource() {}
    //Ensure thread safety
    public static DataSource getInstance() {
      if (dataSource == null) dataSource = new DataSource();
      return dataSource;
    }
  }

```

## Main problem to run

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
