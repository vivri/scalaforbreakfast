package scalaforbreakfast

import scala.annotation.tailrec

/**
 * TOPIC 2 - OPTIONS (AND PARAMETRIZED TYPES)
 *
 * This is a somewhat big chunk of things to learn, so don't feel bad if you don't have time to do everything yourselves.
 *
 * For this topic, before you engage in this exercise, it's highly recommended that you're familiar
 * with the Option type and it's rationale,as well as the very basics of Parametrized Types.
 * You've seen them already - List[String], Option[Int] etc.
 *
 * Also - think how to employ tail recursion to the algorithm; read about @tailrec. I couldn't find a way to do it, maybe you can!
 *
 * TODO -
 * The first task is to implement a trinary tree (with three possible branches) using T as the value of each tree node.
 * The idea is that a branch _may_ exist, but it may not exist as well, so the branch references should be Options.
 * Also, implement a " find (element: T): Option[T] " method using tail recursion.
 *
 *
 * HINTS ARE BELOW, BUT TRY TO SOLVE ON YOUR OWN FIRST.
 */

















/**
 * HINT 1:
 *
 * class TrinaryTree[T]
 *
 * def find (tree: TrinaryTree[T]): Option[T]
 */



































/**
 * HINT 2: class TrinaryTree[T] (branches: ... , value: ... )
 *
 * def find (tree: TrinaryTree[T]): Option[T] = {
 *    // base case: found here! - Some(value)
 *
 *    // recursive case: (use collections!)
 *    1) find and enumerate the existing branches,
 *    2) use folding to get the value recursively; short circuit if found
 * }
 */

























/**
 * SOLUTION:
 */

class TrinaryTree[T] (val branches:
                      ( Option[TrinaryTree[T]],
                        Option[TrinaryTree[T]],
                        Option[TrinaryTree[T]]),
                      val value: T)

object TrinaryTree {

  def find[T] (value: T, tree: TrinaryTree[T]): Option[T] = {
    // base case
    if (tree.value == value)
      return Some (value)

    List (tree.branches._1, tree.branches._2, tree.branches._3)
      .filter (_ != None)
      .map { _.get }
      .foldLeft[Option[T]] (None) { (result, branch) =>  {
        if (result != None)
          result
        else
          find(value, branch)
        }
      }
  }
}