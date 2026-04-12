package algomaster.designpatterns.handler.loggersystem;

public enum LogLevel {
    DEBUG(1), INFO(2), WARN(3), ERROR(4);

    private int level;

    LogLevel(int level){
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public static void main(String[] args) {
        for (int i = 0; i < LogLevel.values().length; i++) {
            System.out.println(LogLevel.values()[i].toString() + " " + LogLevel.values()[i].getLevel());
        }
    }
}
