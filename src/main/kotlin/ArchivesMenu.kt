class ArchivesMenu {
    val archivesMap: MutableMap <Int, Archive> = mutableMapOf()
    var numberOfArchives: Int = 0

    private fun newArchive(name: String) {
        val newArchive: Archive = Archive(name)
        val currentNumber: Int = numberOfArchives + 1
        archivesMap.put(currentNumber, newArchive)
        numberOfArchives = currentNumber
    }

    fun showMenu() {
        while (true) {
            println("Список архивов:")
            var lastNumber: Int = 0
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
            var command: Int = 0
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
                println("Введите имя архива:")
                newArchive(MenuLogic.getObjectName())
            } else if (command == lastNumber) {
                return
            } else {
                val neededArchive: Archive = archivesMap.get(command)!!
                val noteMenu: NoteMenu = NoteMenu()
                noteMenu.showNoteMenu(neededArchive)
            }
        }
    }
}