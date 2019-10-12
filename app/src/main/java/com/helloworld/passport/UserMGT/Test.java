//import User.User;
public class Test
{
    public static void main(String[]args){
        User user1 = new User();
//        user1.writeInfo("Becky", "BigBecky");
        boolean matches = user1.checkInfo("Becky", "BigBecky");
        System.out.println(""+matches);
//        System.out.println("hello world");
    }
}