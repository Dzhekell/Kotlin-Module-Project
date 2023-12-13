import java.util.Scanner

class MenuLogic<T> {


    companion object {
        fun mainMenu() {
            println("Добро пожаловать в приложение \"Заметки\". Пожалуйста, выберете нужный пункт:")
        }
        fun getUserAnswer():Int {
            var answer: String = ""
            while (true) {
                answer = Scanner(System.`in`).nextLine()
                val check: Int? = answer.toIntOrNull()
                if (check == null && answer != "0") {
                    println("Ответ не является числом! Пожалуйста, повторите ввод")
                } else {
                    break
                }
            }
            return answer.toInt()
        }

        fun getObjectName(): String {
            return Scanner(System.`in`).nextLine()
        }

    }

}