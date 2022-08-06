public class Bat extends Mammal {
    public Bat() {
        super();
        this.energy = 300;
    }
    public void fly() {
        System.out.println("Flap! Flap! Flap!");
        this.energy -= 50;
    }
    public void eatHumans() {
        this.energy += 25;
    }
    public void attackTown() {
        System.out.println("Burnnnnnn!");
        this.energy -= 100;
    }
}