package JMeter;

public class JMeter {
	String name;
	String friend;
	void setName(String name1) {
		this.name=name1;
	}
	String getName() {
		return this.name;
	}
	void setFriend(String friend1) {
		this.friend=friend1;
	}
	String getFriend() {
		return this.friend;
	}
	public static void main(String[] args) {
         JMeter j= new JMeter();
         j.setFriend("aaa");
         j.setName("Bob");
         System.out.println("JMeter's friend is "+j.getFriend());
         System.out.println("JMeter's friend's name is "+j.getName());
	}
}

