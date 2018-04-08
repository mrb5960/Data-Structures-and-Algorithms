package com.ctci.dynamic;

public class DerivedClass extends BaseClass{
	public String str = "Derived class";
	public void print(){
		System.out.println("I am in derived class");
		System.out.println(str);
	}
	public static void main(String[] args) {
		BaseClass bc1 = new BaseClass();
		bc1.func();
		BaseClass bc2 = new DerivedClass();
		bc2.func();
		// compile time exception: cannot convert from BaseClass to DerivedClass
		//DerivedClass bc3 = (BaseClass)new DerivedClass();
		//bc3.print();
		// runtime exception: java.lang.ClassCastException
		//DerivedClass dc1 = (DerivedClass)new BaseClass();
		//dc1.print();
	}

}

interface NewInterface{
	final int var = 10;
	public void func();
}

class BaseClass implements NewInterface{
	public String str = "Base class";
	public void print(){
		System.out.println("I am in base class");
		System.out.println(str);
		System.out.println(var);
	}
	@Override
	public void func() {
		System.out.println("Inside func");
	}
}
