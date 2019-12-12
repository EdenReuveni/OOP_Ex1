package Ex1;


import Ex1.complex_function;


/**
 * this class represents a complex function that have a left and right branches, with an operator in the middle.
 * each branch can be a complex function by itself.
 * @author Eden Reuveni
 * @author Noa Aizer
 *
 */
public class ComplexFunction implements complex_function{
	private function leftFunc;
	private function rightFunc;
	private Operation op;

	/**
	 * constructor for building a new complex function
	 * the operator is of type Operator and is the first of the variables
	 * @param op is the given operator 
	 * @param left is the given left function
	 * @param right is the given right function
	 */
	public ComplexFunction(Operation op,function left, function right) {
		constructorHelper(left, right, op);
	}
	/**
	 * constructor for building a new complex function
	 * the operator is of type Operator and is the second of the variables
	 * @param op is the given operator 
	 * @param left is the given left function
	 * @param right is the given right function
	 */
	public ComplexFunction(function left,Operation op, function right) {
		constructorHelper(left, right, op);
	}
	/**
	 * constructor for building a new complex function
	 * the operator is of type Operator and is the third of the variables
	 * @param op is the given operator 
	 * @param left is the given left function
	 * @param right is the given right function
	 */
	public ComplexFunction(function left, function right, Operation op) {
		constructorHelper(left, right, op);
	}
	/**
	 * constructor for building a new complex function
	 * the operator is of type String and is the first of the variables
	 * @param new_op is the given operator 
	 * @param left is the given left function
	 * @param right is the given right function
	 */
	public ComplexFunction(String new_op, function left, function right) {
		constructorHelper(left, right, operatorBuilder(new_op));
	}
	/**
	 * constructor for building a new complex function
	 * the operator is of type String and is the second of the variables
	 * @param new_op is the given operator 
	 * @param left is the given left function
	 * @param right is the given right function
	 */
	public ComplexFunction(function left, String new_op, function right) {
		constructorHelper(left, right, operatorBuilder(new_op));
	}
	/**
	 * constructor for building a new complex function
	 * the operator is of type String and is the third of the variables
	 * @param new_op is the given operator 
	 * @param left is the given left function
	 * @param right is the given right function
	 */
	public ComplexFunction(function left, function right, String new_op) {
		constructorHelper(left, right, operatorBuilder(new_op));
	}
	/**
	 * constructor for building a new complex function from a monom
	 * @param monom is the given monom
	 */
	public ComplexFunction(Monom monom) {
		this.leftFunc=monom;
		this.rightFunc=null;
		this.op=Operation.None;
	}
	/**
	 * constructor for building a new complex function from a polynom
	 * @param polynom is the given polynom
	 */
	public ComplexFunction(Polynom polynom) {
		this.leftFunc=polynom;
		this.rightFunc=null;
		this.op=Operation.None;
	}
	public ComplexFunction(ComplexFunction cf) {
		this.leftFunc=cf.leftFunc.copy();
		this.rightFunc=cf.rightFunc.copy();
		this.op=cf.getOp();
	}
	public ComplexFunction(function f) {
		if(f instanceof Monom)
			new ComplexFunction((Monom)f);
		else if(f instanceof Polynom)
			new ComplexFunction((Polynom)f);
		else if(f instanceof ComplexFunction) {
			ComplexFunction cf= (ComplexFunction)f.copy();
			this.leftFunc=cf.leftFunc;
			this.rightFunc=cf.rightFunc;
			this.op=cf.getOp();
		}
		else throw new RuntimeException("ERROR: The object type is invalid");
	}
	
	public ComplexFunction() {
	}

	/**
	 * constructor to build a new complax function
	 * each constructor is using this one to fit the given parameters to this order
	 * (left, right, operator) 
	 * @param left is the given left function
	 * @param right is the given right function
	 * @param new_op is the given operator
	 */
	private void constructorHelper(function left, function right, Operation new_op) {
		if (right==null && new_op.equals(Operation.None)) {
			this.leftFunc=left.copy();
			this.rightFunc=right;
			this.op=new_op;
		}
		else if (right!=null && new_op.equals(Operation.None)) 
			throw new RuntimeException("ERROR: Right function should be null");
		else {	
			this.leftFunc=left.copy();
			this.rightFunc=right.copy();
			this.op=new_op;
		}
	}
	/**
	 * function to convert a string representing an operation to its enum value
	 * @param new_op is the given string
	 * @return is the enum value of the operation
	 */
	private Operation operatorBuilder(String new_op) {
		new_op.toLowerCase();
		switch(new_op) {
		case "plus":
			return Operation.Plus;
		case "mul":
			return Operation.Times;
		case "div":
			return Operation.Divid;
		case "min":
			return Operation.Min;
		case "max":
			return Operation.Max;
		case "comp":
			return Operation.Comp;
		case "":
			return Operation.None;
		default:
			return Operation.Error;
		}
	}

	/** Add to this complex_function the f1 complex_function
	 * 
	 * @param f1 the complex_function which will be added to this complex_function.
	 */
	public void plus(function f1) {
		function temp=f1.copy();
		this.leftFunc= new ComplexFunction(this.leftFunc, this.rightFunc, this.op);
		this.rightFunc=temp;
		this.op=Operation.Plus;
	}
	/** Multiply this complex_function with the f1 complex_function
	 * 
	 * @param f1 the complex_function which will be multiply be this complex_function.
	 */
	public void mul(function f1) {
		function temp=f1.copy();
		ComplexFunction cf= new ComplexFunction(this.leftFunc, this.rightFunc, this.op);
		this.leftFunc= cf.copy();
		this.rightFunc=temp;
		this.op=Operation.Times;
	}
	/** Divides this complex_function with the f1 complex_function
	 * 
	 * @param f1 the complex_function which will be divid this complex_function.
	 */
	public void div(function f1) {
		function temp=f1.copy();
		this.leftFunc= new ComplexFunction(this.leftFunc, this.rightFunc, this.op);
		this.rightFunc=temp;
		this.op=Operation.Divid;
	}
	/** Computes the maximum over this complex_function and the f1 complex_function
	 * 
	 * @param f1 the complex_function which will be compared with this complex_function - to compute the maximum.
	 */
	public void max(function f1) {
		this.leftFunc= new ComplexFunction(this.leftFunc, this.rightFunc, this.op);
		this.rightFunc=f1.copy();
		this.op=Operation.Max;
	}
	/** Computes the minimum over this complex_function and the f1 complex_function
	 * 
	 * @param f1 the complex_function which will be compared with this complex_function - to compute the minimum.
	 */
	public void min(function f1) {
		function temp=f1.copy();
		this.leftFunc= new ComplexFunction(this.leftFunc, this.rightFunc, this.op);
		this.rightFunc=temp;
		this.op=Operation.Min;
	}
	/**
	 * This method wrap the f1 complex_function with this function: this.f(f1(x))
	 * @param f1 complex function
	 */
	public void comp(function f1) {
		function temp=f1.copy();
		this.leftFunc= new ComplexFunction(this.leftFunc, this.rightFunc, this.op);
		this.rightFunc=temp;
		this.op=Operation.Comp;
	}
	/** returns the left side of the complex function - this side should always exists (should NOT be null).
	 * @return a function representing the left side of this complex funcation
	 */
	public function left() {
		try {
			if (this.leftFunc==null)
				throw new RuntimeException("ERR left function should not be null");
		}
		catch (Exception e) {
			System.out.println("ERR left function should not be null");
		}
		return this.leftFunc;
	}
	/** returns the right side of the complex function - this side might not exists (aka equals null).
	 * @return a function representing the left side of this complex funcation
	 */
	public function right() {
		try {
			if(this.getOp().equals(Operation.None))
			{
				if(!this.rightFunc.equals(null))
					throw new RuntimeException("ERR right function should be null");
			}
			if (!this.getOp().equals(Operation.None)) {
				if (this.rightFunc.equals(null)) {
					throw new RuntimeException("ERR right function should be null");
				}
			}
		}
		catch (Exception e) {
			System.out.println("ERR right function should be null");
		}
		return this.rightFunc;
	}
	/**
	 * The complex_function oparation: plus, mul, div, max, min, comp
	 * @return
	 */
	public Operation getOp() {
		return this.op;
	}
	@Override
	public double f(double x) {
		try {
			if(this.leftFunc!=null) {
				switch(this.op) {
				case Plus:
					return leftFunc.f(x)+rightFunc.f(x);
				case Times:
					return leftFunc.f(x)*rightFunc.f(x);
				case Divid:
					return leftFunc.f(x)/rightFunc.f(x);
				case Min:
					return Math.min(leftFunc.f(x), rightFunc.f(x));
				case Max:
					return Math.max(leftFunc.f(x), rightFunc.f(x));
				case Comp:
					return leftFunc.f(rightFunc.f(x));
				case None:
					return leftFunc.f(x);
				default:
					throw new RuntimeException("ERR this operation " + this.op + " is undefined");
				}
			}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return Double.NaN;
		}
		return Double.NaN;
	}

	/**
	 * creates a function from a string
	 * @param s is the given string
	 * @return the complex function
	 */
	@Override
	public function initFromString(String s) {
		int counterForStart=0, counterForEnd=0,indexcomma=-1;
		s.toLowerCase();
		s=s.replace(" ", "");
		try {
			if (s.contains("(")) {
				String[] strStart=s.split("\\(",2);//split the string into 2 parts op and the rest;
				for (int i = 0; i < strStart[1].length(); i++) {// find the comma between the 2 functions
					if (strStart[1].charAt(i)=='(')
						counterForStart++;
					if (strStart[1].charAt(i)==')')
						counterForEnd++;
					if ((counterForEnd-counterForStart)==0&& strStart[1].charAt(i)==',') {//found the middle comma
						indexcomma=i;
						break;
					}
				}

				Operation op=operatorBuilder(strStart[0]);
				if(op.equals(Operation.Error))
					throw new RuntimeException();
				String leftFunc=strStart[1].substring(0,indexcomma);
				String rightFunc=strStart[1].substring(indexcomma+1,strStart[1].length()-1);
				return new ComplexFunction(initFromString(leftFunc), initFromString(rightFunc),op);
			}
			else {
				Polynom pol=new Polynom(s);
				return pol;
			}
		}
		catch(Exception e)
		{
			System.out.println("Error: The function "+ s +" is invalid!");
			return new ComplexFunction(null, null,Operation.None);
		}

	}
	/**
	 * copies a function
	 * @return the copy of the asked function
	 */
	@Override
	public function copy() {
		ComplexFunction cf;
		try {
			if(this.rightFunc==null)
				cf= new ComplexFunction(this.leftFunc.copy(),null, this.getOp());
			else
				cf= new ComplexFunction(this.leftFunc.copy(), this.rightFunc.copy(), this.getOp());
			return cf;
		}
		catch(Exception e) {
			return null;
		}

	}
	/**
	 * checks if two Objects are logically equals
	 * @return the boolean value of the question
	 */
	public boolean equals(Object obj) {
		if (obj instanceof ComplexFunction) {
			return visualEquals(this,(ComplexFunction)obj);
		}
		if (obj instanceof Monom) {
			ComplexFunction cf= new ComplexFunction(new Monom(obj.toString()));
			return visualEquals(this, cf);
		}
		if (obj instanceof Polynom) {
			ComplexFunction cf= new ComplexFunction(new Polynom(obj.toString()));
			return visualEquals(this, cf);
		}
		return false;
	}
	/**
	 * checks if the values of two complex functions equals- for the same index
	 * the method equals is using this method to answer the question.
	 * even thought this is not the perfect way to check it, but statistically it will be correct
	 * @param cf1 is the first complex function
	 * @param cf2 is the second complex function
	 * @return the boolean value of the question
	 */
	private  boolean visualEquals(ComplexFunction cf1, ComplexFunction cf2)
	{
		for (double i = -1; i < 1 ; i+=Monom.EPSILON) {
			if(Math.abs(cf1.f(i)-cf2.f(i))>Monom.EPSILON)
				return false;
		}
		return true;
	}
	/**
	 * prints to screen a complex function
	 */
	public String toString() {
		try {
			if(this.leftFunc.toString()!=null) {
				switch(this.op) {
				case Plus:
					return "plus("+this.leftFunc.toString()+","+this.rightFunc.toString()+")";
				case Times:
					return "mul("+this.leftFunc.toString()+","+this.rightFunc.toString()+")";
				case Divid:
					return "div("+this.leftFunc.toString()+","+this.rightFunc.toString()+")";
				case Min:
					return "min("+this.leftFunc.toString()+","+this.rightFunc.toString()+")";
				case Max:
					return "max("+this.leftFunc.toString()+","+this.rightFunc.toString()+")";
				case Comp:
					return "comp("+this.leftFunc.toString()+","+this.rightFunc.toString()+")";
				case None:
					return this.leftFunc.toString();
				default:
					throw new RuntimeException("ERR this operation " +this.op+ " is undefined");
				}
			}
			else 
				return null;

		}
		catch (Exception e) {
			return null;
		}
	}
}