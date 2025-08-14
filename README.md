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

```scala
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

```scala
val chainedIfExpression = 
    if (meaningOfLife > 43 ) 56
    else if (meaningOfLife < 0) -2
    else if (meaningOfLife > 999) 300
    else 0
```

Functions:
`
def myFunction(x : Int, y: String): String = {
    y + " " + x
}
`

codeblocks in a variable - last expression result is stored in the val 

```scala
val aCodeBlock = {
    val aLocalValue =67
    aLocalValue + 3
} 
```

Use RECURSION not loops or iteration

```scala
def factorial (n: Int): Int = 
    if (n <= 1) 1
    else n * factorial(n - 1)
```

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

```scala
class RationalNumber(x: Int, y: Int):
    require(y > 0, "denominator must be positive")                 
```

- auxilliary constructor: additional constructors for a class
```scala
class Rational(x: Int, y: Int):
    def this(x: Int) = this(x, 1)
...
Rational(2) > 2/1
```

**End Markers**

- end className -> use to signify end of class def
- also can be used in control logic

```scala
f x >= 0 then
...
else
...
end if
`

**Checking Code**
- assert(condition) -> checks code itself
```scala
val x = sqrt(y)
assert(x>=0)  
```


**Infix Operators**
```scala
extension (x: Rational)
    infix def min(that: Rational): Rational = ..
```
allows for syntax `x min y` not x.min(y)


An object and a class can have the same name. This is possible since
Scala has two global namespaces: one for types and one for values.
Classes live in the type namespace, whereas objects live in the term
namespace

Defining parameters in a class constructor automatically creates fields in the class: `class Person(name: String, age: Int)` -> name and age are fields without declaring them in the body

# Scala Singleton and Companion Objects

### An object is a singleton. One object, that's it.  
This object is a replacement of `static` in Java, and is called upon much in the same way:

```scala
def singletonObjects(res0: String, res1: String) = {
  object Greeting {
    def english = "Hi"
    def espanol = "Hola"
  }

  Greeting.english should be(res0)
  Greeting.espanol should be(res1)
}
```

---

### Here is a proof that an object is a singleton, and not a static method in a class:

```scala
def notStaticMethodObjects(res0: Boolean, res1: Boolean) = {
  object Greeting {
    def english = "Hi"
    def espanol = "Hola"
  }

  val x = Greeting
  val y = x

  x eq y should be(res0) // Reminder: eq checks for reference

  val z = Greeting

  x eq z should be(res1)
}
```

---

### An object that has the same name as a class is called a companion object of the class.  
It is often used to contain factory methods for the class that it complements:

```scala
def companionObjectObjects(res0: String) = {
  class Movie(val name: String, val year: Short)

  object Movie {
    def academyAwardBestMoviesForYear(x: Short) = {
      // This is a match statement, more powerful than a Java switch statement!
      x match {
        case 1930 => Some(new Movie("All Quiet On the Western Front", 1930))
        case 1931 => Some(new Movie("Cimarron", 1931))
        case 1932 => Some(new Movie("Grand Hotel", 1932))
        case _    => None
      }
    }
  }

  Movie.academyAwardBestMoviesForYear(1932).get.name should be(res0)
}
```

---

### A companion object can also see private values and variables of the corresponding classes' instantiated objects:

```scala
def privateValuesObjects(res0: String, res1: String) = {
  class Person(
      val name: String,
      private val superheroName: String
  ) // The superhero name is private!

  object Person {
    def showMeInnerSecret(x: Person) = x.superheroName
  }

  val clark = new Person("Clark Kent", "Superman")
  val peter = new Person("Peter Parker", "Spider-Man")

  Person.showMeInnerSecret(clark) should be(res0)
  Person.showMeInnerSecret(peter) should be(res1)
}
```


# Tuples

Scala tuple combines a fixed number of items together so that they can be passed around as a whole. They are one-indexed. Unlike an array or list, a tuple can hold objects with different types but they are also immutable. 
Here is an example of a tuple holding an integer, a string, and the console:
