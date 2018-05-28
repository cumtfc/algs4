package ACM;

public class test {


    public static void main(String[] args) {
        DO aDo = new DO(1);
        DO bDo = aDo;
        aDo.val = 2;
        System.out.println(bDo.val);
    }
}

class DO{
    public Integer val;

    public DO(Integer val) {
        this.val = val;
    }
}