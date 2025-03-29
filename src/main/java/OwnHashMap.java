import java.util.*;

public class OwnHashMap<K, V> implements Map<K, V> {

    public final int DEFAULT_BUCKET_SIZE = 16;

    public List<Bucket> buckets;

    public OwnHashMap() {
        this.buckets = new ArrayList<>();
        for (int i = 0; i < DEFAULT_BUCKET_SIZE; i++) {
            buckets.add(i, new Bucket());
        }
    }

    @Override
    public V put(K key, V value) {
        Entry entry = new Entry(key, value);
        int bucketIndex = getBucketIndex(key);
        if (bucketIndex < 0 || bucketIndex > DEFAULT_BUCKET_SIZE) {
            throw new Error("Out of bound");
        }
        Bucket matchBucket = buckets.get(bucketIndex);
        matchBucket.add(entry);
        return null;
    }

    @Override
    public V remove(Object key) {
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set<K> keySet() {
        return null;
    }

    @Override
    public Collection<V> values() {
        return null;
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public V get(Object key) {
        int bucketIndex = getBucketIndex(key);
        if (bucketIndex < 0 || bucketIndex > DEFAULT_BUCKET_SIZE) {
            throw new Error("");
        }
        Bucket matchBucket = buckets.get(bucketIndex);
        return matchBucket.get(key).value;
    }

    private int getBucketIndex(Object key) {
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

        public Entry get(Object key) {
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
