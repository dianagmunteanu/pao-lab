import org.apache.commons.lang3.StringUtils;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome to our online shop!");
        OnlineShopService onlineShopService = OnlineShopService.getInstance();
        onlineShopService.addProduct("mere", 3);
        onlineShopService.addProduct("apa", 2);

        System.out.println("Lista produse service1");
        onlineShopService.listProducts();
        String obiectulCautat = "pere";
        int id = onlineShopService.searchProductByName(obiectulCautat);
        if (id == -1) {
            System.out.println("\nProdusul " + obiectulCautat + " nu a fost gasit");
        } else {
            System.out.println("Produsul a fost gasit cu id-ul " + id);
        }

        System.out.println("Lista produse service2");
        OnlineShopService service2 = OnlineShopService.getInstance();
        service2.listProducts();

        UserService userService = new UserService();
        userService.listAllUsers();

        //Pentru compare stringuri
        System.out.println(StringUtils.compare("mere", "mere"));
        "mere".compareTo("mere");
    }
}
