import java.util.Objects;

public class Item {
    private String name;
    private String phone;

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }

    public String getPhone(){
        return phone;
    }

    public void setPhone(String phone){
        this.phone=phone;
    }

    Item(String name, String phone){
        this.name=name;
        this.phone=phone;
    }

    @Override
    public String toString() {
        return "Name: "+getName()+" | Phone: "+getPhone()+" |";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;
        Item item = (Item) o;
        return Objects.equals(name, item.name) &&
                Objects.equals(phone, item.phone);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, phone);
    }
}
