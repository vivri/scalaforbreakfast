package scalaforbreakfast


/**
 * In this topic, we'll cover classes and objects, as well as begin looking into case classes.
 * Everyone's encouraged to look them up online or in any textbooks you've got!
 */


/**
 * 1 - Plain Inheritence
 */

class Shape (val color: String)


/**
 * Exercise 1: Create a GreenShape class that extends shape, and always has the color green
 */


/**
 * Exercise 2: Create a ShapeWithArea class that extends shape, and has an area attribute (floating point)
 */

/**
 * Exercise 3: Add a secondary constructor to ShapeWithArea that always sets the color to "Rainbow"
 */



/**
 * 2 - Abstract classes
 */

abstract class Face (val emotion: String)


/**
 * Exercise 4 - Modify Face and define a signature to change the emotion (remember immutability...!!!!!)
 */

/**
 * Exercise 5 - Extend the Face (ExtendedFace?) and implement the emotion changing. Also, define a `name` value.
 */



/**
 * 3 - Traits
 */

trait Noisy { def makeNoise: String }
trait Colorful { val color: String }

/**
 * Exercise 6 - Create a class to extend these.
 */

/**
 * Exercise 7 - Extend an _instance_ of ExtendedFace with Noisy and Colorful. Did the base class change?
 */




/**
 * 4 - Sealed classes and traits
 */

sealed trait SecretSauce { val doSecretStuff: Unit }

/**
 * Exercise 8 - Try to extend SecretSause from another source file! Rly? Y u not extend?!
 */


/**
 * 5 - Case classes (beginning)
 */

/**
 * Exercise 9 - Read about case classes! We'll be doing exercises tomorrow.
 */
