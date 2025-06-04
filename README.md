# scala-projects

## Language Notes

Variables:

val -> immutable 

var -> mutable


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

codeblocks in a variable

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

  // Point #1: in Scala we usually operate with IMMUTABLE values/objects
  // Any modification to an object must return ANOTHER object
  /*
    Benefits:
    1) works miracles in multithreaded/distributed env
    2) helps making sense of the code ("reasoning about")
   */
  val reversedList = aList.reverse // returns a NEW list

  // Point #2: Scala is closest to the OO ideal
