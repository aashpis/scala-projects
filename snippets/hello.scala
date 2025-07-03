import scala.io.StdIn.readLine

def hello() = println("Hello, World!")


@main def helloInteractive() =
  println("Please enter your name:")
  val name = readLine()

  println("Hello, " + name + "!")