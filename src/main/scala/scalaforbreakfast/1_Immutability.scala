package scalaforbreakfast


/**
 * TOPIC 1 - Immutable Data Structures
 * 
 * We'll be covering mutable vs. immutable data structures.
 *
 * The idea: investigate the pros and cons of mutable vs immutable data structures.
 * Of concern are: Thread-safety, caching, reason-ability, performance, ease of use.
 *
 * The task:
 *
 * Create a mutable version of String, where you can append, prepend strings, as well as set the string to something.
 * You are not allowed to use immutable Strings in the implementation, as well as `val`s.
 *
 */

trait MutableString {
  def setTo (mutableString: MutableString): Unit

  def prepend (mutableString: MutableString): Unit

  def append (mutableString: MutableString): Unit

  def getChars: Array[Char]
}

/**
 * TODO -
 *
 * Now create the class MutableStringImpl that extends the trait
 *
 * Don't look down for the solution!
 *
 * Once you created it, comment the solution underneath for the code to compile.
 *
 * See the runner in /test/scala/1_ImmutabilitySpec.scala for more.
 */






































// SOLUTION, SAFE FOR MULTITHREADING AND FROM SHALLOW COPIES
//
class MutableStringImpl (chars: Array[Char]) extends MutableString {

  private var _chars = chars

  def setTo (mutableString: MutableString): Unit = synchronized { _chars = mutableString.getChars.clone() }

  def prepend (mutableString: MutableString): Unit = synchronized { _chars = mutableString.getChars.clone() ++ _chars }

  def append (mutableString: MutableString): Unit =synchronized {  _chars = _chars ++ mutableString.getChars.clone() }

  def getChars: Array[Char] = synchronized {  _chars }
}

