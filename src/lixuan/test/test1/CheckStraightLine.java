package lixuan.test.test1;

/**
 * 1232. 缀点成线
 */
public class CheckStraightLine {
    public boolean checkStraightLine(int[][] coordinates) {
        if (coordinates.length <= 2) {
            return true;
        }
        double num = (coordinates[1][0] - coordinates[0][0] == 0) ? 0 : (coordinates[1][1] - coordinates[0][1] * 1.0) / (coordinates[1][0] - coordinates[0][0]);
        for (int i = 2; i < coordinates.length; i++) {
            double temp = (coordinates[i][0] - coordinates[i - 1][0] == 0) ? 0 : (coordinates[i][1] - coordinates[i - 1][1] * 1.0) / (coordinates[i][0] - coordinates[i - 1][0]) * 1.0;
            if (num != temp) {
                return false;
            }
        }
        return true;
    }
}
