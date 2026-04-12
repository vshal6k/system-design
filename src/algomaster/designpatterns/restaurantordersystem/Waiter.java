package algomaster.designpatterns.restaurantordersystem;

import java.util.Stack;

public class Waiter {
    private Stack<Command> commands = new Stack<>();
    private Stack<Command> undoStack = new Stack<>();

    public void takeOrder(Command command){
        commands.push(command);
    }

    public void undoLast(){
        if(undoStack.empty()){
            System.out.println("Nothing to undo.");
            return;
        }
        undoStack.pop().undo();
    }

    public void submitOrders(){
        for (Command command : commands) {
            command.execute();
            undoStack.push(command);
        }
    }
}
