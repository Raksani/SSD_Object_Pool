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
    public Bullet acquireBullets(int x, int y, int dx, int dy){
        //to: Create the bullets in a pool if there is nothing in there.
        if (bulletsPools.isEmpty()){
            for (int kk = 0; kk < 99; kk++){
                bulletsPools.add(new Bullet(0,0,0,0));
            }
        }

        //acquire the bullet from the first one.
        bulletsPools.get(0).setX(x);
        bulletsPools.get(0).setY(y);
        bulletsPools.get(0).setDx(dx);
        bulletsPools.get(0).setDy(dy);
        Bullet pewpew = bulletsPools.get(0);
        bulletsPools.remove(0);
        return pewpew;
    }

    //TO DO release reusable
    public void releaseBullets(Bullet oldBullet){
        bulletsPools.add(oldBullet);
    }
}
