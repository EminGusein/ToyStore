import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Store {
    private List<Toy> toys;
    private List<Toy> prize;

    public Store () {
        toys = new ArrayList<>();
        prize = new ArrayList<>();
    }

    public void addToy(int id, String name, int quantity, double weight){
        Toy toy = new Toy(id, name, quantity, weight);
        toys.add(toy);
    }

    public void setToyWeight(int id, double weight){
        for (Toy toy: toys) {
            if (toy.getId() == id) {
                toy.setWeight(weight);
                break;
            }
        }
    }

    public void raffle() {
        double totalWeight = 0;
        for (Toy toy : toys) {
            totalWeight += toy.getWeight();
        }

        Random random = new Random();
        double randomNumber = random.nextDouble() * totalWeight;

        Toy prizeToy = null;
        for (Toy toy : toys) {
            if (randomNumber < toy.getWeight()) {
                prizeToy = toy;
                break;
            }
            randomNumber -= toy.getWeight();
        }

        if (prizeToy != null && prizeToy.getQuantity() > 0) {
            prize.add(prizeToy);

            prizeToy.setQuantity(prizeToy.getQuantity() - 1);
        }

    }

    public void getPrize() throws IOException {
        if (!prize.isEmpty()) {
            Toy prizeToy = prize.remove(0);

            FileWriter writer = new FileWriter("prize.txt", true);
            writer.write(prizeToy.getId() + "," + prizeToy.getName() + "\n");
            writer.close();
        }
    }






}
