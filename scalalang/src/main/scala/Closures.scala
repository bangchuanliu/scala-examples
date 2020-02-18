package main.scala

object Closures {

  var votingAge = 18

  def isVotingAge(age : Int): Boolean = {
    age >= votingAge
  }
}
