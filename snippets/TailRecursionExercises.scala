import scala.annotation.tailrec

def factorial (n: Int): Int = 
    @tailrec
    def factorialAcc(acc: Int, n: Int): Int = 
        if n <=1 then acc else factorialAcc(n*acc, n - 1)
    
    factorialAcc(1, n)

def sum(n: Int): Int =
  if n == 0 then 0
  else n + sum(n - 1)

def sum_recursive(n: Int): Int =
  @tailrec
  def sumAcc (acc: Int, n: Int): Int =
    if n == 0 then acc else sumAcc(n+acc, n-1)
  sumAcc(0,n)
