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

`
println(s"2 + 2 = ${2 + 2}")   // prints "2 + 2 = 4"

val x = -1
println(s"x.abs = ${x.abs}")
`

Store 
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

Unit type = "void" type, no meaningful value
Type of Side Effects
