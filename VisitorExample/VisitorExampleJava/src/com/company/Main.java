package com.company;

public class Main {

    public static void main(String[] args) {
        // Új inventory
        Inventory inventory = new Inventory();

        // Fordok
        Ford f = new Ford("asd");
        inventory.add(f);

        // Toyoták
        Toyota t1 = new Toyota("sad");
        Toyota t2 = new Toyota("dsa");
        inventory.add(t1);
        inventory.add(t2);

        // Airbusok
        Airbus a = new Airbus("123");
        inventory.add(a);

        // Boeingek
        Boeing b1 = new Boeing("234");
        Boeing b2 = new Boeing("345");
        inventory.add(b1);
        inventory.add(b2);

        // Új visitor
        InventorySorterVisitor visitor = new InventorySorterVisitor();

        // Látogatások
        inventory.accept(visitor);

        // Nem szétválogatott inventory (Ezek IStorable-ként vannak tárolva, type-check nélkül nem látnád úgy, mint a listában)
        System.out.println("Nem szétválogatott inventory:");
        System.out.println(inventory.getInventory());

        // Szétválogatott inventory
        System.out.println("\nSzétválogatott inventory:");
        System.out.println(visitor.ford);
        System.out.println(visitor.airbus);
        System.out.println(visitor.boeing);
        System.out.println(visitor.toyota);

    }
}
