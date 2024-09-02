/**
 * Реализация паттерна: Chain of Responsibility.
 * Паттерн используется для обработки запросов, когда
 * есть несколько объектов, каждый из которых может обработать запрос. Этот
 * паттерн позволяет избежать прямого обращения к конкретному объекту, который
 * будет обрабатывать запрос, вместо этого запрос передаётся по цепочке объектов
 * до тех пор, пока один из них не сможет его обработать.
 * */
package ChainOfResponsibility;

/**
 * Класс Handler является абстрактным базовым классом,
 * который определяет интерфейс для обработки запросов.
 * */
public abstract class Handler {
    private Handler successor;

    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    public boolean handleRequest(String request) {
        if (canHandle(request)) {
            return processRequest(request);
        } else if (successor != null) {
            return successor.handleRequest(request);
        }
        return false;
    }

    protected abstract boolean canHandle(String request);
    protected abstract boolean processRequest(String request);
}

