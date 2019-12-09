# Polynom_Ex1

This project represents a general Polynom: f(x) = a_1X^b_1 + a_2x^b_2 ... a_nX^b_n,
 where: a_1, a_2 ... a_n are real numbers and b_1<b_2..<b_n are none negative integers (naturals).
Each Polynom consists of a collection (Array List in our project) of monoms.
(In our project the Polynom does not consist the chars _ , (), /  and *. )

*In this project we have 4 JUNIT tests for: Polynom, Monom, ComplexFunction, Functions_GUI. We also have 7 classes:*

# Monon:
 This class represents a simple "Monom" of shape ax^b, where a is a real number (the coefficient) and b (the power) is an integer (summed a nonnegative). <br />
The functions- <br />
Constructors:<br />
•	Default constructor <br />
•	Copy constructor <br />
•	String constructor- Init a Monom from a String. <br />
Getters and setters: <br />
•	get_coefficient <br />
•	get_power <br />
•	set_coefficient <br />
•	set_power<br />
Derivative- This function returns the Monom’s derivative.<br />
f- This function calculates a simple function of type y=f(x) – (implements of the interface function).<br />
isZero- Test if this is the Zero Monom.<br />
Add- add 2 monoms (only if they have the same power).<br />
Multiply- multiply 2 monoms.<br />
toString-  return a string of the Monom.<br />
Equals- checks the logically equality of 2 monoms.<br />
getNewZeroMonom- create a zero monom.<br />
# Polynom:
This class is an implemention of Polynom_able interface.<br />
The Polynom  is from the type of f(x) = a_1X^b_1 + a_2x^b_2 ... a_nX^b_n,<br />
 and does not consist the chars _ , (), /  and *.<br />

The functions-<br />
Constructors:<br />
•	Default constructor<br />
•	Copy constructor (deep copy)<br />
•	string constructor- Init a Monom from a String.<br />
f- This function calculates a simple function of type y=f(x) – (implements of the interface function).<br />
Add:<br />
•	Polynom_able-  add 2 Polynoms.<br />
•	Monom- add a Monom to the Polynom.<br />
Substract- subtract between two Polynoms.<br />
Multiply:<br />
•	Polynom_able-  multiply 2 Polynoms.<br />
•	Monom- multiply a Monom to the Polynom.<br />
Equals- Tests if the Polynom is logically equals to other one.<br />
isZero-  Tests if this is the zero Polynom.<br />
Root-  Finding a numerical value between two values when f(x)=0 (or farther than that at most in eps).<br />
Derivative- This function returns the Polynom’s derivative.<br />
Area- Compute a Riman's integral from x0 to x1 in eps steps.<br />
Iterator- Passing on the Polynom (on each Monom of the Polynom)<br />
toString- returns a string of the Polynom.<br />

# ComplexFunction:
This class is an implemention of complex_function interface.<br />
 This class represents a complex function that have a left and right branches, with an operator in the middle.
Each complex function have these three fields: leftFunc, rightFunc, op.<br />
 Each branch can be a complex function by itself.<br />
 The functions-<br />
 Constructors:<br />
  We have 6 constructors for complex function: one for each place the operator can be in (first, second, third).
  The constructors also handle the cases which in the operator can appears as a String, also in each place.<br />
  We have a constructor that bulids a complex function from a Polynom, a Monom, a complex function and a function.<br />
  plus- sums up the leftFunc and the rightFunc<br />
  mul- multiplaies the leftFunc by the rightFunc<br />
  div- divides the leftFunc by the rightFunc<br />
  max- returns the max value between the leftFunc and the rightFunc<br />
   min- returns the min value between the leftFunc and the rightFunc<br />
   comp- returns the function composition of rightFunc on leftFunc<br />
   left- returns the leftFunc<br />
   right- returns the rightFunc<br />
   gerOp- returns the operation of this complex function<br />
   f- computes the value of this complex function with the given value<br />
   initFromString- creates a complex function from a given String<br />
   copy- deep copies this complex function<br />
   equals- checkes if two complex functions are eqauls. while we were working on this project,
   we found out that it is impossible for us to determine if two function are equals by a String (facrtors can divided by each other etc.)-<br />
   The best way to test if two complex functions are equals is to check if their values with a few different numbers are equals.
 In most cases this system is working, exept when _______.<br />
So we bulid a visual equals function to determine if it's true or false, checking all the values between -1 to 1, each time incrising the number by 0.0000001 <br />
toString- prints to user this complex function.

  # Functions_GUI:
  This class is an implemention of functions interface.<br />
  It's consistong of a collection (Array List in our project) of functions.<br />
  The class have an array of colors, in which it will draw the functions.<br />
  It implements all the functions of a collection (size, isEmpty, contains, Iterator, both toArray functions, add, remove, contiansAll,addAll,removeAll,retainAll,clear)<br />
   The functions-<br />
   Constructors:<br />
A default constructor that creates an empty new collection<br />
initFromFile- <br />
saveToFile- <br />
drawFunctions- gets all the parameters <br />
drawFunctions- reads from a Json file, using Gson <br />
  
  
  # Parameters:
 This class represents the parameters a function in Function_GUI<br />
 The parameters are: width, Height, Range_X, Range_Y and Resolution.<br />
  The functions-<br />
 Constructors:<br />
 default constructor- sets the arraies of Range_X and Range_Y to 2 values<br />
 constructor that gets all the parametrs and sets them<br />
 Getters: <br />
•	getWidth <br />
•	getHeight <br />
•	getResolution <br />

# Range:
 This class represents a simple 1D range of shape [min,max]<br />
  The functions-<br />
 Constructors:<br />
 constructor that gets min and max and sets them<br />
 isIn- checks if a given distance is in this range<br />
 toString- prints to user the range in the format of [min,max]<br />
 isEmpty- checks if the this max < this min, meaning the range is empty<br />
 Getters and setters: <br />
•	get_max <br />
•	get_min <br />
•	set_max <br />
•	set_min<br />


# stdDraw:
 We are using this given class to draw function on Functions_GUI<br />
 
 

