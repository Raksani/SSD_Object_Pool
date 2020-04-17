import java.util.ArrayList;
import java.util.List;

public class ReusableBulletsPool {
    // TO DO define list of bullets that store bullets to reuse.
    private static ReusableBulletsPool instance;
    private static List<Bullet> bulletsPools;

    private ReusableBulletsPool() {
        bulletsPools = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            bulletsPools.add(new Bullet(0, 0, 0, 0));
        }
    }

    public static ReusableBulletsPool getInstance() {
        if (instance == null) {
            instance = new ReusableBulletsPool();
            return instance;
        } else {
            return instance;
        }
    }

    //TO DO acquire reusable
    //TO DO release reusable
}
