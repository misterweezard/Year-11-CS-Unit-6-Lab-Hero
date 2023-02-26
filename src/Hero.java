public class Hero {
    private String name;
    private int hitPoints;
    public Hero(String x){
        this.name = x;
        hitPoints = 100;
    }
    public String getName(){
        return name;
    }
    public int getHitPoints(){
        return hitPoints;
    }
    public String toString(){
        return "Hero{name='" + name + "', hitPoints=" + hitPoints + "}";
    }
    public void attack(Hero opponent){
        double random = Math.random();
        if(random < 0.5){
            opponent.hitPoints -= 10;
        }
        else {
            hitPoints -= 10;
        }
    }
    public void senzuBean(){
        hitPoints = 100;
    }
    private void fightUntilTheDeathHelper(Hero opponent){
        while(hitPoints > 0 && opponent.hitPoints > 0){
            attack(opponent);
        }
    }
    public String fightUntilTheDeath(Hero opponent){
        senzuBean();
        opponent.senzuBean();
        fightUntilTheDeathHelper(opponent);
        return name + ": " + hitPoints + "  " + opponent.getName() + ": " + opponent.getHitPoints();
    }
    private int [] nFightsToTheDeathHelper(Hero opponent, int y){
        int [] score = new int [2];
        while (y > 0) {
            fightUntilTheDeathHelper(opponent);
            if(hitPoints > 0){
                score[0]++;
            }
            else{
                score[1]++;
            }
            senzuBean();
            opponent.senzuBean();
            y--;
        }
        return score;
    }
    public String nFightsToTheDeath(Hero opponent, int z){
        int [] score = nFightsToTheDeathHelper(opponent, z);
        String message = name + ": " + score[0] + " wins\n" + opponent.getName() + ": " + score[1] + " wins\n";
        if(score[0] > score [1]){
            return message + name + " wins!";
        }
        else if(score[0] < score[1]){
            return message + opponent.getName() + " wins!";
        }
        else{
            return message + "OMG! It was actually a draw!";
        }
    }
    public void dramaticFightToTheDeath(Hero opponent) throws InterruptedException {
        while(hitPoints > 0 && opponent.hitPoints > 0){
            attack(opponent);
            Thread.sleep(1000);
            System.out.println((name + ": " + hitPoints + "\t\t" + opponent.getName() + ": " + opponent.hitPoints));

        }
        if(hitPoints > 0){
            System.out.println(name + " wins!");
        }
        else{
            System.out.println(opponent.getName() + " wins!");
        }
    }
}
