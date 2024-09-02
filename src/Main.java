import ChainOfResponsibility.ConcreteHandler;
import ChainOfResponsibility.Handler;

public class Main {
    public static void main(String[] args) {
        startCustomChainOfResposibility();
    }

    /**
     * Cоздаются два экземпляра ConcreteHandler,
     * которые связываются в цепочку через метод setSuccessor.
     * Затем запрос передаётся первому объекту в цепочке,
     * который либо обрабатывает его самостоятельно, если может,
     * либо передаёт следующему объекту в цепочке.
     * Процесс продолжается до тех пор,
     * пока запрос не будет обработан или пока не будет достигнут конец цепочки.
     * */
    public static void startCustomChainOfResposibility(){
        Handler handler1 = new ConcreteHandler();
        Handler handler2 = new ConcreteHandler();

        handler1.setSuccessor(handler2);

        String request = "Process request";
        if (handler1.handleRequest(request)) {
            System.out.println("Request was handled successfully.");
        } else {
            System.out.println("No handler could process the request.");
        }
    }
}