package jp.ac.uryukyu.ie.e185740;

public class LivingThing {
    private String name;
    private int hitPoint;
    private int attack;
    private boolean dead;

    LivingThing(String name, int maximumHP, int attack){
        this.name = name;
        this.hitPoint = maximumHP;
        this.attack = attack;
        System.out.printf("%sのHPは%d。攻撃力は%dです。\n", name, maximumHP, attack);

    }

    boolean isDead() {
        return  dead;
    }

    void  setDead(boolean dead)
    {
        this.dead = dead;
    }

    String getName() {
        return name;
    }

    int getHitPoint()
    {
        return hitPoint;
    }
    void setHitPoint(int hitPoint)
    {
        this.hitPoint = hitPoint;
    }

    void attack(LivingThing opponent)
    {
        if (!isDead()) {
            int damage = (int) (Math.random() * attack);
            System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", name, opponent.getName(), damage);
            opponent.wounded(damage);
        }
    }

    public void wounded( int damage)
    {
        hitPoint -= damage;
        if (hitPoint < 0)
        {
            dead = true;
            System.out.printf("%sは倒れた。\n", name);
        }
    }
}