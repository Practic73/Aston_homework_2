package ChainOfResponsibility;

/**
 * Класс ConcreteHandler наследуется от Handler и реализует методы canHandle и processRequest,
 * где определяется, может ли данный объект обработать запрос, и как он это делает.
 * */
public class ConcreteHandler extends Handler {

    @Override
    protected boolean canHandle(String request) {
        // Здесь должна быть логика определения, может ли данный объект обработать запрос
        return request.startsWith("ок");
    }

    @Override
    protected boolean processRequest(String request) {
        // Здесь должна быть логика обработки запроса
        System.out.println("Обработка запроса: " + request);
        return true;
    }
}
