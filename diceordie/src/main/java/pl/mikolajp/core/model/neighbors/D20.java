package pl.mikolajp.core.model.neighbors;

import java.util.List;

public class D20 {
    static List<Integer> n1 = List.of(19, 7, 13); // 1
    static List<Integer> n2 = List.of(12, 18, 20); // 2
    static List<Integer> n3 = List.of(19, 17, 16); // 3
    static List<Integer> n4 = List.of(11, 18, 14); // 4
    static List<Integer> n5 = List.of(18, 15, 13); // 5
    static List<Integer> n6 = List.of(9, 14, 16); // 6
    static List<Integer> n7 = List.of(1, 15, 17); // 7
    static List<Integer> n8 = List.of(20, 10, 16); // 8
    static List<Integer> n9 = List.of(19, 6, 11); // 9
    static List<Integer> n10 = List.of(8, 17, 12); // 10
    static List<Integer> n11 = List.of(13, 4, 9); // 11
    static List<Integer> n12 = List.of(2, 10, 15); // 12
    static List<Integer> n13 = List.of(5, 1, 11); // 13
    static List<Integer> n14 = List.of(6, 20, 4); // 14
    static List<Integer> n15 = List.of(5, 12, 7); // 15
    static List<Integer> n16 = List.of(6, 3, 8); // 16
    static List<Integer> n17 = List.of(10, 3, 7); // 17
    static List<Integer> n18 = List.of(2, 4, 5); // 18
    static List<Integer> n19 = List.of(9, 1, 3); // 19
    static List<Integer> n20 = List.of(8, 2, 14); // 20

    public static List<List<Integer>> getNeighbors() {
        return List.of(n1, n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, n12, n13, n14, n15, n16, n17, n18, n19, n20);
    }
}
