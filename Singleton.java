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

class DataSource {
  private static DataSource dataSource;
  private DataSource() {}
  public static DataSource getInstance() {
    if (dataSource == null) dataSource = new DataSource();
    return dataSource;
  }
}
