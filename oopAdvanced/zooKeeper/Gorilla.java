public class Gorilla extends Mammal {
	
	public Gorilla() {
		super();
	}

	public void throwSomething() {
		System.out.println("This gorilla threw something.");
		this.energy -= 5;
	}
	public void eatBananas() {
		System.out.println("This gorilla is enjoying bananas.");
		this.energy += 10;
	}
	public void climb() {
		System.out.println("This gorilla is climbing a tree.");
		this.energy -= 10;
	}
}