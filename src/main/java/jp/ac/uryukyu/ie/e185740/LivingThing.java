package jp.ac.uryukyu.ie.e185740;
/**
 * キャラクターのクラス。
 *  String name; //キャラクターの名前
 *  int hitPoint; //キャラクターのHP
 *  int attack; //キャラクターの攻撃力
 *  boolean dead; //キャラクターの生死状態。true=死亡。
 * Created by shinya on 2018/12/10.
 */
public class LivingThing {
    private String name;
    private int hitPoint;
    private int attack;
    private boolean dead;
    /**
     * コンストラクタ。名前、最大HP、攻撃力を指定する。
     * @param name ヒーロー又は、敵の名前
     * @param maximumHP ヒーロー又は、敵のHP
     * @param attack ヒーロー又は、敵の攻撃力
     */

    public LivingThing(String name, int maximumHP, int attack){
        this.name = name;
        this.hitPoint = maximumHP;
        this.attack = attack;
        System.out.printf("%sのHPは%d。攻撃力は%dです。\n", name, maximumHP, attack);

    }

    public boolean isDead() {
        return  dead;
    }

    public void setDead(boolean dead)
    {
        this.dead = dead;
    }

    public String getName() {
        return name;
    }

    public int getHitPoint()
    {
        return hitPoint;
    }

    public void setHitPoint(int hitPoint)
    {
        this.hitPoint = hitPoint;
    }
    /**
     * 自身が死亡していないかを確認して、
     * ランダムにダメージを選出する。
     * それを、wondedメソッドに渡す。
     * @param opponent ダメージを受けるキャラクターのオブジェクト
     */
    public void attack(LivingThing opponent)
    {
        if (!isDead()) {
            int damage = (int) (Math.random() * attack);
            System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", name, opponent.getName(), damage);
            opponent.wounded(damage);
        }
    }
    /**
     * 自身へ攻撃されたときのダメージ処理をするメソッド。
     * 指定されたダメージを hitPoint から引き、死亡判定を行う。
     * @param damage 受けたダメージ
     */
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