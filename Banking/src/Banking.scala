
import scala.collection.mutable.ListBuffer
import scala.io.StdIn.{readInt, readLine}
  
class Account{
  

  var name = new ListBuffer[String]()
  name += ( "Sameerna", "Ram", "Sham" )
  var balance_current = new ListBuffer[Int]()
  balance_current += ( 60000, 70000, 440000 )
  var account_number = new ListBuffer[Int]()
  account_number += ( 1234, 5678, 9101 )
  var phone_number = new ListBuffer[Long]()
  phone_number += ( 9998273493L, 5569392838L, 6651299039L )
  

  def details(): Unit ={
    println("Details of customer is\nNames of customer: " + name +
            "\nBalance list" + "is respectively: " + balance_current +
            "\nAccount number is respectively: " + account_number +
            "\nPhone number" + "is respectively: " + phone_number)
  }
  
  def credit(): Unit = {
    var credit_amount: Int = 0
    println("Enter the account number you want to credit in: ")
  
    val acc_num1 = readInt()
  
    val index1 = account_number.indexOf(acc_num1)
    println("Enter the amount you want to credit: ")
    credit_amount = readInt()
    balance_current(index1) += credit_amount
    println("Amount added successfully\nNew Balance is: " +
             balance_current(index1))
  }
  
  def debit(): Unit ={
    var debit_amount : Int = 0
    println("Enter the account number " +
            "you want to withdraw from: ")
    val acc_num2 = readInt()
    val index2 = account_number.indexOf(acc_num2)
    println("Enter the amount you want to withdraw: ")
  
    debit_amount = readInt()
    balance_current(index2) -= debit_amount
    println("Money withdrawn successfully\n" +
            "Remaining balance is: " +
            balance_current(index2))
  }
}
  
class SavingsAccount extends Account
{
  var interest : Double = 2
  
  def interest_amount(): Unit = {
    println("Enter the account number " +
            "to see the interest amount: ")
  
    val acc_num3 = readInt()
    val index3 = account_number.indexOf(acc_num3)
    interest =  (balance_current(index3) * 2) / 100
    println("The interest amount is: "+interest)
  }
  
  override def details(): Unit ={
    println("Enter the account_number to see its details: ")
    val acc_num4 = readInt()
    val index4 = account_number.indexOf(acc_num4)
  
    println("Details of this account is\n" +
            "Name of customer is: " + name(index4) +
            "\nAccount number is: " + account_number(index4) +
            "\nPhone number is: " + phone_number(index4)  +
            "\nAccount balance is: " + balance_current(index4))
  }
}
  
class Bank extends Account
{
  
  def opening(): Unit ={
  
    var new_name = readLine("Enter the name: ")
    name += new_name
    println("Enter the opening balance: ")
    var opening_balance = readInt()
    balance_current += opening_balance
    account_number += 1908
    println("Account added successfully")
  }
  
  def closing(): Unit ={
    println("Enter the account number: ")
    val acc_num6 = readInt()
    val index6 = account_number.indexOf(acc_num6)
    name -= name(index6)
    balance_current -= balance_current(index6)
    account_number -= account_number(index6)
    println("Account removed successfully")
  }
}
  
object Banking
{
  def main(args: Array[String]): Unit = {
  
    val obj1 = new Account()
    val obj2 = new SavingsAccount()
    
    val obj4 = new Bank()
  
    println("Enter 1 for account details, \n" +
            "2 for SavingsAccount, \n" +
            "3 for closing or opening account \n")
  
    val choice = readInt()
    if (choice == 1)
    {
      obj1.details()
    }
  
    if (choice == 2)
    {
      println("Enter 1 for checking the interest " +
              "amount and 2 if you want to see the " +
              "details of any particular account: ")
  
      val choice1 = readInt()
      if (choice1 == 1)
      {
        obj2.interest_amount()
      }
      else if (choice == 2)
      {
        obj2.details()
      }
    }
  
    if(choice == 3)
    {
      println("Enter 1 for credit and 2 for debit: ")
      val choice2 = readInt()
  
    }
  
    if (choice == 4)
    {
      println("Enter 1 for opening account " +
              "and 2 for closing an account: ")
  
      val choice3 = readInt()
      if(choice3 == 1)
      {
        obj4.opening()
      }
      else
      {
        obj4.closing()
      }
    }
  }
}