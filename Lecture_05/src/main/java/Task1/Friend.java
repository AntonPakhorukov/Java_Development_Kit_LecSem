package Task1;

public class Friend {
    private String name;
    public Friend(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public synchronized void bow(Friend friend){
        System.out.println(name + ": " + friend.getName() + " подал мне руку");
        friend.bowBack(this);
    }
    private synchronized void bowBack(Friend friend){
        System.out.println(name + ": протянул руку в ответ " + friend.getName());
    }
}
