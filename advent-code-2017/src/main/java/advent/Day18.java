package advent;

import java.util.*;

public class Day18 {

    private static String input =
            "set i 31\n" +
            "set a 1\n" +
            "mul p 17\n" +
            "jgz p p\n" +
            "mul a 2\n" +
            "add i -1\n" +
            "jgz i -2\n" +
            "add a -1\n" +
            "set i 127\n" +
            "set p 735\n" +
            "mul p 8505\n" +
            "mod p a\n" +
            "mul p 129749\n" +
            "add p 12345\n" +
            "mod p a\n" +
            "set b p\n" +
            "mod b 10000\n" +
            "snd b\n" +
            "add i -1\n" +
            "jgz i -9\n" +
            "jgz a 3\n" +
            "rcv b\n" +
            "jgz b -1\n" +
            "set f 0\n" +
            "set i 126\n" +
            "rcv a\n" +
            "rcv b\n" +
            "set p a\n" +
            "mul p -1\n" +
            "add p b\n" +
            "jgz p 4\n" +
            "snd a\n" +
            "set a b\n" +
            "jgz 1 3\n" +
            "snd b\n" +
            "set f 1\n" +
            "add i -1\n" +
            "jgz i -11\n" +
            "snd a\n" +
            "jgz f -16\n" +
            "jgz a -19\n";

    public static void main(String[] args) {
        System.out.println(prob1(input));
        System.out.println(prob2(input));
    }

    public static long prob1(String input) {
        Map<String, Long> registers = new HashMap<>();
        String[] lines = input.split("\\r?\\n");
        int  i = 0;
        Long freq = null;
        while (i < lines.length) {
            String[] split = lines[i].split(" ");
            String op = split[0];
            String reg = split[1];
            String val = null;
            if (split.length == 3) {
                val = split[2];
            }
            Long a;
            switch (op) {
                case "set":
                    try {
                        a = Long.parseLong(val);
                        registers.put(reg, a);
                    } catch (Exception e) {
                        registers.put(reg, registers.getOrDefault(val, 0L));
                    }
                    break;
                case "add":
                    a = registers.getOrDefault(reg, 0L);
                    a += Long.parseLong(val);
                    registers.put(reg, a);
                    break;
                case "mod":
                    a = registers.getOrDefault(reg, 0L);
                    try {
                        a = a % registers.getOrDefault(val, 0L);
                    } catch (Exception e) {
                        a = a % Long.parseLong(val);
                    }
                    registers.put(reg, a);
                    break;
                case "mul":
                    a = registers.getOrDefault(reg, 0L);
                    try {
                        a = a * Long.parseLong(val);
                    } catch (Exception e) {
                        a = a * registers.get(val);
                    }
                    registers.put(reg, a);
                    break;
                case "snd":
                    freq = registers.getOrDefault(reg, 0L);
                    break;
                case "rcv":
                    a = registers.getOrDefault(reg, 0L);
                    if (a != 0) return freq;
                    break;
                case "jgz":
                    if (registers.getOrDefault(reg, 0L) > 0) {
                        i += Long.parseLong(val);
                        continue;
                    }
            }
            i++;
        }
        return freq;
    }

    public static int prob2(String input) {
        Map<String, Map<String, Long>> registers = new HashMap<>();
        registers.put("0", new HashMap<>());
        registers.put("1", new HashMap<>());
        registers.get("0").put("p", 0L);
        registers.get("1").put("p", 1L);
        registers.get("0").put("other", 1L);
        registers.get("1").put("other", 0L);
        registers.get("0").put("index", 0L);
        registers.get("1").put("index", 0L);

        Map<String, Queue<Long>> queues = new HashMap<>();

        int count = 0;
        Queue<Long> p0 = new ArrayDeque<>();
        Queue<Long> p1 = new ArrayDeque<>();
        queues.put("0", p0);
        queues.put("1", p1);

        String current = "0";

        String[] lines = input.split("\\r?\\n");
        boolean done = false;
        while (registers.get(current).get("index") < lines.length) {
            Map<String, Long> currentMap = registers.get(current);
            String[] split = lines[Math.toIntExact(currentMap.get("index"))].split(" ");
            String op = split[0];
            String reg = split[1];
            String val = null;
            if (split.length == 3) {
                val = split[2];
            }
            Long a;
            switch (op) {
                case "set":
                    try {
                        a = Long.parseLong(val);
                        currentMap.put(reg, a);
                    } catch (Exception e) {
                        currentMap.put(reg, currentMap.getOrDefault(val, 0L));
                    }
                    break;
                case "add":
                    Long curVal = currentMap.get(reg);
                    try {
                        a = Long.parseLong(val) + curVal;
                    } catch (Exception e) {
                        a = currentMap.get(val) + curVal;
                    }
                    currentMap.put(reg, a);
                    break;
                case "mod":
                    a = currentMap.getOrDefault(reg, 0L);
                    try {
                        a = a % currentMap.getOrDefault(val, 0L);
                    } catch (Exception e) {
                        a = a % Long.parseLong(val);
                    }
                    currentMap.put(reg, a);
                    break;
                case "mul":
                    a = currentMap.getOrDefault(reg, 0L);
                    try {
                        a = a * Long.parseLong(val);
                    } catch (Exception e) {
                        a = a * currentMap.get(val);
                    }
                    currentMap.put(reg, a);
                    break;
                case "snd":
                    if (current.equals("1")) count++;
                    try {
                        a = Long.parseLong(reg);
                    } catch (Exception e) {
                        a = currentMap.get(reg);
                    }
                    queues.get(currentMap.get("other").toString()).add(a);
                    break;
                case "rcv":
                    if (p0.size() == 0 && p1.size() == 0) {
                        done = true;
                    } else if (queues.get(current).size() == 0) {
                        current = currentMap.get("other").toString();
                        continue;
                    } else {
                        currentMap.put(reg, queues.get(current).remove());
                    }
                    break;
                case "jgz":
                    Long cond;
                    try {
                        cond = Long.parseLong(reg);
                    } catch (Exception e) {
                        cond = currentMap.getOrDefault(reg, 0L);
                    }
                    if (cond > 0) {
                        try {
                            a = Long.parseLong(val);
                        } catch (Exception e) {
                            a = currentMap.get(val);
                        }
                        currentMap.put("index", currentMap.get("index") + a);
                        continue;
                    }
            }
            if (done) break;
            currentMap.put("index", currentMap.get("index") + 1);
        }

        return count;
    }
}
