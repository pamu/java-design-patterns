public class StrategyPattern {
  public static void main(String ... args) {
    SortUtils sortUtils = new SortUtils();
    sortUtils.sortItems(new QuickSort());
    sortUtils.sortItems(new MergeSort());
  }
}

class SortUtils {
  void sortItems(Sorting sortingMethod)  {
    sortingMethod.sort();
  }
}

interface Sorting  {
  void sort();
}

class QuickSort implements Sorting {
  public void sort() { System.out.println("QuickSorting");}
}

class MergeSort implements Sorting {
  public void sort() { System.out.println("MergeSorting");}
}
