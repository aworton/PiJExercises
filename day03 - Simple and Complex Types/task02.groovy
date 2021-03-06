/*
Write a program that reads two numbers from the user and then off
ers a menu with the four basic operations:
addition, subtraction, multiplication, and division. Once the user has
selected an operation from the menu, the
calculator performs the operation.
Hint:  In the same way that there exists an Integer.parseInt() me
thod to parse integers, there is a Dou-
ble.parseDouble() method to parse real numbers.
*/


List<Double> numbers = new ArrayList<Double>()

numbers = readNumbers()
String operator = readOperator()
/*
numbers.add(1.255)
numbers.add(7)
String operator = "+"
*/

Double result = calculate(numbers, operator)
println result


def readNumbers(){

    List<Double> inputNumbers = new ArrayList<Double>()
    String[] output = ["first","second"] as String[]

    for(int i = 0; i < output.size(); i++){
        print String.format("Please enter your %s number: ", output[i])
        String input = System.console().readLine()
        try{
            double number = Double.parseDouble(input)
            inputNumbers.add(number)
        }
        catch(NumberFormatException e){
            println "Your number could not be parsed. Please try again"
            i--
        }
    }
    return inputNumbers
}

def readOperator(){
    Iterable<String> Operators = Arrays.asList("+", "-", "*", "/")



    String operator = null

    while(!Operators.contains(operator)){
        println "Please choose an operator from the list"

        for(String op : Operators){
            println "\t" + op
        }

        operator = System.console().readLine()
    }

    return operator
}

def calculate(numbers, operator){

    Double precision = 1E14

    if(numbers.size() < 1)
        return null

    double result = numbers[0]

    for(int i = 1; i < numbers.size(); i++) {
        switch(operator){
            case "+":
                result += numbers[i]
                break

            case "-":
                result -= numbers[i]
                break

            case "/":
                result /= numbers[i]
                break

            case "*":
                result *= numbers[i]
                break
        }
    }

    return Math.round(result * precision) / precision
}