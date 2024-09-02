/**
 * Класс MyAbstractFactory предоставляет реализацию порождающего
 * паттерна: Абстрактная фабрика AbstractFactory.
 * Суть реализации: абстрактная фабрика представляет собой стратегию создания
 * семейства взаимосвязанных или родственных объектов.
 *
 * Для примера взята мебельная фабрика по производству мебели;
 * Абстрактный продукт - Мебель (Furniture);
 * Продукты: обеденный стол (dinnerTable), рабочий стол (desk)
 * Абстрактная фабрика - FurnitureFactory
 * Фабрики реализации: DeskFactory, DinnerTableFactory
 */

/**
* Абстрактный класс, который описывает абстрактный продукт,
 * создаваемый методом фабрики. Определяет общее представление
 * объектов, которые могут быть созданы методом в Фабрике.
* */
abstract class Furniture {
    public abstract void printFurniture();
}

/**
 * Класс, представляет реальный продукт, который производит
 * конкретная фабрика. Наследуется от абстрактного класса
 * Furniture и реализует метод создания.
 * */
class DinnerTable extends Furniture {
    public void printFurniture() {
        System.out.println("Создан обеденный стол.");
    }
}


/**
 * Класс, представляет реальный продукт, который производит
 * конкретная фабрика. Наследуется от абстрактного класса
 * Furniture и реализует метод создания.
 * */
class Desk extends Furniture {
    public void printFurniture() {
        System.out.println("Создан рабочий стол.");
    }
}

/**
 * Абстрактная фабрика, которая предоставляет схему для
 * создания объектов, реализующим класса, а именно: DinnerTableFactory и
 * DeskFactory.
 * */
interface FurnitureFactory {
    Furniture createFurniture();
}

/**
 *  Конкретная фабрика, реализующая интерфейс и методы в ней
 *  по созданию продукта, а именно DinnerTable.
 * */
class DinnerTableFactory implements FurnitureFactory {
    public Furniture createFurniture() {
        return new DinnerTable();
    }
}

/**
 *  Конкретная фабрика, реализующая интерфейс и методы в ней
 *  по созданию продукта, а именно Desk.
 * */
class DeskFactory implements FurnitureFactory {
    public Furniture createFurniture() {
        return new Desk();
    }
}


/**
 * Класс, представляющий "Создателя", использует абстрактную фабрику
 * для создания семейств объектов без указания конкретных их типов и
 * взаимодействует с объектами через абстрактные интерфейсы предоставляемые
 * абстрактными продуктами.
 * */
class Worker {
    private final Furniture currentFurniture;
    public Worker(FurnitureFactory factory) {
        currentFurniture = factory.createFurniture();
    }

    public Furniture getFurniture() {
        return currentFurniture;
    }
}