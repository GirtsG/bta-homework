import java.util.Iterator;
import java.util.Map;

public class PrettyPrintFrequencyMap<K, V> {

    private final Map<K, V> map;

    public PrettyPrintFrequencyMap(Map<K, V> map) {
        this.map = map;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator<Map.Entry<K, V>> iter = map.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<K, V> entry = iter.next();
            sb.append(entry.getKey());
            sb.append('\t');
            sb.append(entry.getValue());
            sb.append('%');
            if (iter.hasNext()) {
                sb.append('\n');
            }
        }
        return sb.toString();

    }
}
