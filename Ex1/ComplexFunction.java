package Ex1;

public class ComplexFunction implements complex_function{
	private function leftFunc;
	private function rightFunc;
	private Operation op;


	public ComplexFunction(Operation new_op,function left, function right) {
		// TODO Auto-generated constructor stub
		constructorHelper(left, right, new_op);
	}
	public ComplexFunction(function left,Operation new_op, function right) {
		// TODO Auto-generated constructor stub
		constructorHelper(left, right, new_op);
	}
	public ComplexFunction(function left, function right, Operation new_op) {
		// TODO Auto-generated constructor stub
		constructorHelper(left, right, new_op);
	}
	public ComplexFunction(String new_op, function left, function right) {
		// TODO Auto-generated constructor stub
		constructorHelper(left, right, Operator(new_op));
	}
	public ComplexFunction(function left, String new_op, function right) {
		constructorHelper(left, right, Operator(new_op));
		// TODO Auto-generated constructor stub
	}
	public ComplexFunction(function left, function right, String new_op) {
		constructorHelper(left, right, Operator(new_op));
		// TODO Auto-generated constructor stub
	}
	public ComplexFunction(Monom monom) {
		this.leftFunc=monom;
		this.rightFunc=null;
		this.op=Operation.None;
	}
	public ComplexFunction(Polynom polynom) {
		this.leftFunc=polynom;
		this.rightFunc=null;
		this.op=Operation.None;
	}
	private void constructorHelper(function left, function right, Operation new_op) {
		this.leftFunc=left.copy();
		this.rightFunc=right.copy();
		this.op=new_op;	
	}
	private Operation Operator(String new_op) {
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
		this.leftFunc= new ComplexFunction(this.leftFunc, this.rightFunc, this.op);
		this.rightFunc=f1.copy();
		this.op=Operation.Plus;
	}
	/** Multiply this complex_function with the f1 complex_function
	 * 
	 * @param f1 the complex_function which will be multiply be this complex_function.
	 */
	public void mul(function f1) {
		this.leftFunc= new ComplexFunction(this.leftFunc, this.rightFunc, this.op);
		this.rightFunc=f1.copy();
		this.op=Operation.Times;
	}
	/** Divides this complex_function with the f1 complex_function
	 * 
	 * @param f1 the complex_function which will be divid this complex_function.
	 */
	public void div(function f1) {
		this.leftFunc= new ComplexFunction(this.leftFunc, this.rightFunc, this.op);
		this.rightFunc=f1.copy();
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
		this.leftFunc= new ComplexFunction(this.leftFunc, this.rightFunc, this.op);
		this.rightFunc=f1.copy();
		this.op=Operation.Min;
	}
	/**
	 * This method wrap the f1 complex_function with this function: this.f(f1(x))
	 * @param f1 complex function
	 */
	public void comp(function f1) {
		this.leftFunc= new ComplexFunction(this.leftFunc, this.rightFunc, this.op);
		this.rightFunc=f1.copy();
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
		return this.leftFunc.copy();
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
		return this.rightFunc.copy();
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
			return rightFunc.f(leftFunc.f(x));
		case None:
			return leftFunc.f(x);
		default:
			try {
				throw new RuntimeException("ERR this operation is undefined");
			}catch (Exception e) {
				//	System.out.println("ERR this operation is undefined");
				e.printStackTrace();
				return Double.NaN;
			}
		}

	}
	@Override
	public function initFromString(String s) {
		int counterForStart=0, counterForEnd=0, CounterForComma=0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i)=='(')
				counterForStart++;
			if (s.charAt(i)==')')
				counterForEnd++;
			if (s.charAt(i)==',')
				CounterForComma++;
		}
		try {
		if (counterForEnd>counterForStart || counterForStart>counterForEnd) {
			throw new RuntimeException("ERR the expretion is invalid");
		}
		}catch (Exception e) {
			e.printStackTrace();
		}
		if (CounterForComma==0 && counterForEnd==1 && counterForStart==1) {
			String strForOp = s.substring(0, s.indexOf('('));
			this.op=Operator(strForOp);			
			this.leftFunc=new Polynom(s.substring(s.indexOf('(')+1,s.indexOf(')')));
			this.rightFunc=null;
			ComplexFunction cf=new ComplexFunction(this.leftFunc,this.rightFunc,this.op);
			return cf;
		}
		if (counterForStart==1 && counterForEnd==1 && CounterForComma==1) {
			String strForOp = s.substring(0, s.indexOf('('));
			this.op=Operator(strForOp);			
			this.leftFunc=new Polynom(s.substring(s.indexOf('(')+1,s.indexOf(',')));
			this.rightFunc=new Polynom(s.substring(s.indexOf(',')+1,s.indexOf(')')));
			ComplexFunction cf=new ComplexFunction(this.leftFunc,this.rightFunc,this.op);
			return cf;
		}
		return initFromString(s.substring(s.indexOf('(')+1, s.lastIndexOf(')')));
	}
	
	@Override
	public function copy() {
		ComplexFunction cf= new ComplexFunction(this.leftFunc.copy(), this.rightFunc.copy(), this.op);
		return cf;
	}

	public boolean equals(Object obj) {
		if (obj instanceof ComplexFunction) {
			ComplexFunction cf= new ComplexFunction(this.leftFunc, this.rightFunc, this.op);
			return visualEquals(this, cf);
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
	private  boolean visualEquals(ComplexFunction cf1, ComplexFunction cf2)
	{
		for (double i = -100; i < 100 ; i+=Monom.EPSILON) {
			if (cf1.f(i)!=cf2.f(i))
				return false;
		}
		return true;
	}
	public String toString() {
		return null;
	}
}
