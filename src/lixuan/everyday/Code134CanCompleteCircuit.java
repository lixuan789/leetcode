package lixuan.everyday;

import java.util.Arrays;
import java.util.Comparator;

public class Code134CanCompleteCircuit {

    class node {
        int index;
        int x;
        int y;

        node(int index, int x, int y) {
            this.index = index;
            this.x = x;
            this.y = y;
        }

    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        node[] array = new node[gas.length];
        for (int i = 0; i < gas.length; i++) {
            node node = new node(i, gas[i], cost[i]);
            array[i] = node;
        }
        Arrays.sort(array, new Comparator<node>() {
            @Override
            public int compare(node o1, node o2) {
                int num1 = o2.x - o2.y;
                int num2 = o1.x - o1.y;
                if (num1 > num2) {
                    return 1;
                } else if (num1 == num2) {
                    return 0;
                } else {
                    return -1;
                }
            }
        });
        int last = 0;
        for (int i = 0; i < array.length; i++) {
            last += (array[i].x - array[i].y);
            if (last < 0) {
                return -1;
            }
        }
        if (last >= 0) {
            return array[0].index;
        }
        return -1;
    }

    public int canCompleteCircuit1(int[] gas, int[] cost) {
        int rest = 0, run = 0, start = 0;
        for (int i = 0; i < gas.length; ++i) {
            run += (gas[i] - cost[i]);
            rest += (gas[i] - cost[i]);
            if (run < 0) {
                start = i + 1;
                run = 0;
            }
        }
        return rest < 0 ? -1 : start;
    }
}
