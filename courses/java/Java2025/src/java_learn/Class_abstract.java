package java_learn;

public class Class_abstract {
// abstract class Animal

  abstract class Animal {
   abstract String cry(); // the method fit for all animals, but the implementation is different for each animal
  }

  // son class 1 : Baby
  class Baby extends Animal { 
    @Override
    String cry() {
      return "Wa wa wa";
     }
    }

    // son class 2 : Dog
    class Dog extends Animal {
      @Override
      String cry() {
        return "Woof woof";
      }
    }

      // son class 3 : Crow
      class Crow extends Animal {
        @Override
        String cry() {
          return "Caw caw";
        }
      }
      class Trainer {
        public void makeAnimalCry(Animal animal) {
          System.out.println(animal.cry());
        }
      } 
    }

    public class Main {
      public static void main(String[] args) {
        Class_abstract ca = new Class_abstract();
        Class_abstract.Trainer trainer = ca.new Trainer();

        Class_abstract.Baby baby = ca.new Baby();
        Class_abstract.Dog dog = ca.new Dog();
        Class_abstract.Crow crow = ca.new Crow();

        trainer.makeAnimalCry(baby); // Output: Wa wa wa
        trainer.makeAnimalCry(dog);  // Output: Woof woof
        trainer.makeAnimalCry(crow); // Output: Caw caw
      }
    }
  