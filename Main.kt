package machine

enum class StatesOfMachine(val state: String) {
    CHOOSING_AN_ACTION("choosing an action"),
    CHOOSING_TYPE_OF_COFFEE("choosing type of coffee"),

}

class CoffeeMachine(){
    private var input: String = ""
    private var water = 400
    private var milk = 540
    private var beans = 120
    private var dispCups = 9
    private var money = 550
    var workInProgress = true

    fun readUserInput() {
        println()
        println("Write action (buy, fill, take, remaining, exit):")
        this.input = readln()
        when(this.input) {
            "buy" -> this.buy()
            "fill" -> this.fill()
            "take" -> this.take()
            "remaining" -> {
                println()
                this.printMachineState()
            }
            "exit" -> this.workInProgress = false
        }
    }

    private fun printMachineState() = println("""The coffee machine has:
        ${this.water} ml of water
        ${this.milk} ml of milk
        ${this.beans} g of coffee beans
        ${this.dispCups} disposable cups
        $${this.money} of money""".trimIndent())

    private fun buy() {
        println()
        println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:")
        when (readln()) {
            "1" -> this.makeEspresso()
            "2" -> this.makeLatte()
            "3" -> this.makeCappuccino()
            "back" -> return
        }
    }

    private fun fill() {
        println("Write how many ml of water you want to add:")
        this.water += readln().toInt()
        println("Write how many ml of milk you want to add:")
        this.milk += readln().toInt()
        println("Write how many grams of coffee beans you want to add:")
        this.beans += readln().toInt()
        println("Write how many disposable cups you want to add:")
        this.dispCups += readln().toInt()
    }

    private fun take() {
        println("I gave you $${this.money}")
        this.money = 0
    }

    private fun makeEspresso(){
        if (this.water - 250 < 0) {
            println("Sorry, not enough water!")
            return
        }
        this.water -= 250
        if (this.beans - 16 < 0) {
            println("Sorry, not enough coffee beans!")
            return
        }
        this.beans -= 16
        if (this.dispCups - 1 < 0) {
            println("Sorry, not enough disposable cups!")
            return
        }
        this.dispCups--
        this.money += 4
        println("I have enough resources, making you a coffee!")
    }

    private fun makeLatte() {
        if (this.water - 350 < 0) {
            println("Sorry, not enough water!")
            return
        }
        this.water -= 350
        if (this.milk - 75 < 0) {
            println("Sorry, not enough milk!")
            return
        }
        this.milk -= 75
        if (this.beans - 20 < 0) {
            println("Sorry, not enough coffee beans!")
            return
        }
        this.beans -= 20
        if (this.dispCups - 1 < 0) {
            println("Sorry, not enough disposable cups!")
            return
        }
        this.dispCups--
        this.money += 7
        println("I have enough resources, making you a coffee!")
    }

    private fun makeCappuccino() {
        if (this.water - 200 < 0) {
            println("Sorry, not enough water!")
            return
        }
        this.water -= 200
        if (this.milk - 100 < 0) {
            println("Sorry, not enough milk!")
            return
        }
        this.milk -= 100
        if (this.beans - 12 < 0) {
            println("Sorry, not enough coffee beans!")
            return
        }
        this.beans -= 12
        if (this.dispCups - 1 < 0) {
            println("Sorry, not enough disposable cups!")
            return
        }
        this.dispCups--
        this.money += 6
        println("I have enough resources, making you a coffee!")
    }
}

fun main() {
    val coffeeMachine = CoffeeMachine()
    while (coffeeMachine.workInProgress){
        coffeeMachine.readUserInput()
    }
}