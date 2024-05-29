enum Size {
    XXS(32) {
        @Override
        public String getDescription() {
            return "Детский размер";
        }
    },
    XS(34), S(36), M(38), L(40);

    private int euroSize;

    Size(int euroSize) {
        this.euroSize = euroSize;
    }

    public String getDescription() {
        return "Взрослый размер";
    }

    public int getEuroSize() {
        return euroSize;
    }
}

interface MenClothing {
    void dressMan();
}

interface WomenClothing {
    void dressWoman();
}

abstract class Clothing {
    Size size;
    double cost;
    String color;

    Clothing(Size size, double cost, String color) {
        this.size = size;
        this.cost = cost;
        this.color = color;
    }
}

class TShirt extends Clothing implements MenClothing, WomenClothing {
    TShirt(Size size, double cost, String color) {
        super(size, cost, color);
    }

    public void dressMan() {
        System.out.printf("Мужчина одет в  футболку: цвет котрой - %s, цена которой - %.2f и размер которой - %s, %d, %s\n",
                color, cost, size.name(), size.getEuroSize(), size.getDescription());
    }

    public void dressWoman() {
        System.out.printf("Женщина одета в футболку: цвет которой - %s, цена которой - %.2f и размер которой - %s, %d, %s\n",
                color, cost, size.name(), size.getEuroSize(), size.getDescription());
    }
}

class Trousers extends Clothing implements MenClothing, WomenClothing {
    Trousers(Size size, double cost, String color) {
        super(size, cost, color);
    }

    public void dressMan() {
        System.out.printf("Мужчина в штанах: цвет которых - %s, цена которых - %.2f и размер которых - %s, %d, %s\n",
                color, cost, size.name(), size.getEuroSize(), size.getDescription());
    }

    public void dressWoman() {
        System.out.printf("Женщина в штанах: цвет которых - %s, цена которых - %.2f и размер которых - %s, %d, %s\n",
                color, cost, size.name(), size.getEuroSize(), size.getDescription());
    }
}

class Skirt extends Clothing implements WomenClothing {
    Skirt(Size size, double cost, String color) {
        super(size, cost, color);
    }

    public void dressWoman() {
        System.out.printf("Женщина одета в юбку: цвет которой - %s, цена которой - %.2f и размер которой - %s, %d, %s\n",
                color, cost, size.name(), size.getEuroSize(), size.getDescription());
    }
}

class Tie extends Clothing implements MenClothing {

    Tie(Size size, double cost, String color) {
        super(size, cost, color);
    }

    public void dressMan() {
        System.out.printf("Мужчина с галстуком: цвета - %s, с ценой - %.2f и с размером - %s, %d, %s\n",
                color, cost, size.name(), size.getEuroSize(), size.getDescription());
    }
}

class Atelier {
    static void dressWomen(Clothing[] clothes) {
        for (Clothing c : clothes) {
            if (c instanceof WomenClothing) {
                ((WomenClothing) c).dressWoman();
            }
        }
    }

    static void dressMen(Clothing[] clothes) {
        for (Clothing c : clothes) {
            if (c instanceof MenClothing) {
                ((MenClothing) c).dressMan();
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Clothing[] clothing = new Clothing[4];
        clothing[0] =  new TShirt(Size.M, 1234.55, "Белый");
        clothing[1] =  new Trousers(Size.L, 5643.44, "Черный");
        clothing[2] =  new Skirt(Size.XXS, 1212.33, "Желтый");
        clothing[3] =  new Tie(Size.XS, 9999.22, "Красный");

        Atelier.dressMen(clothing);
        Atelier.dressWomen(clothing);
    }
}