# CS4278-Clojure-Spec

A demonstration of clojure.spec

The demo is based on a talk by Rich Hickey and the clojure.spec guide.

## Setup

This demo has some samples and tooling to help you run them.

### Download the repository

```bash
git clone https://github.com/phreed/CS4278-Clojure-Spec.git
```

If you plan on recording your work you should first fork the repository.

### Use Clojure Tooling 

* boot : http://boot-clj.com/
* lein : https://leiningen.org/

## Demonstration

Start the repl.

```bash
lein repl
```

or

```bash
boot repl
```

Run the examples.

```bash
(syn/check-samples ::syn/syntax syn/syntax-samples)
```

```bash
(pp/pprint (s/exercise ::syn/syntax))
```

```bash
(fun/exercise)
```

```bash
(fun/run-check)
```

```bash
(fun/ranged-rand 42 11)
```

## Class Project Specific

```bash
(pp/pprint (s/exercise ::msg/message))
(pp/pprint (s/exercise ::msg/thread))
(pp/pprint (s/exercise ::msg/thread-s))
```

## Live Coding

It you are running boot you can improve the live coding experience.

```bash
boot live-repl

boot repl --client
```

You can also write tasks that continually update the target output.
But that will have to wait until another time.

## References

* [A collection about Rich Hickey's works on the internet](https://github.com/tallesl/Rich-Hickey-fanclub)
* [Rich Hickey on Clojure Spec](https://vimeo.com/195711510) at LispNYC .
* [The primary source for clojure.spec](https://github.com/clojure/spec.alpha)
* [The clojure.spec Guide](https://clojure.org/guides/spec)


