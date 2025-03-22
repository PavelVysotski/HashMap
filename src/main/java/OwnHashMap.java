import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class OwnHashMap<K, V> implements OwnMap<K, V> {

    public final int DEFAULT_BUCKET_SIZE = 16;

    public List<Bucket> buckets;

    public OwnHashMap() {
        this.buckets = new ArrayList<>();
        for (int i = 0; i < DEFAULT_BUCKET_SIZE; i++) {
            buckets.add(i, new Bucket());
        }
    }

    @Override
    public void put(K key, V value) {
        Entry entry = new Entry(key, value);
        int bucketIndex = getBucketIndex(key);
        if (bucketIndex < 0 || bucketIndex > DEFAULT_BUCKET_SIZE) {
            throw new Error("Out of bound");
        }
        Bucket matchBucket = buckets.get(bucketIndex);
        matchBucket.add(entry);
    }

    @Override
    public V get(K key) {
        int bucketIndex = getBucketIndex(key);
        if (bucketIndex < 0 || bucketIndex > DEFAULT_BUCKET_SIZE) {
            throw new Error("");
        }
        Bucket matchBucket = buckets.get(bucketIndex);
        return matchBucket.get(key).value;
    }

    private int getBucketIndex(K key) {
        int keyHashCode = key.hashCode();
        return keyHashCode % buckets.size();
    }

    public class Bucket {

        List<Entry> entryList = new LinkedList<>();

        public void add(Entry entry) {
            Entry existEntry = get(entry.key);
            if (get(entry.key) != null) {

                entryList.remove(existEntry);
            }
            entryList.add(entry);
        }

        public Entry get(K key) {
            for (Entry entry : entryList) {
                if (entry.key.equals(key)) {
                    return entry;
                }
            }
            return null;
        }
    }

    public class Entry {

        K key;
        V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
