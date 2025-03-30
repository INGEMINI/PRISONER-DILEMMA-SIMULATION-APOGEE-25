import java.util.Random;

class pd {
  private int id;
  private int[] history;
  private Random rand;

  public pd(int id, int r) {
    this.id = id;
    this.history = new int[r];
    this.rand = new Random();
  }

  public int nextmove(int round, int[] oppohistory) {

    if (round == 0) {
      return 1;

    }
    int lastmove = oppohistory[round - 1];
    if (rand.nextInt(10) == 0) {
      return -1;
    }

    if (lastmove == -1 && rand.nextInt(5) == 0) {
      return 1;
    }
    return lastmove;
  }

  public void record(int round, int move) {
    history[round] = move;
  }

  public int[] gethistory() {
    return history;
  }
}

public class PrisonersDilemmaSimulation {

  public static void main(String[] args) {

    int round = 10;
    pd p1 = new pd(1, round);
    pd p2 = new pd(2, round);

    for (int r = 0; r < round; r++) {
      int m1 = p1.nextmove(r, p2.gethistory());
      int m2 = p2.nextmove(r, p1.gethistory());
      p1.record(r, m1);
      p2.record(r, m2);
      System.out.println("round " + (r + 1) + " -> player 1 : " + (m1 == 1 ? "cooperate " : " defect")
          + " , player 2 : " + (m2 == 1 ? "cooperate " : "defect "));

    }
  }
}