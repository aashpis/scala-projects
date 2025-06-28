Functional programming are programs that only use only pure functions—functions without have side effects.

**Side effect:** something a function does aside from simply returning a result.

- Examples: modifying a field on an object, throwing an exception, and accessing the network or file system.
- limits our ability to understand, compose, test, and refactor parts of our programs.


Moving side effects to the outer edges of our program results in a pure core and
thin outer layer, which handles effects and results in better testability.

**Referential transparency** defines whether an expression is pure or contains side effects.

- for an expression to be referentially transparent—in any program, the expression can be replaced by its result without changing the meaning of the program.
- we don't want an expression to being anything else besides evaluating to a single result. The more "extra" and "outside" stuff it does - side effects, the harder it is to follow the logic and maintain it.
- if we can replace an expression (ex. x + 1) with its results based on the parameters and the program doesn't change meaning, it is **RT**

The substitution model provides a way to test whether an expression is referentially transparent. 

- We fully expand every part of an expression, replacing all variables with their referents, and then we reduce it to its simplest form.
- At each step, we replace a term with an equivalent one; computation proceeds by substituting equals for equals.
- In other words, RT enables equational reasoning about programs.

Functional programming enables local reasoning and allows the embedding of smaller programs within larger programs
