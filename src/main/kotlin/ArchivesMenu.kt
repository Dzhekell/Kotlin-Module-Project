class ArchivesMenu {
    val archivesMap: MutableMap <Int, Archive> = mutableMapOf()
    var numberOfArchives: Int = 0

    private fun newArchive(name: String) {
        val newArchive = Archive(name)
        val currentNumber: Int = numberOfArchives + 1
        archivesMap.put(currentNumber, newArchive)
        numberOfArchives = currentNumber
    }

    fun showMenu() {
        while (true) {
            println("Список архивов:")
            var lastNumber = 0
            println("0. Создать архив")
            for (key in archivesMap.keys) {
                val str: Archive? = archivesMap.get(key)
                val number: Int = key
                val list: String = str!!.name
                println("${number}. ${list}")
                lastNumber = number
            }
            lastNumber += 1
            println("${lastNumber}. Выход")
            var command: Int
            while (true) {
                val answer: Int = MenuLogic.getUserAnswer()
                if (answer > lastNumber) {
                    println("Команда не найдена! Пожалуйста, повторите попытку")
                } else if (answer < 0) {
                    println("Команда не найдена! Пожалуйста, повторите попытку")
                } else {
                    command = answer
                    break
                }
            }
            if (command == 0) {
                var archiveName: String
                while (true) {
                    println("Введите имя архива:")
                    archiveName = MenuLogic.getObjectName()
                    if (archiveName.equals("") or archiveName.equals(" ")) {
                        println("Имя архива не может быть пустым! Попробуйте снова.")
                    } else {
                        break
                    }
                }
                newArchive(archiveName)
            } else if (command == lastNumber) {
                return
            } else {
                val neededArchive: Archive = archivesMap.get(command)!!
                val noteMenu = NoteMenu()
                noteMenu.showNoteMenu(neededArchive)
            }
        }
    }
}