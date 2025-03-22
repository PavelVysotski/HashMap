public class Main {
    public static void main(String[] args) {
        OwnMap<String, String> ownMap = new OwnHashMap<>();

        ownMap.put("Key", "Value");
        ownMap.put("Key", "Nice");
        ownMap.put("Key2", "Value2");
        ownMap.put("Key3", "Value3");
        ownMap.put("Key4", "Value4");

        System.out.println(ownMap.get("Key"));
        System.out.println(ownMap.get("Key2"));
        System.out.println(ownMap.get("Key3"));
        System.out.println(ownMap.get("Key4"));
    }
}
