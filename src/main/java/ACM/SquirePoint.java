package ACM;

import java.util.Scanner;

public class SquirePoint {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        Squire[] squires = new Squire[count];
        Long minX = null;
        Long maxX = null;
        Long minY = null;
        Long maxY = null;
        for (int i = 0; i < count; i++) {
            squires[i] = (new Squire(in.nextLong()));
            long x1 = squires[i].getX1();
            if (maxX==null) {
                maxX = x1;
            }
            if (minX==null) {
                minX = x1;
            }
            if (minX > x1) {
                minX = x1;
            } else if (maxX < x1) {
                maxX = x1;
            }
        }
        for (int i = 0; i < count; i++) {
            squires[i].setY1(in.nextLong());
            long y1 = squires[i].getY1();
            if (maxY==null) {
                maxY = y1;
            }
            if (minY==null) {
                minY = y1;
            }
            if (minY > y1) {
                minY = y1;
            } else if (maxY < y1) {
                maxY = y1;
            }
        }
        for (int i = 0; i < count; i++) {
            squires[i].setX2(in.nextLong());
            long x2 = squires[i].getX2();
            if (minX > x2) {
                minX = x2;
            } else if (maxX < x2) {
                maxX = x2;
            }
        }
        for (int i = 0; i < count; i++) {
            squires[i].setY2(in.nextLong());
            long y2 = squires[i].getY2();
            if (minY > y2) {
                minY = y2;
            } else if (maxY < y2) {
                maxY = y2;
            }
        }
        int max = 0;
        for (long i = minX; i <maxX ; i++) {
            for (long j= minY; j <maxY ; j++) {
                int t = 0;
                for (Squire squire : squires) {
                    if (squire.getX1() < i && squire.getX2() > i && squire.getY1() < j && squire.getY2() > j) {
                        t++;
                    }
                }
                if (t > max) {
                    max = t;
                }
            }
        }
        if (max == 0) {
            max = 1;
        }
        System.out.println(max);

    }
}

class Squire {
    private long x1;
    private long x2;
    private long y1;
    private long y2;

    public Squire(long x1) {
        this.x1 = x1;
    }

    public long getX1() {
        return x1;
    }

    public void setX1(long x1) {
        this.x1 = x1;
    }

    public long getX2() {
        return x2;
    }

    public void setX2(long x2) {
        this.x2 = x2;
    }

    public long getY1() {
        return y1;
    }

    public void setY1(long y1) {
        this.y1 = y1;
    }

    public long getY2() {
        return y2;
    }

    public void setY2(long y2) {
        this.y2 = y2;
    }
}
