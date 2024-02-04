import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Store store = new Store();

        store.addToy(1, "Toy1", 20, 40);
        store.addToy(2, "Toy2", 5, 10);
        store.addToy(3, "Toy3", 10, 20);
        store.addToy(4, "Toy4", 15, 30);

        store.raffle();
        store.getPrize();


    }
}
