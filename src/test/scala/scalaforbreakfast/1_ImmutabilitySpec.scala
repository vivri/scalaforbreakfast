package scalaforbreakfast

import org.scalatest.{FlatSpec, Matchers}

class MutableStringSpec extends FlatSpec with Matchers {

  it should "do things" in {
    val s1 = new MutableStringImpl(Array('1'))
    val s2 = new MutableStringImpl(Array('2'))

    (1 to 30)
    //.par // TODO now uncomment and do this in parallel! Did the result change? Now run it 10 times. Is it consistent?
    // TODO What can happen if a variable is accessed concurrently in the JVM?
    .foreach { i=> s1.setTo(new MutableStringImpl(s1.getChars ++ s2.getChars)) }

    // -- consideration:
    // now must call s1 to continue transformations; can't do filter, groupby, reduce etc.
    // TODO - can you think of an improvement to MutableString to allow the transformation flow of the collections library?

    // ^ HINT - Builder Pattern

    // Can anyone guess what this will equal to???
    print (" S1: ")
    s1.getChars.foreach { print _}
    println

    ///////////////////////////////////
    // And now its immutable cousin - so much easier, right?
    val si1 = "1"
    val si2 = "2"

    val immRes: String = (1 to 30)
      .par // it's easy in parallel all of a sudden!
      .map { i => si1 + si2 }
      .reduceLeft { _ + _ }

    // Can you guess the results now?
    println ("Immutable String result: " + immRes + " Immutable String itself: " + si1)

    // TODO for discussion - think where mutable and immutable instances are appropriate, and why. Give examples.
  }


}
