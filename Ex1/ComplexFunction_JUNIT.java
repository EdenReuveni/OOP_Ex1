package Ex1;

import static org.junit.Assert.*;
/*import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;*/
import org.junit.jupiter.api.Test;

class ComplexFunction_JUNIT {
	public static final double EPS = 0.00001;

/*	@Test
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
	@Test
	void testToString() {
		Polynom p1=new Polynom("3x^5+2x-1");
		Polynom p2=new Polynom("x^2-3x+11");
		ComplexFunction cf=new ComplexFunction(p1, p2, "plus");
		String expected="plus(3.0x^5+2.0X-1.0,1.0X^2-3.0X+11.0)";
		String actuel=cf.toString();
		assertFalse("check toString function: ",!expected.equalsIgnoreCase(actuel));
	}
	
	/////?????????????????
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
	@Test
	void testEquals() {
		Polynom p1=new Polynom("2x^3+3x+2");
		Polynom p2=new Polynom("1.9999999x^2-x");
		ComplexFunction cf=new ComplexFunction(p1, p2, "max");
		ComplexFunction cf2=new ComplexFunction(p1, p2, Operation.Max);
		assertTrue("check equals: ",cf.equals(cf2));
			
		}
	
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
	@Test
	void testDiv() {
		Polynom p1=new Polynom("3x^5+2x-1");
		Polynom p2=new Polynom("x^2-3x+11");
		ComplexFunction cf=new ComplexFunction(p1, p2, "div");
		cf.mul(p2);
		assertTrue("check dic function: ",cf.equals(p1));
	}
	@Test
	void testMax() {
		Polynom p1=new Polynom("x^3+x");
		function p2=new Polynom ("2");
		ComplexFunction cf=new ComplexFunction(p1, p2, "max");
		if((cf.f(1)!=p2.f(1))|| Math.abs(cf.f(-1))!=Math.abs(p2.f(-1)))
			fail("max failed");
	}
	@Test
	void testMin() {
		Polynom p1=new Polynom("x^3+x");
		function p2=new Polynom ("2");
		ComplexFunction cf=new ComplexFunction(p1, p2, "min");
		assertTrue(cf.f(1)==p2.f(1));
		assertTrue(Math.abs(cf.f(-1))==Math.abs(p2.f(-1)));
	}
	@Test
	void testPlus() {
		Polynom p1=new Polynom("3x^5+2x-1");
		Polynom p2=new Polynom("x^2-3x+11");
		ComplexFunction cf=new ComplexFunction("plus", p1, p2);
		assertTrue(cf.f(1)==13);
	}	
	@Test
	void testMul() {
		Polynom p1=new Polynom("3x^5+2x-1");
		Polynom p2=new Polynom("x^2-3x+11");
		ComplexFunction cf=new ComplexFunction(p1, p2, "mul");
		cf.div(p2);
		assertTrue("check mul function: ",p1.equals(cf));
	}
	@Test
	void testComp() {
		Polynom p1=new Polynom("3x^2+x");
		Polynom p2=new Polynom("x+1");
		ComplexFunction cf=new ComplexFunction(p1, "comp", p2);
		assertTrue("check comp function ",cf.f(2)!=30);
		
	}
	
	@Test
	void testGetOP() {
		Polynom p1=new Polynom("3x^5+2x-1");
		Polynom p2=new Polynom("x^2-3x+11");
		ComplexFunction cf=new ComplexFunction(p1, p2, "");
		assertTrue("check getOP function: ",cf.getOp().equals(Operation.None));
		ComplexFunction cf1=new ComplexFunction(p1, p2, "skdj");
		assertTrue("check getOP function: ",cf1.getOp().equals(Operation.Error));
		ComplexFunction cf2=new ComplexFunction(p1, p2, "mul");
		assertTrue("check getOP function: ",cf2.getOp().equals(Operation.Times));

	}*/
	@Test
	void testRightFunctionNull() {
		Polynom p1=new Polynom("3x^5+2x-1");
		Polynom p2=new Polynom("");
		Polynom p3=null;
		ComplexFunction cf=new ComplexFunction(p1, p2, "");
		try {
		ComplexFunction cf1=new ComplexFunction(p1, p2, "plus");
		}catch (Exception e) {
			fail("complex function did not need to throw an exeption");

		}
		try {
		ComplexFunction cf2=new ComplexFunction(p1, p3, "");
		fail("complex function was not created");

		}catch (Exception e) {
			
		}
		try {
		ComplexFunction cf3=new ComplexFunction(p1, p3, "mul");
		fail("complex function was not created");
		}
		catch (Exception e) {
		}
		
	}

}
