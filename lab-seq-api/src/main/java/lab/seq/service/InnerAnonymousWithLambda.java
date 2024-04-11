package lab.seq.service;

import org.apache.commons.lang3.RandomUtils;
import org.springframework.util.function.SupplierUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDate;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.Stack;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.Executors;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.LongToIntFunction;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToIntBiFunction;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class InnerAnonymousWithLambda {

    public static void main(String[] args) {

        Runnable r = () -> {

            for (int i = 0; i < 10; i++) {
                System.out.println("Child");
            }
        };

        Thread t = new Thread(r);

        t.start();

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            System.out.println("Main");
            list.add(i);
        }

        List<Integer> collect = list.stream().filter(i -> i < 2).collect(Collectors.toList());

        Predicate<Integer> p = s -> s > 10;

        Predicate<String> pString = s -> !s.isEmpty() && s != null;

        List<String> arrayString = new ArrayList<>();
        arrayString.add("aa");
        arrayString.add("bb");

        // arrayString.removeIf( pString );

        //arrayString.stream().filter( pString);

        System.out.println(arrayString.stream().map(i -> i.length() * 3).collect(Collectors.toList()));

        Predicate<String> predicate = Predicate.isEqual("Observe carefully Sir");

        Function<String, Integer> f = s -> s.length();

        f = a -> a.length() + 3;

        System.out.println(f.apply("Ola"));


        String ola = "ola";

        f.andThen(a -> a.intValue() + 3);

        Function.identity();

        Consumer<String> consumer = System.out::println;

        consumer.accept("Olá");

        Supplier<String> supplier = new Supplier<String>() {
            @Override
            public String get() {
                return "Ola";
            }
        };

        supplier.get();


        Supplier<LocalDate> supplier1 = LocalDate::now;


        System.out.println(supplier1.get());

        System.out.println((int) (Math.random() * 10));

        BiPredicate<String, String> biPredicate = (s1, s2) -> s1.equals(s2);

        biPredicate.test("Ola", "Ola");

        BiFunction<String, String, Integer> biFunction = (s1, s2) -> s1.length() + s2.length();

        biFunction.apply("S1", "S2");

        BiConsumer<String, String> consumer1 = (s1, s2) -> s1 = s2;
        consumer1.accept("Ola", "Ola2");

        final Integer i = 3;

        //IntPredicate intPredicate = i -> i%2 == 0;

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("www").append("oal");

        ToIntBiFunction<String, String> e = (s1, s2) -> s1.length() + s2.length();

        LongToIntFunction re = myinteger -> 122;

        IntConsumer d = (rrr) -> System.out.println(rrr * rrr);

        re.applyAsInt(123L);
//        UnaryOperator
        //BinaryOperator

        System.out.println(arrayString.stream().sorted(String::compareTo).collect(Collectors.toList()));

        // arrayString.stream().min()
        System.out.println(arrayString.stream().max(String::compareTo));

        arrayString.stream().forEach(System.out::println);

        // Creating a list of Strings
        List<String> list2 = Arrays.asList("5.36", "2.79",
                "3", "42", "5");

        // Using Stream mapToLong(ToLongFunction mapper)
        // and displaying the corresponding LongStream
        list2.stream().flatMapToDouble(n
                        -> DoubleStream.of(Double.parseDouble(n)))
                .forEach(System.out::println);


        Stream<Integer> s = Stream.of(9, 99, 999); // stream for group of values

        s.collect(Collectors.toList());
        Executors.newCachedThreadPool();

        Thread thread = new Thread(() -> System.out.println("Hello from the other side"));
        System.out.println(thread.getState());
        thread.start();

        RestTemplate restTemplate = new RestTemplate();
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromUriString("http://localhost:8080");
        // restTemplate.getForEntity(uriComponentsBuilder.toUriString(), )

        String a = "ola";

        String[] split = a.split(",");

        Arrays.stream(split).collect(Collectors.toList());

        List<String> array = new ArrayList<>();
        array.add("Red");
        array.add("Blue");
        array.set(1, "Green");

        array.forEach(item -> System.out.println("Ola" + item));

        List<Integer> array2 = new ArrayList<>();
        array2.add(1);
        array2.add(3);
        array2.add(4);

        Optional<Integer> max = array2.stream().max((x, y) -> x > y ? 1 : x < y ? -1 : 0);

        Optional<Integer> max2 = array2.stream().max((x, y) -> x.compareTo(y));

        Optional<Integer> min = array2.stream().min(Integer::compare);

        System.out.println("array" + array);

        System.out.println("max" + max.get());
        System.out.println("min" + min.get());


        System.out.println("isEquals" + isArraysEquals());

        LinkedList<Integer> linkedList = new LinkedList<>();

        linkedList.add(1);
        linkedList.add(2);

        Iterator<Integer> iterator = linkedList.iterator();

        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println("Last" + linkedList.getLast());

        Set<Integer> set = new HashSet<>(array2);

        Stack<String> stack = new Stack<>();

        stack.add("Vera");
        stack.add("Lima");
        System.out.println("Pop stack " + stack.pop());

        System.out.println("Peek stack " + stack.peek());


        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        map.put("1", 1);
        map.put("2", 2);


        map2.put("1", 1);
        map2.put("2", 2);

        map.forEach( (key, value) -> map2.merge(key, value, Integer::sum));

        System.out.println("MAp" + map2);

        UUID uuid = UUID.randomUUID();
        uuid.toString();

        toy();

        clientQueue();

        Collection<String> collection = new ArrayList<>();

        collection.add("Ola");

        Iterator<String> iterator1 = collection.iterator();

        while(iterator1.hasNext()){

            System.out.println(iterator1.next());
        }
    }

    protected static boolean isArraysEquals2() {
        List<Integer> arrayToCompare1 = Arrays.asList(1, 2, 3, 4);
        List<Integer> arrayToCompare2 = Arrays.asList(1, 2, 3, 4);
        return arrayToCompare1.equals(arrayToCompare2);
    }

    protected static boolean isArraysEquals3() {
        List<Integer> arrayToCompare1 = Arrays.asList(1, 2, 3, 4);
        List<Integer> arrayToCompare2 = Arrays.asList(1, 2, 3, 4);
        return arrayToCompare1.equals(arrayToCompare2);
    }

    protected static boolean isArraysEquals() {
        List<Integer> arrayToCompare1 = Arrays.asList(1, 2, 3, 4);
        List<Integer> arrayToCompare2 = Arrays.asList(1, 2, 3, 4);

        if (arrayToCompare1.size() != arrayToCompare2.size()) {
            return false;
        }

        for (int i = 0; i < arrayToCompare1.size(); i++) {

            int compareResult = arrayToCompare1.get(i).compareTo(arrayToCompare2.get(i));

            if (compareResult != 0) {
                return false;
            }
        }

        return true;
    }

    private static void toy(){

        List<String> clients = new ArrayList<>();

        clients.add("Vera");
        clients.add("Lima");

        Random random = new Random();

        System.out.println("Winner is " + clients.get(random.nextInt(clients.size())));


    }

    private static void clientQueue(){

        Queue<String> queue = new LinkedList<>();

        queue.add("Vera");
        queue.add("Lima");

        queue.offer("Marques");

        System.out.println("Poll " + queue.poll());
        System.out.println("Peek " + queue.peek());
        Deque<String> deque = new ArrayDeque<>();

        Map<Object, Object> objectObjectMap = Collections.synchronizedMap(new HashMap<>());

        Set<Object> objects = objectObjectMap.keySet();

        synchronized (objectObjectMap){

            Iterator<Object> iterator = objects.iterator();

            while(iterator.hasNext()){
                System.out.println("" + iterator.next());
            }
        }

        ConcurrentMap<String, String> lkl = new ConcurrentHashMap<>();

        lkl.put("Ola", "Ola");
    }

}
