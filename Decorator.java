public class Decorator {
  public static void main(String ... args) {
   CoolDrink coolDrink = new ChilledSoda(new SweetSoda(new PlainSoda()));
   System.out.println(coolDrink.taste());
   System.out.println(coolDrink.cost());
  }
}

interface CoolDrink {
  String taste();
  float cost();
}

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
