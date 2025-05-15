package com.example.pamo_s24261

class KotlinExercises {

    /**
     * Exercise 1
     *
     * Prints the name and age of a person in a formatted string.
     * In this example, it prints "Mary is 20 years old".
     */
    fun printPersonInfo() {
        val name = "Mary"
        val age = 20
        println("$name is $age years old")
    }

    /**
     * Exercise 2
     *
     * Declares and initializes variables of various Kotlin types:
     * Int, String, Double, Long, Boolean, and Char.
     */
    fun declareVariableTypes() {
        val a: Int = 1000
        val b: String = "log message"
        val c: Double = 3.14
        val d: Long = 100_000_000_000_000
        val e: Boolean = false
        val f: Char = '\n'
    }

    /**
     * Exercise 3
     *
     * Counts the total number of elements in two lists and prints the sum.
     * @see List.count
     */
    fun countNumbersInLists() {
        val greenNumbers = listOf(1, 4, 23)
        val redNumbers = listOf(17, 2)
        val totalCount = greenNumbers.count() + redNumbers.count()
        println(totalCount)
    }

    /**
     * Exercise 4
     *
     * Checks whether a requested protocol (case-insensitive) is supported.
     * Prints true if supported, false otherwise.
     *
     * @sample SUPPORTED contains HTTP, HTTPS, FTP
     */
    fun checkProtocolSupport() {
        val SUPPORTED = setOf("HTTP", "HTTPS", "FTP")
        val requested = "smtp"
        val isSupported = requested.uppercase() in SUPPORTED
        println("Support for $requested: $isSupported")
    }

    /**
     * Exercise 5
     *
     * Looks up the spelled-out word for a number from a predefined map and prints it.
     * @receiver number-to-word map
     * @sample number2word
     */
    fun spellNumber() {
        val number2word = mapOf(1 to "one", 2 to "two", 3 to "three")
        val n = 2
        println("$n is spelt as '${number2word[n]}'")
    }

    /**
     * Exercise 6
     *
     * Maps button inputs to actions and prints the result.
     * @throws IllegalArgumentException if button is unrecognized
     */
    fun buttonAction() {
        val button = "A"
        println(
            when (button) {
                "A" -> "Yes"
                "B" -> "No"
                "X" -> "Menu"
                "Y" -> "Nothing"
                else -> "There is no such button"
            }
        )
    }

    /**
     * Exercise 7
     *
     * Demonstrates a do-while loop by incrementing pizzaSlices until a full pizza (8 slices) is reached.
     * Prints the slice count at each step.
     */
    fun countPizzaSlices() {
        var pizzaSlices = 0
        pizzaSlices++

        do {
            println("There's only $pizzaSlices slice/s of pizza :(")
            pizzaSlices++
        } while (pizzaSlices < 8)

        println("There are $pizzaSlices slices of pizza. Hooray! We have a whole pizza! :D")
    }

    /**
     * Exercise 8
     *
     * Plays the classic FizzBuzz game from 1 to 100.
     * Prints "fizz" for multiples of 3, "buzz" for multiples of 5,
     * "fizzbuzz" for multiples of both, or the number otherwise.
     */
    fun playFizzBuzz() {
        for (number in 1..100) {
            println(
                when {
                    number % 15 == 0 -> "fizzbuzz"
                    number % 3 == 0 -> "fizz"
                    number % 5 == 0 -> "buzz"
                    else -> "$number"
                }
            )
        }
    }

    /**
     * Exercise 9
     *
     * Prints words from a list that start with the letter 'l'.
     */
    fun printWordsStartingWithL() {
        val words = listOf("dinosaur", "limousine", "magazine", "language")
        for (w in words) {
            if (w.startsWith("l"))
                println(w)
        }
    }

    /**
     * Exercise 10
     *
     * Generates a list of action URLs for a given book ID and prints them.
     * @receiver List of action names (e.g., "title", "year", "author").
     * @receiver URL prefix and book ID for constructing each URL.
     */
    fun generateActionUrls() {
        val actions = listOf("title", "year", "author")
        val prefix = "https://example.com/book-info"
        val id = 5
        val urls = actions.map { action -> "$prefix/$id/$action" }
        println(urls)
    }

    /**
     * Exercise 11
     *
     * Repeats the provided action function n times.
     *
     * @param n the number of times to execute the action
     * @param action a lambda to be invoked repeatedly
     */
    fun repeatActionNTimes(n: Int, action: () -> Unit) {
        for (i in 1..n) {
            action()
        }
    }

    /**
     * Exercise 12
     *
     * Retrieves the salary of an employee by their ID, returning 0 if not found.
     *
     * @param id the unique identifier of the employee
     * @return the salary of the employee or 0 if the employee does not exist
     */
    fun getEmployeeSalaryById(id: Int): Int {
        val employee = employeeById(id)
        return employee?.salary ?: 0
    }

    /**
     *
     * @param id the unique identifier of the employee
     * @return an Employee object if found, or null otherwise
     */
    fun employeeById(id: Int): Employee? = when (id) {
        1 -> Employee("Mary", 20)
        2 -> null
        3 -> Employee("John", 21)
        4 -> Employee("Ann", 23)
        else -> null
    }
}

data class Employee(val name: String, val salary: Int)