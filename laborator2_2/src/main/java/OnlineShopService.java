public class OnlineShopService {

    private static final OnlineShopService onlineShopService = new OnlineShopService();

    private OnlineShopService() {
    }

    public static OnlineShopService getInstance(){
        return  onlineShopService;
    }

    private User[] users = new User[]{
            new User(1, "gigel", "admin"),
            new User(2, "ionel", "cumparator"),
            new User(3, "marioara", "cumparator")
    };
    private Product[] products = new Product[40];
    private int numberOfProducts = 0;

    public int searchProductByName(String productName){
        for(int i = 0; i < numberOfProducts; i++){
            if(productName.equals(products[i].getName())){
                return products[i].getId();
            }
        }
        return -1;
    }
    //sortAll

    public void addProduct(String productName, int price){
        System.out.println("Adding new product: "+productName);
        Product newProduct = new Product(numberOfProducts, productName, price);
        products[numberOfProducts] = newProduct;
        System.out.println("Product "+productName+" was added with id "+numberOfProducts);
        numberOfProducts ++;

    }
    public void listProducts(){
        for (int i=0; i<numberOfProducts; i++){
            System.out.println(products[i].getId()+": "+products[i].getName());
        }
    }

    public User[] getUsers() {
        return users;
    }
    //deleteProduct
    //registerUser
    //buyProduct
}
