package Ex1Testing;

import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;

import Ex1.ComplexFunction;
import Ex1.Monom;
import Ex1.Operation;
import Ex1.Polynom;
import Ex1.function;

class ComplexFunctionTest {
	public static final double EPS = 0.00001;
/**
 * Testing left() function.
 */
	@Test
	void testLeft() {
		Monom m1 = new Monom(2,3);
		Monom m2 = new Monom(3,2);
		ComplexFunction cf = new ComplexFunction("mul", m2,m1);
		cf.plus(m1);
		function f=(function) cf.left();
		if (f instanceof Monom) {
			Monom m=(Monom)f;
			assertTrue(m.equals(m1));
		}
	}
	/**
	 * Testing right() function.
	 */
	@Test
	void testRight() {
		Monom m1 = new Monom(2,3);
		Monom m2 = new Monom(3,2);
		ComplexFunction cf = new ComplexFunction("mul", m2,m1);
		cf.plus(m1);
		function f=(function) cf.right();
		if (f instanceof Monom) {
			Monom m=(Monom)f;
			assertTrue("check right function: ",m.equals(m1));
		}
	}
	/**
	 * Testing f(x) function.
	 */
	@Test
	void testF() {
		Polynom p1=new Polynom("3x^5+2x-1");
		Polynom p2=new Polynom("x^2-3x+11");
		ComplexFunction cf=new ComplexFunction(p1, p2, Operation.Divid);
		double expected=p1.f(5)/p2.f(5);
		double actuel =cf.f(5);
		if(expected!=actuel)
			fail("f(x) test failed");
	}
	/**
	 * Testing toString() function.
	 */
	@Test
	void testToString() {
		Polynom p1=new Polynom("3x^5+2x-1");
		Polynom p2=new Polynom("x^2-3x+11");
		ComplexFunction cf=new ComplexFunction(p1, p2, "plus");
		String expected="plus(3.0x^5+2.0X-1.0,1.0X^2-3.0X+11.0)";
		String actuel=cf.toString();
		assertFalse("check toString function: ",!expected.equalsIgnoreCase(actuel));
	}
	
	/**
	 * Testing Init From String(String) function.
	 */
	@Test
	void testInitFromString() {
		Polynom p1=new Polynom("x^2+3x-5");
		Polynom p2=new Polynom("3x^2-7x");
		ComplexFunction cf=new ComplexFunction(p1, p2, "div");
		function cf1=cf.initFromString("plus(min(x,2x),max(3x^2+7x, 120))");
		Polynom p3=new Polynom("x");
		Polynom p4=new Polynom("2x");
		Polynom p5=new Polynom("3x^2+7x");
		Polynom p6=new Polynom("120");
		ComplexFunction cf2=new ComplexFunction(p3, p4, "min");
		ComplexFunction cf3=new ComplexFunction(p5, p6, "max");
		ComplexFunction cf4=new ComplexFunction(cf2, cf3, "plus");
		if(!cf4.equals(cf1))
			fail("init from string failed");
	}
	
	/**
	 * Testing equals(Object) function.
	 */
	@Test
	void testEquals() {
		Polynom p1=new Polynom("2x^3+3x+2");
		Polynom p2=new Polynom("1.9999999x^2-x");
		Polynom p3=new Polynom("x");
		Polynom p4=new Polynom("x^2");
		Polynom p5=new Polynom("1");
		ComplexFunction cf=new ComplexFunction(p1, p2, "max");
		ComplexFunction cf2=new ComplexFunction(p1, p2, Operation.Max);
		ComplexFunction cf3=new ComplexFunction(p5,"div",p3);
		ComplexFunction cf4=new ComplexFunction("div",p3,p4);
		assertTrue("check equals: ",cf.equals(cf2));
		assertTrue("check equals with a value: ", cf3.f(1000)==cf4.f(1000));
	}

	/**
	 * Testing copy(Complex Function) function.
	 */
	@Test
	void testCopy() {
		Polynom p1=new Polynom("3x^5+2x-1");
		Polynom p2=new Polynom("x^2-3x+11");
		ComplexFunction cf=new ComplexFunction(p1, p2, "mul");
		function cfcopy=cf.copy();
		if(!cfcopy.equals(cf))
			fail("should be equals");
		if(cfcopy instanceof ComplexFunction)
			((ComplexFunction)cfcopy).plus(p1);
		if(cfcopy.equals(cf))
			fail("should be differente");
	}
	
	/**
	 * Testing div(function) function.
	 */
	@Test
	void testDiv() {
		Polynom p1=new Polynom("3x^5+2x-1");
		Polynom p2=new Polynom("x^2-3x+11");
		ComplexFunction cf=new ComplexFunction(p1, p2, "div");
		cf.mul(p2);
		assertTrue("check div function: ",cf.equals(p1));
	}
	
	/**
	 * Testing Max(function) function.
	 */
	@Test
	void testMax() {
		Polynom p1=new Polynom("x^3+x");
		function p2=new Polynom ("2");
		ComplexFunction cf=new ComplexFunction(p1, p2, "max");
		if((cf.f(1)!=p2.f(1))|| Math.abs(cf.f(-1))!=Math.abs(p2.f(-1)))
			fail("max failed");
	}
	
	/**
	 * Testing Min(function) function.
	 */
	@Test
	void testMin() {
		Polynom p1=new Polynom("x^3+x");
		function p2=new Polynom ("2");
		ComplexFunction cf=new ComplexFunction(p1, p2, "min");
		assertTrue(cf.f(1)==p2.f(1));
		assertTrue(Math.abs(cf.f(-1))==Math.abs(p2.f(-1)));
	}
	
	/**
	 * Testing plus(function) function.
	 */
	@Test
	void testPlus() {
		Polynom p1=new Polynom("3x^5+2x-1");
		Polynom p2=new Polynom("x^2-3x+11");
		ComplexFunction cf=new ComplexFunction("plus", p1, p2);
		assertTrue(cf.f(1)==13);
	}
	
	/**
	 * Testing mul(function) function.
	 */
	@Test
	void testMul() {
		Polynom p1=new Polynom("3x^5+2x-1");
		Polynom p2=new Polynom("x^2-3x+11");
		ComplexFunction cf=new ComplexFunction(p1, p2, "mul");
		cf.div(p2);
		assertTrue("check mul function: ",p1.equals(cf));
	}
	
	/**
	 * Testing comp(function) function.
	 */
	@Test
	void testComp() {
		Polynom p1=new Polynom("3x^2+x");
		Polynom p2=new Polynom("x+1");
		ComplexFunction cf=new ComplexFunction(p1, "comp", p2);
		assertTrue("check comp function ",cf.f(2)!=30);

	}

	/**
	 * Testing getOp() function.
	 */
	@Test
	void testGetOP() {
		Polynom p1=new Polynom("3x^5+2x-1");
		Polynom p2=new Polynom("x^2-3x+11");
		ComplexFunction cf1=new ComplexFunction(p1, p2, "skdj");
		assertTrue("check getOP function: ",cf1.getOp().equals(Operation.Error));
		ComplexFunction cf2=new ComplexFunction(p1, p2, "mul");
		assertTrue("check getOP function: ",cf2.getOp().equals(Operation.Times));
	}
	/**
	 * Testing the cases of rightFunc=null.
	 */
	@Test
	void testRightFunctionNull() {
		Polynom p1=new Polynom("3x^5+2x-1");
		function f = null;
		ComplexFunction cf=new ComplexFunction(p1, f,Operation.None);
		try {
			ComplexFunction cf1=new ComplexFunction(p1, f, "plus");
		}catch (Exception e) {
			fail("complex function did not need to throw an exeption");

		}
	}

}