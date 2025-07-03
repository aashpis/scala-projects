error id: file://<WORKSPACE>/snippets/TailRecursionExercises.scala:`<none>`.
file://<WORKSPACE>/snippets/TailRecursionExercises.scala
empty definition using pc, found symbol in pc: `<none>`.
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 340
uri: file://<WORKSPACE>/snippets/TailRecursionExercises.scala
text:
```scala
import scala.annotation.tailrec

def factorial (n: Int): Int = 
    @tailrec
    def factorialAcc(acc: Int, n: Int): Int = 
        if n <=1 then acc else factorialAcc(n*acc, n - 1)
    
    factorialAcc(1, n)

factorialAcc(1, 3)

factorialAcc(3*1, 2)
factorialAcc(2*1, 1)
factorialAcc(1*1, 0) returns 1
factorialAcc(2*1, 1) returns 2


def@@ sum(n: Int): Int =
  if n == 0 then 0
  else n + sum(n - 1)

def sum_recursive(n: Int): Int =
  @tailrec
  def sumAcc (acc: Int, n: Int) Int =
    if n == 0 then 0 else sumAcc(n+acc, n-1)
  sumAcc(0,n)

```


#### Short summary: 

empty definition using pc, found symbol in pc: `<none>`.