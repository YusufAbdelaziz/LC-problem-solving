
class TimeMap {

    // Key is the key, and the list stores the pair of value and timestamp.
    private Map<String, List<TimeValue>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        //     var entry = new AbstractMap.SimpleEntry<String, Integer>();
        // if (!map.containsKey(key)) {
        //     var newList = new ArrayList<Map.Entry<String, Integer>>();
        //     entry,put(value, timestamp);
        //     newList.add(entry);
        //     map.put(key, newList);

        // } else {
        //     var existingList = map.get(key);
        //     entry = new AbstractMap.SimpleEntry<String, Integer>(value, timestamp);
        //     existingList.add(entry);
        // }

        map.computeIfAbsent(key, k -> new ArrayList<>()).add(new TimeValue(value, timestamp));

    }

    public String get(String key, int timestamp) {
        var list = map.get(key);
        if (list == null || list.isEmpty())
            return "";
        return binarySearch(list, timestamp);

    }

    private String binarySearch(List<TimeValue> list, int timestamp) {
        int l = 0;
        int h = list.size() - 1;
        while (l <= h) {

            // Since these are postive integers, it's safe to use >>>.
            int mid = l + ((h - l) >>> 1);
            TimeValue tv = list.get(mid);
            var ts = tv.getTs();
            var val = tv.getValue();
            if (timestamp == ts)
                return val;

            else if (ts > timestamp) {

                h = mid - 1;

            } else {
                l = mid + 1;
            }
        }

        return h >= 0 ? list.get(h).getValue() : "";
    }

    class TimeValue {
        private String value;
        private Integer ts;

        TimeValue(String value, Integer ts) {
            this.value = value;
            this.ts = ts;
        }

        public String getValue() {
            return value;
        }

        public Integer getTs() {
            return ts;
        }
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */