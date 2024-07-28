// Product interface
interface Pet {
    String careInstructions();
}

// Concrete products
class Dog implements Pet {
    public String careInstructions() {
        return "Feed twice a day, walk daily.";
    }
}

class Cat implements Pet {
    public String careInstructions() {
        return "Feed thrice a day, clean litter box.";
    }
}

// Factory interface
interface PetFactory {
    Pet createPet();
}

// Concrete factories
class DogFactory implements PetFactory {
    public Pet createPet() {
        return new Dog();
    }
}

class CatFactory implements PetFactory {
    public Pet createPet() {
        return new Cat();
    }
}

// Usage
public class Test3 {
    public static void main(String[] args) {
        PetFactory dogFactory = new DogFactory();
        Pet dog = dogFactory.createPet();
        System.out.println("Dog: " + dog.careInstructions());

        PetFactory catFactory = new CatFactory();
        Pet cat = catFactory.createPet();
        System.out.println("Cat: " + cat.careInstructions());
    }
}