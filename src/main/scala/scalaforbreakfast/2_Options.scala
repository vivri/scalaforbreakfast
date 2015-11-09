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
 * HINT:
 *
 * class TrinaryTree[T] {
 *  def find (value: T): Option[T]
 * }
 *
 */
















/**
 * SOLUTION (BETTER):
 *
 */
case class TreeNode[T](left: Option[TreeNode[T]], center: Option[TreeNode[T]], right: Option[TreeNode[T]], something: T) {

  def find(leaf: T): Option[T] = {
    if (something == leaf)
      return Some(something)

    left.flatMap(_.find(leaf)).
      getOrElse[Option[T]](center.flatMap(_.find(leaf))).
      getOrElse[Option[T]](center.flatMap(_.find(leaf)))
  }
}






/**
 * SOLUTION (WORSE):
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
      .foldLeft[Option[T]] (None) { (result, branch) => result match {
          case Some(x) => result
          case None => find(value, branch)
        }

      }
  }
}