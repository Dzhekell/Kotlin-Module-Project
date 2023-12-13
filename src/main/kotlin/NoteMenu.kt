class NoteMenu() {
    var lastNumber: Int = 0

        fun showNoteMenu(archive: Archive) {
            while (true) {
                println("0. Создать заметку")
                for (key in archive.noteMap.keys) {
                    val number: Int = key
                    val note: Note = archive.noteMap.get(key)!!
                    println("${number}. ${note.name}")
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
                    println("Введите имя заметки:")
                    newNote(MenuLogic.getObjectName(), archive)
                } else if (command == lastNumber) {
                    return
                } else {
                    val currentNote: Note = archive.noteMap.get(command)!!
                    readNote(currentNote)
                }
            }
        }

        fun newNote(name: String, archive: Archive) {
           val newNote = Note(name)
           println("Введите текст заметки:")
           val text: String = MenuLogic.getObjectName()
            val currentNumber: Int = lastNumber + 1
            newNote.text = text
           archive.noteMap.put(currentNumber, newNote)
            lastNumber = currentNumber
        }

        fun readNote(note: Note) {
            println("Заметка \"${note.name}\"")
            println(note.text)
            println("0. Выход")
            while (true) {
                val command: Int = MenuLogic.getUserAnswer()
                if (command == 0)
                    return
                else
                    println("Команда не найдена! Попробуйте снова.")
            }
        }


}