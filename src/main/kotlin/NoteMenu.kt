class NoteMenu {
    private var numberOfNotes: Int = 0

        fun showNoteMenu(archive: Archive) {
            while (true) {
                var lastNumber = 0
                println("0. Создать заметку")
                for (key in archive.noteMap.keys) {
                    val number: Int = key
                    val note: Note = archive.noteMap.get(key)!!
                    println("${number}. ${note.name}")
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
                    var noteName: String
                    while (true) {
                        println("Введите имя заметки:")
                        noteName = MenuLogic.getObjectName()
                        if (noteName.equals("") or noteName.equals(" ")) {
                            println("Имя заметки не может быть пустым! Попробуйте снова.")
                        } else {
                            break
                        }
                    }
                    newNote(noteName, archive)
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
            var text: String
            while (true) {

                println("Введите текст заметки:")
                text = MenuLogic.getObjectName()
                if (text.equals("")  or text.equals(" ")) {
                    println("Текст заметки не может быть пустым! Попробуйте снова.")
                } else {
                    break
                }                }
                val currentNumber: Int = numberOfNotes + 1
                newNote.text = text
                archive.noteMap.put(currentNumber, newNote)
                numberOfNotes = currentNumber
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