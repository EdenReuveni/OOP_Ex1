# Polynom_Ex1

This project represents a general Polynom: f(x) = a_1X^b_1 + a_2x^b_2 ... a_nX^b_n,
 where: a_1, a_2 ... a_n are real numbers and b_1<b_2..<b_n are none negative integers (naturals).
Each Polynom consists of a collection (Array List in our project) of monoms.
(In our project the Polynom does not consist the chars _ , (), /  and *. )

*In this project we have 4 JUNIT tests for: Polynom, Monom, ComplexFunction, Functions_GUI. We also have 7 classes:*

# Monon:
 This class represents a simple "Monom" of shape ax^b, where a is a real number (the coefficient) and b (the power) is an integer (summed a nonnegative). <br />
 For more information: https://en.wikipedia.org/wiki/Monomial

# Polynom:
This class is an implemention of Polynom_able interface.<br />
The Polynom  is from the type of f(x) = a_1X^b_1 + a_2x^b_2 ... a_nX^b_n,<br />
 and does not consist the chars _ , (), /  and *.<br />
  For more information:https://en.wikipedia.org/wiki/Polynomial


# ComplexFunction:
This class is an implemention of complex_function interface.<br />
 This class represents a complex function that have a left and right branches, with an operator in the middle.
Each complex function have these three fields: leftFunc, rightFunc, op.<br />
 Each branch can be a complex function by itself.<br />

  # Functions_GUI:
  This class is an implemention of functions interface.<br />
  It's consistong of a collection (Array List in our project) of functions.<br />
  The class have an array of colors, in which it will draw the functions.<br />
  
 
  
  # Parameters:
 This class represents the parameters a function in Function_GUI<br />
 The parameters are: width, Height, Range_X, Range_Y and Resolution.<br />
 
# Range:
 This class represents a simple 1D range of shape [min,max]<br />
 


# stdDraw:
 We are using this given class to draw function on Functions_GUI<br />
 
 

