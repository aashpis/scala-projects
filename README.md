# scala-projects

## Language Notes

Variables:

- val -> immutable 
- var -> mutable


You can declare types

`
val meaningOfLife: Int = 42
`

Type inference: compiler can infer types not specifically declared

`
val aBoolean = false
`

String Inteporlation, add s before string, $ before val name

`
val anInterpolatedString = s"The Meaning of Life is $meaningOfLife"
`

You can interpolate expressions:

```
println(s"2 + 2 = ${2 + 2}")   // prints "2 + 2 = 4"

val x = -1
println(s"x.abs = ${x.abs}")

println(s"2 + 2 = ${2 + 2}")   // prints "2 + 2 = 4"

val x = -1
println(s"x.abs = ${x.abs}")
```

Store expressions in variables
`
val ifExpression = if (meaningOfLife > 43 ) 56 else 999
`

`
val chainedIfExpression = 
    if (meaningOfLife > 43 ) 56
    else if (meaningOfLife < 0) -2
    else if (meaningOfLife > 999) 300
    else 0
`

Functions:
`
def myFunction(x : Int, y: String): String = {
    y + " " + x
}
`

codeblocks in a variable - last expression result is stored in the val 

`
val aCodeBlock = {
    val aLocalValue =67
    aLocalValue + 3
} 
`

Use RECURSION not loops or iteration

`
def factorial (n: Int): Int = 
    if (n <= 1) 1
    else n * factorial(n - 1)
`

Unit type = "void" type, no meaningful value, Need to return something though, so Unit type is like a placeholder when there isn't any.

Point #1: in Scala we usually operate with IMMUTABLE values/objects
- Any modification to an object must return ANOTHER object: `val reversedList = aList.reverse // returns a NEW list`
- Benefits:
  * works miracles in multithreaded/distributed env
  * helps making sense of the code ("reasoning about")
   

Point #2: Scala is closest to the OO ideal

**Functions are values** and can be passed as function arguments 
**Higher Order Functions** are functions that take functions as arguments
- Variable naming convention: use single letters f,g,h for params

**Anonymous Function:** functions defined without a name. A=>B type A returns type B. 
- cube function (x:Int) => x * x * x
- (x: Int, y: Int) => x + y
- (x,y) => x + y can be written as _ + _   ->where the types of x and y could be inferred by Scala.
    * _ + _  is the same as (x, y) => x + y   

**Polymorphic Functions:** higher-roder functions that can operate on any datatype

**Partial Function**

**Currying**

**Uncurrying**

**Data Sharing:** reusing parts of data structures instead of copying them. 
- rather than deleting the head of list, you can have another list that points to the list starting at the 2nd index (the new head)
    
**Class constructors**
- require(condition, message) -> for checking constructor arguments 

`
class RationalNumber(x: Int, y: Int):
    require(y > 0, "denominator must be positive")                 
`

- auxilliary constructor: additional constructors for a class
`
class Rational(x: Int, y: Int):
    def this(x: Int) = this(x, 1)
...
Rational(2) > 2/1
`

**End Markers**

- end className -> use to signify end of class def
- also can be used in control logic

`
f x >= 0 then
...
else
...
end if
`

**Checking Code**
- assert(condition) -> checks code itself
`
val x = sqrt(y)
assert(x>=0)  
`


**Infix Operators**
```
extension (x: Rational)
    infix def min(that: Rational): Rational = ..
```
allows for syntax `x min y` not x.min(y)


An object and a class can have the same name. This is possible since
Scala has two global namespaces: one for types and one for values.
Classes live in the type namespace, whereas objects live in the term
namespace
