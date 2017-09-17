/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
abstract class Animal{
	String name;
	int order;
	public Animal(String name){
		this.name = name;
	}
	public void setOrder(int order){
		this.order = order;
	}
	public int getOrder(){
		return order;
	}
	public boolean isOlderThan(Animal a){
		return this.order > a.getOrder();
	}
}
class AnimalQueue{
	LinkedList<Dog> dogs = new LinkedList<Dog>();
	LinkedList<Cat> cats = new LinkedList<Cat>();
	int order;
	public void enqueue(Animal a){
		a.setOrder(order);
		order++;
		if(a instanceof Dog){
			dogs.addLast((Dog) a);
		}
		if(a instanceof Cat){
			cats.addLast((Cat) a);
		}
	}
	public Animal dequeueAny(){
		if(dogs.size() == 0){
			return dequeueCats();
		}
		if(cats.size() == 0){
			return dequeueDogs();
		}
		Dog dog = dogs.peek();
		Cat cat = cats.peek();
		if(dog.isOlderThan(cat)){
			return dequeueDogs();
		}
		else{
			return dequeueCats();
		}
	}
	public Dog dequeueDogs(){
		return dogs.poll();
	}
	public Cat dequeueCats(){
		return cats.poll();
	}
}
class Dog extends Animal{
	public Dog(String name){
		super(name);
	}
}
class Cat extends Animal{
	public Cat(String name){
		super(name);
	}
}
class AnimalHelper{
	public static void main(String[] args){
		AnimalQueue aq = new AnimalQueue();
		aq.enqueue(new Dog("d1"));
		aq.enqueue(new Cat("c1"));
		aq.enqueue(new Dog("d2"));
		aq.enqueue(new Dog("d3"));
		aq.enqueue(new Cat("c2"));
		aq.enqueue(new Cat("c3"));
		aq.enqueue(new Dog("d4"));
		System.out.println(aq.dequeueAny().name);
		System.out.println(aq.dequeueDogs().name);
		System.out.println(aq.dequeueDogs().name);
		System.out.println(aq.dequeueCats().name);
		System.out.println(aq.dequeueDogs().name);
	}
}