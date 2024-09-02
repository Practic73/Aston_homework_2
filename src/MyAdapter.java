/**
 * Класс MyAdapter реализует структурный паттерн: Адаптер.
 * Роль двух интерфейсов выполняют
 * */


/**
 * Основной интерфейс, который содержит методы, требующиеся
 * для клиентского кода.
 * */
interface Printer {
     void print();
}

/**
 * Класс с несовместимым кодом, который нельзя использовать
 * напрямую.
 * */
class LegacyPrinter {
    public void printDocument() {
        System.out.println("Печать документа на старом принтере.");
    }
}

/**
 * Класс реализует основной интерфейс и переопределяет метод,
 * используя метод из адаптируемого класса.
 * */
class PrinterAdapter implements Printer {
    private final LegacyPrinter legacyPrinter;

    public PrinterAdapter(LegacyPrinter legacyPrinter) {
        this.legacyPrinter = legacyPrinter;
    }

    @Override
    public void print() {
        legacyPrinter.printDocument();
    }
}

/**
 * Код, который использует целевой интерфейс для взаимодействия
 * с объектами. Он остается неосведомленным о конкретных деталях
 * реализации адаптируемого объекта и адаптера.
 * */
class clientCode {
    public  Printer printer;
    public clientCode(Printer printer) {
        this.printer = printer;
    }
}
