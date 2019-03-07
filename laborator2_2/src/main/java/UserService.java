public class UserService {

    public void listAllUsers(){
        User[] userList = OnlineShopService.getInstance().getUsers();
        for(int i=0; i< userList.length; i++){
            System.out.println(userList[i].getName());
        }
    }
}
